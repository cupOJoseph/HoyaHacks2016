/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
package plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.plugin.commands.MCtweet;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.*;


public class Commands extends JavaPlugin{

    /**  public static void main(String[] argu){
     //Your Twitter App's Consumer Key
     String consumerKey = "";

     //Your Twitter App's Consumer Secret
     String consumerSecret = "";

     //Your Twitter Access Token
     String accessToken = "-";

     //Your Twitter Access Token Secret
     String accessTokenSecret = "";

     //Instantiate a re-usable and thread-safe factory
     TwitterFactory twitterFactory = new TwitterFactory();

     //Instantiate a new Twitter instance
     Twitter twitter = twitterFactory.getInstance();

     //setup OAuth Consumer Credentials
     twitter.setOAuthConsumer(consumerKey, consumerSecret);

     //setup OAuth Access Token
     twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

     twitter.users()
     }**/


    public void onEnable(){

        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

        getCommand("tweet").setExecutor(new MCtweet());

        logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ") !");
    }

    public void  onDisable(){
        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

        logger.info(pdfFile.getName() + " has been disabled sucessfully.");
    }



}
