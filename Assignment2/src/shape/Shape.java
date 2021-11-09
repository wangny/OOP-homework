package shape;

public abstract class Shape implements Comparable {		///it's abstract since it won't implement some method here
	
	public abstract double getArea();
	
	public abstract String toString();
	
	public int compareTo(Shape B){
		if( this.getArea() > B.getArea() ) return 1;	/// implement compareTo to compare area through getArea
		else return 0;
	}

}

