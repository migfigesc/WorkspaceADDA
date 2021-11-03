package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class TestEjercicio2 {
	
	public static List<List<String>> lecturaFichero(String path) { 
		List<String> lines = Files2.linesFromFile("ficheros/PI1E2_DatosEntrada1.txt");
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
		for(int i=1;i<=2;i++) { //No es necesario el toString en el entero i
			List<List<String>> datos = lecturaFichero("./data/PI1E2_DatosEntrada" + i + ".txt");
			Map<Integer,List<String>> resultado_ejercicio2_funcional = Ejercicio2.ejercicio2_iterativo(datos); 
			Map<Integer,List<String>> resultado_ejercicio2_iterativo = Ejercicio2.ejercicio2_iterativo(datos); 
			Map<Integer,List<String>> resultado_ejercicio2_recursivo = Ejercicio2.ejercicio2_recursivo(datos);
			System.out.println("##################################################\n" + "#\t\tEjercicio 2\t\t\t #\n"
			+ "#\tdata/PI1E2_DatosEntrada" + i + ".txt\t\t #\n"
			+ "##################################################\n\n"
			+ "Entrada: " + datos + "\n"
			+ "1. Iterativa (while):\t\t"+ resultado_ejercicio2_funcional +"\n"
			+ "2. Recursiva final:\t\t"+ resultado_ejercicio2_iterativo + "\n"
			+ "3. Funcional:\t\t\t" + resultado_ejercicio2_recursivo + "\n\n"
			+ "##################################################\n\n\n");
			} 
		}
			 
	}


