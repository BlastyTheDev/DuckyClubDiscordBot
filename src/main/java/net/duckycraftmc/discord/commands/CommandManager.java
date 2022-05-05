package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private final List<Command> commands = new ArrayList<>();

    public CommandManager() {
        getCommands().add(new ServerInfoCommand());
        getCommands().add(new AnnounceCommand());
        getCommands().add(new JoinCommand());
        getCommands().add(new StopCommand());
        getCommands().add(new QueueCommand());
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent e) {
        String name = e.getName();
        for (Command command : getCommands())
            if (name.equals(command.getName())) command.execute(e);
    }

    public List<Command> getCommands() {
        return commands;
    }

}
