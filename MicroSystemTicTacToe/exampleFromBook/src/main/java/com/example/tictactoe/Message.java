package com.example.tictactoe;

import java.io.Serializable;

public class Message implements Serializable {
    // gives an ID to this version of the object
    private static final long serialVersionUID = 1234L;

    private String type;
    private String text;

    public Message(String text, String type){
        this.text = text;
        this.type = type;
    }

    public Message(String text){
        this.text = text;
        this.type = "Regular";
    }

    public String getText(){
        return text;
    }

    public String getType(){
        return type;
    }

}
