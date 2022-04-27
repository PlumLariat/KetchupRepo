package com.example.delieverable_4_27;

import java.io.Serializable;

public class MoveMessage implements Serializable {
    // gives an ID to this version of the object
    private static final long serialVersionUID = 1234L;
    private int row;
    private int col;
    private String msg;

    public MoveMessage(int row, int col, String msg) {
        this.row = row;
        this.col = col;
        this.msg = msg;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
