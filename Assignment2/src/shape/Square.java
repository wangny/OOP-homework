package shape;

public class Square extends Shape{
	
	public double length ;
	
	Square(){
		this.length = 0.0;
	}
	
	public double getArea(){
		return this.length*this.length;		///implement abstract method to get area of the shape by specific formula
	}
	
	public String toString(){
		String str = "I am a Square and my area is ";
		str = str + String.valueOf( this.getArea());	/// combine str and the return value of getArea to a new string
		
		return str;
	}
	
}