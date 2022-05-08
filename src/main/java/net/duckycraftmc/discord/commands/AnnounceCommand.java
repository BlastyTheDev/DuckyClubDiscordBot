package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class AnnounceCommand extends Command {

    @Override
    public String getName() {
        return "announce";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (e.getMember().getRoles().contains(e.getGuild().getRoleById("747249849535037483"))) {
            OptionMapping messageOption = e.getOption("message");
            OptionMapping pingOption = e.getOption("ping");
            assert messageOption != null;
            assert pingOption != null;
            String message = pingOption.getAsBoolean() ? messageOption.getAsString() + "\n<@&915545654623883264>" :
                    messageOption.getAsString();
            e.reply(message).allowedMentions(null).queue();
        } else e.reply("Only Owners can use this!").setEphemeral(true).queue();
    }

}
