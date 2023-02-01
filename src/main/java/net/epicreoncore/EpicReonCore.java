package net.epicreoncore;

import net.epicreoncore.command.ChestsCommand;
import net.epicreoncore.data.PlayerData;
import net.epicreoncore.listener.ConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicReonCore extends JavaPlugin {
    public static String prefix = "<&dEpic&5Reon&f> ";
    public static PlayerData playerData;
    @Override
    public void onEnable() {
        this.playerData = new PlayerData(this);
        registerListener(new ConnectionListener());
        registerCommand("chests" , new ChestsCommand());
        SpawnSystem.initialise();
        SpawnSystem.startSchedule(this);
    }
    private void registerCommand(String command , CommandExecutor commandExecutor) {
        getCommand(command).setExecutor(commandExecutor);
    }
    private void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener , this);
    }
    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&' , string);
    }
}
