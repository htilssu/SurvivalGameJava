package org.htilssu.inventory;

public class InventoryManager {
    boolean isOpen = false;
    Inventory currentInventory;

    public void openInventory() {
        if (currentInventory != null) {
            //TODO: open inventory
            isOpen = true;
        } else {
            isOpen = false;
        }
    }

    public void render() {
        
    }

    public void setCurrentInventory(Inventory currentInventory) {
        this.currentInventory = currentInventory;
    }
}

