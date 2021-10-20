package test;

import java.util.stream.Stream;

import ejercicios.Ejercicio0;
import us.lsi.common.Files2;

public class TestEjercicio0 {

	public static void main(String[] args) {
/*		List<String> lineasFichero = Files2.linesFromFile("ficheros/Ejemplo0_DatosEntrada.txt");
		for (String linea : lineasFichero) {
			String[] elementos = linea.split(",");

			Integer a = Integer.parseInt(elementos[0].trim());
			Integer b = Integer.parseInt(elementos[1].trim());
			String pf = elementos[2].trim();
			String sf = elementos[3].trim();
			String sp = elementos[4].trim();

			String res_funcional = Ejercicio0.ejemplo1(a, b, f, sp, pf, sf);
			String res_iterativo = Ejercicio0.ejemplo1_iterativo(a, b, f, sp, pf, sf);
			String res_recursivo = Ejercicio0.ejemplo1_recursivo(a, b, f, sp, pf, sf);

			System.out.print("Funcional: " + res_funcional);
			System.out.print("Iterativo: " + res_iterativo);
			System.out.print("Recursivo: " + res_recursivo);*/
		ejemplo3("ficheros/Ejercicio0");
		
	}
	public static void ejemplo3(String path) {
		Stream<String> lineasFichero = Files2.streamFromFile("ficheros/Ejercicio0.txt");		
		//Stream con lineas fichero
		lineasFichero
			//Stream con listas de elementos de cada linea
			.map(linea->linea.split(","))
			.forEach(elementos -> System.out.println(Ejercicio0.ejemplo3_test(elementos[0],
					elementos[1])));

		
		}
	}


