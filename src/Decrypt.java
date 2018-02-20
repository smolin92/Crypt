//************************************************
//Decrypt.java
//
//Decryptor using the mapped alphabet. 
//
//by Stefanie Molin
//November 19, 2011
//************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Decrypt {
	private File inFile;
	private String keyword;
	private Map m;
	private File outFile;
		
		public Decrypt(File entered, File destination, String key){
			inFile=entered;
			outFile=destination;
			keyword=key;
			m=new Map(keyword);
		}
		
		public void decryption() throws FileNotFoundException{
			int numOfWords=0;
			Scanner input=new Scanner(inFile);
			while(input.hasNext()){
				input.next();
				numOfWords++;
			}//checks the number of words in the file to create an array
			input.close();
			String[] words=new String[numOfWords];
			Scanner readFile=new Scanner(inFile);
			for(int i=0; i<numOfWords; i++){
				words[i]=readFile.next();
			}//puts the words of the file into an array
			
			String change=new String(m.charMap);//used to convert the characters to lowercase as needed
			
			for(int i=0; i<words.length; i++){
				char []letters=words[i].toCharArray();//creates a character array out of the word at the given index
				
				for(int j=0; j<letters.length; j++)
				{//checks to see what character to change it to.
					for(int b=0; b<Map.ALPHABET_SIZE; b++){
						if(letters[j]==m.charMap[b]){
							letters[j]=Map.alphabet[b].charAt(0);
							b=Map.alphabet.length;
						}//checks if the character matches the uppercase form of the index in the coded alphabet 
						//and converts it to the original alphabet preserving case and ends the for loop
						else if(letters[j]==change.toLowerCase().charAt(b)){
							letters[j]=Map.alphabet[b].toLowerCase().charAt(0);
							b=Map.alphabet.length;
						}//checks if the character matches the lowercase form of the index in the coded alphabet 
						//and converts it to the original alphabet preserving case and ends the for loop
						else{
							letters[j]=letters[j];
						}//if the letter matches no letter in the alphabet ignoring case, its character is preserved
					}
				}
				words[i]=new String(letters);//places the new word back into the same index it came from.
			}
			
			PrintWriter output=new PrintWriter(outFile);
			String wordsDecrypt;
			for(int i=0; i<words.length; i++){
				wordsDecrypt=words[i];
				output.print(wordsDecrypt);
				output.print(" ");//preserves spaces
			}//writes the decrypted file
			output.close();
		}
}
