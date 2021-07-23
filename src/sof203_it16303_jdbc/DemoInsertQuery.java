package sof203_it16303_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoInsertQuery {
    public static void main(String[] args) {
        User user = new User(0, "TienNH18", "123456", 2);
        
        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối
            String username = "sa", password="Aa@123456",
                url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic";

            Connection conn = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
            // B3: Tạo PreparedStatement
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole());

            // B4: Thực thi truy vấn
            // B5: Bóc dữ liệu
            /*
             * Giá trị trả về của executeUpdate được lưu trong biến kq,
             * thể hiện có bao nhiêu bản ghi trong DB bị ảnh hưởng bởi câu query
             */
            int kq = ps.executeUpdate();

            // B6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
