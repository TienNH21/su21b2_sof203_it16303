/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof203_it16303_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoDelete {
    public static void main(String[] args) {
        User user = new User(2002, "TienNH1", "123456", 1);
        
        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // B3: Tạo PreparedStatement
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, user.getId());

            // B4: Thực thi truy vấn
            // B5: Bóc dữ liệu
            ps.executeUpdate();

            // B6: Đóng kết nối
            conn.close();
            
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
