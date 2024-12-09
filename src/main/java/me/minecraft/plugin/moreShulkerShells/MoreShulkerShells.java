package me.minecraft.plugin.moreShulkerShells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
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
        saveDefaultConfig();

        FileConfiguration config = this.getConfig();
        config.addDefault("shulker_shell_drop_amount", 3);
    }

    @EventHandler
    public void shulkerDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();

        int ss_am = this.getConfig().getInt("shulker_shell_drop_amount", 3);

        if (ss_am > 10 || ss_am < 1) {
            ss_am = 3;
        }

        if (ent.getType() == EntityType.SHULKER) {
            e.getDrops().add(new ItemStack(Material.SHULKER_SHELL, ss_am));
        }
    }
}
