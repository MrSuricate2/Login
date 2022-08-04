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
        main.logConsole(Level.INFO, Objects.requireNonNull(e.deathMessage()).toString());
    }

}
