import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	MyWindow window;	///for convenience
	String input;
	JLabel label;
	int no;
	int phase; ///0=waiting, 1=wrong answer, 2=playing
	int y;	///the position y of the words
	
	private File file1;
	
	public LeftPanel(MyWindow my){	///the word image 
		window = my;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,400));	///add the label for showing message
		label = new JLabel("Waiting...");
		label.setFont(new Font(" ",Font.BOLD,18));
		add(label);
		phase=0;
		no=0;
		
		Thread thread = new Thread(this);	///start the thread
		thread.start();
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.getHSBColor(100,310,100));
		
		try {
				if(phase>=2)g.drawImage(ImageIO.read(file1), 50, y, null);	///show the known word
			//g.drawImage(ImageIO.read(file2), 220, y,null);	///show the unknown one
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void nextpic(){
		this.no++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			String str = (String)window.known.map.keySet().toArray()[no];	
			file1 = new File("assignment4_materials/img/known/"+str);	///get the file name of the next known word
			//file2 = new File("assignment4_materials/img/unknown/"+(String)window.unknown.map.keySet().toArray()[window.no]);	///get the file name of the next unknown word
			this.no = window.score;
			
			if(phase==0){	///show waiting if for phase 0
				label.setText("Waiting...");
				label.setVisible(true);	///set visualization to show the label
			}else if(phase==1){
				label.setText("Wrong Answer, please re-enter...");	
				label.setVisible(true);		
			}else{
				
				label.setVisible(false);	///unshow the label
				
				this.y = 10;	///the initial position for the words 
				while( phase==2 ){
					
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
}
