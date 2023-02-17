
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import me.system.runner.methods.API;
import org.bukkit.entity.Player;

public class ServerchatCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            if (plugin.serverchat.contains(p2.getName())) {
                plugin.serverchat.remove(p2.getName());
                p2.sendMessage(Settings.PREFIX("ServerChat has been turned " + Settings.RED + "OFF"));
            } else {
                plugin.serverchat.add(p2.getName());
                p2.sendMessage(Settings.PREFIX("ServerChat has been turned " + Settings.RED + "ON"));
                p2.sendMessage(Settings.PREFIX("Everything you send will be sent to ServerChat as long as it isn't a HackBackdoor command"));
            }
        } else {
            StringBuilder chat = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                chat.append(args[i2]).append(" ");
            }
            API.sendPM(p2, chat.toString());
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

