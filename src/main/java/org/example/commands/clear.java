package org.example.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@CommandInfo()
public class clear extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if(event.getName().equals("clear")){
            List<Role> r = event.getMember().getRoles();
            if(r.contains(event.getGuild().getRoleById(System.getenv("GOD")))){
                List<Message> l = event.getChannel().getHistory().retrievePast(20).complete();
                event.reply("Done sir").queue();
                event.getChannel().asTextChannel().deleteMessages(l).queue();

            }else{
                event.deferReply().queue();
                event.getHook().sendMessage("You don't have the necessary permissions").queue();
            }
        }
    }
}
