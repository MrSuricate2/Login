package fr.mrsuricate.login.tabcompleter;

import fr.mrsuricate.login.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Tlogin implements TabCompleter {

    private final Main main = Main.getInstance();

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            return null;
        }
        List<String> list = new ArrayList<>();
        if (args.length == 1){
            list.addAll(main.allPlayerRegistered);
            return list;
        }
        if (args.length == 2){
            list.add("Mots de passe");
            return list;
        }
        return null;
    }
}
