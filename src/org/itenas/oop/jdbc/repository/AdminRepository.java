package org.itenas.oop.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.itenas.oop.jdbc.model.Admin;
import org.itenas.oop.jdbc.utils.ConnectionManager;

public class AdminRepository {

    private final ConnectionManager cm = new ConnectionManager(); 

    public boolean login(Admin admin) {
        String sql = "SELECT * FROM admin WHERE username=? AND password=?";
        Connection conn = null;

        try {
            conn = cm.connectDb(); // JDBC
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) { 
            // EXCEPTION HANDLING
            System.out.println("Login error: " + e.getMessage());
            return false;
        } finally {
            cm.disconnectDb(conn); // RESOURCE MANAGEMENT
        }
    }
}
