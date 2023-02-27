package org.example.JdaUtils;

public class Roles {

    private final String Member = System.getenv("MEMBER");
    private final String God = System.getenv("GOD");
    private final String Badboy = System.getenv("BADBOY");
    private final String Coders = System.getenv("CODERS");
    private final String Nerd = System.getenv("NERD");

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
