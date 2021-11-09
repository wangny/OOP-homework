import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	JTextField text;	///the textfield allow user type
	MyWindow window;	///for convenience
	String input;
	String[] ans = new String[10];	///the anwser that user type
	int y;	///the position y of the words
	public int enter=0;
	private File file1, file2;
	
	public LeftPanel(MyWindow my){	///the word image and the textfield part
		window = my;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,720));	///put the textfield to the buttom of the panel
		text = new JTextField();					///initial the textfield
		text.setFont(new Font(" ",Font.BOLD,18));
		text.setPreferredSize(new Dimension(500,40));
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	///get the content that user typed and split it into known and unknown part
				input = text.getText();
				ans = input.split(" ");
				text.setText("");	///clear the textfield afterwards
				enter=1;
			}
	    });
		this.add(text);
		
		Thread thread = new Thread(this);	///start the thread
		thread.start();
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.getHSBColor(100,310,100));
		
		try {
			g.drawImage(ImageIO.read(file1), 50, y, null);	///show the known word
			g.drawImage(ImageIO.read(file2), 220, y,null);	///show the unknown one
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			String str = (String)window.known.map.keySet().toArray()[window.no];	
			file1 = new File("assignment4_materials/img/known/"+str);	///get the file name of the next known word
			file2 = new File("assignment4_materials/img/unknown/"+(String)window.unknown.map.keySet().toArray()[window.no]);	///get the file name of the next unknown word
			this.y = 10;	///the initial position for the words 
			while( window.phase==0 ){
				y +=5;	/// words will fall down as time by
				if(y>650) y = 5;	/// words will return to the top if reach the buttom 
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
