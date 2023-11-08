package com.ll.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.PrintWriter;
import java.util.List;

public class Save {
    public static void saver(List<Quote> quotes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String quotesToJson = gson.toJson(quotes);

        try {
            PrintWriter pw = new PrintWriter("C:\\Users\\hagd0\\Desktop\\Quote_app\\quote.json");
            pw.println(quotesToJson);
            pw.close();
        } catch (Exception e) {}
    }
}
