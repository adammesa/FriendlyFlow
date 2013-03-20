package me.muffinjello.friendlyflow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatChanger implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void filterchat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        Player player = event.getPlayer();
        String pname = player.getName();
    }
}
