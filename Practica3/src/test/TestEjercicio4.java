package test;

import java.util.ArrayList;
import java.util.List;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio4 {
	public static List<Tree<String>> lecturaFichero(String ruta) {
		List<Tree<String>> res = new ArrayList<Tree<String>>();
		List<String> lines = Files2.linesFromFile(ruta); 
		for(String line:lines) {
			Tree<String> parsedTree = Tree.parse(line); 
			res.add(parsedTree);
		} return res;	
	}
	
	public static void main(String[] args) {
		List<Tree<String>> datos = lecturaFichero("ficheros/PI3E4_DatosEntrada.txt"); 
		System.out.println("============Test Ejercicio 4============\n");
		System.out.println("SOLUCIÓN RECURSIVA:");
		for(Tree<String> dato:datos) {
			List<String> ej4Recursivo = Ejercicio4.ejercicio4_recursivo(dato);
			System.out.format("\n%s: %s",dato,ej4Recursivo);
		}
	}

}
