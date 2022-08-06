package fr.mrsuricate.login.listeners;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.utils.UExperienceManager;
import fr.mrsuricate.login.utils.Uplayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class LOnQuit implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void OnQuit(PlayerQuitEvent e) throws IOException {
        YamlConfiguration inventaire = YamlConfiguration.loadConfiguration(main.inventoryFile);
        YamlConfiguration position = YamlConfiguration.loadConfiguration(main.positionFile);
        YamlConfiguration heal = YamlConfiguration.loadConfiguration(main.healFile);
        YamlConfiguration saturation = YamlConfiguration.loadConfiguration(main.saturationFile);
        YamlConfiguration experience = YamlConfiguration.loadConfiguration(main.experienceFile);
        for (Uplayer data : main.playerLogin) {
            if (data.getPlayer().equals(e.getPlayer())) {
                inventaire.set("Inventory." + data.getName(), e.getPlayer().getInventory().getContents());
                position.set("Position." + data.getName(), e.getPlayer().getLocation());
                heal.set("Heal." + data.getName(), e.getPlayer().getHealth());
                saturation.set("Saturation." + data.getName(), e.getPlayer().getFoodLevel());
                experience.set("XP." + data.getName(), UExperienceManager.getTotalExperience(e.getPlayer()));
                inventaire.save(main.inventoryFile);
                position.save(main.positionFile);
                heal.save(main.healFile);
                saturation.save(main.saturationFile);
                experience.save(main.experienceFile);
                e.getPlayer().getInventory().clear();
                main.playerLogin.remove(data);
                break;
            }
        }
    }

}
