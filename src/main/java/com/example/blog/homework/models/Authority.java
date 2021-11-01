package com.example.blog.homework.models;

public enum Authority {

    USER(UserAuth.READ, UserAuth.WRITE, UserAuth.EDIT, UserAuth.DELETE),
    MODERATOR(UserAuth.READ, UserAuth.WRITE, UserAuth.EDIT, UserAuth.DELETE),
    ADMIN(UserAuth.READ, UserAuth.WRITE, UserAuth.EDIT, UserAuth.DELETE);

    public final UserAuth[] AUTHS;

    Authority(UserAuth... auths) {
        AUTHS = auths;
    }
}
