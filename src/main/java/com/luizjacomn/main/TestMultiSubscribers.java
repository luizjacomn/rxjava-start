package com.luizjacomn.main;

import io.reactivex.Observable;

/**
 * TestMultiSubscribers
 */
public class TestMultiSubscribers {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("one", "two", "three");

        observable.subscribe(v -> System.out.println("First subscriber: " + v), Throwable::printStackTrace, () -> System.out.println("Completed..."));

        observable.subscribe(v -> System.out.println("Second subscriber: " + v));
    }
}