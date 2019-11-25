package com.luizjacomn.main;

import java.math.BigDecimal;

import io.reactivex.Observable;

/**
 * TestSideEffectsCallbacks
 */
public class TestSideEffectsCallbacks {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("15", "8", "20");

        observable.map(BigDecimal::new)
                  .doOnNext(System.out::print)
                  .subscribe(v -> System.out.println(" -> Ao quadrado: " + v.pow(2)));
    }
}