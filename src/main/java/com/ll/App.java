package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.Getter;

import javax.annotation.processing.Filer;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();


        // 10 단계 data.json 빌드(String to Json)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 9 단계 파일을 통한 영속성 (불러오기)
        try {
            FileReader fr = new FileReader("C:\\Users\\hagd0\\Desktop\\Quote_app\\quote.json");
            Type listType = new TypeToken<ArrayList<Quote>>(){}.getType();
            quotes = gson.fromJson(fr, listType);
        } catch (Exception e) {}

        int idQueue = (quotes.isEmpty()) ? 1 : quotes.get(quotes.size()-1).getId() + 1;
        System.out.println(idQueue);

        // 1 단계 종료
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd, 0);

            if (rq.cmd.equals("종료")) break;

            // 2, 3, 4 단계 등록, 명언번호 노출 및 순차적인 증가
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

            // 5 단계 목록
            if (rq.cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n-----------------------");
                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote quote = quotes.get(i);

                    System.out.printf("%d / %s / %s\n", quote.getId(), quote.getAuthor(), quote.getContent());
                }
            }

            // 6 단계 명언 삭제
            if (rq.cmd.equals("삭제")) {
                // 7 단계 존재하지 않는 명언삭제에 대한 예외처리
                boolean exceptionForNone = true;
                for (int i = 0; i < quotes.size() - 1; i++) {
                    if (Integer.parseInt(rq.rqId) == 0) break;
                    if (quotes.get(i).getId() == Integer.parseInt(rq.rqId)) {
                        quotes.remove(i);
                        exceptionForNone = false;
                        break;
                    }
                }
                if (exceptionForNone) System.out.printf("%s번 명언은 존재하지 않습니다.\n", rq.rqId);
            }

            // 8 단계 명언 수정
            if (rq.cmd.equals("수정")) {
                boolean exceptionForNone = true;
                for (int i = 0; i < quotes.size() - 1; i++) {
                    if (Integer.parseInt(rq.rqId) == 0) break;
                    if (quotes.get(i).getId() == Integer.parseInt(rq.rqId)) {
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
                if (exceptionForNone) System.out.printf("%s번 명언은 존재하지 않습니다.\n", rq.rqId);
            }
        }

        // 10 단계 data.json 빌드(String from Json)
        String quotesToJson = gson.toJson(quotes);
        for (int i = 0; i < quotes.size(); i++) {
//            gsonData.add(gson.toJson(quotes.get(i)));
//            System.out.println(gsonData.get(i));
        }

        // 9 단계 파일을 통한 영속성 (저장)
        PrintWriter pw = new PrintWriter("C:\\Users\\hagd0\\Desktop\\Quote_app\\quote.json");
        pw.println(quotesToJson);
        pw.close();
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
    String rqId;
    public Rq(String cmd, int defaultNum) {
        String[] cmds = cmd.split("\\?");
        if (cmds.length == 1) this.cmd = cmds[0].trim();
        if (cmds.length > 1) {
            this.cmd = cmds[0].trim();
            if (cmds.length > 1) {
                String[] contents = cmds[1].split("=");
                if (contents[0].trim().equals("id")) {
                    rqId = contents[1].trim();
                }
                if (!contents[0].trim().equals("id")) rqId = String.valueOf(defaultNum);
            }
        }
    }
}