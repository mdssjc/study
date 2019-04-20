package com.github.mdssjc.mja.cap15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.github.mdssjc.mja.cap15.v2.Functions.f;
import static com.github.mdssjc.mja.cap15.v2.Functions.g;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 1337;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> y = f(x);
        Future<Integer> z = g(x);

        System.out.println(y.get() + z.get());
        executorService.shutdown();
    }
}
