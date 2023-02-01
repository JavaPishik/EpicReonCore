package net.epicreoncore.chests;

import net.epicreoncore.utils.SimpleItem;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EPCommonChest extends EPChest {

    @Override
    public List<Chest> getChests() {
        List<Chest> chests = new ArrayList<>();
        chests.add(getChest(40 , -63 , -65));
        return chests;
    }

    @Override
    public void spawnItems() {
        for (Chest chest : getChests()) chest.getInventory().clear();
        spawnItem(new SimpleItem(Material.OAK_BOAT , "&7Boat" , "&7The fastest vehicle"), 1 , 0.5);
    }

    @Override
    public ItemStack getAsItem() {
        return new SimpleItem(Material.CHEST , "&7Common Chest" , "&7Tier : 1");
    }

}
