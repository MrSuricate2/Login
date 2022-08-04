package fr.mrsuricate.login.commands;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.utils.UExperienceManager;
import fr.mrsuricate.login.utils.Upassword;
import fr.mrsuricate.login.utils.Uplayer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Clogin implements CommandExecutor {

    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            if (args.length <= 1){
                sender.sendMessage("/login <prénom> <mot de passe>");
            }
            if (args.length == 2){
                for (Upassword password: main.password) {
                    if (args[0].equalsIgnoreCase(password.getName())){
                        if (args[1].equalsIgnoreCase(password.getPassword())){
                            Player p = ((Player) sender).getPlayer();
                            assert p != null;
                            p.sendMessage("§aVous êtes désormais connecter "+ args[0].toLowerCase()+".");
                            main.playerLogin.add(new Uplayer(p.getPlayer(), args[0]));
                            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(main.dataFile);
                            ItemStack[] inventory = ((List<ItemStack>) (yamlConfiguration.get("Inventory." + args[0].toLowerCase()))).toArray(new ItemStack[0]);
                            p.getInventory().setContents(inventory);
                            Location loc = (Location) yamlConfiguration.get("Position." + args[0].toLowerCase());
                            p.teleport(loc);
                            double health = yamlConfiguration.getDouble("Heal." + args[0].toLowerCase());
                            p.getPlayer().setHealth(health);
                            int saturation = yamlConfiguration.getInt("Saturation." + args[0].toLowerCase());
                            p.getPlayer().setFoodLevel(saturation);
                            int XP = yamlConfiguration.getInt("XP." + args[0].toLowerCase());
                            UExperienceManager.setTotalExperience(p,XP);
                            p.setInvulnerable(false);
                            main.login.add(p);
                        } else {
                            sender.sendMessage("§cMauvaise information !");
                        }
                    }
                }

            }
        }
        return false;
    }
}
