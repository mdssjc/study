package com.github.mdssjc.mja.cap15.v4;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Functions {

    public static void f(int x, IntConsumer dealWithresult, Consumer<Throwable> dealWithException) {
        try {
            dealWithresult.accept(x);
        } catch (Exception e) {
            dealWithException.accept(e);
        }
    }

    public static void g(int x, IntConsumer dealWithresult, Consumer<Throwable> dealWithException) {
        try {
            dealWithresult.accept(x);
        } catch (Exception e) {
            dealWithException.accept(e);
        }
    }
}
