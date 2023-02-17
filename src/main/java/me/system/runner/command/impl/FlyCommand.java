
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.entity.Player;

public class FlyCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (!p2.isFlying()) {
            p2.sendMessage(Settings.PREFIX("Set fly to enabled"));
            p2.setAllowFlight(true);
            p2.setFlying(true);
        } else {
            p2.sendMessage(Settings.PREFIX("Set fly to disabled"));
            p2.setAllowFlight(false);
            p2.setFlying(false);
        }
    }

    @Override
    public boolean isBlatant() {
        return true;
    }
}

