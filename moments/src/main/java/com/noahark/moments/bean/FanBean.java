package com.noahark.moments.bean;

import java.io.Serializable;

/**
 * 关注人
 */
public class FanBean implements Serializable {

    private String avatar; //头像URI
    private String nickname;//昵称

    public FanBean(){
        super();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}