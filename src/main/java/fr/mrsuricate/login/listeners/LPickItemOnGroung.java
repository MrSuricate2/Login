package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class LPickItemOnGroung implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnPickItemOnGround(EntityPickupItemEvent e){
        if (e.getEntity() instanceof Player){
            Player p = ((Player) e.getEntity()).getPlayer();
            if (!main.login.contains(p)){
                e.setCancelled(true);
            }
        }
    }
}
