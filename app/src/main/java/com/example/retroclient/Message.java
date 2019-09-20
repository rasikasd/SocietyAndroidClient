package com.example.retroclient;

public class Message {

    private String token;

    public Message() {
    }

    public Message(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Message{" +
                "token='" + token + '\'' +
                '}';
    }
}


