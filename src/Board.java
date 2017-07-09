import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import jaco.mp3.player.MP3Player;

public class Board extends JPanel implements GameConstants{
    Image bg;


    MP3Player mp3Start;
    MP3Player mp3End;
    Bullet bullet;
    Player player ;
    Enemy enemies[] = new Enemy[MAX_ENEMY];
    Camera camera = new Camera();
    public Board(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        music();

       /* try{
            File f = new File ("Akhiyan.mp3");  
            MP3Player mp3 = new MP3Player(f);
            mp3.play();
        }
        catch(Exception e){System.err.println(e);}
        */
        //bg = new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
        player = new Player();
        prepareEnemy();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    player.fire();
                }
               /* if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                        //player.setSpeed(25);
                        //player.move();
                        if(camera.x<=(3700-(GAME_WIDTH))){
                            // camera.speed = 5;
                            camera.right();

                            camera.move();
                        }
                }*/



                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(camera.x>0) {
                        //camera.speed = -5;
                        camera.left();
                        camera.move();
                    }
                    //System.out.println("Left...");
                    //player.setSpeed(-25);
                    //player.move();
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){

                    if(player.y>0) player.jump();
                }

            }
        });

        gameLoop();


    }
    public void music(){
       mp3Start = new MP3Player(new File("E:\\PROJECT\\Game\\Dave\\src\\Super.mp3"));
       mp3Start.play();
       mp3End = new MP3Player(new File("E:\\PROJECT\\Game\\Dave\\src\\SuperDeath.mp3"));


    }

    private void drawBullets(Graphics g){
        for(Bullet bullet : player.bulletList){
            if(bullet.isVisible){
                bullet.drawBullet(g);
                bullet.move();
            }
        }
    }
    public boolean isCollide(Enemy enemy){
        int distance = bullet.getX()+ bullet.getW();

        return distance==enemy.getX();
    }

    public boolean isCollision(Player player , Enemy enemy){
        int xDistance = Math.abs(player.getX() - enemy.getX());
        int yDistance = Math.abs(player.getY() - enemy.getY());
        return xDistance<=(player.getW()-30) && yDistance<=(player.getH()-20);
    }

    boolean isGameOver = false;
    public void checkCollision(){
        for(Enemy enemy: enemies){
            //boolean result = isCollision(player, enemy);
            //if(result == true){
            if(isCollision(player, enemy)){
                isGameOver = true;
                player.y = FLOOR;
                repaint();
                //timer.stop();
            }
            else if(player.y>= (FLOOR - 80)){
                isGameOver = true;
                repaint();

                mp3Start.stop();
                mp3End.play();
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } timer.stop();


            }
        }
    }



    public void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("Game Over", GAME_WIDTH/2, GAME_HEIGHT/2);
    }

    private void prepareEnemy(){
        Image enemy;
        int speed = 5;
        int x = 350;
        int y = 60;
        for(int  i= 0; i<MAX_ENEMY; i++){
            if(i%2==0){
                enemy = new ImageIcon(Board.class.getResource("spider.gif")).getImage();

            }
            else
            {
                enemy = new ImageIcon(Board.class.getResource("fire.gif")).getImage();

            }

            enemies[i] = new Enemy(y, x, enemy, speed);
            x += 350;
            y += 250;
        }
    }

    Timer timer;
    private void gameLoop(){
        timer  = new Timer(DELAY, (ActionEvent e) ->{
             repaint();
             player.fall();
            checkCollision();

        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        camera.drawBG(g);
        player.move();
        camera.move();
        //drawBackGround(g);
        if(isGameOver){
            gameOver(g);
        }
        player.drawPlayer(g);
        drawEnemy(g);
        drawBullets(g);

    }

//	private void drawBackGround(Graphics g){
//		g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
//	}

    private void drawEnemy(Graphics g){
        for(Enemy enemy : enemies){
            //if (!isCollide(enemy)) {
                enemy.drawEnemy(g);
            //}
        }
    }
}