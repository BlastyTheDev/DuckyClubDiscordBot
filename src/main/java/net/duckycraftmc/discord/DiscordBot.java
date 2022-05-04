package net.duckycraftmc.discord;

import net.duckycraftmc.discord.commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

public final class DiscordBot {

    public DiscordBot() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("")
                .setActivity(Activity.watching("myself become completed"))
                .addEventListeners(new CommandManager())
                .build().awaitReady();
        Guild guild = jda.getGuildById("747237441026523147");
        if (guild != null) {
            guild.upsertCommand("serverinfo", "Get the Duckycraft Minecraft server information").queue();
            guild.upsertCommand("announce", "Announce and Ping Duckycraft Pings").addOption(OptionType.STRING, "message",
                    "The message to send", true).queue();
        }
    }

}
