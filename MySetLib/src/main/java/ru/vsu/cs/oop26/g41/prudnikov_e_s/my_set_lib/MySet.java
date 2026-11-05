package ru.vsu.cs.oop26.g41.prudnikov_e_s.my_set_lib;

public class MySet {
    private int[] data;
    private int size;

    public MySet(){
        data = new int[10];
        size = 0;
    }
    private void resize(int n){

    }
    public void add(int v){
        if (contains(v)){
            return;
        }
        if (size >= data.length){
            resize(data.length + 10);
        }
        data[size] = v;
        size++;
    }
    public void remove(int v){

    }
    public int size(){
        return size;
    }
    public boolean contains(int v){
        return false;
    }

}
