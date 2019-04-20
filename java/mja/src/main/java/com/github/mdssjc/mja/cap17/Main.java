package com.github.mdssjc.mja.cap17;

import io.reactivex.Observable;

import java.util.concurrent.Flow;

public class Main {

    public static void main(String[] args) {
        //getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
        // getTemperatures("New York").subscribe(new TempSubscriber());

        Observable<TempInfo> observable = TempObservable.getTemperature("New York");
        observable.blockingSubscribe(new TempObserver());

        observable = TempObservable.getCelsiusTemperatures("New York", "Chicago", "San Francisco");
        observable.blockingSubscribe(new TempObserver());
    }

    private static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }

    private static Flow.Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }
}
