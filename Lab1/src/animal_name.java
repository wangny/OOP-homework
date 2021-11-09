
public class animal_name extends Animal {
	
	String name = new String();
	
	public animal_name(){
		
	}

	public animal_name(String str){
		this.name = str;
	}

	public void speak(){
		System.out.println("My name is "+name);
		int legn = this.getLegnumber();
		System.out.println("I have "+ legn +" legs.");
		float dis = this.getDistance();
		float sec = this.getSecond();
		float spe = this.speed(dis, sec);
		System.out.println("I can in "+spe+" m/s speed.");
	}
}
