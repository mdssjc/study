package com.github.mdssjc.mja.cap15;

public interface Subscription {

    void cancel();

    void request(long n);
}
