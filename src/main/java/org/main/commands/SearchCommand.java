package org.main.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SearchCommand implements CommandHandler {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        // Logic for handling the search command
        event.reply("Search functionality is not yet implemented!").queue();
    }
}
