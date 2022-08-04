package fr.mrsuricate.login.managers;

import fr.mrsuricate.login.Main;
import fr.mrsuricate.login.commands.Clogin;
import fr.mrsuricate.login.commands.Cregister;

import java.util.Objects;

public class MCommands {

    private final Main main = Main.getInstance();

    public void initCommands() {
        Objects.requireNonNull(main.getCommand("login")).setExecutor(new Clogin());
        Objects.requireNonNull(main.getCommand("register")).setExecutor(new Cregister());
    }

}
