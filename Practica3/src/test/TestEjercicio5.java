package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ejercicios.Ejercicio5;
import ejercicios.Paridad;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjercicio5 {
	
	public static List<BinaryTree<Integer>> lecturaFichero(String ruta) {
		List<BinaryTree<Integer>> res = new ArrayList<BinaryTree<Integer>>(); 
		List<String> lines = Files2.linesFromFile(ruta);
		for(String line:lines) {
			BinaryTree<Integer> parsedTree = BinaryTree.parse(line, x->Integer.parseInt(x));
			res.add(parsedTree);
		} return res;
	}
	
	public static void main(String[] args) {
		List<BinaryTree<Integer>> datos = lecturaFichero("ficheros/PI3E5_DatosEntrada.txt");
			
		System.out.println("============Test Ejercicio 5============\n");

			System.out.println("SOLUCIÓN RECURSIVA:");
			for (BinaryTree<Integer> dato : datos) {
				Map<Paridad, List<Integer>> ej5Recursivo = Ejercicio5.ejercicio5_recursivo(dato);
				System.out.format("\n%s: %s",dato,ej5Recursivo);


			}
			
			System.out.println("\n\n\nSOLUCIÓN ITERATIVA:"); 
			for (BinaryTree<Integer> dato : datos) {
				Map<Paridad, List<Integer>> ej5Iterativo = Ejercicio5.ejercicio5_iterativo(dato);
				System.out.format("\n%s: %s",dato,ej5Iterativo);
			}
	}
}
