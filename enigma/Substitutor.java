package enigma;


public abstract class Substitutor {
	private static final int Alphlength =26;
	int newposition=0;
	int arrSize;
	int letter;
	int[] letterToNumber;
	int[] newletter;
   public int[] HelpLetIndex(String str){ //translate each char in the string to his number in the ASCII  
	    str.toUpperCase();
	    char[] ch  = str.toCharArray();
	    arrSize=str.length();
	    letterToNumber= new int[arrSize];
	    for (int i=0;i<str.length();i++)
	    { 
	        int temp =ch[i];
	        if(temp<=90 & temp>=65)
	        {
	        	int temp_integer=(ch[i]-'A')+1;//for upper case
	        	letterToNumber[i]=temp_integer;
	        }
	        else {
	        	letterToNumber[i]=0;
	        }
	        
	    }
		return letterToNumber;
   }   
 public int CircularShifts(int shifts){//shift as mod 26
	 newposition=shifts;
			 if(shifts>26)
				 return newposition=(shifts)%Alphlength;
			 if(shifts<0||shifts==0)//if it is a negative number
				 return newposition=26+shifts;
			 else 
				 return newposition=shifts;
 };
 public abstract int[] letForward(String letters);
 public abstract int[] letReverse(int[] arr);
 
	
}

