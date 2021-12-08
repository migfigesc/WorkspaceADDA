package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.tiposrecursivos.Tree;

public class Ejemplo4 {
	
	public static <E> Map<Integer, List<E>> recursivo(Tree<E> t) {
		return recursivo_aux(t, 0, new HashMap<>());
	}
	
	private static <E> Map<Integer, List<E>> recursivo_aux(Tree<E> t, int nivel, Map<Integer, List<E>> res) {
		switch(t.getType()) {
		case Empty:
			actualizaMap(null, false, nivel, res);
			break;
		case Leaf:
			actualizaMap(null, false, nivel, res);
			break;
		case Nary:
			actualizaMap(t.getLabel(), t.getChildren().size()%2==0, nivel, res);
			t.getChildren().forEach(tc -> recursivo_aux(tc,nivel+1,res));
		
		} return res;
	} 
	
	private static <E> void actualizaMap(E label, boolean test, int nivel, Map<Integer, List<E>> res) {
		List<E> ls = res.get(nivel);
		if(ls==null) {
			if(test) {
				res.put(nivel, new ArrayList<>(List.of(label)));
			} else {
				res.put(nivel,new ArrayList<>());
			}
		} else if(test) {
			ls.add(label);
		}
	}

}
