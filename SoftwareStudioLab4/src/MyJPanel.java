
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class MyJPanel extends JPanel implements MouseMotionListener{
	
	private Square square = new Square(100);
	int centerX;
	int centerY;
	
	public MyJPanel(){
		addMouseMotionListener(this);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawRect(centerX, centerY, square.getShapeWidth(), square.getShapeHeight());
		// TODO Draw square and fill it with random color decided by method getRandomColor()
		g.setColor(square.getRandomColor());
        g.fillRect(centerX, centerY, square.getShapeWidth(), square.getShapeHeight());
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Get mouse dragged position and change suqare's position
		centerX = square.getCenterX(e.getX() );
		centerY = square.getCenterY( e.getY() );
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// No need to implement
	}
}
