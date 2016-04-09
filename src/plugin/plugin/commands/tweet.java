package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class tweet implements CommandExecutor{

    public String ConsumerKey = "", SecretKey="", MyAccessToken="", MySecretToken="";

    public tweet(String key1, String key2, String key3, String key4) {
        this.ConsumerKey = key1;
        this.SecretKey = key2;
        this.MyAccessToken = key3;
        this.MySecretToken = key4;
        return; //get 4 strings as the keys from the main java file, which takes them from the config file on startup.

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){//make sure it's a player using the command, terminal and zombies aren't allowed to have twitters.
            //sender wasn't a player.
            return false;
        }

        /**
         * sender is the player or console sending command
         * label is "tweet"
         *
         * for(int i = 0; i < args.length; i++){
         sender.sendMessage(args[i]);
         }
         *
         */



        Player tweeter = (Player) sender;
        String IP = tweeter.getServer().getIp();
        int length = 140 - (IP.length() + 1);
        if (length < 1){
            tweeter.sendMessage("There was a problem with your tweet. Your IP is too long!");
            return false;
        }

        // varify the tweeter owns that twitter account.  Error Check.
        AccessToken myToken = getMyAccessToken();

        //create tweet
        TwitterFactory factory = new TwitterFactory();
        Twitter twitter = factory.getInstance();

        twitter.setOAuthConsumer(ConsumerKey, SecretKey);//Consumer Key (API Key), consumer api.

        twitter.setOAuthAccessToken(myToken);

        //use ChatColor.AQUA
        String words = args[0];
        for(int i =1; i<args.length; i++){
            words = words + " " + args[i];
        }
        //"tweeter.getName() just got a diamond - via Bukkit.getIp()";
        // count the words
        sender.sendMessage(words);

        if(words.length() > length){
            //shorten words
            words = words.substring(0,length-1);
        }


        // add IP address to the end of words
        words = words + " " + IP;


        try {
            Status status = twitter.updateStatus(words);
        } catch (TwitterException e) {
            tweeter.sendMessage("There was a problem with your tweet.");
            e.printStackTrace();
        }

        tweeter.sendMessage(ChatColor.AQUA + "Tweet Sent!");

        return false;
    }

    private AccessToken getMyAccessToken(){
        String token = this.MyAccessToken;  // todo load from a persistent store
        String tokenSecret = this.MySecretToken;  // load from a persistent store
        return new AccessToken(token, tokenSecret);
    }
}
