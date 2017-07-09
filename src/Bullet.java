
import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Sprite implements GameConstants {
    boolean isVisible;
    public Bullet(int x, int y){
        this.x = x ;
        this.y = y;
        this.speed = 10;
        this.w = this.h= 10;
        this.isVisible = true;
    }
    public void outOfScreen(){
        if(x>=GAME_WIDTH){
            isVisible = false;
        }
    }
    public void move(){
        x+=speed;
        outOfScreen();
    }
    public void drawBullet(Graphics g){

        g.setColor(Color.BLACK);
        g.fillOval(x, y, w, h);
    }
}