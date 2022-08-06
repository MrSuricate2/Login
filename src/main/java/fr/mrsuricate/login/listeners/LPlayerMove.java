package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LPlayerMove implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (!main.login.contains(p)){
            e.setCancelled(true);
            e.getPlayer().sendMessage("§5/register <prenom> <mot de passe>");
            e.getPlayer().sendMessage("§5/login <prenom> <mot de passe>");
        }
    }

}
