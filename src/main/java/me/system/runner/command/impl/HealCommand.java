
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;


public class HealCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.PREFIX("You have been healed"));
            if (p2.getMaxHealth() == 20.0) {
                p2.setHealth(20.0);
            }
            else {
                p2.setMaxHealth(p2.getMaxHealth());
            }
            for (PotionEffect effects : p2.getActivePotionEffects()) {
                
                
                
                
                
            }
        } else if (args[1].equals("*")) {
            for (Player a2 : Bukkit.getOnlinePlayers()) {
                a2.sendMessage(Settings.PREFIX("You have been healed by " + Settings.RED + p2.getName()));
                if (a2.getMaxHealth() == 20.0) {
                    a2.setHealth(20.0);
                }
                else {
                    a2.setHealth(a2.getMaxHealth());
                }
                for (PotionEffect effects : a2.getActivePotionEffects()) {
                    
                    
                }
            }
            p2.sendMessage(Settings.PREFIX("Everyone was healed!"));
        } else {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if (target == null) {
                p2.sendMessage(Settings.PREFIX("The player " + Settings.RED + args[1] + Settings.WHITE + " is not online."));
            } else {
                target.sendMessage(Settings.PREFIX("You have been healed by " + Settings.RED + p2.getName()));
                if (target.getMaxHealth() == 20.0) {
                    target.setHealth(20.0);
                }
                else {
                    target.setHealth(target.getMaxHealth());
                }
                for (PotionEffect effects : target.getActivePotionEffects()) {
                    
                    
                }
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }


}

