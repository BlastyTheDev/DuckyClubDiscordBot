package net.duckycraftmc.discord.commands.duckycraftcommands;

import net.duckycraftmc.discord.commands.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GuildCommand extends Command {

    // TODO: Complete the Guild Management system - To be ready for next Duckycraft season

    @Override
    public String getName() {
        return "guild";
    }

    @Override
    public void execute(SlashCommandInteractionEvent e) {
        e.reply("This command is under development. If you need it completed now, please contact Blasty - the developer of this bot.").setEphemeral(true).queue();
        String action = e.getOption("action").getAsString();
        switch (action) {
            case "create" -> {
            }
            case "delete" -> {
            }
            case "join" -> {
            }
            case "leave" -> {
            }
        }
    }

}
