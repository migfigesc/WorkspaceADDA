package ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.common.Map2;

public class Ejercicio5 {
	
	public static Long g_sin_memoria(Integer a, Integer b, Integer c) {
		Long res = null;
		if(a<3 || b<3 || c<3) {
			res = (long) a + b*b + 2*c;
		} else if(a%b == 0) {
			res = (long) (g_sin_memoria(a-1, b/2, c/2) + g_sin_memoria(a-3, b/3, c/3));
		} else {
			res = (long) (g_sin_memoria(a/3, b-3, c-3) + g_sin_memoria(a/2, b-2, c-2));
		} return res;
	}
	
	public static Integer g_con_memoria(Integer a, Integer b, Integer c) {
		return g_con_memoria_aux(a, b, c, Map2.empty());
	}
	
	public static Integer g_con_memoria_aux(Integer a, Integer b, Integer c, Map<List<Integer>,Integer> m) {
		Integer res = m.get(List.of(a, b, c));
		if(res == null) {
			if(a<3 || b<3 || c<3) {
				res = a + b*b + 2*c;
			} else if(a%b == 0) {
				res = (int) (g_con_memoria_aux(a-1, b/2, c/2, m) + g_con_memoria_aux(a-3, b/3, c/3, m));
			} else {
				res = (int) (g_con_memoria_aux(a/3, b-3, c-3, m) + g_con_memoria_aux(a/2, b-2, c-2, m));
		} m.put(List.of(a, b, c), res);
		} return res;
	}
	
	public static Integer g_iterativo(Integer a, Integer b, Integer c ) {
		Map<List<Integer>, Integer> m = new HashMap<>();
		Integer res = null;
		for(int a_prima = 0; a_prima <=a; a_prima++) {
			for(int b_prima = 0; b_prima <=b; b_prima++) {
				for(int c_prima = 0; c_prima <=c; c_prima++) {
					if(a_prima<3 || b_prima<3 || c_prima<3) {
						res = a_prima + b_prima*b_prima + 2*c_prima;
					} else if(a_prima%b_prima == 0) {
						res = m.get(List.of(a_prima-1, b_prima/2, c_prima/2)) + m.get(List.of(a_prima-3, b_prima/3, c_prima/3));
					} else {
						res = m.get(List.of(a_prima/3, b_prima-3, c_prima-3)) + m.get(List.of(a_prima/2, b_prima-2, c_prima-2));
					} m.put(List.of(a_prima, b_prima, c_prima), res);
				}
			}
		} return m.get(List.of(a, b, c));
	}
}
