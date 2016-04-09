/**
 * Created by Joseph Schiarizzi on 1/30/16.
 */
package plugin;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.plugin.commands.Tlogin;
import plugin.plugin.commands.tweet;

import java.io.*;


public class Commands extends JavaPlugin{

    public String key1, key2, key3, key4;

    File config;
    File groupsFile;

    FileConfiguration configConfig;
    FileConfiguration groupsConfig;

    public void onEnable(){

        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");



        //========================== Get Keys and Tokens from config ====================//
        config = new File(getDataFolder(), "config.yml");
        groupsFile = new File(getDataFolder(), "groups.yml");

        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }

        configConfig = new YamlConfiguration();
        groupsConfig = new YamlConfiguration();

        key1 = configConfig.getString("ConsumerKey");
        key2 = configConfig.getString("ConsumerSecret");
        key3 = configConfig.getString("AccessToken");
        key4 = configConfig.getString("SecretToken");



        //===============================================================================//

        //where to send commands
        getCommand("tweet").setExecutor(new tweet(key1, key2, key3, key4));
        getCommand("tlogin").setExecutor(new Tlogin());

        logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ") !");


    }

    private void firstRun() throws Exception {
        if (!config.exists()) {
            config.getParentFile().mkdirs();
            copy(getResource("config.yml"), config);
        }
        if (!groupsFile.exists()) {
            groupsFile.getParentFile().mkdirs();
            copy(getResource("groups.yml"), groupsFile);
        }
    }

    private void copy(InputStream in, File config) {
        try {

            OutputStream out = new FileOutputStream(config);
            byte[] buf = new byte[1024];
            int len;

            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveYamls() {
        try {
            configConfig.save(config);
            groupsConfig.save(groupsFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadYamls() {
        try {
            configConfig.load(config);
            groupsConfig.load(groupsFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  onDisable(){
        PluginDescriptionFile pdfFile = getDescription();

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Minecraft");

        logger.info(pdfFile.getName() + " has been disabled sucessfully.");
    }



}
