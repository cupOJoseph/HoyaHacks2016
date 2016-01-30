package plugin.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class Tlogin implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){//make sure it's a player using the command, terminal and zombies aren't allowed to have twitters.
            //sender wasn't a player.
            return false;
        }


        return false;
    }
}
