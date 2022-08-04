package fr.mrsuricate.login.listeners;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import fr.mrsuricate.login.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class LPickExperienceOnGroung implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnPickExperienceOnGround(PlayerPickupExperienceEvent e){
        Player p = e.getPlayer();
        if (!main.login.contains(p)){
            e.setCancelled(true);
        }
    }

}
