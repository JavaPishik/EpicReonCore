package net.epicreoncore.chests;

import net.epicreoncore.utils.SimpleItem;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EPSpawnChest extends EPChest {

    @Override
    public List<Chest> getChests() {
        List<Chest> chests = new ArrayList<>();
        chests.add(getChest(8 , -62 , -14));
        chests.add(getChest(5 , -61 , 3));
        chests.add(getChest(-10 , -62 , -10));
        return chests;
    }

    @Override
    public void spawnItems() {
        for (Chest chest : getChests()) chest.getInventory().clear();
        spawnItem(new SimpleItem(Material.COOKIE , "&aSpawn Cookie" , "&7Very testy food"), 5 , 0.8);
        spawnItem(new SimpleItem(Material.WOODEN_SWORD , "&aSpawn Sword" , "&7The weakest weapon"), 3 , 0.5);
    }

    @Override
    public ItemStack getAsItem() {
        return new SimpleItem(Material.CHEST , "&aSpawn Chest" , "&7Tier : 0");
    }

}
