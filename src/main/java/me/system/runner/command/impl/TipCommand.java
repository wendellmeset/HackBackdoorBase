
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import me.system.runner.methods.Tips;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TipCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip()));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

