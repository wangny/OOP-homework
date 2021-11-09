import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MyWindow extends JFrame{
	private MyJPanel myJPanel;
	
	public MyWindow(){
		myJPanel = new MyJPanel();
		
		// Add JPanel to JFrame
		this.add(myJPanel);
	}
}