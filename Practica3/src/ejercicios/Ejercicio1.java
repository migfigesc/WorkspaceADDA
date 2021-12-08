package ejercicios;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {
	
	public static <E> Set<E> ejercicio1_recursivo(Tree<E> tree, Predicate<E> predicate) {
		return ejercicio1_recursivo_aux(tree, predicate, new HashSet<E>());
	}
	
	public static <E> Set<E> ejercicio1_recursivo_aux(Tree<E> tree, Predicate<E> predicate, Set<E> res) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			if(predicate.test(tree.getLabel())) res.add(tree.getLabel());
			break;
		case Nary:
			for(Tree<E> child:tree.getChildren()) {
				ejercicio1_recursivo_aux(child, predicate, res);
			}
			break;
		} return res;
	}
	
	public static <E> Set<E> ejercicio1_iterativo(Tree<E> tree, Predicate<E> predicate) {
		return tree.stream()
				.filter(t->!t.isEmpty() && t.isLeaf() && predicate.test(t.getLabel()))
				.map(t->t.getLabel())
				.collect(Collectors.toSet());
	}

}
