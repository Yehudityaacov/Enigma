package enigma;

public class Enigma extends Substitutor{
	int[] rotor ;
	int[] offsets;
	int[] settings; 
	int[] massege;
	Reflector ref=new Reflector();
	Plugboard plag_in=new Plugboard();
	int outputOf_input ;
	int inputOf_output;
	Rotor RotorRight=new Rotor();
	Rotor RotorMiddle=new Rotor();
	Rotor Rotorlefth=new Rotor();
	String pluge;
	int[] tempPluge;
	int numOfpairs;
public  Enigma(int[] rotor ,int[] offsets, int[] settings,String Massege,String plug,int numofpairs){
     this.offsets=offsets;
     this.settings=settings;
     this.rotor=rotor;
     massege=this.HelpLetIndex(Massege);
     this.pluge=plug;
     numOfpairs=plag_in.countPairs(numofpairs);
    
     
}
public void setSetting(int index){//dont change!!
	if(index==0)
		RotorRight.ringsettingC=settings[0];
	if(index==1)
		RotorMiddle.ringsettingC=settings[1];
	if(index==2)
		Rotorlefth.ringsettingC=settings[2];
}
public int RotetForword(Rotor rotor ,int letter){
	
	outputOf_input=rotor.RotorPosition(rotor.Rotor,letter,rotor.ringsettingC, rotor.OffsetB);
	return outputOf_input;
	
	//after all the rotation 
}
public int RotetReverse(Rotor rotor ,int letter){
	
	inputOf_output=rotor.reRotorPosition(rotor.Rotor,letter,rotor.ringsettingC, rotor.OffsetB);
	return inputOf_output;
	
	//after all the rotation 
}

public char[] process(){
	int letterMassg=0;
	creteRotor();
	int[] encriptref=new int[26];
	char[] encriptMass=new char[massege.length];
	char[] encriptMass2=new char[massege.length];
	int[] alphBat=new int[26];
	plag_in.ToPlug(pluge);
	tempPluge=this.HelpLetIndex(pluge);
	
	
	this.plag_in.newPlug(tempPluge);
	encriptref=ref.reflactor(); 
	alphBat=this.HelpLetIndex(RotorRight.Alph);
	encriptMass2=RotorRight.Alph.toCharArray();
	for( int i=0;i<massege.length;i++){
		
		letterMassg=massege[i];
		if(letterMassg!=0){
			
		letterMassg=this.plag_in.newletterIndex(letterMassg);//first throw plAgboard
		letterMassg=alphBat[letterMassg-1];
		updateOffset(RotorRight);//update the offset
		letterMassg=RotetForword(Rotorlefth,RotetForword(RotorMiddle,RotetForword(RotorRight,letterMassg)));//rotor R-M-L
		letterMassg=encriptref[letterMassg-1];// reflector
		letterMassg=RotetReverse(RotorRight,RotetReverse(RotorMiddle,RotetReverse(Rotorlefth,letterMassg)));//rotor L-M-R
		letterMassg=this.plag_in.newletterIndex(letterMassg);//in reverse throw plugboard
		letterMassg=alphBat[letterMassg-1];
		encriptMass[i]=encriptMass2[letterMassg-1];//change back to array of char
		}
		else {
			encriptMass[i]=' ';
		}
		
	}
	
	return encriptMass;
}

public void updateOffset(Rotor rot)
{
	if(RotorRight.OffsetB==RotorRight.TenrOverNnotch(rotor[0])||RotorMiddle.OffsetB==RotorMiddle.TenrOverNnotch(rotor[1])){
		if(RotorMiddle.OffsetB==RotorMiddle.TenrOverNnotch(rotor[1]))
		{
			Rotorlefth.OffsetB=(RotorMiddle.OffsetB+1)%26;
		}
	 RotorMiddle.OffsetB=(RotorMiddle.OffsetB+1)%26;
	 }
	RotorRight.OffsetB=(RotorRight.OffsetB+1)%26;
	
}
public void SetOffset(int index){
	if(index==0)
		RotorRight.OffsetB=offsets[0];
	if(index==1)
		RotorMiddle.OffsetB=offsets[1];
	if(index==2)
		Rotorlefth.OffsetB=offsets[2];
}
public void setRotor(int numRotor,int index){
	if(index==0)
		RotorRight.intialRotor(numRotor);
	if(index==1)
		RotorMiddle.intialRotor(numRotor);
	if(index==2)
		Rotorlefth.intialRotor(numRotor);
}

public int[] setReflector(){
    return ref.reflactor();

}
	
public void creteRotor(){
	for(int i=0;i<rotor.length;i++){
		    setRotor(rotor[i],i);
		    SetOffset(i);
		    setSetting(i);
		}
	
}
@Override
public int[] letReverse(int[] arr) {
	for(int i = 0; i < arr.length-2; i++)
	{
	 int temp = arr[i];
	 arr[i] = arr[arr.length - i - 1];
	 arr[arr.length - i - 1] = temp;
	}
	return arr;
}

@Override
public int[] letForward(String letters) {
	return this.HelpLetIndex(letters);
	
}

	

}
