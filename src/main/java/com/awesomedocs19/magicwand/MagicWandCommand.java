package com.awesomedocs19.magicwand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MagicWandCommand implements CommandExecutor {
    private final MagicWandPlugin plugin;

    public MagicWandCommand(MagicWandPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
        Player player = (Player) sender;
        player.getInventory().addItem(ItemManager.createMagicWand());
        player.sendMessage("You have been given a magic wand! you will now be happy");
        return true;
    }
}
