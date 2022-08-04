package fr.mrsuricate.login;

import fr.mrsuricate.login.managers.MCommands;
import fr.mrsuricate.login.managers.MFiles;
import fr.mrsuricate.login.managers.MListeners;
import fr.mrsuricate.login.managers.MLoad;
import fr.mrsuricate.login.utils.*;
import org.bukkit.configuration.file.FileConfiguration;
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

    //data.yml [Default folder]
    public File dataFile = new File(getDataFolder().getPath() + "/data.yml");
    public FileConfiguration fileDataConfiguration;

    //message.yml [Default folder]
    public File messagesFile = new File(getDataFolder().getPath() + "/messages.yml");
    public FileConfiguration fileMessagesConfiguration;


    //List
    public List<Upassword> password = new ArrayList<>();
    public List<Player> login = new ArrayList<>();
    public List<Uplayer> playerLogin = new ArrayList<>();
    public List<UInventory> playerInventory = new ArrayList<>();




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

    public MLoad getLoadManager() {
        return loadManager;
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
