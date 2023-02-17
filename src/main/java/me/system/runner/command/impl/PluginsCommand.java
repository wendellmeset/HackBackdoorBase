
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PluginsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        StringBuilder plugins = new StringBuilder();
        for (int i2 = 0; i2 < Bukkit.getPluginManager().getPlugins().length; ++i2) {
            if (Bukkit.getPluginManager().getPlugins()[i2].isEnabled()) {
                plugins.append(Settings.WHITE).append(Bukkit.getPluginManager().getPlugins()[i2].getName()).append(", ");
                continue;
            }
            plugins.append(Settings.RED).append(Bukkit.getPluginManager().getPlugins()[i2].getName()).append(Settings.WHITE + ", ");
        }
        p2.sendMessage(Settings.PREFIX(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + Bukkit.getPluginManager().getPlugins().length + "&8) " + Settings.WHITE + plugins.substring(2, plugins.length())))));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

