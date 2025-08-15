package database;
import model.KhachHang;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class KhachHangDAO implements DAOInterface<KhachHang> {
    private final Connection con = DBUtils.getConnection();
    private ArrayList<KhachHang> data = new ArrayList<KhachHang>();

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> data = new ArrayList<KhachHang>();
        try {
            String sql = "SELECT * FROM khachhang";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                String hoVaTen = rs.getString("hoVaTen");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String diaChiNhanHang = rs.getString("diaChiNhanHang");
                String diaChiMuaHang = rs.getString("diaChiMuaHang");
                Date ngaySinh = rs.getDate("ngaySinh");
                String soDienThoai = rs.getString("soDienThoai");
                String email = rs.getString("email");
                boolean dangKiNhanBangTin = rs.getBoolean("dangKiNhanBangTin");
                KhachHang khachHang = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKiNhanBangTin);
                data.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        KhachHang data =null;
        try {
            String sql = "SELECT * FROM khachhang WHERE maKhachHang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaKhachHang());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                String hoVaTen = rs.getString("hoVaTen");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String diaChiNhanHang = rs.getString("diaChiNhanHang");
                String diaChiMuaHang = rs.getString("diaChiMuaHang");
                Date ngaySinh = rs.getDate("ngaySinh");
                String soDienThoai = rs.getString("soDienThoai");
                String email = rs.getString("email");
                boolean dangKiNhanBangTin = rs.getBoolean("dangKiNhanBangTin");
                data = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKiNhanBangTin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean kiemTraTenDangNhap(String tenDangNhap) {
        try {
            String sql = "SELECT * FROM khachhang WHERE tenDangNhap = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int insert(KhachHang t) {
        int count  =0;
        try {
            String sql = "INSERT INTO khachhang( maKhachHang, tenDangNhap, matKhau, hoVaTen, " +
                    "gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, " +
                    "soDienThoai, email, dangKiNhanBangTin) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,t.getMaKhachHang());
            ps.setString(2, t.getTenDangNhap());
            ps.setString(3, t.getMatKhau());
            ps.setString(4, t.getHoVaTen());
            ps.setString(5, t.getGioiTinh());
            ps.setString(6, t.getDiaChi());
            ps.setString(7, t.getDiaChiNhanHang());
            ps.setString(8, t.getDiaChiMuaHang());
            ps.setDate(9, new java.sql.Date(t.getNgaySinh().getTime()));
            ps.setString(10, t.getSoDienThoai());
            ps.setString(11, t.getEmail());
            ps.setBoolean(12, t.isDangKiNhanBangTin());
            count = ps.executeUpdate();
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public int insertAll(ArrayList<KhachHang> arr) {
        int count = 0;
        for(KhachHang t : arr){
            count += this.insert(t);
        }
        return count;
    }

    @Override
    public int delete(KhachHang t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<KhachHang> t) {
        int count = 0;
        for(KhachHang khachHang : t){
            count += this.delete(khachHang);
        }
        return count;
    }

    @Override
    public int update(KhachHang t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }
}
