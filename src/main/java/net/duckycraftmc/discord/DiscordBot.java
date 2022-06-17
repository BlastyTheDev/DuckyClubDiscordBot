package net.duckycraftmc.discord;

import net.duckycraftmc.discord.commands.CommandManager;
import net.duckycraftmc.discord.listeners.EmoteOnlyMode;
import net.duckycraftmc.discord.listeners.MessageLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.security.auth.login.LoginException;

public final class DiscordBot {

    public DiscordBot() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("")
                .addEventListeners(new CommandManager(), new MessageLogger(), new EmoteOnlyMode())
                .build().awaitReady();
        Guild guild = jda.getGuildById("747237441026523147");
        if (guild != null) {
            guild.upsertCommand("serverinfo", "Get the Duckycraft Minecraft server information").queue();
            guild.upsertCommand("announce", "Announce and Ping Duckycraft Pings").addOptions(
                    new OptionData(OptionType.STRING, "message", "The message to send", true),
                    new OptionData(OptionType.BOOLEAN, "ping", "Whether Duckycraft Pings should be mentioned", true)
            ).queue();

            // music commands
            guild.upsertCommand("join", "Make the bot join your voice channel").queue();
            guild.upsertCommand("stop", "Make the bot disconnect from its current voice channel").queue();
            guild.upsertCommand("queue", "Add a song to the queue").addOptions(
                    new OptionData(OptionType.STRING, "link", "Link of the soundtrack to add", true)
            ).queue();
            guild.upsertCommand("clearqueue", "Clear the song queue").addOptions(
                    new OptionData(OptionType.BOOLEAN, "stopplaying", "Whether the current track should also be ended", true)
            ).queue();
            guild.upsertCommand("skip", "Skip the current track").queue();

            guild.upsertCommand("emoteonlymode", "Toggle Emote Only Mode").addOptions(
                    new OptionData(OptionType.BOOLEAN, "enabled", "Whether emote only mode should be on", true)
            ).queue();
            guild.upsertCommand("help", "Show all commands and uses for the bot").queue();
        }
    }

}
