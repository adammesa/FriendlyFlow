package me.muffinjello.friendlyflow;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FriendlyFlow extends JavaPlugin {
    List<String> blockedWords = new ArrayList<String>();
    //Config
    public void loadConfig(){
        blockedWords.add(getConfig().getString("BlockedWords").toLowerCase());
        String[] split = getConfig().getString("BlockedWords").split(Pattern.quote(","));
        for (String s : split){
            if(!blockedWords.contains(s.trim().toLowerCase())){
                blockedWords.add(s.trim().toLowerCase());
            }
        }
    }
    public void writeConfig(){
        setConfig().
    }

    //Plugin Enable/Disable
    @Override
    public void onEnable(){
        PluginDescriptionFile pdfFile = this.getDescription();
        getServer().getPluginManager().registerEvents(new ChatChanger(), this);
        this.getLogger().info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled.");
        loadConfig();
        writeConfig();
        saveConfig();
    }
    @Override
    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.getLogger().info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Disabled.");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
        if (command.getName().equalsIgnoreCase("filter")){
            PluginDescriptionFile pdfFile = this.getDescription();
            if (args.length >= 1){
                String action = args[0].trim();
                if (action.equalsIgnoreCase("on")){
                    sender.sendMessage(ChatColor.GREEN + "[FriendlyFlow] Your swearing filter has been turned " + ChatColor.BLUE + "on");
                    return true;
                }
                if (action.equalsIgnoreCase("off")){
                    sender.sendMessage(ChatColor.GREEN + "[FriendlyFlow] Your swearing filter has been turned" + ChatColor.RED + "off");
                    return true;
                }
                if (action.equalsIgnoreCase("help")){
                    sender.sendMessage(ChatColor.GREEN + "[FriendlyFlow] Help Menu:");
                    sender.sendMessage(ChatColor.GRAY + "Plugin developed by Muffinjello");
                    sender.sendMessage(ChatColor.GRAY + "Type " + ChatColor.RED + "/filter on " + ChatColor.GRAY + "to filter out cursing and swearing");
                    sender.sendMessage(ChatColor.GRAY + "Type " + ChatColor.RED + "/filter off " + ChatColor.GRAY + "to stop filtering cursing and swearing");
                }
            }
        }
        return false;
    }
}
