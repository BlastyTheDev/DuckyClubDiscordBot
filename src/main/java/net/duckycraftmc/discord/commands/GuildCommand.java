package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GuildCommand extends Command {

    @Override
    public String getName() {
        return "guild";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        String action = e.getOption("action").getAsString();
        switch (action) {
            case "create" -> {
            }
            case "delete" -> {
            }
            case "join" -> {
            }
            case "leave" -> {
            }
        }
    }

}
