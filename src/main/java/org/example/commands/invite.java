package org.example.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@CommandInfo()
public class invite extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("invite")){
            event.deferReply().queue();
            event.getHook().sendMessage("If you wish to invite someone: " + event.getChannel().asTextChannel().createInvite().complete().getUrl()).queue();
        }

    }
}
