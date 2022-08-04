package fr.mrsuricate.login.utils;

import org.bukkit.entity.Player;

public class Uplayer {

    private final Player player;
    private final String name;

    public Uplayer(Player player, String name){
        this.name = name;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }
}
