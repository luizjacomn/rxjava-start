package com.luizjacomn.main;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestObserver {

	public static void main(String[] args) {
		Observable<String> observable = Observable.just("one", "two", "three");

		observable.subscribe(new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Alguém se subscreveu...");
			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed...");
			}
		});
	}
	
}