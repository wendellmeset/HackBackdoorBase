
package me.system.runner.command.impl.admin;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LoginCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (plugin.admin.contains(p2.getName())) {
            if (args.length <= 2) {
                p2.sendMessage(Settings.USAGE("login <player> <rank>"));
            } else {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else if (plugin.lite.contains(target.getName())) {
                    p2.sendMessage(Settings.PREFIX("This player is already logged in"));
                } else {
                    if (args[2].equalsIgnoreCase("admin")) {
                        plugin.lite.add(target.getName());
                        plugin.premium.add(target.getName());
                        plugin.admin.add(target.getName());
                        p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " has been logged into " + Settings.RED + Settings.NAME + " admin"));
                    } else if (args[2].equalsIgnoreCase("premium")) {
                        plugin.lite.add(target.getName());
                        plugin.premium.add(target.getName());
                        p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " has been logged into " + Settings.RED + Settings.NAME + " premium"));
                    } else if (args[2].equalsIgnoreCase("lite")) {
                        plugin.lite.add(target.getName());
                        p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " has been logged into " + Settings.RED + Settings.NAME + " lite"));
                    } else {
                        plugin.lite.add(target.getName());
                        plugin.free.add(target.getName());
                        p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " has been logged into " + Settings.RED + Settings.NAME + " free"));
                    }
                    target.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " " + args[2].toLowerCase() + Settings.WHITE + " by an admin"));
                }
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

