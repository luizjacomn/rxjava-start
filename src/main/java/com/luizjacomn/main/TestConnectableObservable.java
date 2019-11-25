package com.luizjacomn.main;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

/**
 * TestConnectableObservable
 */
public class TestConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1000, TimeUnit.MILLISECONDS);
        ConnectableObservable<Long> hot = observable.publish();
        Disposable disposable = hot.connect();

        Thread.sleep(3000);
        
        hot.subscribe(System.out::println);
        
        Thread.sleep(1500);
        disposable.dispose();
    }
}