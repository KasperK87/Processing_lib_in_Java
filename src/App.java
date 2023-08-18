import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class App extends PApplet{

    //globale variabler 

    //liste over alle punkter vores slange optager
    ArrayList<PVector> longSnake;

    //bestemmer hvor lang vores slange skal være,
    //før vi sletter den ældste del af slangen.
    int snakeSize;

    //bestemmer hvilken retning slangen bevæger sig
    PVector dir;

    //slange mad
    PVector food;
	
	public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		App mySketch = new App();
		PApplet.runSketch(processingArgs, mySketch);
	}

    public void settings(){
        size(190, 190);
    }

    public void setup(){
        frameRate(4);
        
        snakeSize = 2;
  
        //vi tilføjer den første del af vores slange
        longSnake = new ArrayList<PVector>();
        longSnake.add(new PVector(9*10, 9*10));
        
        //vi finder et tilfældig sted at ligge noget
        //mad til vores slange
        food = new PVector((int)random(0,18)*10, 
            (int)random(0,18)*10);
            
        dir = new PVector(0, 0);
    }

    public void draw(){
        background(0);
  
        //tegner maden
        rect(food.x, food.y, 10, 10);
        
        //har tilføjer vi et extra segment af vores slange,
        //i den retning vi bevæger os i
        longSnake.add(new PVector(
          longSnake.get(longSnake.size()-1).x + dir.x*10, 
          longSnake.get(longSnake.size()-1).y + dir.y*10));
        
        //går igennem vært segment af vores slange
        //og tegner den.
        for(int i = longSnake.size()-1; i >= 0; i--){
          rect(longSnake.get(i).x, longSnake.get(i).y,10,10);
          
          //kollision detection for vores slange,
          //her tjekker vi om hovedt at vores slange
          //rammer sig selv
          if (longSnake.get(longSnake.size()-1).x == longSnake.get(i).x &&
                longSnake.get(longSnake.size()-1).y == longSnake.get(i).y &&
                i < longSnake.size()-1){
            
            //vi fjerner alle dele af vores slange,
            //og sætter den tilbage til sin start 
            //position
            longSnake = new ArrayList<PVector>();
            longSnake.add(new PVector(9*10, 9*10));
            snakeSize = 2;
            //break kan vi bruge til at breake ud af
            //vores for-loop, uden at gøre det færdigt
            break;
      
            }
        }

        //kollision detection for vores mad.
        //her tjekker vi om slangens hoved er det
        //samme sted som maden
        if (food.x == longSnake.get(longSnake.size()-1).x &&
            food.y == longSnake.get(longSnake.size()-1).y){

            //vi flytter vores med et nyt sted
            food = new PVector((int)random(0,18)*10, 
            (int)random(0,18)*10);

            snakeSize++;
        }

        //vi fjerner den ældste del
        //af vores slange, så det ser ud som om
        //den bevægersig
        if (longSnake.size() >= snakeSize){
            longSnake.remove(0);
        }
    }

        //læser keyboarded, og sætter retningen for
    //vores slange
    public void keyPressed(){
    if (key == CODED) {
      //"dir.y != 1" vi forhinder slangen i at
      //gå bæglens
      if (keyCode == UP && dir.y != 1) {
        dir.y = -1;
        dir.x = 0;
      } else if (keyCode == DOWN && dir.y != -1){
        dir.y = 1;
        dir.x = 0;
      } else if (keyCode == LEFT && dir.x != 1){
        dir.x = -1;
        dir.y = 0;
      } else if (keyCode == RIGHT && dir.x != -1){
        dir.x = 1;
        dir.y = 0;
      }
    }
    }
}