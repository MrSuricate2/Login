package fr.mrsuricate.login.managers;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.listeners.*;
import org.bukkit.plugin.PluginManager;

public class MListeners {

    private final Main main = Main.getInstance();

    public void initEvents() {
        PluginManager pm = main.getServer().getPluginManager();

        pm.registerEvents(new LOnJoin(), main);
        pm.registerEvents(new LOnQuit(), main);
        pm.registerEvents(new LPickItemOnGroung(), main);
        pm.registerEvents(new LPickExperienceOnGroung(), main);
        pm.registerEvents(new LDropItemOnGroung(), main);
        pm.registerEvents(new LPlayerMove(), main);
    }

}
