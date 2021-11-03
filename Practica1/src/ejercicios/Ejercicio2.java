package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicio2 {
	
	public static Map<Integer, List<String>> ejercicio2_funcional (List<List<String>> listas) {
		return listas.stream()
				.flatMap(lista->lista.stream())
				.collect(Collectors.groupingBy(String::length));
	}
	
	public static Map<Integer, List<String>> ejercicio2_iterativo (List<List<String>> listas) {
		Map<Integer, List<String>> res = new HashMap<Integer,List<String>>();
		int i=0;
		while(i<listas.size()) {
			int r=0;
			while(listas.get(i).size()>r) {
				String palabra = listas.get(i).get(r);
				if(res.containsKey(palabra.length())) {
					res.get(palabra.length()).add(palabra);
				} else {
					List<String> valorUpdate = new ArrayList<String>();
					valorUpdate.add(palabra);
					res.put(palabra.length(), valorUpdate);
				} r++;
			} i++;
		} return res;
	}
	
	public static Map<Integer, List<String>> ejercicio2_recursivo(List<List<String>> listas) {
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();
		return ejercicio2_recursivo_aux(listas, res, 0, 0);
	}
	
	public static Map<Integer, List<String>> ejercicio2_recursivo_aux(List<List<String>> listas, Map<Integer,List<String>> res, Integer i, Integer r) {
		if(listas.size()>i) {
			if(listas.get(i).size()>r) {
				String palabra = listas.get(i).get(r);
				if(res.containsKey(palabra.length())) {
					res.get(palabra.length()).add(palabra);
				} else {
					List<String> valorUpdate = new ArrayList<String>();
					valorUpdate.add(palabra);
					res.put(palabra.length(), valorUpdate);
				} res = ejercicio2_recursivo_aux(listas, res, i, r+1);
			}
		} return res;
	}

}
