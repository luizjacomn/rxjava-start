package com.luizjacomn.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

public class TestCompletable {
	private final static String campoNome = "nome";
	private final static String campoEmail = "email";
	private final static String campoIsMasculino = "isMasculino";

	public static void main(String[] args) {
		Action onComplete = () -> System.out.println("Completed..");

		Completable completable = Completable.complete();

		completable.subscribe(onComplete);

		Completable completableError = Completable.error(new RuntimeException("Eita piula..."));

		completableError.subscribe(onComplete, Throwable::printStackTrace);

		/*
		 * aqui você poderia executar alguma ação como invocar uma API externa,
		 * persistir alguma informação, etc. ou qualquer outra tarefa onde você não
		 * precisa de algum valor de retorno, mas precisa reagir caso ocorra algum erro
		 * ou quando essa ação seja concluída
		 */
		Completable completableFromAction = Completable.fromAction(() -> {
			pessoas().stream().filter(pessoa -> pessoa.get(campoIsMasculino).equals(Boolean.FALSE))
					.forEach(System.out::println);
		});

		completableFromAction.subscribe(() -> System.out.println("Ok...a ação terminou sem erros."),
				Throwable::printStackTrace);
	}

	private static List<Map<String, Object>> pessoas() {
		Map<String, Object> p1 = new HashMap<>();
		p1.put(campoNome, "Lucas");
		p1.put(campoEmail, "lucas@test.com");
		p1.put(campoIsMasculino, Boolean.TRUE);

		Map<String, Object> p2 = new HashMap<>();
		p2.put(campoNome, "Marcos");
		p2.put(campoEmail, "marcos@test.com");
		p2.put(campoIsMasculino, Boolean.TRUE);

		Map<String, Object> p3 = new HashMap<>();
		p3.put(campoNome, "Paula");
		p3.put(campoEmail, "paula@test.com");
		p3.put(campoIsMasculino, Boolean.FALSE);

		return Arrays.asList(p1, p2, p3);
	}
}