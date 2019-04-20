package com.github.mdssjc.mja.cap15.v3;

import java.util.function.IntConsumer;

public class Functions {

    public static void f(int x, IntConsumer dealWithresult) {
        dealWithresult.accept(x);
    }

    public static void g(int x, IntConsumer dealWithresult) {
        dealWithresult.accept(x);
    }
}
