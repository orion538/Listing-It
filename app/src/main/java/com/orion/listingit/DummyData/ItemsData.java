package com.orion.listingit.DummyData;

import com.orion.listingit.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsData {

    private List<Item> itemsList = new ArrayList<Item>() {
        {
            add(new Item(0, "Bread"));
            add(new Item(1, "Eggs"));
            add(new Item(2, "Bacon"));
            add(new Item(3, "Vanilla Ice cream"));
            add(new Item(4, "Pancakes"));
            add(new Item(5, "Crisps"));
            add(new Item(6, "Chips"));
            add(new Item(7, "Cola"));
            add(new Item(8, "Orange Juice"));
            add(new Item(9, "Grapes"));
            add(new Item(10, "Blueberries"));
            add(new Item(11, "Strawberries"));
            add(new Item(12, "Bananas"));
            add(new Item(13, "Coffee"));
            add(new Item(14, "Chicken"));
            add(new Item(15, "Beef"));
            add(new Item(16, "Cookies"));
            add(new Item(17, "Milk"));
            add(new Item(18, "Donuts"));
            add(new Item(19, "Tea"));
            add(new Item(20, "Peas"));
            add(new Item(21, "Beans"));
            add(new Item(22, "Melons"));
        }
    };

    public List<Item> getItemsList() {
        return itemsList;
    }

}
