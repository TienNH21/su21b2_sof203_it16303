package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class QLMonHocService {
    public List<MonHoc> getAll() {
        List<MonHoc> list = new ArrayList<MonHoc>();
        try {
            // Bước 1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bước 2: Tạo Connection tới DB
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Bước 3: Tạp PreparedStatement
            String query = "SELECT * FROM mon_hoc";
            PreparedStatement ps = conn.prepareStatement(query);

            // Bước 4: thực thi truy vấn
            ResultSet rs = ps.executeQuery();

            // Bước 5: bóc dữ liệu từ ResultSet
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String tenMH = rs.getString("ten_mon_hoc");
                String maMH = rs.getString("ma_mon_hoc");
                Date ngayTao = rs.getDate("ngay_tao");
                int chuyenNganhId = rs.getInt("chuyen_nganh_id");

                MonHoc mh = new MonHoc(id, tenMH, maMH, ngayTao, chuyenNganhId);
                list.add(mh);
            }

            // Bước 6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public MonHoc insert(MonHoc monHoc) {
        try {
            // Bước 1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bước 2: Tạo Connection tới DB
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Bước 3: Tạp PreparedStatement
            // TODO: OUTPUT INSERTED.ID -> lấy id mới thêm
            String query = "INSERT INTO mon_hoc(ten_mon_hoc, ma_mon_hoc, ngay_tao, chuyen_nganh_id) "
                    + " VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, monHoc.getTenMonHoc());
            ps.setString(2, monHoc.getMaMonHoc());
            
            /*
             * monHoc.getNgayTao() -> java.util.Date
             * setDate(int, java.sql.Date);
             */
            java.sql.Date ngayTaoSqlDate = new java.sql.Date( monHoc.getNgayTao().getTime() );
            ps.setDate(3, ngayTaoSqlDate);
            
            ps.setInt(4, monHoc.getChuyenNganhId());

            // Bước 4: thực thi truy vấn
            // Bước 5: nhận kết quả trả về
            int result = ps.executeUpdate();

            System.out.println("Số bản ghi chịu tác động: " + result);

            // Bước 6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return monHoc;
    }

    public int update(MonHoc monHoc) {
        return 0;
    }
    
    public int delete(int id) {
        return 0;
    }
}
