package com.orion.listingit.Models;

public class Item {

    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(Item item) {
        this.id = item.id;
        this.name = item.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
