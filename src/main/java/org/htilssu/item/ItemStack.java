package org.htilssu.item;

import java.util.ArrayList;
import java.util.List;

public class ItemStack {
    Item item;
    int quantity;

    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
