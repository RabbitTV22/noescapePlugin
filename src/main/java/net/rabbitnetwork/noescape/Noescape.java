package net.rabbitnetwork.noescape;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Noescape extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().severe("[No Escape] Started up");
Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void playerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() || player.getName() == "RabbitTV") {

            return;
        }

        if (player.getLocation().getY() >= 28) {
            Location newLocation = player.getLocation().subtract(0, 1, 0);
            player.teleport(newLocation);
        }
    }



    @Override
    public void onDisable() {
      Bukkit.getLogger().severe("[NoEscape] Closed");


    }
}
