package code.akselm.tsmcbot;

import com.thestratagemmc.droolchat.bot.Bot;
import com.thestratagemmc.droolchat.bot.BotInfo;
import com.thestratagemmc.droolchat.channels.PMFactory;
import com.thestratagemmc.droolchat.channels.PrivateMessageChannel;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Axel on 5/23/2016.
 */
public class TSMCBot extends JavaPlugin implements Listener {
    private Bot bot;
    private String message = "Say hi to the new boy in town, Steve! Ask a question in chat addressing 'Steve'.";

    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
        bot = new Bot() {
            @Override
            public BotInfo getInfo() {
                return new BotInfo("TSMCbot", "The server do-gooder.", ChatColor.GRAY, "0.1beta");
            }

            @Override
            public String respondToPM(Player player, String s) {
                return null;
            }
        };
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        PrivateMessageChannel channel = PMFactory.getBotChannel(event.getPlayer());
        channel.sendMessage(bot.getSender(), message, event.getPlayer());
    }
}
