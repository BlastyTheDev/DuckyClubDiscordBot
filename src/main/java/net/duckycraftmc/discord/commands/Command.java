package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public abstract class Command {

    public abstract String getName();

    public abstract void execute(SlashCommandInteractionEvent e);

}
