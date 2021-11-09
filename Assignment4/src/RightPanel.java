import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
public class RightPanel extends JPanel implements Runnable{ 	/// the duck part
	private static final long serialVersionUID = 1L;
	JLabel score;	/// show the current score
	MyWindow window;
	private int direction;	/// the current direction of the duck
	private int pic_x, duck_y, duck_x;	///some variables for positions
	
	public RightPanel(MyWindow my){
		setLayout(null);	///initial this panel
		score = new JLabel();	///initial the label for score-showing
		score.setText("SCORE : "+"0");
		score.setBounds(750, 0, 250, 50);
		score.setFont(new Font(" ",Font.ITALIC,35));
		add(score);
		
		this.window = my;	/// for convenience
		direction = 1;	///initial some variables
		pic_x = 0;
		duck_y = 300;
		duck_x=0;
		Thread thread = new Thread(this);	/// start the thread
		thread.start();
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);;
		setBackground(Color.lightGray);
		try {
			g.drawImage(ImageIO.read(new File("assignment4_materials/res/h.png")),pic_x,0,1200,400,null);	/// the x of background will change according to score
			///the ball will move left during the game
			g.drawImage(ImageIO.read(new File("assignment4_materials/res/b.png")),duck_x+1000+pic_x/8*21,duck_y+30,150,120,null);
			g.drawImage(ImageIO.read(new File("assignment4_materials/res/duck.png")),300+duck_x,duck_y,200,150,null);
			///show the win icon if the goal is achieved
			if(window.score>= window.goal)g.drawImage(ImageIO.read(new File("assignment4_materials/res/win.png")),200,100,500,500,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if (this.direction == 1 && this.duck_y > 310) {	///followed the pseudo code TA provided for duck-moving
				this.direction = 0;
			} else if (this.direction == 0 && this.duck_y < 290){
				this.direction = 1;
			}
			if (direction == 1) duck_y ++;
			else if(direction == 0) duck_y --;
			
			if(window.score<=25)pic_x = 0 - window.score*8;	///the background will move according to the current score
			else duck_x = (window.score-25)*5;
			score.setText("SCORE : "+window.score);	///update the content of the label according to the current score
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
