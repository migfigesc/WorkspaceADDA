package test;

import java.util.function.Predicate;

import org.jgrapht.Graph;

import ejercicios.Ejemplo1;
import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class TestEjemplo1 {
	
	public static void main(String[] args) {
		Graph<Ciudad, Carretera> andalucia =
				GraphsReader.newGraph(
						"ficheros/Andalucia.txt",
						Ciudad::ofFormat, //constructor a partir de string para vértices
						Carretera::ofFormat, //constructor a partir de string para aristas
						Graphs2::simpleWeightedGraph, //constructor del grafo
						Carretera::getKm); //peso del grafo
		
		
		Predicate<Ciudad> p_v = v->v.getHabitantes()<50000;
		Predicate<Carretera> p_e = e->e.getKm()	< 150.;
		
		Graph<Ciudad, Carretera> vista = Ejemplo1.ejercicio1apA(andalucia, p_v, p_e);
		
		Predicate<Ciudad> p_estilo = v->vista.degreeOf(v) > 2;
		
		GraphColors.toDot(vista, //grafo a representar
				"ficheros/Andalucia1A.gv", //ruta donde guardo el grafo
				v -> v.getNombre(), //etiqueta vertices
				e -> e.getNombre() + "--" + e.getKm(), //etiqueta aristas
				v -> GraphColors.colorIf(Color.orange, Color.gray, p_estilo.test(v)),
				e -> GraphColors.color(Color.cyan));
		
	}

}
