package net.duckycraftmc.discord.commands;

import net.duckycraftmc.discord.music.PlayerManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.net.URI;
import java.net.URISyntaxException;

import static net.duckycraftmc.discord.music.PlayerManager.isBotInVoice;

public class QueueCommand extends Command {

    @Override
    public String getName() {
        return "queue";
    }

    @SuppressWarnings("all")
    @Override
    public void execute(SlashCommandInteractionEvent e) {
        if (isBotInVoice) {
            OptionMapping linkOption = e.getOption("link");
            assert linkOption != null;
            String link = linkOption.getAsString();
            if (isUrl(link))
                PlayerManager.getInstance().loadAndPlay(e.getGuild().getTextChannelById("747287295866044489"), link);
            else e.reply("That is not a valid link!").setEphemeral(true).queue();
        } else e.reply("I am not connected to a voice channel!").setEphemeral(true).queue();
    }

    public boolean isUrl(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

}
