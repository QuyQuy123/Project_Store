package database;

import model.ChiTietDonHang;
import model.DonHang;

import java.util.ArrayList;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

    private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();
    @Override
    public ArrayList<ChiTietDonHang> selectAll() {
        return this.data;
    }

    @Override
    public ChiTietDonHang selectById(ChiTietDonHang t) {
        for(ChiTietDonHang donHang : data){
            if (data.equals(t)){
                return donHang;
            }
        }
        return null;
    }

    @Override
    public int insert(ChiTietDonHang t) {
        if(this.selectById(t) != null){
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<ChiTietDonHang> arr) {
        int count = 0;
        for(ChiTietDonHang t : arr){
            count += this.insert(t);
        }
        return count;
    }

    @Override
    public int delete(ChiTietDonHang t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<ChiTietDonHang> t) {
        int count = 0;
        for(ChiTietDonHang donHang : t){
            count += this.delete(donHang);
        }
        return count;
    }
    public int deleteAll(DonHang dh){
        int dem = 0;
        for(ChiTietDonHang ctdh : this.data){
            if(ctdh.getDonHang().equals(dh)){
                this.delete(ctdh);
            }
        }
        return dem;
    }

    @Override
    public int update(ChiTietDonHang t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }



}
