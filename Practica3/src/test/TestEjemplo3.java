package test;

import java.util.List;
import java.util.function.Predicate;

import ejercicios.Ejemplo3;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class TestEjemplo3 {
	
	public static Predicate<Integer> PAR = x -> x%2==0;
	public static void main(String[] args) {
		List<Tree<Integer>> inputs = Files2.streamFromFile("ficheros/Ejemplo3_DatosEntrada.txt")
				.map(linea->Tree.parse(linea, s -> Integer.parseInt(s)))
				.toList();
		inputs.stream()
		.forEach(t->System.out.println("Arbol: " + t + "Sol: " + Ejemplo3.recursivo(t, PAR)));
		
	}

}
