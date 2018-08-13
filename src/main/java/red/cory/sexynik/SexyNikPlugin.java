package red.cory.sexynik;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by Cory Redmond on 13/08/2018.
 * ace@ac3-servers.eu
 */
public class SexyNikPlugin extends JavaPlugin implements Listener {

    private final char[] colours = new char[]{'1','2','3','5','6','7','8','9','a','b','d','e','f'};
    private final Random rand = new Random();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You can not nik because you are not a player.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("nik")) {
            ((Player) sender).setDisplayName(ChatColor.getByChar(colours[rand.nextInt(colours.length)]) + "nik" + ChatColor.RESET);
            sender.sendMessage(ChatColor.GREEN + "You can use " + ChatColor.ITALIC + "/un" + label + ChatColor.RESET + ChatColor.GREEN + " to reset your name.");
        } else if (command.getName().equalsIgnoreCase("unnik")) {
            ((Player) sender).setDisplayName(null);
            sender.sendMessage(ChatColor.GOLD + "Reset your nik name.");
        } else {
            return false;
        }

        return true;
    }
}
