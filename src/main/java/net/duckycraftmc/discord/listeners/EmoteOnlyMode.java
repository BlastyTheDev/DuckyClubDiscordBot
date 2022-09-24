package net.duckycraftmc.discord.listeners;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class EmoteOnlyMode extends ListenerAdapter {

    public static boolean emoteOnlyEnabled = false;
    public static List<TextChannel> emoteOnlyEnabledIn;

    public EmoteOnlyMode() {
        emoteOnlyEnabledIn = new ArrayList<>();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        if (emoteOnlyEnabled) {
            String[] message = e.getMessage().getContentRaw().split(" ");
            for (String s : message) {
                // Tenor GIF
                if (s.contains("https://tenor.com/view/")) return;
                // Server Emoji
                if (s.startsWith("<:") && s.endsWith(">")) return;
                try {
                    if (s.length() >= 24)
                        Integer.parseInt(s.substring(s.length() - 19, s.length() - 1));
                } catch (NumberFormatException ex) {
                    e.getMessage().delete().queue();
                }
                // Built In Emojis (Hopefully)
                if (s.isBlank()) return;
                if (s.isEmpty()) return;
                if (e.getAuthor().isBot()) return;
                if (!(e.getChannel() instanceof TextChannel)) return;

                if (emoteOnlyEnabledIn.contains(e.getTextChannel()))
                    e.getMessage().delete().queue();
            }
        }
    }

}
