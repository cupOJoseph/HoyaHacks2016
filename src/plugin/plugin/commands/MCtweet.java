package plugin.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class MCtweet implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("tweet")){//check for twitter command

        }

        if(!(sender instanceof Player)){//make sure it's a player using the command, terminal and zombies aren't allowed to have twitters.
            //sender wasn't a player.
            return false;
        }

        Player tweeter = (Player) sender;
        //TODO: varify the tweeder owns that twitter account.  Error Check.

        //TODO: use args to let the user log into their twitter account, save that information securely somehow
        //use ChatColor.AQUA

        //"tweeter.getName() just got a diamond - via Bukkit.getIp()";

        return true;
    }
}
