package database;

import model.TheLoai;

import java.util.ArrayList;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
    private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

    @Override
    public ArrayList<TheLoai> selectAll() {
        return this.data;
    }

    @Override
    public TheLoai selectById(TheLoai t) {
        for(TheLoai theLoai : data){
            if (data.equals(t)){
                return theLoai;
            }
        }
        return null;
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
