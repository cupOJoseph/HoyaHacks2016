package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
public class Tlogin implements CommandExecutor{

    java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){//make sure it's a player using the command, the command line and zombies aren't allowed to have twitters.
            //sender wasn't a player.
            return false;
        }

        /**

        Player user = (Player) sender;
        String name = user.getName();



        //: authorize user's twitter account
        //user.sendMessage("We're working on it, " + name + ".");
        try {
            logger.info("Getting token");
            useTokens(user);

        } catch (Exception e) {
            user.sendMessage("One fish, two fish.  Red fish, there's a serious problem fish.");
            e.printStackTrace();
        }

        //user.sendMessage(ChatColor.AQUA + "Logged in.") unless you didnt **/
        sender.sendMessage("This function has not been implemented.  Make a pull request if you want to fix it.");

        return false;
    }

    public void useTokens(Player player) throws Exception{
        //Your Twitter App's Consumer Key              TODO: PUT IN the ACTUAL VALUES FOR THE FIRST 2 VARIABLES
       /** String consumerKey = "";

        //Your Twitter App's Consumer Secret
        String consumerSecret = "";

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

            player.sendMessage(ChatColor.AQUA + "Open the following URL and grant access to your account:");
            player.sendMessage(requestToken.getAuthorizationURL());
            player.sendMessage("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            //String pin = br.readLine();//causes error
            try{
                aToken = twitter.getOAuthAccessToken();
            } catch (TwitterException te) {
                if(401 == te.getStatusCode()){
                    player.sendMessage("Unable to get the access token. Check with admin.");
                }else{
                    te.printStackTrace();
                }
            }


        //aToken is now the correct token for this user.  Unless it's not
        storeAccessToken(player.getName(), aToken);
        player.sendMessage("Testing print statement, token recieved: " + accessToken.toString());
        **/

        //THE FOLLOWING IS A HARD CODED EXAMPLE JUST FOR SHOW AND TELL
        //============================================================
        //player.sendMessage(ChatColor.AQUA + "Open the following URL and grant access to your account:");
        player.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.WHITE + ", You are already logged in to twitter on this server.");


    }

    /**private static void storeAccessToken(String userIGN, AccessToken accessToken){
        //store accessToken.getToken()
        //store accessToken.getTokenSecret()
        //TODO: make an effective and safe storage system to hopefully be able to have multiple users online logged in safely.
    }**/
}

