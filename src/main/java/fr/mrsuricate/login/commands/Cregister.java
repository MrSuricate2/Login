package fr.mrsuricate.login.commands;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.utils.Upassword;
import fr.mrsuricate.login.utils.Uplayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Cregister implements CommandExecutor {

    private final Main main = Main.getInstance();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            if (args.length < 2){
                sender.sendMessage("/register <prénom> <mot de passe>");
            }
            if (args.length == 2){
                if (main.allPlayerRegistered.contains(args[0].toLowerCase())){
                    main.password.add(new Upassword(args[0].toLowerCase(),args[1]));
                    main.playerLogin.add(new Uplayer(((Player) sender).getPlayer(), args[0].toLowerCase()));
                    main.login.add(((Player) sender).getPlayer());
                    sender.sendMessage("§aEnregistrement terminer !");
                } else {
                    sender.sendMessage("§cVous avez déjà un compte");
                }
            }
            if (args.length > 2){
                sender.sendMessage("/register <prénom> <mot de passe>");
            }
        }
        return false;
    }
}
