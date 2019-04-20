package com.github.mdssjc.mja.cap15;

public interface Publisher<T> {

    void subscribe(Subscriber<? super T> subscriber);
}
