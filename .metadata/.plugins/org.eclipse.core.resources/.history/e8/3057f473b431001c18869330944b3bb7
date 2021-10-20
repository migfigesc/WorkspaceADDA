package ejercicios;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio0 {
	public static String ejemplo1(
			Integer a, //primer elemento
			Integer b, //limite (condicion de parada)
			Function<Integer,Integer> f, //siguiente elemento
			String sp, //separador
			String pf, //prefijo <
			String sf){ //sufijo >
			
		return Stream.iterate(a, x->x<=b, x -> f.apply(x))
				
			//operaciones para hacer, dadas por el enunciado
			.map(x->x*x) //cuadrados
			.map(x->x.toString()) //pasamos a string
			.collect(Collectors.joining(sp,pf,sf)); //acumulacion
			}
	
	public static String ejemplo1_iterativo(
			Integer a, //primer elemento
			Integer b, //limite (condicion de parada)
			Function<Integer,Integer> f, //siguiente elemento
			String sp, //separador
			String pf, //prefijo <
			String sf){ //sufijo >
			
		Integer x = a;
		String cadena = "";
		
		while(x<=b) {
			Integer x1 = x*x;
			String x2 = x1.toString();
			
			if(cadena == "") {
				cadena = x2;
			} else {
				cadena = cadena + sp + x2;
			}
			x = f.apply(x);	
		}	
		return pf + cadena + sf;
	}
	
	public static String ejemplo1_recursivo(
			Integer a, //primer elemento
			Integer b, //limite (condicion de parada)
			Function<Integer,Integer> f, //siguiente elemento
			String sp, //separador
			String pf, //prefijo <
			String sf){ //sufijo >
			
			Integer x = a;
			String cadena = "";
			cadena = ejemplo1_recursivo_aux(a, b, f, sp, cadena);
			
			return pf + cadena + sf;
	}
	
	public static String ejemplo1_recursivo_aux(
			Integer x,
			Integer b,
			Function<Integer, Integer> f,
			String sp,
			String cadena) {
	
		if(!(x<=b)) {
			return cadena;
		} else {
			Integer x1 = x*x;
			String x2 = x1.toString();
			if(cadena=="") {
				cadena = x2;
			} else {
				cadena = cadena + sp + x2;
			}
			x = f.apply(x);
			return ejemplo1_recursivo_aux(x, b, f, sp, cadena);
		}
	}
}


	
