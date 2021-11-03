package ejercicios;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ejercicio1 {
	
	private static Boolean res;

	public static boolean ejercicio1_funcional(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		
		return ls.stream()
				.filter(pS)
				.map(f)
				.anyMatch(pI);
	}

	public static boolean ejercicio1_iterativo(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		
		res = false;
		int i = 0;
		while(i<ls.size()&&res==false) {
			String word = ls.get(i);
			if(pS.test(word)) {
				
			}
		}
		return res;
	}
	
	public static boolean ejercicio1_recursivo(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f) {
		
		return ejercicio1_recursivo_aux(ls, pS, pI, f, false, 0);
	}
	
	public static boolean ejercicio1_recursivo_aux(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String, Integer> f, Boolean res, Integer i) {
		
		if(i<ls.size()&&res==false) {
			if(pS.test(ls.get(i))) {
				if(pI.test(f.apply(ls.get(i)))) {
					res = true;
				}
			}
			res = ejercicio1_recursivo_aux(ls, pS, pI, f, res, i++);
		}
		return res;
	}

}
