package com.github.mdssjc.mja.cap15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.github.mdssjc.mja.cap15.v1.Functions.f;
import static com.github.mdssjc.mja.cap15.v1.Functions.g;

public class CFComplete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        executorService.submit(() -> a.complete(f(x)));
        int b = g(x);

        System.out.println(a.get() + b);
        executorService.shutdown();
    }
}
