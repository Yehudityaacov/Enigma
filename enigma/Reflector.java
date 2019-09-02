package enigma;

public class Reflector extends Translator {
	
	String ref ="YRUHQSLDPXNGOKMIEBFZCWVJAT";
   int[] reflact=new int[ref.length()];
   int[]ReversRef;
   
public int[] reflactor(){
	
	   reflact=HelpLetIndex(ref);
	 return reflact;
   }
public int[] Reverse(int[] arr) {
	return ReversRef=this.letReverse(arr);
	}
}
