package org.itenas.oop.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.jdbc.model.Layanan;
import org.itenas.oop.jdbc.utils.ConnectionManager;

public class LayananController {

    // JDBC CONNECTION
    private ConnectionManager cm = new ConnectionManager();
    private Connection con = cm.connectDb();

    public List<Layanan> getAllLayanan() {
        List<Layanan> list = new ArrayList<>();
        String sql = "SELECT * FROM layanan WHERE status = 1";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Layanan l = new Layanan();
                l.setIdLayanan(rs.getInt("id_layanan"));
                l.setNamaLayanan(rs.getString("nama_layanan"));
                l.setHarga(rs.getDouble("harga"));
                l.setDurasi(rs.getInt("durasi"));
                list.add(l);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Layanan getById(int id) {
        String sql = "SELECT * FROM layanan WHERE id_layanan = ? AND status = 1";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Layanan l = new Layanan();
                l.setIdLayanan(rs.getInt("id_layanan"));
                l.setNamaLayanan(rs.getString("nama_layanan"));
                l.setHarga(rs.getDouble("harga"));
                l.setDurasi(rs.getInt("durasi"));
                return l;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insert(Layanan l) {
        String sql = "INSERT INTO layanan (nama_layanan, harga, durasi, status) VALUES (?, ?, ?, 1)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, l.getNamaLayanan());
            ps.setDouble(2, l.getHarga());
            ps.setInt(3, l.getDurasi());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLayanan(Layanan l) {
        String sql = "UPDATE layanan SET nama_layanan=?, harga=?, durasi=? WHERE id_layanan=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, l.getNamaLayanan());
            ps.setDouble(2, l.getHarga());
            ps.setInt(3, l.getDurasi());
            ps.setInt(4, l.getIdLayanan());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void nonaktifkanLayanan(int id) {
        String sql = "UPDATE layanan SET status = 0 WHERE id_layanan = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
