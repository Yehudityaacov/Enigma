package enigma;
///SUBMITION NAME : YEHUDIT YAACOV ID:016003659
import java.util.Scanner;
//all the Enigma rotation is from  PLUGBOARD then rotor's R-M-L REFLACTOR then L-M-R and back to PLUGBOARD 
public class Main {
	
	
	public static void main(String[] args) {
		Translator sub= new Translator();
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter the Number of  pairs to pluge (up to 10): ");//Plugboard
		 while (!scanner.hasNextInt()) {
		        System.out.println("That's not a number!");
		        scanner.next(); 
		    }
		  int numOfPlug = scanner.nextInt();
		  while (numOfPlug>10) {
		        System.out.println("That's not lass the 10 !");
		        numOfPlug= scanner.nextInt(); 
		    }
		  String toPlug;
		if(numOfPlug!=0){
			System.out.println("Enter "+numOfPlug+" pairs of latter to pluge (put a spece between ech pair): ");//Plugboard
			while (!scanner.hasNext()) {
			    System.out.println("That's not upper letter!");
			    scanner.next();
			}
			 toPlug = scanner.nextLine();
		}
		else 
			numOfPlug=0;
		    toPlug=" ";
		
		System.out.println("Enter the  3- Rotor in R-M-L (in numbers): ");
	    int[] rotor = new int[3];
	    int chack=0;
	    for (int i = 0; i < rotor.length; i++)
	    {
	    	scanner.nextLine();
	        System.out.println("Enter rotor "+(i+1));
	        while (!scanner.hasNextInt()) {
		        System.out.println("That's not a number!");
		        scanner.next();
	        }
	        chack=scanner.nextInt();
	        while (!(chack<=5&chack>=1)) {
		        System.out.println("That's  not 1-5 !");
		        chack=scanner.nextInt();
		        //scanner.next();
		    }
	        rotor[i] = chack;
	        
	    }
	    scanner.nextLine();
	    System.out.println("Enter the Ring setting a 3- letter:  (IN UPERCASE String (example SIX))");//need to check if it uppercase letter
	    while (scanner.hasNextInt()) {
	        System.out.println("That's not astring try agen upper case!");
	        scanner.next();
        }
	    String toSett_in = scanner.nextLine();//S-I-X
		int[] settings=sub.StringReverse(sub.HelpLetIndex(toSett_in));
		
		System.out.println("Enter the First 3- letter in the Incrypt Massege: (IN UPERCASE String (example CON) )");//need to check if it uppercase letter
		 while (scanner.hasNextInt()) {
		        System.out.println("That's not a string try agen upper case!");
		        scanner.next();
	        }
		String toOff_in = scanner.nextLine();//C-O-N
		int[] offsets=sub.StringReverse(sub.HelpLetIndex(toOff_in));
		
		System.out.println("Enter the Secend 3- letter in the Incrypt Massege: (IN UPERCASE String (example MLD))");//MLD
		 while (scanner.hasNextInt()) {
		        System.out.println("That's not a string try agen upper case!");
		        scanner.next();
	        }
		String toIncrypt = scanner.nextLine();// need to put in the machine and his output is the new offset ring
		
		System.out.println("Enter the reste of the Incrypt Massege (IN UPERCASE String (example SIXMLDCONTR..)): ");
		 while (scanner.hasNextInt()) {
		        System.out.println("That's not a string try agen upper case!");
		        scanner.next();
	        }
		String MassegeToDecrypt = scanner.nextLine();
		System.out.println("do yo whant to chack preformence (y\n) ");
		String a = scanner.nextLine();
		if(a.equals("n")||a.equals("N")){
			///È****INITIALZING THE ENIGMA-getting the real offset ring******//////////
			Enigma em=new Enigma(rotor,offsets,settings, toIncrypt, toPlug ,numOfPlug);
			char[] massege =new char[toIncrypt.length()];
			massege=em.process();
			String newStringmassege=new String(massege);//the new massage == new offset
			int[] newOffset=em.letForward(newStringmassege);
			newOffset=em.letReverse(newOffset);
			
			/////*******THE MASSEGE INCRYPTION******////////////
			Enigma em2=new Enigma(rotor,newOffset,settings, MassegeToDecrypt, toPlug,numOfPlug );
			char[] massege2 =new char[ MassegeToDecrypt.length()];
			massege2=em2.process();
			for(int j=0;j<massege2.length;j++)
			 System.out.print(massege2[j]);
		}
		else if(a.equals("y")||a.equals("Y")){
	
		for(int i=0; i<1000;i++){
		///È****INITIALZING THE ENIGMA-getting the real offset ring******//////////
		Enigma em=new Enigma(rotor,offsets,settings, toIncrypt, toPlug ,numOfPlug);
		char[] massege =new char[toIncrypt.length()];
		massege=em.process();
		String newStringmassege=new String(massege);//the new massage == new offset
		int[] newOffset=em.letForward(newStringmassege);
		newOffset=em.letReverse(newOffset);
		
		/////*******THE MASSEGE INCRYPTION******////////////
		Enigma em2=new Enigma(rotor,newOffset,settings, MassegeToDecrypt, toPlug,numOfPlug );
		char[] massege2 =new char[ MassegeToDecrypt.length()];
		massege2=em2.process();
		for(int j=0;j<massege2.length;j++)
		 System.out.print(massege2[j]);
		}
		}
		
		
	
		
		
		
		
		
		
	}
}


