package com.ll.stardard;

import lombok.Getter;

import java.util.stream.IntStream;

@Getter
public class Rq {
    private String cmd;
    private String rqId;
    public Rq(String cmd, int defaultNum) {
        String[] cmds = cmd.split("\\?");
        this.cmd = cmds[0].trim();
        if (cmds.length > 1) {
            String[] contents = cmds[1].split("=");
            rqId = (contents[0].trim().equals("id")) ? contents[1].trim() : String.valueOf(defaultNum);
        }
    }
}