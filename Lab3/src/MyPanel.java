import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	boolean isPaint;
	
	MyPanel(){}
	
	public void setIsPaint(boolean b){
		this.isPaint = b;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(this.isPaint){
		
		OvalShape ova = new OvalShape(50,80);
		RectShape rec = new RectShape(50,80);
		
		g.drawOval(0,0,ova.getShapeWidth(),ova.getShapeHeight());
		g.drawRect(50, 30, rec.getShapeWidth(), rec.getShapeHeight());
		//g.drawLine(0, 0, 50, 50);
		}
	}
	
}	
