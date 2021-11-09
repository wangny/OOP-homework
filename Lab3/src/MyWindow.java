import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener{
	private JButton[] button;
	private MyPanel pan;
	
	MyWindow(){
		button = new JButton[2];
		button[0] = new JButton("Paint");
		button[1] = new JButton("Clear");
		button[0].addActionListener(this);
		button[1].addActionListener(this);
		pan = new MyPanel();
		this.add(pan);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		this.add(button[0]);
		this.add(button[1]);
		
		
		pan.setPreferredSize(new Dimension(400,200));
		
		
	}
	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==button[0]){
			pan.setIsPaint(true);
			pan.repaint();
		}else if(a.getSource()==button[1]){
			pan.setIsPaint(false);
			pan.repaint();
		}
	}
	
}
