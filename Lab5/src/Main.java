import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	Main(){
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				MyWindow window = new MyWindow();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setSize(300, 100);
				window.setVisible(true);
			}
		});
	}
}
