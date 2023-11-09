package com.ll.domain;


import java.util.List;
import java.util.stream.IntStream;

public class GetList {
    public static void getLister(List<Quote> quotes) {
        System.out.println("번호 / 작가 / 명언\n-----------------------");
        for (Quote quote : quotes) System.out.printf("%d / %s / %s\n", quote.getId(), quote.getAuthor(), quote.getContent());
    }
}
