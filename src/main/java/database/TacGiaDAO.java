package database;
import model.TacGia;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TacGiaDAO implements DAOInterface<TacGia> {
    private final Connection con = DBUtils.getConnection();
    @Override
    public ArrayList<TacGia> selectAll() {
        ArrayList<TacGia> data = new ArrayList<TacGia>();
        try {
            String sql = "SELECT * FROM tacgia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maTacGia = rs.getString("maTacGia");
                String tenTacGia = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String tieuSu = rs.getString("tieuSu");
                TacGia tg = new TacGia(maTacGia, tenTacGia, ngaySinh , tieuSu);
                data.add(tg);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    @Override
    public TacGia selectById(TacGia t) {
       TacGia data =null;
        try {
            String sql = "SELECT * FROM tacgia where maTacGia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,t.getMaTacGia());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maTacGia = rs.getString("maTacGia");
                String tenTacGia = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String tieuSu = rs.getString("tieuSu");
                data = new TacGia(maTacGia, tenTacGia, ngaySinh , tieuSu);
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return data;
    }


    @Override
    public int insert(TacGia tacGia) {
        int ketQua = 0;
        try{
            String sql = "INSERT INTO tacgia(maTacGia, hoVaTen, ngaySinh, tieuSu) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tacGia.getMaTacGia());
            ps.setString(2, tacGia.getHoVaTen());
            ps.setDate(3, new java.sql.Date(tacGia.getNgaySinh().getTime()));
            ps.setString(4, tacGia.getTieuSu());
            ketQua = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }



    @Override
    public int insertAll(ArrayList<TacGia> arr) {
        int count = 0;
        for(TacGia tacGia : arr){
            count += this.insert(tacGia);
        }
        return count;
    }

    @Override
    public int delete(TacGia tacGia) {
        int count  =0 ;
        try{
            String sql = "DELETE FROM tacgia WHERE maTacGia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tacGia.getMaTacGia());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }



    @Override
    public int deleteAll(ArrayList<TacGia> t) {
        int count = 0;
        for(TacGia tacGia : t){
            count += this.delete(tacGia);
        }
        return count;
    }

    @Override
    public int update(TacGia tacGia) {
        int count  =0 ;
        try{
            String sql = "UPDATE tacgia SET hoVaTen = ?, ngaySinh = ?, tieuSu = ? WHERE maTacGia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tacGia.getHoVaTen());
            ps.setDate(2, new java.sql.Date(tacGia.getNgaySinh().getTime()));
            ps.setString(3, tacGia.getTieuSu());
            ps.setString(4, tacGia.getMaTacGia());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}



