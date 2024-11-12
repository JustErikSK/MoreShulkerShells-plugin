package me.minecraft.plugin.moreShulkerShells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreShulkerShells extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "MoreShulkerShells >> Plugin has been enabled!");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void shulkerDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();

        if (ent.getType() == EntityType.SHULKER) {
            e.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 3));
        }
    }
}
