package net.duckycraftmc.discord.commands;

import net.duckycraftmc.discord.listeners.EmoteOnlyMode;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class EmoteOnlyModeCommand extends Command {

    @Override
    public String getName() {
        return "emoteonlymode";
    }

    @SuppressWarnings("all")
    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (!e.getMember().getRoles().contains(e.getGuild().getRoleById("747249849535037483")))
            e.reply("Only Owners can use this!").queue();
        if (EmoteOnlyMode.emoteOnlyEnabled) {
            EmoteOnlyMode.emoteOnlyEnabled = false;
            EmoteOnlyMode.emoteOnlyEnabledIn.remove(e.getTextChannel());
            e.reply("Emote Only Mode has been disabled.").queue();
        } else {
            final var channelId = e.getChannel().getId();
            e.reply("Emote Only Mode has been enabled!").queue();
            EmoteOnlyMode.emoteOnlyEnabled = true;
            EmoteOnlyMode.emoteOnlyEnabledIn.add(e.getTextChannel());
            e.getGuild().getNewsChannelById("747277996418924596").sendMessage("Emote Only Mode in " + e.getChannel().getAsMention() + "!").queue();
        }
    }

}
