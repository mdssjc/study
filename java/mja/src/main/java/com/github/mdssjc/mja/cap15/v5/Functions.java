package com.github.mdssjc.mja.cap15.v5;

import java.util.concurrent.Flow;

public class Functions {

    public static void f(int x, Flow.Subscriber<Integer> s) {
        try {
            s.onNext(x);
            s.onComplete();
        } catch (Exception e) {
            s.onError(e);
        }
    }

    public static void g(int x, Flow.Subscriber<Integer> s) {
        try {
            s.onNext(x);
            s.onComplete();
        } catch (Exception e) {
            s.onError(e);
        }
    }
}
