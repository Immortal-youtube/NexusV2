package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
@CommandInfo()
public class bot extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("bot")){
            event.deferReply().queue();
            event.getHook().sendMessage("https://github.com/Immortal-youtube/NexusV2").queue();
        }
    }
}
