package ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.List2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio5 {
	
	public static Map<Paridad, List<Integer>> ejercicio5_recursivo(BinaryTree<Integer> tree){
		return ejercicio5_recursivo_aux(tree, new HashMap<Paridad, List<Integer>>());
	}
	
	public static Map<Paridad, List<Integer>> ejercicio5_recursivo_aux(BinaryTree<Integer> tree, Map<Paridad, List<Integer>> res) {
		switch(tree.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			if(!tree.getLeft().isEmpty() && !tree.getRight().isEmpty()
				&& tree.getLabel() > tree.getLeft().getLabel()
				&& tree.getLabel() < tree.getRight().getLabel()) {
					if(tree.getLabel()%2==0) {
						if(res.containsKey(Paridad.Par)) res.get(Paridad.Par).add(tree.getLabel());
						else res.put(Paridad.Par, List2.of(tree.getLabel()));
					} else {
						if(res.containsKey(Paridad.Impar)) res.get(Paridad.Impar).add(tree.getLabel());
						else res.put(Paridad.Impar, List2.of(tree.getLabel()));
					}
				}
			ejercicio5_recursivo_aux(tree.getLeft(), res);
			ejercicio5_recursivo_aux(tree.getRight(), res);
			break;
		}  return res;
	}
	
	public static Map<Paridad, List<Integer>> ejercicio5_iterativo(BinaryTree<Integer> tree) {
		return tree.stream()
				.filter(t->t.isBinary()&&!t.getLeft().isEmpty()&&!t.getRight().isEmpty()
						&&t.getLabel()>t.getLeft().getLabel()
						&&t.getLabel()<t.getRight().getLabel())
				.map(t->t.getLabel())
				.collect(Collectors.groupingBy(t->t%2==0 ? Paridad.Par : Paridad.Impar));
	}

}
