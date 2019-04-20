package com.github.mdssjc.mja.cap17;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

@AllArgsConstructor
public class TempSubscription implements Flow.Subscription {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Flow.Subscriber<? super TempInfo> subscriber;
    private final String town;

    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                try {
                    this.subscriber.onNext(TempInfo.fetch(this.town));
                } catch (Exception e) {
                    this.subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        this.subscriber.onComplete();
    }
}
