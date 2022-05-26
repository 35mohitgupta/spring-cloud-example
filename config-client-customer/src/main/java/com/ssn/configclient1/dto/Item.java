package com.ssn.configclient1.dto;

public class Item {

    String name;
    int count;

    public String getName() {
        return name;
    }

    public Item(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
