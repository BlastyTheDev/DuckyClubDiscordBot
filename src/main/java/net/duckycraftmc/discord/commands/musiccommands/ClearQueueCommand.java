package net.duckycraftmc.discord.commands.musiccommands;

import net.duckycraftmc.discord.commands.Command;
import net.duckycraftmc.discord.music.PlayerManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ClearQueueCommand extends Command {

    @Override
    public String getName() {
        return "clearqueue";
    }

    @SuppressWarnings("all")
    @Override
    public void execute(SlashCommandInteractionEvent e) {
        assert e.getGuild() != null;
        boolean stopPlaying = e.getOption("stopplaying").getAsBoolean();
        PlayerManager.getInstance().getMusicManager(e.getGuild()).scheduler.clearQueue(stopPlaying);
        if (stopPlaying)
            e.reply("Cleared the queue and ended the current track.").queue();
        e.reply("Cleared the queue.");
    }

}
