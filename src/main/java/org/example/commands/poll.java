package org.example.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

@CommandInfo()
public class poll extends ListenerAdapter {
    public static EmbedBuilder builder;
    public static Message message;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("poll")){
            OptionMapping question = event.getOption("question");
            OptionMapping option1 = event.getOption("option1");
            OptionMapping option2 = event.getOption("option2");

            builder = new EmbedBuilder();
            builder.setTitle(question.getAsString());
            builder.addField("1) " + option1.getAsString(), "", false);
            builder.addField("2) " + option2.getAsString(), "", false);
            builder.setThumbnail(event.getUser().getAvatarUrl());
            builder.setColor(event.getMember().getColor());
            event.deferReply().queue();
            event.getHook().sendMessageEmbeds(builder.build()).queue(message1 -> {
                message1.addReaction(Emoji.fromUnicode("1️⃣")).queue();
                message1.addReaction(Emoji.fromUnicode("2️⃣")).queue();
            });


        }


    }
}
