package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TreeLevel;

public class Ejemplo3 {
	
	public static <E> List<Boolean> recursivo (Tree<E> tree, Predicate<E> p) {
		return recursivo_aux(tree, p, 0, new ArrayList<>());
		
	}

	private static <E> List<Boolean> recursivo_aux(Tree<E> tree, Predicate<E> p, int nivel, List<Boolean> res) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			actualizaLista(p.test(tree.getLabel()), nivel, res);
		case Nary:
			actualizaLista(p.test(tree.getLabel()), nivel, res);
			tree.getChildren().stream().forEach(tc->recursivo_aux(tc, p, nivel+1,res));
		}
		return res;
	}

	private static void actualizaLista(boolean test, int nivel, List<Boolean> res) {
		if(nivel==res.size()) {
			res.add(test);
		} else {
			res.set(nivel, res.get(nivel) && test);
		}
		
	}
	
	public static <E> List<Boolean> iterativo(Tree<E> tree, Predicate<E> p) {
		List<Boolean> res = new ArrayList<>();
		Iterator<TreeLevel<E>> it = tree.byLevel();
		Boolean enc = false;
		
		while(it.hasNext()) {
			TreeLevel<E> nxt = it.next();
			
			if(res.size()<nxt.level()) {
				res.add(true);
				enc = true;
			}
			
			if(!enc) {
				if(!nxt.tree().isEmpty()) {
					if(p.test(nxt.tree().getLabel()))
						res.set(nxt.level(),	 true);
				}	
			}

		} return res;
	}

}
