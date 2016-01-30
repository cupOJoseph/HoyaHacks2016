package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.*;

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


        Player user = (Player) sender;
        String name = user.getName();

        //TODO: authorize user's twitter account

        try {
            useTokens(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.sendMessage(ChatColor.AQUA + "Logged in.");
        return false;
    }

    public void useTokens(Player player) throws Exception{
        //Your Twitter App's Consumer Key
        String consumerKey = "km8Fdp3UT5ajoMy6ipeaxe1lM";

        //Your Twitter App's Consumer Secret
        String consumerSecret = "lvljKyXOpUZiKDFUZ7tMHOuyxWkZfiFRwsjsWjlsdKKmJ3gZG4";

        // Twitter Access Token, for each user
        String accessToken = "-";

        // Twitter Access Token Secret, for each user
        String accessTokenSecret = "";

        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();

        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();

        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        RequestToken requestToken = twitter.getOAuthRequestToken();

        AccessToken aToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == aToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            String pin = br.readLine();
            try{
                if(pin.length() > 0){
                    aToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else{
                    aToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te) {
                if(401 == te.getStatusCode()){
                    System.out.println("Unable to get the access token.");
                }else{
                    te.printStackTrace();
                }
            }
        }
        //setup OAuth Access Token
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));


    }
}

