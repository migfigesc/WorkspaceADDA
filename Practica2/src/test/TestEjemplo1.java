package test;

import java.util.List;
import ejercicios.Ejemplo1;
import us.lsi.common.Files2;
import us.lsi.common.List2;

public class TestEjemplo1 {
	


	public static void main(String[] args) {
		Files2.streamFromFile("ficheros/datos1.txt")
		.forEach(linea->ejemplo1(linea));
		System.out.println("Test");

	}

	public static void ejemplo1(String linea) {
		List<Integer> ls = List2.parse(linea, ",", Integer::parseInt);
		Ejemplo1.pruebas(ls);
	}

}
