package me.muffinjello.friendlyflow;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class friendlyflow extends JavaPlugin {
    @Override
    public void onEnable(){
        PluginDescriptionFile pdfFile = this.getDescription();
        getServer().getPluginManager().registerEvents(new chatchanger(), this);
        this.getLogger().info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled.");
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
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
    }
}
