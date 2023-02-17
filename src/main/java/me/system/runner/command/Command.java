
package me.system.runner.command;

import me.system.runner.Core;
import me.system.runner.utils.Settings;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Command
implements Listener {
    public boolean isBlatant() {
        return false;
    }

    public void execute(Core plugin, String msg, String[] args, Player p2) {
        p2.sendMessage(Settings.PREFIX("Unable to execute that command"));
    }
}

