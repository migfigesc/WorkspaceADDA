package ejercicios;

import java.util.Optional;
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
	
//========================================================================================//	
	// BUSQUEDA BINARIA -> siempre se aplica con listas ordenadas (pag 74 Miguel Toro)
	// usando record se define un objeto, y no hace falta generar getters, setters, hash code...
	// dentro de la llave se le pueden definir algunos métodos
	
	public static record RangoString(
			Integer i,
			Integer j,
			Integer k, //la generamos ya que es prop. derivada -> k = (i+j)/2
			String a, //cadena string 1
			String b  //cadena string 2
			) {
		public static RangoString of(Integer i, Integer j, String a, String b) {
			return new RangoString(i, j, (i+j)/2, a, b);
		}
		
		public RangoString next() {
			Integer k = (i+j)/2;
			RangoString r;
			if(a.charAt(k)==b.charAt(k)) {
				r = RangoString.of(k+1,j,a,b);
			} else {
				r = RangoString.of(i, k, a, b);
			}
			return r;
		}
	};
	
	public static Integer ejemplo3_funcional(String a, String b) {
		RangoString inicial =  RangoString.of(0, a.length(), a, b);
		Stream<RangoString> sec = Stream.iterate(inicial, r->r.next()); //inicial: primer elemento, r->r.next: obtener siguiente elemento
		
		Optional<RangoString> res = sec
		.filter(r->r.i().equals(r.j))
		.findFirst();
		
		return res.isPresent() ? res.get().i() : -1;
	}
	
	public static Integer ejemplo3_iterativo(String a, String b) {
		Integer i = 0;
		Integer j = a.length();
		while(i<j) {
			Integer k = (i+j)/2;
			if(a.charAt(k)==b.charAt(k)) {
				i = k+1;
			} else {
				j=k;
			}
		}
		return i; //puede ser i, j, k ya que todos tendrán el mismo valor al final
	}
	
	public static Integer ejemplo3_recursivo(String a, String b) {
		Integer i = 0;
		Integer j = a.length();
		i = ejemplo3_recursivo_aux(a, b, i, j);
		return i;
	}
	
	public static Integer ejemplo3_recursivo_aux(String a, String b, Integer i, Integer j) {
		if(i<j) {
		} else {
			Integer k = (i+j)/2;
			if(a.charAt(k)==b.charAt(k)) {
				i = ejemplo3_recursivo_aux(a, b, k+1, j);
			} else {
				i = ejemplo3_recursivo_aux(a, b, i, k);
			}
		}
		return i;
	}
	
	public static String ejemplo3_test(String a, String b) {
		String res = "";
		res += "Funcional: " + ejemplo3_funcional(a, b);
		res += "\nIterativo: " + ejemplo3_iterativo(a, b);
		res += "\nRecursivo: " + ejemplo3_recursivo(a, b);
		return res;
	}
//========================================================================================//	

	
}


	
