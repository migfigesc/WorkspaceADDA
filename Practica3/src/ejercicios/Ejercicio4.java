package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {
	
	public static List<String> ejercicio4_recursivo(Tree<String> tree){
		return ejercicio4_recursivo_aux(tree, "", new ArrayList<String>());
	}

	public static List<String> ejercicio4_recursivo_aux(Tree<String> tree, String strRes, List<String> res){
		switch (tree.getType()) { 
		case Empty:
			break; 
		case Leaf:
			strRes = strRes.concat(tree.getLabel());
			boolean isPalindrome = true;
			int i = 0; int j = strRes.length()-1;
			while (i < j && isPalindrome == true) {
				isPalindrome = strRes.charAt(i++) == strRes.charAt(j--);
			}
			if(isPalindrome) res.add(strRes);
			break;
		case Nary:
			strRes = strRes.concat(tree.getLabel());
			for(Tree<String> child:tree.getChildren()) {
				res = ejercicio4_recursivo_aux(child,strRes,res); break;
			}
		} return res;
	}
}
