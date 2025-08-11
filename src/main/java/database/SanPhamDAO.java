package database;

import model.Sanpham;

import java.util.ArrayList;

public class SanPhamDAO implements DAOInterface<Sanpham> {
    private ArrayList<Sanpham> data = new ArrayList<Sanpham>();

    @Override
    public ArrayList<Sanpham> selectAll() {
        return this.data;
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
