package net.epicreoncore.command;

import net.epicreoncore.EpicReonCore;
import net.epicreoncore.SpawnSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChestsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) return true;
        if (args[0].equalsIgnoreCase("update")) {
            SpawnSystem.spawnAll();
            sender.sendMessage(EpicReonCore.format(EpicReonCore.prefix + "Chests are updated successfully."));
            return true;
        }
        if (args[0].equalsIgnoreCase("get")) {
            Player player = (Player) sender;
            player.getInventory().addItem(SpawnSystem.spawnChest.getAsItem());
            player.getInventory().addItem(SpawnSystem.commonChest.getAsItem());
        }
        return true;
    }
}
