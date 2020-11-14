package com.example.dicesimulator.model;

public class Role {
    private long id;
    private String nums;

    public Role(long id, String num) {
        this.id = id;
        this.nums = num;
    }

    public long getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getNums() { return this.nums; }
    public void setNums(String nums) { this.nums = nums; }


}
