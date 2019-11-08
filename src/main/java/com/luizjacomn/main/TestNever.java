package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestNever {

	public static void main(String[] args) {
		// cria um Observable que não emite nenhum evento
		Observable.never().subscribe(
				//onNext
				System.out::println,
				//onError
				Throwable::printStackTrace,
				//onCompleted
				() -> System.out.println("OnCompleted"));
	}
	
}