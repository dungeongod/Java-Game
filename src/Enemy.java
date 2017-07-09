
import java.awt.Graphics;
import java.awt.Image;

////

public class Enemy extends Sprite implements GameConstants{
    boolean isVisible =true;
    public Enemy(int y,int x , Image img, int s){
        this.y = y;
        h = w = 60;
        this.x = x;
        this.img = img;
        speed=s;

        Camera camera;
    }

    public void drawEnemy(Graphics g){
           //for(int i=0;i<10;i++) {
                if(isVisible) {
                    g.drawImage(img, x, y, w, h, null);
                }
                    /*if(f == 1){
                x = x - speed;
                System.out.println(f);
            }*/
                move();

                changeDirection();

                //System.out.println(i);
            //}
    }

    public void move(){

        //y+=speed;
        x = x - speed;
    }
    public void changeDirection(){
        if(y>=(FLOOR-h)){
            speed = speed*(-1);
        }
        else{
            if(y<=0)
            speed = speed*(-1);
        }
    }
}