package fr.mrsuricate.login.utils;

import org.bukkit.inventory.ItemStack;

public class UInventory {

    private final String name;
    private final ItemStack[] item;

    public UInventory(String name, ItemStack[] item){
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public ItemStack[] getItem() {
        return item;
    }
}
