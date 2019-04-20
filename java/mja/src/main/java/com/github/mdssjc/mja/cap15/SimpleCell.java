package com.github.mdssjc.mja.cap15;

import java.util.ArrayList;
import java.util.List;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {

    private int value = 0;
    private String name;
    private List<Subscriber> subscribers;

    public SimpleCell(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        this.subscribers.add(subscriber);
    }

    private void notifyAllSubscribers() {
        this.subscribers.forEach(s -> s.onNext(this.value));
    }

    @Override
    public void onNext(Integer newValue) {
        this.value = newValue;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

    public static void main(String[] args) {
        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3);
        c1.onNext(10);
        c2.onNext(20);
    }
}
