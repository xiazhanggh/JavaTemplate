package com.build.oa.socketio;

/**
 * Created by xzhang on 7/16/2017.
 */
public class EmitObject {

    private String emitor;

    private String msg;

    public EmitObject() {
    }

    public EmitObject(String emitor, String msg) {
        this.emitor = emitor;
        this.msg = msg;
    }

    public String getEmitor() {
        return emitor;
    }

    public void setEmitor(String emitor) {
        this.emitor = emitor;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
