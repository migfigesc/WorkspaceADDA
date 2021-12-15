package ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import comun.Graphs3;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.common.TriFunction;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {

	public static <V,E> Graph<V, E> apartadoC(SimpleWeightedGraph<V,E> grafo, Function<E, E> f_a) {
		return Graphs2.toDirectedWeightedGraph(grafo, f_a);
	}
	
	public static <V,E> Map<Color,Set<V>> apartadoD1(Graph<V,E> grafo) {
		var alg = new ConnectivityInspector<>(grafo);
		List<Set<V>> componentes = alg.connectedSets();
		Map<Color,Set<V>> res = /*inicializar Map*/;
		for(int i=0; i<componentes.size(); i++) {
			/* actualizar map con clave: Color.values()[i], y  valor a partir de elemento en lista: componentes*/
		}		
		return res;
	}
	public static <V,E> void apartadoD2(Map<Color,Set<V>> map, Graph<V, E> grafo, String fichero) {
		GraphColors.toDot(grafo, "ficheros/" + fichero + ".gv", /*Etiqueta Vertices*/,
				/*Etiqueta Aristas*/,
				v -> GraphColors.color(/*llamada a asignaColor*/)),
				/*Color aristas (usar asignaColor)*/));			
	}

	// ==================== Auxiliares ====================
	public static SimpleWeightedGraph<Ciudad, Carretera> importar_grafo(String fichero) {
		return GraphsReader.newGraph("ficheros/" + fichero + ".txt", Ciudad::ofFormat, Carretera::ofFormat,
				Graphs2::simpleWeightedGraph, Carretera::getKm);
	}
	
	public static <V> Color asignaColor(V v, Map<Color, Set<V>> map) {
		Color res = null;
		for(Map.Entry<Color, Set<V>> par: map.entrySet()) {
			if(par.getValue().contains(v)) {
				res = par.getKey();
				break;
			}
		}
		return res;
	}

	// ==================== Tests (esto va en la clase de test) ====================
	public static void main(String[] args) {
		SimpleWeightedGraph<Ciudad, Carretera> andalucia = importar_grafo("Andalucia");
		SimpleWeightedGraph<Ciudad, Carretera> castilla = importar_grafo("Castilla La Mancha");

		tests(andalucia, "Andalucia", "Sevilla", "Almeria");
		tests(castilla,"Castilla La Mancha", "Albacete", "Toledo");
	}
	
	private static void tests(SimpleWeightedGraph<Ciudad, Carretera> g, String fichero, String origen, String destino) {
		var g_a = apartadoA1(g, Carretera::ofWeight, Carretera::getKm);
		apartadoA2(g_a, fichero+" 2-A");
		Ciudad desde = Graphs3./*encontrar un vertice a partir de "origen"*/;
		Ciudad hasta = Graphs3./*encontrar un vertice a partir de "destino"*/);
		
		var g_c = apartadoC(g, Carretera::reverse);
		
		
				/* Con Grafo: g_c y nombre del archivo: fichero+" 2-C"
				GraphColors.toDot(grafo, "ficheros/" + fichero + ".gv", 
				v -> v.getNombre(),
				a -> a.getNombre() + "--" + a.getKm());*/
		
		var mc_d = apartadoD1(g);
		apartadoD2(mc_d, g, fichero+" 2-D");		
	}
	
		
	
}
