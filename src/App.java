import myClasses.MyObject;
import processing.core.PApplet;


public class App extends PApplet{

    int red = color(0, 255, 0);

    MyObject obj;
	
	public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		App mySketch = new App();
		PApplet.runSketch(processingArgs, mySketch);
	}

    public void settings(){
        size(500, 500);
    }

    public void setup(){
        frameRate(60);
        rectMode(CENTER);

        obj = new MyObject(this, 0, 0, -100, 100, red);
    }

    public void draw(){
        background(0);
        
        obj.draw();

        translate(mouseX, mouseY);
        //rotate(radians(frameCount*10));
        
        fill(red);
        rect(0, 0, 200, 100); 
        
        // code for house
        fill(255);
        rect(0, 0, 100, 100);
        triangle(-50, -50, 50, -50, 0, -100);
        rect(0, 50, 20, 50);
        rect(0, -50, 20, 50);
        rect(50, 0, 20, 100);
        //rect(-50, 0, 20, 100);
    }

    
}