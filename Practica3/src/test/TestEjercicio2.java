package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;
import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjercicio2 {
	
	public static List<Pair<BinaryTree<Integer>,Integer>> lecturaFichero(String ruta) {
		List<Pair<BinaryTree<Integer>,Integer>> res = new ArrayList<Pair<BinaryTree<Integer>,Integer>>();
			
		List<String> lines = Files2.linesFromFile(ruta); 
		for(String line:lines) {
			String[] splitLine = line.split("#"); BinaryTree<Integer> tree = BinaryTree.parse(splitLine[0],
			x->Integer.parseInt(x)); Integer num = Integer.valueOf(splitLine[1]);
			res.add(Pair.of(tree, num)); 
		} return res;
	}
			
			
			
	public static void main(String[] args) { List<Pair<BinaryTree<Integer>,Integer>> datos =
		lecturaFichero("ficheros/PI3E2_DatosEntrada.txt");
		System.out.println("============Test Ejercicio2============\n");
		System.out.println("SOLUCIÓN RECURSIVA:\n");
		for (Pair<BinaryTree<Integer>, Integer> dato : datos) {
				Set<Integer> ej2Recursivo = Ejercicio2.ejercicio2_recursivo(dato.first(), dato.second());
				System.out.format("%s: %s\n",dato,ej2Recursivo);
			}
		}
}

