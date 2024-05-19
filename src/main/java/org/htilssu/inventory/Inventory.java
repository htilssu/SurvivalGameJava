package org.htilssu.inventory;

import org.htilssu.item.Item;

import java.util.List;

public abstract class Inventory {
    protected int size;
    List<Item> items;

    public int getSize() {
        return size;
    }
}
