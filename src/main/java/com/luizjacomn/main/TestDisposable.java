package com.luizjacomn.main;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * TestDisposable
 */
public class TestDisposable {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1000, TimeUnit.MILLISECONDS);

        Disposable disposable = observable.subscribe(System.out::println);

        Thread.sleep(5000);

        disposable.dispose();

        Thread.sleep(3000);
    }
}