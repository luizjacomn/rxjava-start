package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestCreate {

	public static void main(String[] args) {
		Observable.create(emissor -> {
			emissor.onNext("first");
			emissor.onNext("second");
			emissor.onNext("third");
		}).subscribe(System.out::println);
	}
	
}