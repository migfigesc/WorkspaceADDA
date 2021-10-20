package ejercicios;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicio2 {
	
	public static Map<Integer, List<String>> ejercicio2 (List<List<String>> listas) {
		return listas.stream()
				.flatMap(lista->lista.stream())
				.collect(Collectors.groupingBy(String::length));
	}

}
