package org.example.commands;


import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.example.JdaUtils.LogicRPS;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
@CommandInfo()
public class RPS extends ListenerAdapter {
    Random random = new Random();
    String choice;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("rps")) {
            Button rock = Button.primary("rock", Emoji.fromUnicode("\uD83E\uDEA8"));
            Button paper = Button.primary("paper", Emoji.fromUnicode("\uD83E\uDDFB"));
            Button scissors = Button.primary("scissors", Emoji.fromUnicode("✂"));
            Message message = new MessageBuilder()
                    .append("Pls choose your choice")
                    .setActionRows(ActionRow.of(rock, paper, scissors))
                    .build();
            event.deferReply().queue();
            event.getHook().sendMessage(message).queue();

        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String[] choices = {"rock", "paper", "scissors"};
        choice = choices[random.nextInt(choices.length)];
        if (event.getButton().getId().equals("rock")) {
            LogicRPS.check(event, "rock", choice);
        } else if (event.getButton().getId().equals("paper")) {
            LogicRPS.check(event, "paper", choice);
        } else if (event.getButton().getId().equals("scissors")) {
            LogicRPS.check(event, "scissors", choice);
        }


    }
}
