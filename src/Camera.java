
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Camera implements GameConstants {
    int x;
    int y;
    int h;
    int w;
    int speed;
    BufferedImage bi;

    public Camera(){
        speed = 5;
        try{
            bi = ImageIO.read(Camera.class.getResource(BACKGROUND));
        }
        catch(Exception e){
            System.out.println("Game Would n't Work Someone Delete the BackGround...");
            System.out.println("Thanks for Using");
            System.exit(0);
            //bi = ImageIO.read(Camera.class.getResource("bg2.jpg"));
            //JOptionPane.showMessageDialog(frame,"Game Would n't Work Someone Delete the BackGround...");
        }
    }

    public void left(){

            speed = -5;


    }

    public void right(){

            speed = 5;

    }

    public void move(){
        right();
        x+=speed;
    }

    public void drawBG(Graphics g){
        BufferedImage subImage = null;
        try {
            subImage = bi.getSubimage(x, y, GAME_WIDTH, GAME_HEIGHT);
        }
        catch (Exception e){
            System.out.println("Error in Camera");
        }
        System.out.println("X "+x+" Y "+y );
        g.drawImage(subImage,0,0,GAME_WIDTH,GAME_HEIGHT,null);
    }


}