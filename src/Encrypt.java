//************************************************
//Encrypt.java
//
//Encryptor using the mapped alphabet. 
//
//by Stefanie Molin
//November 19, 2011
//************************************************
//import java.util.ArrayList;

import java.util.Scanner;
import java.io.*;

public class Encrypt {
	private File inFile;
	private String keyword;
	private Map m;
	private File outFile;
	
	public Encrypt(File entered, File destination, String key){
		inFile=entered;
		outFile=destination;
		keyword=key;
		m=new Map(keyword);
	}
	
	public void encryption() throws FileNotFoundException{
		int numOfWords=0;
		Scanner input=new Scanner(inFile);
		while(input.hasNext()){
			input.next();
			numOfWords++;
		}//determines how long the words array should be
		input.close();
		String[] words=new String[numOfWords];
		Scanner readFile=new Scanner(inFile);
		for(int i=0; i<numOfWords; i++){
			words[i]=readFile.next();
		}//fills the words array
		
		String change=new String(m.charMap);
		
		for(int i=0; i<words.length; i++){
			char []letters=new char[words[i].length()];
			for(int k=0; k<words[i].length(); k++){
				letters[k]=words[i].charAt(k);
			}//fills the character array with the letters of the word at the index.
			
			
			for(int j=0; j<letters.length; j++)
			{//checks to see what character to change it to.
				for(int b=0; b<Map.alphabet.length; b++){
					if(letters[j]==Map.alphabet[b].charAt(0)){
						letters[j]=m.charMap[b];
						b=Map.alphabet.length;
					}//checks if character matches capital letter of alphabet and maps it to the coded alphabet
					//ends the for loop if true
					else if(letters[j]==Map.alphabet[b].toLowerCase().charAt(0)){
						letters[j]=change.toLowerCase().charAt(b);
						b=Map.alphabet.length;
					}//checks if character matches lowercase letter of alphabet and maps it
					//ends for loop if true
					else{
						letters[j]=letters[j];
					}//preserves non-letter characters
				}
			}
			words[i]=new String(letters);//places the new word back into the same index it came from.
		}
		
		PrintWriter output=new PrintWriter(outFile);
		String wordsEncrypt;
		for(int i=0; i<words.length; i++){
			wordsEncrypt=words[i];
			output.print(wordsEncrypt);
			output.print(" ");//prints space in between the words of the file.
		}//writes the encrypted file
		output.close();
	}
}
