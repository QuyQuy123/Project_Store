package database;

import model.KhachHang;

import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    private ArrayList<KhachHang> data = new ArrayList<KhachHang>();
    @Override
    public ArrayList<KhachHang> selectAll() {
        return this.data;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        for(KhachHang khachHang : data){
            if (data.equals(t)){
                return khachHang;
            }
        }
        return null;
    }

    @Override
    public int insert(KhachHang t) {
        if(this.selectById(t) != null){
            this.data.add(t);
            return 1;
        }
        return 0;
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
