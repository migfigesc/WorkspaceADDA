package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio3 {
	
	public record Par(
			Integer v1,
			Integer v2) {
		public static Par of(Integer v1, Integer v2) {
			return new Par(v1, v2);
		}
	}
	
	public static String ejercicio3_funcional(Integer a, Integer limit) { return Stream
			.iterate(Par.of(0, a),
			t -> t.v1 < limit,
			t -> Par.of(t.v1+1, t.v1 % 3 == 1 ? t.v2 : t.v1+t.v2)) .collect(Collectors.toList())
			.toString();
	}
	
	public static String ejercicio3_itertivo(Integer a, Integer limit) {
		Par par = Par.of(0, a);
		List<Par> res = new ArrayList<Par>();
		res.add(par);
		while(par.v1<limit-1) {
			if(par.v1%3==1) {
				par = Par.of(par.v1+1, par.v2);
			} else {
				par = Par.of(par.v1+1, par.v1+par.v2);
			} res.add(par);
		} return res.toString();
	}
	
	public static String ejercicio3_recursivo(Integer a, Integer limit) {
		Par par = Par.of(0, a);
		List<Par> res = new ArrayList<Par>();
		res.add(par);
		return ejercicio3_recursivo_aux(a, limit, par, res);
	}
	
	public static String ejercicio3_recursivo_aux(Integer a, Integer limit, Par par, List<Par> res) {
		if(par.v1<limit-1) {
			if(par.v1%3==1) {
				res.add(Par.of(par.v1+1, par.v2));
				ejercicio3_recursivo_aux(a, limit, Par.of(par.v1+1, par.v1+par.v2), res);
			} else {
				res.add(Par.of(par.v1+1, par.v1+par.v2));
				ejercicio3_recursivo_aux(a, limit, Par.of(par.v1+1, par.v1+par.v2), res);
			}
		} return res.toString();
	}
}
