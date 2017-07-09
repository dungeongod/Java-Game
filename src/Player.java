
import jaco.mp3.player.MP3Player;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player extends Sprite implements GameConstants {
    ArrayList<Bullet> bulletList = new ArrayList<>();
    MP3Player fireMusic;
    private boolean isJump ;
    private int acc;
    public Player(){
        x = 122;
        w = 100;
        h = 100;
        y = 20;//FLOOR - (h-10);

        img = new ImageIcon(Player.class.getResource(PLAYER_IMG)).getImage();
    }

    public void fire(){
        fireMusic = new MP3Player(new File("E:\\PROJECT\\Game\\Dave\\src\\fire.mp3"));
        fireMusic.play();
        Bullet bullet = new Bullet(x + w/2, y + h /2);
        bulletList.add(bullet);



    }


    public void drawPlayer(Graphics g){
        g.drawImage(img, x, y, w, h, null);
    }
    public void move(){


    }

    public void jump(){
       // if(!isJump){
            acc = -10;
           if(y>0)
            y = y + acc;

            isJump = true;
        //}
    }
    public void fall(){
        if(y<(FLOOR - (h-22))){
            acc = acc + GRAVITY;
            y = y + acc;
        }
        if(y>=(FLOOR - (h-22))){
            isJump = false;
        }
    }
}