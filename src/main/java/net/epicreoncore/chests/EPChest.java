package net.epicreoncore.chests;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class EPChest {

    public abstract List<Chest> getChests();
    public abstract void spawnItems();
    public abstract ItemStack getAsItem();

    public void spawnItem(ItemStack item, int tries, double chance) {
        for (Chest chest : getChests()) {
            int i = 0;
            while (i < tries) {
                if (Math.random() <= chance) {
                    int slot = ThreadLocalRandom.current().nextInt(0, chest.getInventory().getSize());
                    while (chest.getInventory().getItem(slot) != null) slot = ThreadLocalRandom.current().nextInt(0, chest.getInventory().getSize());
                    chest.getInventory().setItem(slot , item);
                }
                i++;
            }
        }
    }

    public Chest getChest(int x, int y, int z) {
        return (Chest) new Location(Bukkit.getWorld("EpicReon World") , x , y , z).getBlock().getState();
    }

}
