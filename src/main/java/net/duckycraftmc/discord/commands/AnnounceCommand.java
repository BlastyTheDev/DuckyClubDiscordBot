package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class AnnounceCommand extends Command {

    @Override
    public String getName() {
        return "announce";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (e.getInteraction().getMember().getRoles().contains(e.getGuild().getRoleById("747249849535037483"))) {

        }
    }

}
