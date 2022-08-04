package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.utils.UExperienceManager;
import fr.mrsuricate.login.utils.Upassword;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LOnJoin implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        e.getPlayer().sendMessage("§5/register <prenom> <mot de passe>");
        e.getPlayer().sendMessage("§5/login <prenom> <mot de passe>");
        e.getPlayer().setHealth(20);
        e.getPlayer().setFoodLevel(20);
        UExperienceManager.setTotalExperience(e.getPlayer(),0);
        e.getPlayer().setInvulnerable(true);
    }

}
