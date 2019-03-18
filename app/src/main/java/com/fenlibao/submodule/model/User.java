package com.fenlibao.submodule.model;

import java.io.Serializable;

public class User implements Serializable {

    public int userId;
    public String userName;
    public String nickName;

    public User(int userId, String userName, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
