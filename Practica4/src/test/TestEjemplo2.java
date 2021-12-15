package test;

import java.util.function.Predicate;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;

import comun.Graphs3;
import ejercicios.Ejemplo2;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class TestEjemplo2 {
	
	public static void main(String[] args) {
		Graph<Ciudad, Carretera> andalucia =
				GraphsReader.newGraph(
						"ficheros/Andalucia.txt",
						Ciudad::ofFormat, //constructor a partir de string para vértices
						Carretera::ofFormat, //constructor a partir de string para aristas
						Graphs2::simpleWeightedGraph, //constructor del grafo
						Carretera::getKm); //peso del grafo
		
		Graph<Ciudad,Carretera> completo = Ejemplo2.ejercicio2apA(
				andalucia, 
				Carretera::ofWeight, 
				Carretera::getKm);
		
		Predicate<Ciudad> p_estilo_v = v -> completo.edgesOf(v).stream().anyMatch(e -> e.getKm() == 1000.);
		Predicate<Carretera> p_estilo_e = e -> e.getKm() == 1000.;
		
		GraphColors.toDot(completo, //grafo a representar
				"ficheros/Andalucia1A.gv", //ruta donde guardo el grafo
				v -> v.getNombre(), //etiqueta vertices
				e -> e.getNombre() + "--" + e.getKm(), //etiqueta aristas
				v -> GraphColors.colorIf(Color.orange, Color.gray, p_estilo_v.test(v)),
				e -> GraphColors.colorIf(Color.orange, Color.gray, p_estilo_e.test(e)));
		
		Ciudad sevilla = Graphs3.findVertex(andalucia, Ciudad.ofName("Sevilla"));
		Ciudad malaga = Graphs3.findVertex(andalucia, Ciudad.ofName("Malaga"));

		
		GraphPath<Ciudad,Carretera> camino_minimo =
				Ejemplo2.ejercicio2apB(andalucia, sevilla, malaga);
		
		Predicate<Ciudad> p_cm_v = v->camino_minimo.getVertexList().contains(v);
		Predicate<Carretera> p_cm_e = e-> camino_minimo.getEdgeList().contains(e);
		
		GraphColors.toDot(completo, //grafo a representar
				"ficheros/Andalucia2B.gv", //ruta donde guardo el grafo
				v -> v.getNombre(), //etiqueta vertices
				e -> e.getNombre() + "--" + e.getKm(), //etiqueta aristas
				v -> GraphColors.colorIf(Color.orange, Color.gray, p_cm_v.test(v)),
				e -> GraphColors.colorIf(Color.orange, Color.gray, p_cm_e.test(e)));
	}

}
