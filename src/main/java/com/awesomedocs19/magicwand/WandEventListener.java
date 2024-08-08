package com.awesomedocs19.magicwand;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent.Action;
import org.bukkit.entity.Player;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.Location;

public class WandEventListener implements Listener {
    private final MagicWandPlugin plugin;

    public WandEventListener(MagicWandPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            
            if (item.getType() == Material.STICK && item.hasItemMeta()) {
                int modelData = item.getItemMeta().getCustomModelData();
                
                if (modelData == 1) {
                    Location loc = player.getLocation();
                    Vector direction = loc.getDirection().multiply(2);
                    Fireball fireball = (Fireball) player.getWorld().spawnEntity(loc.add(direction), EntityType.FIREBALL);
                    fireball.setDirection(direction);
                    player.sendMessage("Watch out, fireball launched!");
                } else if (modelData == 2) {
                    Location loc = player.getLocation();
                    loc.setX(loc.getX() + 10);
                    player.teleport(loc);
                    player.sendMessage("teleported...");
                }
            }
        }
    }

}
