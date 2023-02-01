package net.epicreoncore.listener;

import net.epicreoncore.EpicReonCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        event.setJoinMessage(ChatColor.LIGHT_PURPLE + player.getName() + " Joined!");
        if (!EpicReonCore.playerData.getConfig().contains(playerUUID)) {
            EpicReonCore.playerData.getConfig().set(playerUUID + ".name" , player.getName());
            EpicReonCore.playerData.getConfig().set(playerUUID + ".data.reon.type" , "fire");
            EpicReonCore.playerData.getConfig().set(playerUUID + ".data.reon.level" , 1);
            EpicReonCore.playerData.saveConfig();
        }
    }
    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.DARK_PURPLE + event.getPlayer().getName() + " Quit!");
    }
}
