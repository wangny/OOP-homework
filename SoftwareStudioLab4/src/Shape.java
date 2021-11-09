import java.awt.Color;

public abstract class Shape {

	public abstract int getCenterX(int mouseX);
	public abstract int getCenterY(int mouseY);
	public abstract int getShapeHeight();
	public abstract int getShapeWidth();
	public abstract Color getRandomColor();
}