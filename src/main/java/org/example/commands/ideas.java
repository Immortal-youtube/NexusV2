package org.example.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.NotNull;
@CommandInfo(option1 = true,option1Name = "idea",option1Type = OptionType.STRING)
public class ideas extends ListenerAdapter {
    boolean x;


    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("idea")) {
            OptionMapping mapping = event.getOption("idea");
            String idea = mapping.getAsString();
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle(event.getMember().getUser().getName());
            builder.setColor(event.getMember().getColor());
            builder.addField("Project Idea: ", idea, false);
            TextChannel channel = event.getGuild().getTextChannelById("1008709592680767498");
            channel.sendMessageEmbeds(builder.build()).queue();
            event.deferReply().queue();
            event.getHook().sendMessage("Your idea has been sent to the server!").queue();

        }
    }
}
