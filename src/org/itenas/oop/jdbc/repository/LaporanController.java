package org.itenas.oop.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import org.itenas.oop.jdbc.utils.ConnectionManager;

public class LaporanController {

    private final ConnectionManager cm = new ConnectionManager();
    // ENCAPSULATION

    public List<Object[]> getLaporan(Date tglAwal, Date tglAkhir) {

        List<Object[]> list = new ArrayList<>();

        String sql = """
            SELECT 
                t.id_transaksi,
                t.tanggal,
                tr.nama_terapis,
                l.nama_layanan,
                d.subtotal,
                t.metode_pembayaran
            FROM transaksi t
            JOIN detail_transaksi d ON t.id_transaksi = d.id_transaksi
            JOIN terapis tr ON d.id_terapis = tr.id_terapis
            JOIN layanan l ON d.id_layanan = l.id_layanan
            WHERE t.tanggal >= ?
              AND t.tanggal < DATE_ADD(?, INTERVAL 1 DAY)
            ORDER BY t.tanggal
        """;

        try (Connection con = cm.connectDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(tglAwal.getTime()));
            ps.setDate(2, new java.sql.Date(tglAkhir.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Object[]{
                    rs.getInt("id_transaksi"),
                    rs.getTimestamp("tanggal"),
                    rs.getString("nama_terapis"),
                    rs.getString("nama_layanan"),
                    rs.getInt("subtotal"),
                    rs.getString("metode_pembayaran")
                });
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }

    public int getTotalTransaksi(Date tglAwal, Date tglAkhir) {
        String sql = """
        SELECT COUNT(DISTINCT id_transaksi)
        FROM transaksi
        WHERE tanggal >= ?
          AND tanggal < DATE_ADD(?, INTERVAL 1 DAY)
    """;

        try (Connection con = cm.connectDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(tglAwal.getTime()));
            ps.setDate(2, new java.sql.Date(tglAkhir.getTime()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
           System.out.println(e.getMessage()); // EXCEPTION HAe.prinNDLING
        }
        return 0;
    }

    public int getAkumulasiPenjualan(Date tglAwal, Date tglAkhir) {
        String sql = """
        SELECT COALESCE(SUM(d.subtotal), 0)
        FROM transaksi t
        JOIN detail_transaksi d ON t.id_transaksi = d.id_transaksi
        WHERE t.tanggal >= ?
          AND t.tanggal < DATE_ADD(?, INTERVAL 1 DAY)
    """;

        try (Connection con = cm.connectDb(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(tglAwal.getTime()));
            ps.setDate(2, new java.sql.Date(tglAkhir.getTime()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage()); // EXCEPTION HANDLING
        }
        return 0;
    }

}
