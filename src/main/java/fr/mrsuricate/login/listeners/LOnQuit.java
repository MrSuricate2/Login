package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.utils.UExperienceManager;
import fr.mrsuricate.login.utils.Uplayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

public class LOnQuit implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnQuit(PlayerQuitEvent e){
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(main.dataFile);
        for (Uplayer data : main.playerLogin) {
            if (data.getPlayer().equals(e.getPlayer())) {
                yamlConfiguration.set("Inventory." + data.getName(), e.getPlayer().getInventory().getContents());
                yamlConfiguration.set("Position." + data.getName(), e.getPlayer().getLocation());
                yamlConfiguration.set("Heal." + data.getName(), e.getPlayer().getHealth());
                yamlConfiguration.set("Saturation." + data.getName(), e.getPlayer().getFoodLevel());
                yamlConfiguration.set("XP." + data.getName(), UExperienceManager.getTotalExperience(e.getPlayer()));
                try {
                    yamlConfiguration.save(main.dataFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                e.getPlayer().getInventory().clear();
                main.playerLogin.remove(data);
                break;
            }
        }
    }

}
