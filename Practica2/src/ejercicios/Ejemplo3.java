package ejercicios;

import java.util.Map;

import us.lsi.common.Map2;
import us.lsi.common.Pair;

public class Ejemplo3 {
	public static Long g_sin_memoria(Integer a, Integer b) {
		Long res = null;
		if(a<2 && b<2 ) {
			res = (long) (a + b*b);
		} else if(a<2 || b<2) {
			res = (long) a*a + b;
		} else {
			res = g_sin_memoria(a/2, b-1) + g_sin_memoria(a/3, b-2) + g_sin_memoria(a-2, b/4);
		} return res;
	}
	
	public static Long g_con_memoria(Integer a, Integer b) {
		return g_con_memoria_aux(a, b, Map2.empty());
	}
	
	public static Long g_con_memoria_aux(Integer a, Integer b, Map<Pair<Integer, Integer>, Long> m) {
		Long res = m.get(Pair.of(a, b));
		if(res == null) {
			if(a<2 && b<2 ) {
				res = (long) (a + b*b);
			} else if(a<2 || b<2) {
				res = (long) a*a + b;
			} else {
				res = g_con_memoria_aux(a/2, b-1, m) + g_con_memoria_aux(a/3, b-2, m) + g_con_memoria_aux(a-2, b/4, m);
		} m.put(Pair.of(a, b), res);
		} return res;

	}
	
	public static Long g_iterativo(Integer a, Integer b) {
		Map<Pair<Integer, Integer>, Long> m = Map2.empty();
		Long res = null;
		for(int a_prima = 0; a_prima <= a; a_prima++) {
			for(int b_prima = 0; b_prima <=b; b_prima++) {
				if(a_prima<2 && b_prima<2) {
					res = (long) a_prima + b_prima*b_prima;
				} else if(a_prima<2 || b_prima<2) {
					res = (long) a_prima * a_prima + b_prima;
				} else {
					res = m.get(Pair.of(a_prima/2, b_prima-1)) + m.get(Pair.of(a_prima/3, b_prima-2)) + 
							m.get(Pair.of(a_prima-2, b_prima/4));
				} m.put(Pair.of(a_prima, b_prima), res);
			} 

		} return m.get(Pair.of(a, b));
	}
}
	
