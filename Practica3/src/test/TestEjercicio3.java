package test;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Ejercicio3;
import us.lsi.common.Files2;
import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjercicio3 {
	
	public static List<BinaryTree<Integer>> lecturaFichero(String ruta) {
		List<BinaryTree<Integer>> res = new ArrayList<BinaryTree<Integer>>();
		List<String> lines = Files2.linesFromFile(ruta);
		for(String line:lines) {
			BinaryTree<Integer> parsedTree = BinaryTree.parse(line, x->Integer.parseInt(x));
			res.add(parsedTree); 
		} return res;
	}
	
	public static void main(String[] args) {
		List<BinaryTree<Integer>> datos = lecturaFichero("ficheros/PI3E3_DatosEntrada.txt");
		System.out.println("============Test Ejercicio 3============\n");
		System.out.println("SOLUCIÓN RECURSIVA:\n");
		for (BinaryTree<Integer> dato : datos) {
			Pair<List<Integer>, Integer> ej3Recursivo = Ejercicio3.ejercicio3_recursivo(dato);
			System.out.format("%s: %s\n",dato,ej3Recursivo);
		}
	}

}
