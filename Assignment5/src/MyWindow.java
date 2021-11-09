import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyWindow extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	int score;	///current score
	int goal = 25;	///the score needed to win the game
	public int phase;	///specify whether the challenge is passed 0=wait, 1=wrong answer, 2=playing, 3=pass
	Words known;	
	LeftPanel left;
	RightPanel right;
	int no;
	
	public boolean correct ;

	MyWindow(){
		setLayout(null);	///initial the Frame
		setSize(1500,800);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		known = new Words("known_words");	///all known words will be saved here
		//unknown = new Words("unknown_words");	///all unknown words will be saved here
		
		no = 0; score=0;
		correct = false;
		left = new LeftPanel(this);				///initial panels
		right = new RightPanel(this);
		left.setBounds(0, 0, 500, 720);
		right.setBounds(501, 0, 1000, 800);
		this.add(left);
		this.add(right);
		
		
	}

	public void setphase(int p){	///set the status of the game
		this.phase = p;
	}
	

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		while(true){
			
			this.left.phase = this.phase;	///synchronize the phase
			
			if(this.phase==3){	///add up the point if passed
				this.score++;
				this.left.nextpic();
				this.phase = 2;	///switch the phase to 2(normal) afterwards
			}

			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();	///refresh the frame
			
			if(this.score>=this.goal) {	/// the game is finished
				if(this.goal>=50) break;	///no second continue
				int con = 0;
				con = JOptionPane.showConfirmDialog (null, "Continue?","Yes", con);	///user my chose to continue or not(for only once)
				if(con == JOptionPane.YES_OPTION) this.goal=70;	///the goal will set to the end of word list
			    else break;
			}
			
			if(no>50){		///word list expired, game over
				JOptionPane.showMessageDialog(null,"Game Over!",null,2);
				break;
			}
			
		}
	}
}
