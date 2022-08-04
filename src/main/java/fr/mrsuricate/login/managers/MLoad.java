package fr.mrsuricate.login.managers;

import fr.mrsuricate.login.Main;

import java.io.IOException;
import java.util.logging.Level;

public class MLoad {

    private final Main main = Main.getInstance();

    public void pluginLoad(){
        long start_timer = System.currentTimeMillis();

        main.logConsole(Level.INFO, "=== Debut du chargement ===");
        main.logConsole(Level.INFO, "Chargement du plugin en cours...");
        main.logConsole(Level.INFO, "Chargement des Listeners...");
        main.getEventsManager().initEvents();
        main.logConsole(Level.INFO, "Chargement des Fichiers...");
        main.getFilesManager().initFile();
        main.logConsole(Level.INFO, "Chargement des Commands...");
        main.getCommandsManager().initCommands();
        main.logConsole(Level.INFO, "Chargement des Données...");
        main.getuLoadData().loadPassword();
        main.logConsole(Level.INFO, "----");

        long end_timer = System.currentTimeMillis();

        main.logConsole(Level.INFO, "Chargement termine en " + (end_timer - start_timer) + " ms");
        pluginEnable();
    }

    public void pluginUnLoad() throws IOException {
        main.logConsole(Level.INFO, "Enregistrement des Données...");
        main.getuUnloadData().unloadPassword();
        pluginDisable();
    }


    public void pluginEnable() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin Login");
        main.logConsole(Level.INFO, "Status: On");
        main.logConsole(Level.INFO, "----");
    }

    public void pluginDisable() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin Login");
        main.logConsole(Level.INFO, "Status: Off");
        main.logConsole(Level.INFO, "----");
    }

}
