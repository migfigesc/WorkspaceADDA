package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class TestEjercicio3 {
	
	public static List<List<Integer>> lecturaFichero(String ruta) { 
		List<String> lines = Files2.linesFromFile(ruta); 
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		for(String line:lines) {
			List<String> nums = Arrays.asList(line.split(",")); 
			List<Integer> numList = List.of(Integer.parseInt(nums.get(0)), Integer.parseInt(nums.get(1)));
			res.add(numList);
			
		}return res;
	}	
	
	public static void main(String[] args) {
		
		List<List<Integer>> datos = lecturaFichero("ficheros/PI1E3_DatosEntrada.txt");
		
		
		System.out.println("##################################################\n" + "#\t\tEjercicio 3\t\t\t #\n"
				+ "#\tdata/PI1E3_DatosEntrada.txt\t\t #\n"
				+ "##################################################\n");
				for (int i=0;i<datos.size();i++) {
				String resEj3Iterativo = Ejercicio3.ejercicio3_funcional(datos.get(i).get(0),datos.get(i).get(1));
				String resEj3Recursivo = Ejercicio3.ejercicio3_itertivo(datos.get(i).get(0),datos.get(i).get(1)); 
				String resEj3Funcional = Ejercicio3.ejercicio3_recursivo(datos.get(i).get(0),datos.get(i).get(1));
				System.out.printf("Entrada: " + datos.get(i).get(0) + ", " + datos.get(i).get(1) + "\n"
				+ "1. Iterativa (while):\t\t%s\n"
				+ "2. Recursiva final:\t\t%s\n"
				+ "3. Funcional:\t\t\t%s\n\n" ,resEj3Iterativo,resEj3Recursivo,resEj3Funcional);
				} System.out.println("##################################################");
	}

}
