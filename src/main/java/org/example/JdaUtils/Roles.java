package org.example.JdaUtils;

import io.github.cdimascio.dotenv.Dotenv;

public class Roles {
    Dotenv dotenv = Dotenv.configure().filename("token").load();
    private final String Member = dotenv.get("MEMBER");
    private final String God = dotenv.get("GOD");
    private final String Badboy = dotenv.get("BADBOY");
    private final String Coders = dotenv.get("CODERS");
    private final String Nerd = dotenv.get("NERD");

    public String getMember() {
        return Member;
    }

    public String getGod() {
        return God;
    }

    public String getBadboy() {
        return Badboy;
    }

    public String getCoders() {
        return Coders;
    }

    public String getNerd() {
        return Nerd;
    }
}
