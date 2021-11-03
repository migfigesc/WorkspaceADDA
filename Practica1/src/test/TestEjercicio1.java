package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import ejercicios.Ejercicio0;
import ejercicios.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.math.Math2;

public class TestEjercicio1 {
	
	public static List<List<String>> lecturaFichero(String path) { 
		List<String> lines = Files2.linesFromFile("ficheros/PI1E1_DatosEntrada.txt");
		List<List<String>> res = new ArrayList<List<String>>();
		for(String line:lines) {
			if(!line.startsWith("//")) {
					List<String> lineList = new ArrayList<String>();
					List<String> words = Arrays.asList(line.split(","));
					for(String word:words) lineList.add(word.trim());
					res.add(lineList);
			}
		} return res;
	}	
	
	public static void main(String[] args) {
		List<List<String>> datos = lecturaFichero("ficheros/PI1E1_DatosEntrada.txt");
			
		Predicate<String> pS = new Predicate<String>() {
				public boolean test(String a) {
				if (a.indexOf('a')==-1&&a.indexOf('e')==-1&&a.indexOf('o')==-1) return false; 
				else return true;
			} 
		};
		
		
		Predicate<Integer> pI = new Predicate<Integer>() {
			public boolean test(Integer a) { 
				return Math2.esPar(a);
			} 
		};
		
		Function<String,Integer> f = new Function<String, Integer>() {
			public Integer apply(String a) {
				return a.length();
			} 
		};
		

		System.out.println("··········································\n" + "#\t\tEjercicio 1\t\t\t #\n"
				+ "#\tdata/PI1E1_DatosEntrada.txt\t\t #\n"
				+ "··········································\n");
				for (int i=0;i<datos.size();i++) {
				boolean resultado_ejercicio1_funcional = Ejercicio1.ejercicio1_funcional(datos.get(i),pS, pI, f);
				boolean resultado_ejercicio1_iterativo = Ejercicio1.ejercicio1_iterativo(datos.get(i),pS, pI, f);
				boolean resultado_ejercicio1_recursivo = Ejercicio1.ejercicio1_recursivo(datos.get(i), pS, pI, f);
				
				System.out.printf("Entrada: "+ datos.get(i)+"\n"
				+ "1. Iterativa (while):\t\t%b\n"
				+ "2. Recursiva final:\t\t%b\n"
				+ "3. Funcional:\t\t\t%b\n\n"
				,resultado_ejercicio1_funcional, resultado_ejercicio1_iterativo, resultado_ejercicio1_recursivo);
				} 
				System.out.println("··········································");
	}
}
	



