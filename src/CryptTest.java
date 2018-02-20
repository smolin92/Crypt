//************************************************
//CryptTest.java
//
//Encrypts or decrypts a file and creates a new file
//for the result.
//
//by Stefanie Molin
//November 19, 2011
//************************************************
import java.io.*;


public class CryptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try{
			File inFile=new File(args[2]);
			File outFile=new File(args[3]);
			
			if(!args[1].substring(0,2).equalsIgnoreCase("-k")){
				System.out.println("Please enter a keyword as follows:");
				System.out.println("for the keyword DOG, enter -kDOG");
			}//makes sure keywords are entered in the correct format
			
			String kword=args[1];
			int i=kword.length();
			String keyword=kword.substring(2,i).toUpperCase();
			//makes sure the keyword is in all caps and removes the -k part.

			if(args[0].equalsIgnoreCase("-e")){
				Encrypt e=new Encrypt(inFile, outFile, keyword);
				e.encryption();
			}
			else if(args[0].equalsIgnoreCase("-d")){
				Decrypt d=new Decrypt(inFile,outFile, keyword);
				d.decryption();
			}
			else{
				System.out.println("Please decide whether you want to encrypt(-e) or decrypt(-d)");
			}//makes sure encryption or decryption are entered and in the right format	
		}
		catch(IOException e){
			System.out.println("Please try again with the correct input file name.");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Please enter 4 command line arguments.");
			System.out.println("For example, to encrypt with the keyword DOG the file input into the file output, enter:");
			System.out.println("-e -kDOG input.txt output.txt");
			System.out.println("\nTo decrypt replace the -e with -d");
		}
	}
}