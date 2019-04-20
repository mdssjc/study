package com.github.mdssjc.mja.cap15.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Functions {

    private static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(2);
    }

    public static Future<Integer> f(int x) {
        return executorService.submit(() -> x);
    }

    public static Future<Integer> g(int x) {
        return executorService.submit(() -> x);
    }
}
