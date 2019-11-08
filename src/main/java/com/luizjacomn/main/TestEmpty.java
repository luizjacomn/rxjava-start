package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestEmpty {

	public static void main(String[] args) {
		// cria um Observable vazio, que emite apenas onCompleted
		Observable.empty().subscribe(
				// onNext
				System.out::println, 
				// onError
				Throwable::printStackTrace, 
				// onCompleted
				() -> System.out.println("OnCompleted"));
	}
	
}