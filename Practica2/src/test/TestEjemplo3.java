package test;

import us.lsi.common.Files2;
import us.lsi.common.IntPair;
import us.lsi.common.String2;
import ejercicios.Ejemplo3;

public class TestEjemplo3 {

	public static void main(String[] args) {
		Files2.streamFromFile("ficheros/Ejemplo3DatosEntrada.txt")
		.forEach(linea->test(linea));
			
		}

	private static void test(String linea) {
		IntPair p = IntPair.parse(linea);
		Integer a = p.first();
		Integer b = p.second();
		
		String2.toConsole("(a, b) = (%d,%d)", a, b);
		
		String2.toConsole("%-25s -> %d", "Recursivo sin memoria", Ejemplo3.g_sin_memoria(a, b));
		String2.toConsole("%-25s -> %d", "Recursivo con memoria", Ejemplo3.g_con_memoria(a, b));
		String2.toConsole("%-25s -> %d", "Iterativo", Ejemplo3.g_iterativo(a, b));
		String2.toConsole(String2.linea());

		//metiendo el 25 en el %s, mete 25 caracteres para que aparezca en forma de columnas. Puede ser + o -
		
	}
}


