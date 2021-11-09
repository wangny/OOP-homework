import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	int score;	///current score
	int goal = 25;	///the score needed to win the game
	int phase;	///specify whether the challenge is passed
	Words known, unknown;	
	LeftPanel left;
	int no;

	MyWindow(){
		setLayout(null);	///initial the Frame
		setSize(1500,800);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		known = new Words("known_words");	///all known words will be saved here
		unknown = new Words("unknown_words");	///all unknown words will be saved here
		
		no = 0; score=0;

		left = new LeftPanel(this);				///initial panels
		RightPanel right = new RightPanel(this);
		left.setBounds(0, 0, 500, 800);
		right.setBounds(501, 0, 1000, 800);
		this.add(left);
		this.add(right);
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		while(true){
			phase = 0;	///0 means the word isn't matched yet
			if(left.enter==1){
				if(known.map.get( known.map.keySet().toArray()[no] ).equals(left.ans[0]) ){	/// if what the user key-in matches the answer 
					this.score ++; /// the score add up
					no++;
					phase = 1;	///1 means the word is matched
					if(left.ans.length>1){
						unknown.map.put((String)unknown.map.keySet().toArray()[no], left.ans[1]); /// save the unknown word the user key-in
					}
				}else{
					if(score>0)this.score --; /// the score minus one if user enter wrong answer
				}
				left.enter=0;
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
