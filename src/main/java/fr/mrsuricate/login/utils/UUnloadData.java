package fr.mrsuricate.login.utils;

import fr.mrsuricate.login.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class UUnloadData {

    private final Main main = Main.getInstance();
    
    public void unloadPassword() throws IOException {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(main.passwordFile);
        for (Upassword password : main.password) {
            yamlConfiguration.set("Password."+password.getName(),password.getPassword());
        }
        yamlConfiguration.save(main.passwordFile);
    }
    
}
