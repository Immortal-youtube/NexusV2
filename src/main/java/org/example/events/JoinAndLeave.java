package org.example.events;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.requests.Route;
import org.example.JdaUtils.Roles;
import org.jetbrains.annotations.NotNull;

public class JoinAndLeave extends ListenerAdapter {

    Roles roles = new Roles();

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Dotenv dotenv = Dotenv.configure().filename("token").load();
        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(roles.getMember())).queue();
        TextChannel channel = event.getGuild().getTextChannelById(dotenv.get("WELCOME"));
        EmbedBuilder builder = new EmbedBuilder();
        builder.setThumbnail(event.getMember().getAvatarUrl());
        builder.setTitle(String.format("Welcome %s",event.getMember().getEffectiveName()));
        channel.sendMessageEmbeds(builder.build()).queue();

    }
}
