package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class MCtweet implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /**
         * sender is the player or console sending command
         * label is "tweet"
         *
         */


        if(!(sender instanceof Player)){//make sure it's a player using the command, terminal and zombies aren't allowed to have twitters.
            //sender wasn't a player.
            return false;
        }

        Player tweeter = (Player) sender;
        //TODO: varify the tweeter owns that twitter account.  Error Check.

        //use ChatColor.AQUA
        String words = args[0];
        for(int i =1; i<args.length; i++){
            words = " " + args[i];
        }
        //"tweeter.getName() just got a diamond - via Bukkit.getIp()";

        tweeter.sendMessage(ChatColor.AQUA + "Tweet Sent!");

        return false;
    }
}
