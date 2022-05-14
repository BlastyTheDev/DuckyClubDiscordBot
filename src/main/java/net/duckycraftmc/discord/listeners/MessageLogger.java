package net.duckycraftmc.discord.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageLogger extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        System.out.println("(" + e.getChannel().getName() + ") " + e.getMember().getUser().getName() + " [" +
                e.getMember().getNickname() + "]: " + e.getMessage().getContentRaw());
    }

}
