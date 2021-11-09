package visualization;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import visualization.MercatorMap;

public class Lab7 extends PApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PImage mapImage;
	MercatorMap mercatormap;
	PVector place ;
	
	
	public void setup(){
		setSize(1000,800);
		smooth();
		background(255);
		mapImage = loadImage("WorldMap.jpeg");
		mercatormap = new MercatorMap(991f,768f);
		place = mercatormap.getScreenLocation(new PVector(23.8f,120.85f));
	}
	
	public void draw(){
		image(mapImage, 0, 0);
		//fill(255);
		text("Taiwan",place.x,place.y-3);
		fill(0,0,255);
		ellipse(place.x,place.y,10,10);
	}
	
	
}
