import javax.swing.JFrame;

public class MainFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindow myWindow = new MyWindow();
		
		//1. Optional: What happens when the frame closes?
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. Size the frame
		myWindow.setSize(800, 600);
		
		//3. Show it.
		myWindow.setVisible(true);
	}

}
