package net.duckycraftmc.discord.commands.musiccommands;

import net.duckycraftmc.discord.commands.Command;
import net.duckycraftmc.discord.music.PlayerManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Objects;

import static net.duckycraftmc.discord.music.PlayerManager.isBotInVoice;

public class SkipCommand extends Command {

    @Override
    public String getName() {
        return "skip";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (isBotInVoice) {
            PlayerManager.getInstance().getMusicManager(Objects.requireNonNull(e.getGuild())).scheduler.nextTrack();
            e.reply("Skipped to the next track!").queue();
        } else e.reply("I am not connected to a voice channel!").setEphemeral(true).queue();
    }

}
