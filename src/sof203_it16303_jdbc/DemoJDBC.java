package sof203_it16303_jdbc;

import models.User;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DemoJDBC {
    public static void main(String[] args) {
        try {
            // B1: Load driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            /*
             * <protocol>://<host>:<port>;databaseName=<db-name>;
             */
            String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic",
                dbUsername = "sa",
                dbPassword = "Aa@123456";
            
            // B2: Tạo kết nối (connection) vào DB
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            // B3: Tạo Statement phục vụ cho truy vấn
            //  Statement stm = conn.createStatement();
            int id = 2;
            String sql = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Gán giá trị tham số
//            ps.setInt(1, id);

            // B4: Thực hiện truy vấn
            ResultSet rs = ps.executeQuery();
            
            /*
             * B5: Dùng vòng lặp while duyệt qua từng bản ghi để đọc dữ liệu
             * rs.next()
             * Nếu còn dữ liệu có thể đọc được -> true
             * Nếu hết dữ liệu, ko còn dữ liệu để đọc -> false
             */
            while ( rs.next() ) {
                int id1 = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt("role");

                User u = new User(id1, username, password, role);
                System.out.printf("%d - %s - %s - %d\n", id1, username, password, role);
            }
            
            // B6: Đóng kết nối
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
