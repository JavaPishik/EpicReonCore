package net.epicreoncore;

import net.epicreoncore.chests.EPCommonChest;
import net.epicreoncore.chests.EPSpawnChest;
import net.epicreoncore.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnSystem {
    public static EPSpawnChest spawnChest;
    public static EPCommonChest commonChest;

    public static void initialise() {
        spawnChest = new EPSpawnChest();
        commonChest = new EPCommonChest();
    }

    public static void spawnAll() {
        Bukkit.broadcastMessage(EpicReonCore.format(EpicReonCore.prefix + "&fAll chests are updated by an administrator!"));
        spawnChest.spawnItems();
        commonChest.spawnItems();
    }

    public static void startSchedule(JavaPlugin plugin) {
        new BukkitRunnable() {@Override public void run() {
            spawnChest.spawnItems();
            Bukkit.broadcastMessage(EpicReonCore.format(EpicReonCore.prefix + "&aSpawn Chests Are Updated!"));
        }}.runTaskTimer(plugin , 0 , 1200);

        new BukkitRunnable() {@Override public void run() {
            commonChest.spawnItems();
            Bukkit.broadcastMessage(EpicReonCore.format(EpicReonCore.prefix + "&7Common Chests Are Updated!"));
        }}.runTaskTimer(plugin , 0 , 3600);
    }
}
