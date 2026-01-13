package org.itenas.oop.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.itenas.oop.jdbc.model.Terapis;
import org.itenas.oop.jdbc.utils.ConnectionManager;

public class TerapisController {

    // JDBC CONNECTION
    private ConnectionManager cm = new ConnectionManager();
    private Connection con = cm.connectDb();

    // ================= GET ALL =================
    public List<Terapis> getAllTerapis() {
        List<Terapis> list = new ArrayList<>();
        String sql = "SELECT * FROM terapis WHERE status = 1";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Terapis t = new Terapis();
                t.setIdTerapis(rs.getInt("id_terapis"));
                t.setNamaTerapis(rs.getString("nama_terapis"));
                t.setNoTelp(rs.getString("no_telp"));
                t.setJenisKelamin(rs.getString("jenis_kelamin"));
                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // ================= GET BY ID =================
    public Terapis getById(int id) {
        String sql = "SELECT * FROM terapis WHERE id_terapis = ? AND status = 1";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Terapis t = new Terapis();
                t.setIdTerapis(rs.getInt("id_terapis"));
                t.setNamaTerapis(rs.getString("nama_terapis"));
                t.setNoTelp(rs.getString("no_telp"));
                t.setJenisKelamin(rs.getString("jenis_kelamin"));
                return t;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // ================= INSERT =================
    public void insert(Terapis t) {
        String sql = """
            INSERT INTO terapis (nama_terapis, no_telp, jenis_kelamin, status)
            VALUES (?, ?, ?, 1)
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getNamaTerapis());
            ps.setString(2, t.getNoTelp());
            ps.setString(3, t.getJenisKelamin());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= UPDATE =================
    public void updateTerapis(Terapis t) {
        String sql = """
            UPDATE terapis
            SET nama_terapis=?, no_telp=?, jenis_kelamin=?
            WHERE id_terapis=?
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getNamaTerapis());
            ps.setString(2, t.getNoTelp());
            ps.setString(3, t.getJenisKelamin());
            ps.setInt(4, t.getIdTerapis());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= DELETE (SOFT DELETE) =================
    public void nonaktifkanTerapis(int id) {
        String sql = "UPDATE terapis SET status = 0 WHERE id_terapis = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
