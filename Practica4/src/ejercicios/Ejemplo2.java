package ejercicios;

import java.util.function.Function;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import us.lsi.common.TriFunction;
import us.lsi.graphs.Graphs2;

public class Ejemplo2 {
	
	public static <V,E> Graph<V,E> ejercicio2apA(Graph<V,E> grafo,
			TriFunction<V,V,Double,E> factoria_e,
			Function<E,Double> func_peso) {
		return Graphs2.explicitCompleteGraph(
				grafo, //grafo a completar
				1000., //peso de aristas artificiales
				Graphs2::simpleWeightedGraph, //facoria del grafo de salida o grafo completo
				factoria_e, //factoria para crear las aristas artificiales
				func_peso); //funcion para obtener el peso de las aristas
	}
	
	public static <V,E> GraphPath<V,E> ejercicio2apB(
			Graph<V,E> grafo,
			V origen,
			V destino) {
		DijkstraShortestPath alg = new DijkstraShortestPath<>(grafo);
		return alg.getPath(origen, destino);
	}

}
