package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestError {

	public static void main(String[] args) {
		Observable.error(new RuntimeException("Eita piula..."))
				  .subscribe(
					  System.out::println,
					  Throwable::printStackTrace,
					  () -> System.out.println("OnCompleted"));
	}

}