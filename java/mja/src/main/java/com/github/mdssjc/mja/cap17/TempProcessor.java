package com.github.mdssjc.mja.cap17;

import java.util.concurrent.Flow;

public class TempProcessor implements Flow.Processor<TempInfo, TempInfo> {

    private Flow.Subscriber<? super TempInfo> subscriber;

    @Override
    public void subscribe(Flow.Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo temp) {
        this.subscriber.onNext(new TempInfo(temp.getTown(), (temp.getTemp() - 32) * 5 / 9));

    }

    @Override
    public void onError(Throwable throwable) {
        this.subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        this.subscriber.onComplete();
    }
}
