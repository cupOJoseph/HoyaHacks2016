/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
package plugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.plugin.commands.MCtweet;


import plugin.plugin.commands.Tlogin;



public class Commands extends JavaPlugin{

    public void onEnable(){

        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");


        //where to send commands
        getCommand("tweet").setExecutor(new MCtweet());
        getCommand("tlogin").setExecutor(new Tlogin());

        logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ") !");
    }

    public void  onDisable(){
        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

        logger.info(pdfFile.getName() + " has been disabled sucessfully.");
    }



}
