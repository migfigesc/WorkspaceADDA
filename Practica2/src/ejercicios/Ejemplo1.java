package ejercicios;

import java.util.List;
import java.util.stream.Stream;

import us.lsi.common.List2;

public class Ejemplo1 {
	
	public static List<Integer> funcional (List<Integer> ls) {
		List<Integer> res = List2.empty(); //nos crea una lista vacía (Miguel Toro)
		Stream.iterate(ls.size()-1, pos -> pos >=0, pos -> pos -1)
			.forEach(pos -> res.add(ls.get(pos)));
		return res;
	}
	
	public static List<Integer> iterativo (List<Integer> ls) {
		List<Integer> res = List2.empty(); //nos crea una lista vacía (Miguel Toro)
//		Stream.iterate(ls.size()-1, pos -> pos >=0, pos -> pos -1)
		Integer pos = ls.size()-1;
		while(pos >= 0) {
//			.forEach(pos -> res.add(ls.get(pos)));
			res.add(ls.get(pos));
			pos--; // es igual a pos - 1
		}
		return res;
	}
	
	public static String pruebas(List<Integer> ls) {
		String res = "=======Ejemplo1======";
		res += "\nFuncional: " + funcional(ls);
		return res;
	}

}
