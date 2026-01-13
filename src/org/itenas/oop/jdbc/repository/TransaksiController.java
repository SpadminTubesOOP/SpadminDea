package org.itenas.oop.jdbc.repository;

import java.sql.*;
import java.util.List;
import org.itenas.oop.jdbc.utils.ConnectionManager;

public class TransaksiController {

    private ConnectionManager cm = new ConnectionManager();
    // JDBC + ENCAPSULATION

    public int createTransaksi(String metodePembayaran) {
        String sql = "INSERT INTO transaksi (tanggal, subtotal, metode_pembayaran, pembayaran, balance) "
                + "VALUES (NOW(), 0, ?, 0, 0)";

        try {
            Connection con = cm.connectDb();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, metodePembayaran);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public boolean addDetail(int idTransaksi, int idLayanan, int idTerapis, int subtotal) {
        String sql = "INSERT INTO detail_transaksi (id_transaksi, id_layanan, id_terapis, subtotal) "
                + "VALUES (?, ?, ?, ?)";

        try {
            Connection con = cm.connectDb();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idTransaksi);
            ps.setInt(2, idLayanan);
            ps.setInt(3, idTerapis);
            ps.setInt(4, subtotal);

            boolean result = ps.executeUpdate() > 0;
            con.close();
            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // EXCEPTION HANDLING
            return false;
        }
    }

    public boolean updateSubtotal(int idTransaksi, int subtotal) {
        String sql = "UPDATE transaksi SET subtotal=? WHERE id_transaksi=?";

        try {
            Connection con = cm.connectDb();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, subtotal);
            ps.setInt(2, idTransaksi);

            boolean result = ps.executeUpdate() > 0;
            con.close();
            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // EXCEPTION HANDLING
            return false;
        }
    }

    public boolean prosesPembayaran(int idTransaksi, int bayar, int total) {
        if (bayar < total) {
            return false; // BUSINESS RULE
        }

        int kembalian = bayar - total;
        String sql = "UPDATE transaksi SET pembayaran=?, balance=? WHERE id_transaksi=?";

        try {
            Connection con = cm.connectDb();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, bayar);
            ps.setInt(2, kembalian);
            ps.setInt(3, idTransaksi);

            boolean result = ps.executeUpdate() > 0;
            con.close();
            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // EXCEPTION HANDLING
            return false;
        }
    }

    public int hitungTotalDariList(List<Integer> subtotals) {
        int total = 0;
        for (int s : subtotals) {
            total += s;
        }
        return total;
        // COLLECTION
    }

    public int hitungKembalian(int total, int bayar) {
        return bayar - total;
    }

    public Integer getHargaLayananById(int idLayanan) {
        String sql = "SELECT harga FROM layanan WHERE id_layanan = ? AND status = 1";

        try {
            Connection con = cm.connectDb();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLayanan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("harga");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
