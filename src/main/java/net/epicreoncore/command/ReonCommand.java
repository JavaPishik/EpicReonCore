package net.epicreoncore.command;

import net.epicreoncore.EpicReonCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            return true;
        }
        if (args[0].equalsIgnoreCase("info")) {
            Player player = (Player) sender;
            player.sendMessage(EpicReonCore.format("&7============================================"));
            player.sendMessage(EpicReonCore.format("Current Reon: &d" + EpicReonCore.playerData.getConfig().get(player.getUniqueId().toString() + ".data.reon.type")));
            player.sendMessage(EpicReonCore.format("Current Reon Level: &b" + EpicReonCore.playerData.getConfig().get(player.getUniqueId().toString() + ".data.reon.level")));
            player.sendMessage(EpicReonCore.format("&7============================================"));
        }
        return true;
    }
}
