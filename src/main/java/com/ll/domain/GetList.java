package com.ll.domain;


import java.util.List;
import java.util.stream.IntStream;

public class GetList {
    public static void getLister(List<Quote> quotes) {
        System.out.println("번호 / 작가 / 명언\n-----------------------");
        for (int i = quotes.size() - 1; i >= 0; i--) System.out.printf("%d / %s / %s\n",
                    quotes.get(i).getId(), quotes.get(i).getAuthor(), quotes.get(i).getContent());
    }
}
