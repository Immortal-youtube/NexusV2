package org.example.JdaUtils;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import org.jetbrains.annotations.NotNull;

public class Welcome {
    public static void onJoin(@NotNull GuildMemberJoinEvent event) {
            event.getUser().openPrivateChannel().queue(privateChannel -> {
                try{
                    privateChannel.sendMessage("Welcome to the server " + event.getMember().getAsMention()).queue();
                    privateChannel.sendMessage("You can go to the commands chat to see the commands that are there").queue();
                }catch(Exception e){
                    int x = 0;
                }
            });

    }
}
