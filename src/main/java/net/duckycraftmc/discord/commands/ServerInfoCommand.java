package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ServerInfoCommand extends Command {

    @Override
    public String getName() {
        return "serverinfo";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        e.reply("**Server Address:** `duckycraftmc.net`").setEphemeral(true).queue();
    }

}
