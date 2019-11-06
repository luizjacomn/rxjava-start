package com.luizjacomn.main;

import io.reactivex.Observable;

public class TestRange {

	public static void main(String[] args) {
		Observable.range(0, 5).subscribe(System.out::println);
	}
	
}