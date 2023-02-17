
package me.system.runner.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PluginUtils {
    public static Plugin getPluginByName(String name) {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (!name.equalsIgnoreCase(plugin.getName())) continue;
            return plugin;
        }
        return null;
    }
}

