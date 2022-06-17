package net.duckycraftmc.discord.commands.musiccommands;

import net.duckycraftmc.discord.commands.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import static net.duckycraftmc.discord.music.PlayerManager.isBotInVoice;

public class StopCommand extends Command {

    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (isBotInVoice) {
            AudioManager manager = e.getGuild().getAudioManager();
            manager.closeAudioConnection();
            isBotInVoice = false;
            e.reply("Disconnected from voice!").queue();
        } else e.reply("I am not connected to a voice channel!").queue();
    }

}
