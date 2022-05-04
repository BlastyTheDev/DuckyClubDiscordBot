package net.duckycraftmc.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public final class DiscordBot {

    public DiscordBot() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("OTMyMTMxODc0OTA4ODE1NDEw.YeOhdQ.XKPPj-QElp77BiNXR1_kUacYvDI").build().awaitReady();
    }

}
