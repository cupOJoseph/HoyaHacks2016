package plugin.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class tlogout implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender user, Command command, String s, String[] strings) {
        //nothing, don't use.
        user.sendMessage("This function has not been implemented.  Make a pull request if you want to fix it.");
        return false;
    }
}
