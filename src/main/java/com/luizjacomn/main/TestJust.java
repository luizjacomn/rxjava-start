package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestJust {

	public static void main(String[] args) {
		Observable<String> observable = Observable.just("l", "j");
		
		observable.subscribe(
				System.out::println,
				Throwable::printStackTrace,
				() -> System.out.println("OnCompleted"));
	}
	
}