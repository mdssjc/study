package com.github.mdssjc.mja.cap15;

public interface Subscriber<T> {

    void onNext(T t);
}
