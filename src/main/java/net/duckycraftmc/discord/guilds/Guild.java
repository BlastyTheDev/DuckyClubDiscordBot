package net.duckycraftmc.discord.guilds;

import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private User owner;
    private List<User> members;

    public Guild(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getNumberOfMembers() {
        return members;
    }

}
