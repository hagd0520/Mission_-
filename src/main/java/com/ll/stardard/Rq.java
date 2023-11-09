package com.ll.stardard;

import lombok.Getter;

import java.util.stream.IntStream;

@Getter
public class Rq {
    private String cmd;
    private int rqId;
    public Rq(String cmd) {
        String[] cmds = cmd.split("\\?");

        this.cmd = cmds[0].trim();

        if (cmds.length > 1) {
            String[] contents = cmds[1].split("=");
            try {
                rqId = Integer.parseInt(contents[1].trim());
            } catch (Exception e) {
                rqId = 0;
            }
        }
    }
}