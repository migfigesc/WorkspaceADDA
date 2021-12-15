package ejercicios;

import java.util.function.Predicate;
import org.jgrapht.Graph;
import us.lsi.graphs.views.SubGraphView;

public class Ejemplo1 {
	
	public static <V,E> Graph <V,E> ejercicio1apA(
			Graph<V,E> grafo, Predicate <V> p_v, Predicate<E> p_e) {
	return SubGraphView.of(grafo, p_v, p_e);	
	}

}
