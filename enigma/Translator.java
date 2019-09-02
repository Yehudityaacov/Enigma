package enigma;

public class Translator extends Substitutor {
	int[] Revers=null;
	int[] Forwoard=null;
	
	


	public int[] letForward(String rotor) {
		//set string to be array of int and change each characters to be a number 
			return Forwoard=HelpLetIndex(rotor);
		
		
	}

	
	public int[] letReverse(int[] arr) {
		Revers=new int[arr.length];
		int i=0;
		for( i=0; i<arr.length;i++){
			Revers[arr[i]-1]=i+1;
		}
		return Revers;
		
	}
	public int[] StringReverse(int[] arr) {
		for(int i = 0; i < arr.length-2; i++)
		{
		 int temp = arr[i];
		 arr[i] = arr[arr.length - i - 1];
		 arr[arr.length - i - 1] = temp;
		}
		return arr;
	}


}
