package org.main.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.components.text.TextInput;


public class ProfileCommand implements CommandHandler {
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        // Send a message with a button to create/edit profile
        Button editProfileButton = Button.primary("create_edit_profile", "Create/Edit Profile");
        Button viewProfileButton = Button.primary("view_profile", "View Profile");
        Button interestButton = Button.primary("select_buddy", "Select Buddy");
        Button selectUniversityButton = Button.primary("select_university", "Select University");
        event.reply("Click the buttons to edit your profile")
                .addActionRow(
                        viewProfileButton,
                        editProfileButton,
                        selectUniversityButton,
                        interestButton
                        )
                .queue();

    }
    public static void viewProfile(ButtonInteractionEvent event){
        String name = "Uchiha Itachi";
        int age = 15;
        String degree = "MIT";
        String aboutMe = "Anbu and Akatsuki Member";
        String university = "Konoha Ninja Academy";

        String data = String.format("Name: %s\nUniversity: %s\nDegree: %s\nAge: %s\nAbout Me: %s", name, university, degree, age, aboutMe);

        // Reply with the data
        event.reply(data).setEphemeral(true).queue();

    }
    // This method can be called from an event listener that listens to button click interactions
    public static void editProfileModal(ButtonInteractionEvent event) {
        // Define text inputs for the modal
        TextInput nameInput = TextInput.create("name_input", "Name", TextInputStyle.SHORT).build();
        TextInput degreeInput = TextInput.create("degree_input", "Degree", TextInputStyle.SHORT).build();
        TextInput ageInput = TextInput.create("age_input", "Age", TextInputStyle.SHORT).build();
        TextInput aboutMeInput = TextInput.create("about_me_input", "About Me", TextInputStyle.PARAGRAPH).build();


        // Create the modal
        Modal createProfileModal = Modal.create("create_profile_modal", "Create/Edit Profile")
                .addActionRows(
                        ActionRow.of(nameInput),
                        ActionRow.of(degreeInput),
                        ActionRow.of(ageInput),
                        ActionRow.of(aboutMeInput)
                ).build();

        // Open the modal for the user
        event.replyModal(createProfileModal).queue();
    }

    public static void selectUniversity(ButtonInteractionEvent event) {
        StringSelectMenu universities = StringSelectMenu.create("select_university")
                .setPlaceholder("Choose your University")
                .addOptions(
                        SelectOption.of("Nazarbaev University", "nazarbaev"),
                        SelectOption.of("KBTU", "kbtu"),
                        SelectOption.of("Satpaev University", "satpaev"),
                        SelectOption.of("KazGU", "kazgu")
                )
                .build();

        // Correctly respond with a select menu
        event.reply("Please select your interest:")
                .addActionRow(universities)
                .setEphemeral(true)
                .queue();
    }
    public static void selectBuddy(ButtonInteractionEvent event) {
        StringSelectMenu menu = StringSelectMenu.create("selected_buddy")
                .setPlaceholder("Select your buddy")
                .addOptions(
                        SelectOption.of("Roommate", "roommate"),
                        SelectOption.of("Friend", "friend"),
                        SelectOption.of("Study Buddy", "study_buddy"),
                        SelectOption.of("Travel Buddy", "travel_buddy")
                )
                .build();

        // Correctly respond with a select menu
        event.reply("Please select your buddy: ")
                .addActionRow(menu)
                .setEphemeral(true)
                .queue();
    }

}

