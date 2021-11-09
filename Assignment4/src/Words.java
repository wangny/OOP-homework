import java.io.*;
import java.util.*;

public class Words {	///the class to collect all known or unknown words in a Hashmap
	private String file;
	public HashMap<String, String> map;
	
	Words(String f){
		map = new HashMap<String, String>();
		file = f;
		this.read();
	}
	
	private void read(){
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new FileInputStream(new File("assignment4_materials/"+file+".txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (fileScan.hasNext())	///save the file name of the word as key and the content as value
		{
			
			String k = fileScan.next();
			String v;
			if(file.equals("known_words")) v = fileScan.next();
			else v = null;	//value would be null for unknown words
			map.put(k, v);
		}
	}
}
