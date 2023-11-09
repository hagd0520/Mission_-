package com.ll.domain;

import java.util.List;
import java.util.Scanner;

public class Regist {
    public static void register(List<Quote> quotes, int idQueue) {
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        Quote quote = new Quote(idQueue, content, author);
        quotes.add(quote);
        System.out.printf("%d번 명언이 등록되었습니다.\n", idQueue);
    }
}
