package com.ll.domain;

import com.ll.stardard.Rq;

import java.util.List;
import java.util.Scanner;

public class Modify {
    public static void modifier(List<Quote> quotes, Rq rq) {
        Scanner sc = new Scanner(System.in);
        boolean exceptionForNone = true;
        for (int i = 0; i < quotes.size(); i++) {
            if (rq.getRqId() == 0) return;
            if (quotes.get(i).getId() == rq.getRqId()) {
                Quote quote = quotes.get(i);
                System.out.printf("명언(기존) : %s\n", quote.getContent());
                System.out.printf("작가(기존) : %s\n", quote.getAuthor());
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                quote = new Quote(i + 1, content, author);
                quotes.set(i, quote);
                exceptionForNone = false;
                break;
            }
        }
        if (exceptionForNone) System.out.printf("%d번 명언은 존재하지 않습니다.\n", rq.getRqId());
    }
}
