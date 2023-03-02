package org.example.JdaUtils;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class LogicRPS {

    public static void check(ButtonInteractionEvent event, String choiceUser,String choiceBot) {
        Emoji user = null;
        Emoji bot = null;
        switch (choiceUser) {
            case "rock" -> user = Emoji.fromUnicode("\uD83E\uDEA8");
            case "paper" -> user = Emoji.fromUnicode("\uD83E\uDDFB");
            case "scissors" -> user = Emoji.fromUnicode("✂");
        }

        switch (choiceBot) {
            case "rock" -> bot = Emoji.fromUnicode("\uD83E\uDEA8");
            case "paper" -> bot = Emoji.fromUnicode("\uD83E\uDDFB");
            case "scissors" -> bot = Emoji.fromUnicode("✂");
        }


        String WinOrLose = decide(choiceUser, choiceBot);
        Message message = new MessageBuilder().append("You chose ").append((user).getFormatted()).append(" and the bot chose ").append((bot).getFormatted()).append(" so you ").append(WinOrLose)
                .build();
        event.deferReply().queue();
        event.getHook().sendMessage(message).queue();
    }

    public static String decide(String choiceUser,String choiceBot){
            String WinOrLose = "";
            if (choiceBot.equals(choiceUser)) {
                WinOrLose = "draw";
            } else if (choiceBot.equals("rock")) {
                if (choiceUser.equals("paper")) {
                    WinOrLose = "win";
                } else {
                    WinOrLose = "lose";
                }
            } else if (choiceBot.equals("paper")) {
                if (choiceUser.equals("scissors")) {
                    WinOrLose = "win";
                } else {
                    WinOrLose = "lose";
                }
            } else if (choiceBot.equals("scissors")) {
                if (choiceUser.equals("rock")) {
                    WinOrLose = "win";
                } else {
                    WinOrLose = "lose";
                }
            }
            return WinOrLose;
    }
}
