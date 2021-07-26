package models;

import java.util.Date;

public class MonHoc {
    private int id;
    private String tenMonHoc;
    private String maMonHoc;
    private Date ngayTao;
    private int chuyenNganhId;

    public MonHoc() {
    }

    public MonHoc(int id, String tenMonHoc, String maMonHoc, Date ngayTao, int chuyenNganhId) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.ngayTao = ngayTao;
        this.chuyenNganhId = chuyenNganhId;
    }

    public int getId() {
        return id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public int getChuyenNganhId() {
        return chuyenNganhId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setChuyenNganhId(int chuyenNganhId) {
        this.chuyenNganhId = chuyenNganhId;
    }
    
    
}
