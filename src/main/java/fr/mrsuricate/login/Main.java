package fr.mrsuricate.login;

import fr.mrsuricate.login.managers.MCommands;
import fr.mrsuricate.login.managers.MFiles;
import fr.mrsuricate.login.managers.MListeners;
import fr.mrsuricate.login.managers.MLoad;
import fr.mrsuricate.login.utils.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class Main extends JavaPlugin {

    //Instance du Plugin
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    //Manager
    private MLoad loadManager;
    private MListeners eventsManager;
    private MCommands commandsManager;
    private MFiles filesManager;

    //Utils
    private ULoadData uLoadData;
    private UUnloadData uUnloadData;

    //Files

    //Experience.yml [Default folder]
    public File experienceFile = new File(getDataFolder().getPath() + "/Experience.yml");
    //Heal.yml [Default folder]
    public File healFile = new File(getDataFolder().getPath() + "/Heal.yml");
    //Inventory.yml [Default folder]
    public File inventoryFile = new File(getDataFolder().getPath() + "/Inventory.yml");
    //Password.yml [Default folder]
    public File passwordFile = new File(getDataFolder().getPath() + "/Password.yml");
    //Position.yml [Default folder]
    public File positionFile = new File(getDataFolder().getPath() + "/Position.yml");
    //Saturation.yml [Default folder]
    public File saturationFile = new File(getDataFolder().getPath() + "/Saturation.yml");


    //List
    public List<Upassword> password = new ArrayList<>();
    public List<Player> login = new ArrayList<>();
    public List<String> allPlayerRegistered = new ArrayList<>();
    public List<Uplayer> playerLogin = new ArrayList<>();


    @Override
    public void onEnable() {
        instance = this;

        loadManager = new MLoad();
        eventsManager = new MListeners();
        filesManager = new MFiles();
        commandsManager = new MCommands();

        uLoadData = new ULoadData();
        uUnloadData = new UUnloadData();

        loadManager.pluginLoad();

    }

    @Override
    public void onDisable() {
        try {
            loadManager.pluginUnLoad();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MListeners getEventsManager() {
        return eventsManager;
    }

    public MCommands getCommandsManager() {
        return commandsManager;
    }

    public MFiles getFilesManager() {
        return filesManager;
    }

    public void logConsole(Level level, String msg) {
        getLogger().log(level, msg);
    }

    public ULoadData getuLoadData() {
        return uLoadData;
    }

    public UUnloadData getuUnloadData() {
        return uUnloadData;
    }


}
