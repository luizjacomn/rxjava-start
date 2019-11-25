package com.luizjacomn.main;

import java.math.BigDecimal;

import io.reactivex.Maybe;

/**
 * TestMaybe
 */
public class TestMaybe {

    public static void main(String[] args) {
        Maybe<BigDecimal> maybe = Maybe.just(BigDecimal.valueOf(50));

        maybe.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Finalizado..."));
    }

}