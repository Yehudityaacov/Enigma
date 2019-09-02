package enigma;

public class Rotor extends Translator {
	
  

	int ringsettingC; 
    int OffsetB;//inner ring rotor 
   int thernover;
    int[] Rotor;
    String Alph="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int Position;
public int[] intialRotor (int type){
		if (type==1)
			return Rotor=letForward("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
		else if (type==2)
			return Rotor=letForward("AJDKSIRUXBLHWTMCQGZNPYFVOE");
		else if (type==3)
			return Rotor=letForward("BDFHJLCPRTXVZNYEIWGAKMUSQO");
	    else if (type==4)
	    	return Rotor=letForward("ESOVPZJAYQUIRHXLNFTGKDCMWB");
	    else 
	    	return Rotor=letForward("VZBRGITYUPSDNHLXAWMJQOFECK");
	    
}

public int TenrOverNnotch (int type)
{
	if (type==1)
		return thernover=17;
	else if (type==2)
		return thernover=5;
	else if (type==3)
		return thernover=22;
    else if (type==4)
    	return thernover=10;
    else 
    	return thernover=26;
	
}


public int RotorPosition  (int[] rotor , int letterA,int ringsetting,int Offset){
	 ringsettingC=ringsetting;
     OffsetB=Offset;
	int[]letterindex1=letForward(Alph);
	int temp;
	int temp1;
	int newletter;
	Position=this.CircularShifts(letterA+this.OffsetB-this.ringsettingC);
	Position=this.CircularShifts(Position);
	temp=rotor[Position-1];//wiring
	temp1=this.CircularShifts(temp-this.OffsetB+this.ringsettingC);
	newletter=letterindex1[(temp1-1)];//the new valu of the inner rotor 
	return newletter;
	}

public int reRotorPosition  (int[] rotor , int letterA,int ringsetting,int Offset){
	 ringsettingC=ringsetting; 
     OffsetB=Offset;
     int[] tempRotor=new int[rotor.length];
     tempRotor=letReverse(rotor);
	int[]letterindex1=HelpLetIndex(Alph);
	int temp;
	int temp1;
	int newletter;
	Position=this.CircularShifts(letterA+this.OffsetB-this.ringsettingC);
	Position=this.CircularShifts(Position);
	temp=tempRotor[Position-1];//wiring
	temp1=this.CircularShifts(temp-this.OffsetB+this.ringsettingC);
	newletter=letterindex1[temp1-1];//the new value of the inner rotor
	return newletter;
	}
}
