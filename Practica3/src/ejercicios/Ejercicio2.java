package ejercicios;

import java.util.HashSet;
import java.util.Set;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio2 {
	
	public static Set<Integer> ejercicio2_recursivo(BinaryTree<Integer> tree, Integer num) {
		return ejercicio2_recursivo_aux(tree, num, new HashSet<Integer>());
	}
	
	public static Set<Integer> ejercicio2_recursivo_aux(BinaryTree<Integer> tree, Integer num, Set<Integer> res) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			if(tree.getLabel()>=num) res.add(tree.getLabel());
			break;
		case Binary:
			if(tree.getLabel()>num) {
				res.add(tree.getLabel());
				res.addAll(ejercicio2_recursivo_aux(tree.getRight(), num, res));
				res.addAll(ejercicio2_recursivo_aux(tree.getLeft(), num, res));
			} else {
				if(tree.getLabel().equals(num)) res.add(tree.getLabel());
				res.addAll(ejercicio2_recursivo_aux(tree.getRight(), num, res));
			}
			break;
		} return res;
	}

}
