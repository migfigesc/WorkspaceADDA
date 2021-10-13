package test;

import java.util.List;
import java.util.function.Function;
import ejercicios.algoritmos;

import us.lsi.common.Files2;

public class ejemplo1 {

	public static Function<Integer, Integer> f = x -> {
		return x + 1;
	};

	public static void main(String[] args) {
		List<String> lineasFichero = Files2.linesFromFile("ficheros/Ejemplo1_DatosEntrada.txt");
		for (String linea : lineasFichero) {
			String[] elementos = linea.split(",");

			Integer a = Integer.parseInt(elementos[0].trim());
			Integer b = Integer.parseInt(elementos[1].trim());
			String pf = elementos[2].trim();
			String sf = elementos[3].trim();
			String sp = elementos[4].trim();

			String res_funcional = algoritmos.ejemplo1(a, b, f, sp, pf, sf);
			String res_iterativo = algoritmos.ejemplo1_iterativo(a, b, f, sp, pf, sf);
			String res_recursivo = algoritmos.ejemplo1_recursivo(a, b, f, sp, pf, sf);

			System.out.print("Funcional: " + res_funcional);
			System.out.print("Iterativo: " + res_iterativo);
			System.out.print("Recursivo: " + res_recursivo);

		}
	}

}
