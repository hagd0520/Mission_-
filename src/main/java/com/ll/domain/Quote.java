package com.ll.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quote {
    private int id;
    private String content;
    private String author;
}