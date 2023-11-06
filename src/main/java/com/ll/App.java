package com.ll;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();
        int idQueue = 1;

        // 1 단계
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd, 0);

            if (rq.cmd.equals("종료")) break;

            // 2, 3, 4 단계
            if (rq.cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                Quote quote = new Quote(idQueue, content, author);
                quotes.add(quote);
                System.out.printf("%d번 명언이 등록되었습니다.\n", idQueue);
                idQueue++;
            }

            // 5 단계
            if (rq.cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n-----------------------");
                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote quote = quotes.get(i);

                    System.out.printf("%d / %s / %s\n", quote.getId(), quote.getAuthor(), quote.getContent());
                }
            }
        }
    }
}

class Quote {
    @Getter
    private int id;
    @Getter
    private String content;
    @Getter
    private String author;
    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}

class Rq {
    String cmd;
    String content;
    String id;
    public Rq(String cmd, int defaultNum) {
        String[] cmds = cmd.split("\\?");
        if (cmds.length == 1) this.cmd = cmds[0].trim();
        if (cmds.length > 1) {
            this.cmd = cmds[0].trim();
            if (cmds.length > 1) {
                String[] contents = cmds[1].split("=");
                content = contents[0].trim();
                id = contents[1].trim();
            }
        }
    }
}