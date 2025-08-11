package database;

import model.TacGia;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public int insert(T t);
    public int insertAll(ArrayList<T> arr);
    public int delete(T t);
    public int deleteAll(ArrayList<T> t);
    public int update(T t);




}
