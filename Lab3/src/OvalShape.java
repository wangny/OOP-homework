
public class OvalShape implements Shape{
	private int shapeWidth;
	private int shapeHeight;
	
	OvalShape(int w, int h){
		this.shapeHeight = h;
		this.shapeWidth = w;
	}
	
	public void setShapeWidth(int i){
		this.shapeWidth = i;
	}
	public int getShapeWidth(){
		return this.shapeWidth;
	}
	public void setShapeHeight(int i){
		this.shapeHeight = i;
	}
	public int getShapeHeight(){
		return this.shapeHeight;
	}
}
