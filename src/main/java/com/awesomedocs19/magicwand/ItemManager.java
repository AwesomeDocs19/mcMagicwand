package com.awesomedocs19.magicwand;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack createMagicWand(int modelData) {
        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta meta = wand.getItemMeta();
        meta.setDisplayName("Magic Wand");
        meta.setCustomModelData(modelData);
        wand.setItemMeta(meta);
        return wand;
    }
}
