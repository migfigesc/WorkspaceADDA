package test;

import ejercicios.Ejemplo1;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjemplo1 {

	public static void main(String[] args) {
		Files2.streamFromFile("Ficheros/Ejemplo1_DatosEntrada.txt")
		.map(linea -> BinaryTree.parse(linea,Integer::parseInt))
		.forEach(t -> Ejemplo1.pruebas(t));
	}

}
