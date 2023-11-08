package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ll.domain.*;
import com.ll.stardard.Rq;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();

        // 9, 10 단계 파일을 통한 영속성 (불러오기) 및 data.json 빌드(String to Json)
        Load.loader(quotes);

        // 1 단계 종료
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd, 0);
            int idQueue = (quotes.isEmpty()) ? 1 : quotes.get(quotes.size()-1).getId() + 1;

            if (rq.getCmd().equals("종료")) break;

            // 2, 3, 4 단계 등록, 명언번호 노출 및 순차적인 증가
            if (rq.getCmd().equals("등록")) Regist.register(quotes, idQueue);

            // 5 단계 목록
            if (rq.getCmd().equals("목록")) GetList.getLister(quotes);

            // 6 단계 명언 삭제
            // 7 단계 존재하지 않는 명언삭제에 대한 예외처리
            if (rq.getCmd().equals("삭제")) Delete.deleter(quotes, rq);

            // 8 단계 명언 수정
            if (rq.getCmd().equals("수정")) Modify.modifier(quotes, rq);
        }
        // 9, 10 단계 파일을 통한 영속성(저장) 및 data.json 빌드(String from Json)
        Save.saver(quotes);
    }
}