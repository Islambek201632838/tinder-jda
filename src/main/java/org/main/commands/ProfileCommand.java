// ProfileCommand.java in the commands package
package org.main.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ProfileCommand implements CommandHandler {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        // Logic for handling the profile command
        event.reply("Profile functionality is not yet implemented!").queue();
    }
}
