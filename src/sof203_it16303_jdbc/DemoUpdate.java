package sof203_it16303_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import models.User;

public class DemoUpdate {
    public static void main(String[] args) {
        User user = new User(2002, "TienNH1", "123456", 1);
        
        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic";
            
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";

            // B3: Tạo PreparedStatement
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole());
            ps.setInt(4, user.getId());
            
            // B4: Thực thi truy vấn
            // B5: Bóc dữ liệu
            int kq = ps.executeUpdate();

            // B6: Đóng kết nối
            conn.close();
            
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
