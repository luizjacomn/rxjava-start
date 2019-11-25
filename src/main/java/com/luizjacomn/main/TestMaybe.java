package com.luizjacomn.main;

import java.math.BigDecimal;

import io.reactivex.Maybe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * TestMaybe
 */
public class TestMaybe {

    public static void main(String[] args) {
        Maybe<BigDecimal> maybe = Maybe.just(BigDecimal.valueOf(50));
        Maybe<BigDecimal> maybeEmpty = Maybe.empty();

        Consumer<BigDecimal> onSuccess = System.out::println;
        Consumer<Throwable> onError = Throwable::printStackTrace;
        Action onComplete = () -> System.out.println("Finalizado...");

        maybe.subscribe(onSuccess, onError, onComplete);
        maybeEmpty.subscribe(onSuccess, onError, onComplete);
    }

}