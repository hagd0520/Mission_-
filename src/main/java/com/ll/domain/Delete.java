package com.ll.domain;

import com.ll.stardard.Rq;

import java.util.List;

public class Delete {
    public static void deleter(List<Quote> quotes, Rq rq) {
        boolean exceptionForNone = true;

        for (int i = 0; i < quotes.size(); i++) {
            if (rq.getRqId() == 0) return;
            if (quotes.get(i).getId() == rq.getRqId()) {
                quotes.remove(i);
                exceptionForNone = false;
                break;
            }
        }
        if (exceptionForNone) System.out.printf("%d번 명언은 존재하지 않습니다.\n", rq.getRqId());
    }
}
