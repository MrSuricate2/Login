package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;
import java.util.logging.Level;

public class LPlayerDeath implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getPlayer();
        if (e.getDeathMessage().contains("drowned")){
            e.setDeathMessage(p.getName()+" a rejoint le petit Grégory !");
        }
        if (e.getDeathMessage().contains("Creeper")){
            e.setDeathMessage(p.getName()+" a coincé son pousse dans un creeper !");
        }
        if (e.getDeathMessage().contains("flammes")){
            e.setDeathMessage(p.getName()+" a découvert que le feu sa brûles !");
        }
    }

}
