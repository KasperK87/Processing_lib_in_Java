package myClasses;
import processing.core.PApplet;

    public class MyObject{
        private PApplet p;

        int x;
        int y;
        int w;
        int h;
        int c;

       public MyObject(PApplet setParent, int x, int y, int w, int h, int c){
            p = setParent;

            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.c = c;
        }

        public void draw(){
            p.fill(c);
            p.rect(x, y, w, h);
        }

        public void setW(int w){
            this.w = w;
        }

        public int getW(){
            return w;
        }
    
}

