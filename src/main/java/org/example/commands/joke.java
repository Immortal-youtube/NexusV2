package org.example.commands;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.commands.MongoDB.JokesConnector;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;

@CommandInfo()
public class joke extends ListenerAdapter {
    String str;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("joke")){
            String joke = null;
            try {
                joke = JokesConnector.joke();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }


            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Joke");
            embedBuilder.addField(joke, "", true);

            embedBuilder.setColor(Color.GREEN);
            embedBuilder.setThumbnail("https://media.gq.com/photos/5720e7496a2af99a11a1dc8a/16:9/w_2560%2Cc_limit/Obama-Laugh.jpg");
            event.deferReply().queue();
            event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();

        }

    }
}
