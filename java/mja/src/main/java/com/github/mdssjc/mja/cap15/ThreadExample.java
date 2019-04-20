package com.github.mdssjc.mja.cap15;

import com.github.mdssjc.mja.cap15.v1.Functions;

import static com.github.mdssjc.mja.cap15.Tasks.work1;
import static com.github.mdssjc.mja.cap15.Tasks.work2;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        int x = 1337;
        Result result = new Result();

        Thread t1 = new Thread(() -> result.left = Functions.f(x));
        Thread t2 = new Thread(() -> result.right = Functions.g(x));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(result.left + result.right);

        work1();
        Thread.sleep(10000);
        work2();
    }
}
