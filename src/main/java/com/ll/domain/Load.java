package com.ll.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static void loader(List<Quote> quotes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileReader fr = new FileReader("C:\\Users\\hagd0\\Desktop\\Quote_app\\quote.json");
            Type listType = new TypeToken<ArrayList<Quote>>(){}.getType();
            List<Quote> quotesJson = gson.fromJson(fr, listType);
            for (int i = 0; i < quotesJson.size(); i++) quotes.add(quotesJson.get(i));
        } catch (Exception e) {}

    }
}
