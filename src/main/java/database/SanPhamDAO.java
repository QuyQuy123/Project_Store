package database;

import model.Sanpham;
import model.TacGia;
import model.TheLoai;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamDAO implements DAOInterface<Sanpham> {

    private ArrayList<Sanpham> data = new ArrayList<Sanpham>();
    private final Connection con = DBUtils.getConnection();

    @Override
    public ArrayList<Sanpham> selectAll() {
        ArrayList<Sanpham> data = new ArrayList<Sanpham>();
        try {
            String sql = "SELECT * FROM sanpham";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String maTacGia = rs.getString("maTacGia");
                int namXuatBan = rs.getInt("namXuatBan");
                double giaNhap = rs.getDouble("giaNhap");
                double giaGoc = rs.getDouble("giaGoc");
                double giaBan = rs.getDouble("giaBan");
                int soLuong = rs.getInt("soLuong");
                String maTheLoai = rs.getString("maTheLoai");
                String ngonNgu = rs.getString("ngonNgu");
                String moTa = rs.getString("moTa");
                TacGia tg = (new TacGiaDAO()).selectById(new TacGia(maTacGia, null, null, null));
                TheLoai tl = (new TheLoaiDAO()).selectById(new TheLoai(maTheLoai, null));
                Sanpham sanpham = new Sanpham(maSanPham, tenSanPham, tg, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, tl, ngonNgu, moTa);
                data.add(sanpham);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Sanpham selectById(Sanpham t) {
        for(Sanpham sanpham : data){
            if (data.equals(t)){
                return sanpham;
            }
        }
        return null;
    }

    @Override
    public int insert(Sanpham t) {
        if(this.selectById(t) != null){
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Sanpham> arr) {
        int count = 0;
        for(Sanpham t : arr){
            count += this.insert(t);
        }
        return count;
    }

    @Override
    public int delete(Sanpham t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Sanpham> t) {
        int count = 0;
        for(Sanpham sanpham : t){
            count += this.delete(sanpham);
        }
        return count;
    }

    @Override
    public int update(Sanpham t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }
}
