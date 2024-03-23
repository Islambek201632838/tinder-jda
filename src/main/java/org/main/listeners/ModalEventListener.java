package org.main.listeners;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ModalEventListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        // Check if the modal submitted is the one we're interested in
        if ("create_profile_modal".equals(event.getModalId())) {
            // Retrieve the values safely using Optional
            String name = event.getValue("name_input") != null ? event.getValue("name_input").getAsString() : "N/A";
            String degree = event.getValue("degree_input") != null ? event.getValue("degree_input").getAsString() : "N/A";
            String age = event.getValue("age_input") != null ? event.getValue("age_input").getAsString() : "N/A";
            String aboutMe = event.getValue("about_me_input") != null ? event.getValue("about_me_input").getAsString() : "N/A";

            // Compile the data into a string format
            String data = String.format("Name: %s\nDegree: %s\nAge: %s\nAbout Me: %s", name, degree, age, aboutMe);

            // Reply with the data
            event.reply(data).setEphemeral(true).queue();
        }
    }

}
