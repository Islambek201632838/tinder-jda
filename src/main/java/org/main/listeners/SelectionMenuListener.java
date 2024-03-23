package org.main.listeners;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SelectionMenuListener extends ListenerAdapter {
    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
        if (event.getComponentId().equals("selected_buddy")) {
            String selectedValue = event.getValues().isEmpty() ? "None" : event.getValues().get(0);
            event.reply("Your buddy is " + selectedValue).queue();
        }
        else if (event.getComponentId().equals("select_university")) {
            String selectedValue = event.getValues().isEmpty() ? "None" : event.getValues().get(0);
            event.reply("Your university " + selectedValue).queue();
        }
    }
}
