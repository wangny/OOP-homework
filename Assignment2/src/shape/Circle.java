package shape;

public class Circle extends Shape{
	
	public double radius;
	
	Circle(){
		this.radius = 0.0;	/// initial radius to 0
	}
	
	public double getArea(){
		return this.radius*this.radius*3.14;	///implement abstract method to get area of the shape by specific formula
	}
	
	public String toString(){
		String str = "I am a Circle and my area is ";
		str = str + String.valueOf( this.getArea());	/// combine str and the return value of getArea to a new string
		
		return str;
	}

	
}
