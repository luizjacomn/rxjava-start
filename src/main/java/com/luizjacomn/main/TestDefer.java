package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestDefer {
	public static void main(String[] args) throws InterruptedException {
		// semelhante ao Observable.create, mas permite declarar dinamicamente como o Observable deve ser criado a cada subscrição
		// o argumento é um java.util.concurrent.Callable<? extends ObservableSource<? extends T>>.
		Observable<String> observable = Observable.defer(() -> e -> e.onNext("hello"));

		observable.subscribe(System.out::println);
		observable.subscribe(System.out::println);
		
		// ambos os subscribers receberam o mesmo valor
		Observable<Long> observavel = Observable.just(System.currentTimeMillis()); //o Observable é criado com este valor

		observavel.subscribe(System.out::println);
		Thread.sleep(1000);
		observavel.subscribe(System.out::println);
		
		// diferentes timestamps
		Observable<Long> observavelDefer = Observable.defer(() -> Observable.just(System.currentTimeMillis()));

		observavelDefer.subscribe(System.out::println);
		Thread.sleep(1000);
		observavelDefer.subscribe(System.out::println);
	}
}