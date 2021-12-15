package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;
import us.lsi.math.Math2;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio1 {
	
		public static List<Tree<Integer>> lecturaFichero(String ruta) {
			List<Tree<Integer>> res = new ArrayList<Tree<Integer>>();
			List<String> lines = Files2.linesFromFile(ruta);
			for(String line:lines) {
				Tree<Integer> parsedTree = Tree.parse(line,x->Integer.parseInt(x));
				res.add(parsedTree);
			}
			return res;	
			
		}
		public static void main(String[] args) {
			List<Tree<Integer>> datos = lecturaFichero("ficheros/PI3E1_DatosEntrada.txt");
	
			Predicate<Integer> predPar = x -> Math2.esPar(x);
			Predicate<Integer> predLess5 = x -> x < 5; 
	
			List<Predicate<Integer>> predicates = List.of(predPar, predLess5);
			List<String> titles = List.of("-PAR:", "-MENOR_QUE_CINCO:"); 
		
			System.out.println("============Test Ejercicio 1============\n");

			for(int i = 0; i<2 ; i++) {
				System.out.println("\nSOLUCIÓN RECURSIVA"+titles.get(i)+"\n");
				for (Tree<Integer> dato : datos) {
					Set<Integer> ej1Recursivo = Ejercicio1.ejercicio1_recursivo(dato, predicates.get(i));
					System.out.format("%s: %s\n",dato,ej1Recursivo);
			 
				} 
			}
			
			for(int i = 0; i<2 ; i++) {
				System.out.println("\nSOLUCIÓN ITERATIVA"+titles.get(i)+"\n");
				for (Tree<Integer> dato : datos) {
					Set<Integer> ej1Iterativo = Ejercicio1.ejercicio1_iterativo(dato, predicates.get(i));
					System.out.format("%s: %s\n",dato,ej1Iterativo);
				}
			}
		}
		

}
