package de.farbtrommel.yagt.test;

import processing.core.*;

public class ProcessingTest extends PApplet{

	public void setup() {
		  size(640, 360);
	}

	public void draw() {
	  background(102);
	  
	  pushMatrix();
	  translate((float)(width*0.2), (float)(height*0.5));
	  rotate((float)(frameCount / 200.0));
	  polygon(0, 0, 82, 6); 
	  popMatrix();
	  
	  pushMatrix();
	  translate((float)(width*0.5), (float)(height*0.5));
	  rotate((float)(frameCount / 50.0));
	  polygon(0, 0, 80, 20); 
	  popMatrix();
	  
	  pushMatrix();
	  translate((float)(width*0.8), (float)(height*0.5));
	  rotate((float)(frameCount / -100.0));
	  polygon(0, 0, 70, 7); 
	  popMatrix();
	}

	public void polygon(float x, float y, float radius, int npoints) {
	  float angle = TWO_PI / npoints;
	  beginShape();
	  for (float a = 0; a < TWO_PI; a += angle) {
	    float sx = x + cos(a) * radius;
	    float sy = y + sin(a) * radius;
	    vertex(sx, sy);
	  }
	  endShape(CLOSE);
	}

}
