package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.math.Math2;

public class TestEjercicio1 {
	
	public static List<List<String>> leeFichero(String path) {
		List<String> lineasFichero = Files2.linesFromFile(path);
		List<List<String>> lineas = new ArrayList<List<String>>();
		for (String linea : lineasFichero) {
			if(!linea.startsWith("//")) {
				
				String[] elementos = linea.split(",");
				List<String> listaLinea = new ArrayList<String>();
				for(String palabra : elementos) {
					listaLinea.add(palabra.trim());
				}
				lineas.add(lineasFichero);
	
			} 
		}
		return lineas;
	}

	
	public static void main(String[] args) {
		List<List<String>> datos = leeFichero("ficheros/PI1E1_DatosEntrada.txt");
		
		// El predicado sobre String devuelve cierto si dicho String contiene
		//alguna vocal abierta (es decir, a, e, o)
		
		Predicate<String> vocalPredicate = new Predicate<String>( ) {
			public boolean test(String a) {
				if (a.indexOf("a")==-1&&a.indexOf("e")==-1&&a.indexOf("o")==-1) {
					return false;
				} else {
					return true;
				}
			}
		};
		
		Predicate<Integer> integerPredicate = new Predicate<Integer>() {
			public boolean test(Integer a) {
				return Math2.esPar(a);
			}
		};
		
		Function<String, Integer> longitudCadena = new Function<String, Integer>() {
			public Integer apply(String a) {
				return a.length();
			}
		};
		
		System.out.println("##################################################\n" + "#\t\tEjercicio 1\t\t\t #\n"
				+ "#\tdata/PI1E1_DatosEntrada.txt\t\t #\n"
				+ "##################################################\n");
				for (int i=0;i<datos.size();i++) {
				boolean resEj1Iterativo = Ejercicio1.ejercicio1_iterativo(datos.get(i),
				vocalPredicate, integerPredicate, longitudCadena);
				boolean resEj1Recursivo = Ejercicio1.ejercicio1_recursivo(datos.get(i),
				vocalPredicate, integerPredicate, longitudCadena);
				boolean resEj1Funcional = Ejercicio1.ejercicio1(datos.get(i),
				vocalPredicate, integerPredicate, longitudCadena);
				System.out.printf("Entrada: "+datos.get(i)+"\n"
				+ "1. Iterativa (while):\t\t%b\n"
				+ "2. Recursiva final:\t\t%b\n"
				+ "3. Funcional:\t\t\t%b\n\n"
				,resEj1Iterativo ,resEj1Recursivo, resEj1Funcional);
				} System.out.println("##################################################");
	}
}
