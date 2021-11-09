import java.io.*;
import java.util.Map.Entry;

public class Game {
	public static void main(String[] args) throws IOException{
		MyWindow window = new MyWindow();	///the Frame
		window.setVisible(true);
		
		Thread thread = new Thread(window);
		thread.start();		///start the run() override by MyWindow
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {	///output the words of unknown word collected from the user
			PrintWriter p = new PrintWriter(new FileOutputStream(new File("out.txt")));
			for(Entry<String,String> entry : window.unknown.map.entrySet()){
				p.println(entry.getKey()+" "+entry.getValue());
			}
			p.flush();
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
