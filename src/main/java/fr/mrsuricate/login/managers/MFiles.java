package fr.mrsuricate.login.managers;

import fr.mrsuricate.login.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

public class MFiles {

    private final Main main = Main.getInstance();

    public void initFile() {
        ressourceSetup("","Experience.yml", false);
        ressourceSetup("","Heal.yml", false);
        ressourceSetup("","Inventory.yml", false);
        ressourceSetup("","Password.yml", false);
        ressourceSetup("","Position.yml", false);
        ressourceSetup("","Saturation.yml", false);
    }

    public void ressourceSetup(String folder, String fileName, boolean reset) {
        InputStream in;
        if (folder.isEmpty()) {
            in = main.getResource(fileName);
        } else {
            in = main.getResource(folder + "/" + fileName);
        }

        if (in == null) {
            throw new IllegalArgumentException("La ressource intégrée '" + fileName + "' ne peut être trouvé !");
        }
        File outDir;
        if (folder.isEmpty()) {
            outDir = new File(main.getDataFolder(), "");
        } else {
            outDir = new File(main.getDataFolder() + "/" + folder, "");
        }
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        File outFile;
        if (folder.isEmpty()) {
            outFile = new File(main.getDataFolder(), fileName);
        } else {
            outFile = new File(main.getDataFolder() + "/" + folder, fileName);
        }
        if (!outFile.exists() || reset) {
            try {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte['?'];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } catch (Exception e) {
                main.logConsole(Level.WARNING, "Fichier " + fileName + " n'a pas été trouvé !");
            }
        }


    }

}
