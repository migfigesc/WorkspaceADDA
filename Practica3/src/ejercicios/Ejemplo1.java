package ejercicios;

import java.util.Iterator;
import java.util.List;

import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejemplo1 {
	
	// Input: arbol binario de enteros
	
	// Para cada nodo con 2 hijos no vacios
	// Su etiqueta == suma(etiqueta de sus 2 hijos)
	
	//Output: Boolean
	
	public static Boolean funcional(BinaryTree<Integer> tree) {
		Boolean res = true;
		List<BinaryTree<Integer>> st = tree.stream()
		.filter(t -> t.isBinary() && !t.getLeft().isEmpty() &&
				!t.getRight().isEmpty())
		.toList();
		
		res = st.stream()
		.allMatch(t->t.getLabel() == (t.getLeft().getLabel() + t.getRight().getLabel()));
		
		if(res && st.size()==0) {
			res = false;
		}
		
		return res;
	}
	
	public static Boolean recursivo(BinaryTree<Integer> tree) {
		Boolean res = true;
		Pair<Boolean,Integer> sol = recursivo_aux(tree, 0);
		if(sol.first() && sol.second()==0)
			res = false;
		else {
			res = sol.first();
		}
		return res;
 	}
	
	private static Pair<Boolean, Integer> recursivo_aux(BinaryTree<Integer> tree, int acumulador) {
		Boolean res = true;
		Pair<Boolean,Integer> sol = Pair.of(res, acumulador);
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if(tree.getLeft().isEmpty())
				sol = recursivo_aux(tree.getRight(), acumulador);
			else if(tree.getRight().isEmpty())
				sol = recursivo_aux(tree.getLeft(), acumulador);
			else {
				acumulador++;
				res = tree.getLabel() == (tree.getLeft().getLabel() + tree.getRight().getLabel()) &&
						recursivo_aux(tree.getLeft(), acumulador).first() &&
						recursivo_aux(tree.getRight(), acumulador).first();
				sol = Pair.of(res, acumulador);
			}
		} 
		
		return sol;
	}
	
	
	public static Boolean iterativo(BinaryTree<Integer> tree) {
		Boolean res = true;
		int acumulador = 0;
		Iterator<BinaryTree<Integer>> it = tree.iterator();
		
		while(res && it.hasNext()) {
			BinaryTree<Integer> t = it.next();
			
			if(t.isBinary() && !t.getLeft().isEmpty() && !t.getRight().isEmpty()) {
				Boolean cond = t.getLabel() == (t.getLeft().getLabel() + t.getRight().getLabel());
				
				if(!cond)
					res = false;
				else
					acumulador++;
			}
			
		}
		
		if(res&&acumulador == 0) {
			res = false;
		}
		
		
		return res;
	}
	
	public static void pruebas(BinaryTree<Integer> tree) {
		String s = "====== Ejemplo1 ======\n";
		s+= tree + "Funcional[" + funcional(tree) + "]\n";
		s+= tree + "Recursivo[" + recursivo(tree) + "]\n";
		s+= tree + "Iterativo[" + iterativo(tree) + "]\n";

		System.out.println(s);

	}

}
