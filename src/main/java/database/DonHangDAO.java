package database;
import model.DonHang;

import java.util.ArrayList;


public class DonHangDAO implements DAOInterface<DonHang>{

    private ArrayList<DonHang> data = new ArrayList<DonHang>();
    @Override
    public ArrayList<DonHang> selectAll() {
        return this.data;
    }

    @Override
    public DonHang selectById(DonHang t) {
        for(DonHang donHang : data){
            if (data.equals(t)){
                return donHang;
            }
        }
        return null;
    }

    @Override
    public int insert(DonHang t) {
        if(this.selectById(t) != null){
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<DonHang> arr) {
        int count = 0;
        for(DonHang t : arr){
            count += this.insert(t);
        }
        return count;
    }

    @Override
    public int delete(DonHang t) {
        if(this.selectById(t) != null){
            ChiTietDonHangDAO ctd = new ChiTietDonHangDAO();
            ctd.deleteAll(t);
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<DonHang> t) {
        int count = 0;
        for(DonHang donHang : t){
            count += this.delete(donHang);
        }
        return count;
    }

    @Override
    public int update(DonHang t) {
        if(this.selectById(t) != null){
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }


}
