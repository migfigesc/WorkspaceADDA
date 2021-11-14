package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ejercicios.Ejercicio5;
import us.lsi.common.Files2;

public class TestEjercicio5 {
	
	public static List<List<Integer>> lecturaFichero (String ruta) {
		List<String> lineas = Files2.linesFromFile(ruta);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(String linea : lineas) {
			List<String> nums = Arrays.asList(linea.split(","));
			res.add(List.of(Integer.parseInt(nums.get(0)), Integer.parseInt(nums.get(1)),
					Integer.parseInt(nums.get(2))));
		} return res;
	}


	public static void main(String[] args) {
		List<List<Integer>> datos = lecturaFichero("ficheros/PI2Ej5DatosEntrada.txt");
		
		for(List<Integer> dato : datos) {
			Long Ejercicio5_Recursivo_SinMem = Ejercicio5.g_sin_memoria(dato.get(0), dato.get(1), dato.get(2));
			Integer Ejercicio5_Recursivo_ConMem = Ejercicio5.g_con_memoria(dato.get(0), dato.get(1), dato.get(2));
			Integer Ejercicio5_Recursivo_Iterativo = Ejercicio5.g_iterativo(dato.get(0), dato.get(1), dato.get(2));
			
			System.out.format("\n(a,b,c) = (%d, %d, %d)\n" 
					+ "Recursivo sin memoria:\t%d\n" 
					+ "Recursivo con memoria:\t%d\\n" 
					+ "Iterativo:\t\t%d\n", 
					
					datos.get(0), datos.get(1), datos.get(2), Ejercicio5_Recursivo_SinMem,
					Ejercicio5_Recursivo_ConMem, Ejercicio5_Recursivo_Iterativo);
		}
	}
}
