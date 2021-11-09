package Hanoi;

public class Hanoi{
	int N;
	Tower a;
	Tower b;
	Tower c;
	
	public void setProblem(int n){
		this.N = n;				/// the number of rings
		a = new Tower("Left");	///initial each towers
		b = new Tower("middle");
		c = new Tower("right");
		for(int i=n; i>0; i--){	/// put all rings to left tower
			a.push(i);
		}
	}
	
	public void sol(){
		this.move(this.a, this.c, this.b, this.N);
	}
	
	
	private void move(Tower a, Tower b, Tower c, int i){	///solving Hanoi by recursive
		if (i == 1)  {
			int tmp = a.pop();
	        System.out.println("Move ring "+tmp+" from "+a.name+" to "+b.name);
	        b.push(tmp);
	        return;
	    }
	    this.move(a, c, b, i-1); 
	    int tmp = a.pop();
	    System.out.println("Move ring "+tmp+" from "+a.name+" to "+b.name);
	    b.push(tmp);
	    this.move(c, b, a, i-1);
	}
}



