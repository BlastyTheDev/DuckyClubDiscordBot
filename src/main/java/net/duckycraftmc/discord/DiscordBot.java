package net.duckycraftmc.discord;

import net.duckycraftmc.discord.commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;

public final class DiscordBot {

    public DiscordBot() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("").build().awaitReady();
        Guild guild = jda.getGuildById("747237441026523147");
        jda.addEventListener(new CommandManager());
        if (guild != null) {
        }
    }

}
