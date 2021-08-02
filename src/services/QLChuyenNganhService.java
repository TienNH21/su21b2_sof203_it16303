package services;

import java.util.List;
import models.ChuyenNganh;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QLChuyenNganhService {
    public List<ChuyenNganh> getAll() {
        List<ChuyenNganh> list = new ArrayList<>();
        
        try {
            // Bước 1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bước 2: Tạo Connection tới DB
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Bước 3: Tạp PreparedStatement
            String query = "SELECT * FROM chuyen_nganh";
            PreparedStatement ps = conn.prepareStatement(query);

            // Bước 4: thực thi truy vấn
            ResultSet rs = ps.executeQuery();

            // Bước 5: bóc dữ liệu từ ResultSet
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten_chuyen_nganh");
                
                System.out.printf("%d - %s\n", id, ten);
                ChuyenNganh cn = new ChuyenNganh(id, ten);
                list.add(cn);
            }

            // Bước 6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
