package com.awesomedocs19.magicwand;

import org.bukkit.plugin.java.JavaPlugin;

public class MagicWandPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("MagicWandPlugin enabled!");
        getServer().getPluginManager().registerEvents(new WandEventListener(this), this);
        getCommand("magicwand").setExecutor(new MagicWandCommand(this));
    }


    @Override
    public void onDisable() {
        getLogger().info("MagicWandPlugin disabled.");
    }
}
