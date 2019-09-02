package enigma;

public class Plugboard extends Translator{
  public static int plugSize;
	int[][] plugb;
public int countPairs(int numofpairs){
	plugSize=numofpairs;
	plugb=new int[2][plugSize];
	return plugSize;
}
public int[][] ToPlug(String pairs){//exchange latter according to his pair
	int j=0;
	int[] plugToIndex=HelpLetIndex(pairs);
	for(int i=0;i<pairs.length();i++){
		if(plugb!=null&&plugToIndex[i]!=0&&j<plugSize){
			plugb[0][j]=plugToIndex[i];
			plugb[1][j]=plugToIndex[i+1];
			i++;
			j++;
		}
	}
	return plugb;
}
public int[] newPlug(int[] newStringPlug){//convert from array of array to one array of char
	for(int i=0;i<plugSize;i++){
		for(int j=0;j<newStringPlug.length;j++)
		{
			if(plugb[0][i]==newStringPlug[j]){
				newStringPlug[j]=plugb[1][i];
			}
			else if (plugb[1][i]==newStringPlug[j])
				newStringPlug[j]=plugb[0][i];
		}
	}
	return newStringPlug;
}
public int newletterIndex(int letter){ //get each letter by his number switch letter reflect 
	for(int i=0;i<plugSize;i++){
		if(plugb[0][i]==letter){
			letter=plugb[1][i];
		}
		else if (plugb[1][i]==letter)
			letter=plugb[0][i];
		}
	return letter;
	}

}




