package test;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjemplo2 {
	
//	public static void main(String[] args) {
//		List<Pair<BinaryTree<Character>, List<Character>>> inputs = Files2.streamFromFile("ficheros/Ejemplo2_DatosEntrada.txt")
//				.map(linea -> {
//					String[] linea_split = linea.split("#");
//					return Pair.of(BinaryTree.parse(linea_split[0]), s->s.chartAt(0)),
//							parseLista(linea_split[1]);
//				})
//	}
	
	public static List<Character> parseLista (String s){
		String letras = s.replace(",", "").replace("[", "").replace("]", "");
		List<Character> res = new ArrayList<>();
		for(int i = 0; i<letras.length(); i++)
			res.add(letras.charAt(i));
				return res;
	}

}
