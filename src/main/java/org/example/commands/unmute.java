package org.example.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.example.JdaUtils.Roles;
import org.jetbrains.annotations.NotNull;

@CommandInfo(option1 = true,option1Name = "user")
public class unmute extends ListenerAdapter {
    Roles r = new Roles();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("unmute")){
            if(!event.getMember().getRoles().contains(event.getGuild().getRoleById(r.getGod()))) {
                event.deferReply(true).queue();
                event.getHook().sendMessage("You don't have the necessary permissions").queue();
                return;
            }
            OptionMapping map = event.getOption("user");
            if(map == null){
                event.deferReply(true).queue();
                event.getHook().sendMessage("You need to specify a user to unmute").queue();

            }else {
                User user = map.getAsUser();
                Member member = event.getGuild().getMember(user);
                if(event.getMember().getRoles().contains(event.getGuild().getRoleById(r.getBadboy()))){
                    event.deferReply(true).queue();
                    event.getHook().sendMessage("This user is not muted").queue();
                }else{
                    event.getGuild().removeRoleFromMember(member, event.getGuild().getRoleById(r.getBadboy())).queue();
                    event.deferReply(true).queue();
                    event.getHook().sendMessage("Unmuted " + user.getAsMention()).queue();
                }

            }
        }
    }
}
