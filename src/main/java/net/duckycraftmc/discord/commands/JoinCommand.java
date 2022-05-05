package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.entities.AudioChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import static net.duckycraftmc.discord.music.PlayerManager.isBotInVoice;

public class JoinCommand extends Command {

    @Override
    public String getName() {
        return "join";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (isBotInVoice)
            e.reply("I am already in a voice channel!").setEphemeral(true).queue();
        else {
            if (e.getChannel().getId().equals("747287295866044489")) {
                AudioChannel channel = e.getMember().getVoiceState().getChannel();
                AudioManager manager = e.getGuild().getAudioManager();
                manager.openAudioConnection(channel);
                isBotInVoice = true;
                e.reply("Connected to voice!").queue();
            } else e.reply("This command can only be used in <#747287295866044489>").setEphemeral(true).queue();
        }
    }

}
