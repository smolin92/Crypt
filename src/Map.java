//************************************************
//Map.java
//
//Creates a new alphabet based on given keyword 
//for encryption and decryption.
//
//by Stefanie Molin
//November 19, 2011
//************************************************
import java.util.ArrayList;

public class Map {
	private String keyword;
	public final static String[] alphabet={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	public final static int ALPHABET_SIZE=26;
	private String[] map;
	public char [] charMap;
	
	public Map(String word){
		keyword=word;
		map=new String[ALPHABET_SIZE];
		ArrayList<String> m=new ArrayList<String>();
		for(int i=0;i<keyword.length();i++){
			m.add(i,keyword.substring(i,i+1));
		}//adds the keyword to an array list
		for(int i=0; i<m.size()-1; i++){
			for(int j=i+1; j<m.size(); j++){
				if(m.get(i).equals(m.get(j))){
					m.remove(j);
				}
			}
		}//removes the repeating letters of the keyword.

		for(int i=0; i<m.size(); i++){
			map[i]=m.get(i);
		}//adds the non-repeating letters of the keyword to an array.
		
		int k=0;
		for(int i=25; i>-1; i--){
			int unique=0;
			for(int j=0; j<m.size(); j++){
				if(alphabet[i].equals(m.get(j))){
					unique++;
				}
			}
			if(unique==0){
				String letter=alphabet[i];
				int index=m.size()+k;
				map[index]=letter;
				k++;
			}
		}//makes sure not to add the letters of the alphabet already in the keyword and adds them backwards
		charMap=new char[26];
		for(int i=0; i<map.length; i++){
			charMap[i]=map[i].charAt(0);
		}//fills charMap with the new coding alphabet.
	}
}
