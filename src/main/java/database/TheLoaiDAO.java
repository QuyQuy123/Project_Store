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

public class TheLoaiDAO implements DAOInterface<TheLoai>{
    private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

    private final Connection con = DBUtils.getConnection();

    @Override
    public ArrayList<TheLoai> selectAll() {
        ArrayList<TheLoai> data = new ArrayList<TheLoai>();
        try {
            String sql = "SELECT * FROM theloai";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maTheLoai = rs.getString("maTheLoai");
                String tenTheLoai = rs.getString("tenTheLoai");
                TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);
                data.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public TheLoai selectById(TheLoai t) {
        TheLoai data = null;
        try {
            String sql = "SELECT * FROM theloai WHERE maTheLoai = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaTheLoai());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String maTheLoai = rs.getString("maTheLoai");
                String tenTheLoai = rs.getString("tenTheLoai");
                data = new TheLoai(maTheLoai, tenTheLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public int insert(TheLoai t) {
        if(this.selectById(t) != null){
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<TheLoai> arr) {
        int count = 0;
        for(TheLoai t : arr){
            count += this.insert(t);
        }
        return count;
    }

    @Override
    public int delete(TheLoai t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<TheLoai> t) {
        int count = 0;
        for(TheLoai theLoai : t){
            count += this.delete(theLoai);
        }
        return count;
    }

    @Override
    public int update(TheLoai t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }

}
