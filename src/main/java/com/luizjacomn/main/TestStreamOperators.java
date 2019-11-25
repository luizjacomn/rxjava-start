package com.luizjacomn.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * TestStreamOperators
 */
public class TestStreamOperators {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>>>> FROM <<<<<<");

        Observable<BigDecimal> observable = Observable.fromCallable(new PowTask(20));
        
        observable.doOnNext(System.out::println)
                .subscribe();

        System.out.println(">>>>>> FLATMAP <<<<<<");

        Observable.just("Lucas", "Daniel", "Flavio")
                .flatMap(value -> Observable.just("Rusbé: " + value))
                .doOnNext(System.out::println)
                .subscribe();

        System.out.println(">>>>>> GROUP BY <<<<<<");

        Observable.range(0, 10)
		        .groupBy(value -> value % 2 == 0 ? "par" : "impar")
		        .subscribe(group -> {
                    group.subscribe(value -> System.out.println("Grupo: " + group.getKey() + " - valor " + value));
                });
        
        System.out.println(">>>>>> REDUCE <<<<<<");

        Observable.just("Fortaleza", "Esporte", "Clube")
                .doOnNext(System.out::println)
                .reduce((a, b) -> a + " " + b)
                .doOnSuccess(r -> System.out.println("Reduce: " + r))
                .subscribe();

        System.out.println(">>>>>> SCAN <<<<<<");

        Observable.just("Fortaleza", "Esporte", "Clube")
                .doOnNext(System.out::println)
                .scan((a, b) -> a + " " + b)
                .doOnNext(s -> System.out.println("Scan: " + s))
                .subscribe();
        
        System.out.println(">>>>>> COLLECT <<<<<<");

        Observable.just("10", "20", "30", "40")
                .collect(ArrayList::new, (l, v) -> l.add(new BigDecimal(v)))
                .doOnSuccess(System.out::println)
                .subscribe();

        System.out.println(">>>>>> THROTTLE <<<<<<");

        Observable.interval(1000, TimeUnit.MILLISECONDS) // emite um valor a cada segundo
                .throttleLast(3000, TimeUnit.MILLISECONDS) // reemite apenas o último valor emitido dentro de uma janela de três segundos
                .doOnNext(System.out::println)
                .subscribe();
                
        Thread.sleep(10000);

        System.out.println(">>>>>> FILTER <<<<<<");

        Observable.range(0,10)
            .filter(v -> v % 2 == 0)
            .doOnNext(System.out::println)
            .subscribe();

        System.out.println(">>>>>> DISTINCT <<<<<<");

        Observable.just('a', 'b', 'c', 'd', 'c', 'b', 'a')
                .distinct()
                .doOnNext(System.out::println)
                .subscribe();

    }
}

class PowTask implements Callable<BigDecimal> {

    private double number;

    PowTask(double number) {
        this.number = number;
    }

    @Override
    public BigDecimal call() throws Exception {
        return BigDecimal.valueOf(number).pow(2);
    }

}