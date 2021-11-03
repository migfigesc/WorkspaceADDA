package ejercicios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Files2;
import us.lsi.common.List2;
import us.lsi.common.Matrix;

public class Ejemplo2 {
	
	public static void pruebas(String fichero) {
		List<Integer> datos = Files2.streamFromFile(fichero)
		.map(linea -> List2.parse(linea, " ", Integer::parseInt))
		.flatMap(ls -> ls.stream())
		.collect(Collectors.toList());
		int n = (int) Math.sqrt(datos.size());
		Matrix m = Matrix.of(datos.toArray(Integer[]::new), n, n);
		System.out.println("Resultado: " + cumpleCondicion(m));
	}
	
	public static Boolean cumpleCondicion(Matrix<Integer> m) {
		if(m.area()==1) {
			return true;
		} else {
			return m.corners().get(0) < m.corners().get(3)
					&& IntStream.range(0, 4).allMatch(i->cumpleCondicion(m.view(i)));
			}
	}

}
