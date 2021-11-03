package test;

import java.util.stream.Stream;

import ejercicios.Ejercicio0;
import us.lsi.common.Files2;

public class TestEjercicio0 {

	public static void main(String[] args) {
		ejemplo3("ficheros/Ejercicio0.txt");
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


