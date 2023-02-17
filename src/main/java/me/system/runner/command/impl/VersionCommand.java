
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.entity.Player;

public class VersionCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(Settings.PREFIX(Settings.NAME + "'s version is " + Settings.RED + "2.5.4"));
        p2.sendMessage(Settings.INFO("Made By " + Settings.RED + "Wendellmeset!"));
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

