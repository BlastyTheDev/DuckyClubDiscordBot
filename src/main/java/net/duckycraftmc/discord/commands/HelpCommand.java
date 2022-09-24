package net.duckycraftmc.discord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class HelpCommand extends Command {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        e.reply("This command is under development. If you need it completed now, please contact Blasty - the developer of this bot.").setEphemeral(true).queue();
    }

}
