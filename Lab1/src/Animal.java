
public abstract class Animal{
		private int legnumber;
		private float distance;
		private float second;
		
		public Animal (){
			setLegNumber(0);
			setDistance(0);
			setSecond(0);
		}
		
		public Animal (int legnumber,float distance,float second){
			setLegNumber(legnumber);
			setDistance(distance);
			setSecond(second);
		}
		
		public void setLegNumber(int n){
			this.legnumber=n;
		}
		
		public int getLegnumber(){
			return legnumber;
		}
		public void setDistance(float n){
			this.distance = n;
		}
		public float getDistance(){
			return distance;
		}
		public void setSecond(float n){
			this.second = n;
		}
		public float getSecond(){
			return second;
		}
		public abstract void speak();
		
		public float speed (float distance,float second){
			return distance/second;
		}
	}