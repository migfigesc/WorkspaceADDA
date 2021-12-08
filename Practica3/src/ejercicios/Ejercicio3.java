package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.List2;
import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {
	
	public static Pair<List<Integer>, Integer> ejercicio3_recursivo(BinaryTree<Integer> tree) {
		return ejercicio3_recursivo_aux(tree, new ArrayList<Integer>(),Pair.of(null, Integer.MIN_VALUE));
	}
	
	public static Pair<List<Integer>, Integer> ejercicio3_recursivo_aux(BinaryTree<Integer> tree, List<Integer> battery,
			Pair<List<Integer>, Integer> res) {
		switch(tree.getType()) {
		case Empty:
			break;
			
		case Leaf:
			battery.add(tree.getLabel());
			int multiplyList=1;
			for(int i : battery) multiplyList*=1;
			if(multiplyList>res.second()) res = Pair.of(battery, multiplyList);
			break;
			x
		case Binary:
			battery.add(tree.getLabel());
			List<Integer> origBattery = List2.copy(battery);
			res = ejercicio3_recursivo_aux(tree.getLeft(), battery, res);
			res = ejercicio3_recursivo_aux(tree.getRight(), origBattery, res);
			break;
		
		} return res;
	}

}
