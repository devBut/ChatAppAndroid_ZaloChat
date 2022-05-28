package com.example.zalochat.messages;

public class MessagesList {
    private String name, mobile, lastMessage, profilePic, chatKey;

    private int unseenMassages;

    public MessagesList(String name, String mobile, String lastMessage, String profilePic, int unseenMassages, String chatKey) {
        this.name = name;
        this.mobile = mobile;
        this.lastMessage = lastMessage;
        this.profilePic = profilePic;
        this.unseenMassages = unseenMassages;
        this.chatKey = chatKey;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public int getUnseenMassages() {
        return unseenMassages;
    }

    public String getChatKey() {
        return chatKey;
    }
}
