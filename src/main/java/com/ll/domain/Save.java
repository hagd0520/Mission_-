package com.ll.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class Save {
    public static void saver(List<Quote> quotes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter fw = new FileWriter("C:\\Users\\hagd0\\Desktop\\Quote_app\\quote.json");
            gson.toJson(quotes, fw);
            fw.close();
        } catch (Exception e) {}

    }
}
