package fr.mrsuricate.login.utils;

import fr.mrsuricate.login.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import java.util.Objects;

public class ULoadData {

    private final Main main = Main.getInstance();
    public void loadPassword(){
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(main.passwordFile);
        if (main.passwordFile.length() != 0L) {
            Objects.requireNonNull(yamlConfiguration.getConfigurationSection("Password")).getKeys(true).forEach(key ->
                    main.password.add(new Upassword(key, (String) yamlConfiguration.get("Password."+key))));
            main.allPlayerRegistered.addAll(Objects.requireNonNull(yamlConfiguration.getConfigurationSection("Password")).getKeys(true));
        }
    }
}
