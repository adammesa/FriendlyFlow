package me.muffinjello.friendlyflow;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatChanger implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void filterchat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        event.setMessage(message.replaceAll("shit", "****"));
    }
}
