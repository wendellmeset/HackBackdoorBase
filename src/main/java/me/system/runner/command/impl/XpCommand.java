
package me.system.runner.command.impl;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import org.bukkit.entity.Player;

public class XpCommand
extends Command {
    private int Mc;

    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("xp give <amount>"));
        } else if (args[1].equalsIgnoreCase("give")) {
            try {
                this.Mc = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex2) {
                p2.sendMessage(Settings.PREFIX("The amount has to be a number"));
                return;
            }
            p2.giveExpLevels(this.Mc);
            p2.sendMessage("You have been given " + Settings.RED + this.Mc + " XP level");
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

