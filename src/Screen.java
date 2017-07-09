import jaco.mp3.player.MP3Player;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.IOException;

public class Screen extends JWindow {

    private MP3Player mp;
    private JPanel contentPane;
    private Timer timer ;
    private JLabel lblNewLabel_1 = new JLabel("GAME - 2017");
    private JProgressBar progressBar = new JProgressBar();

    /**
     * Launch the application.g
     */
    //PlayerThread playerThread;

    /*public void music(){
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;

        try {
            BGM = new AudioStream(new FileInputStream("E:\\PROJECT\\Game\\Dave\\Akhiyan.mp3"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MGP.start(loop);
    }
*/
    public void music(){
        mp = new MP3Player(new File("E:\\PROJECT\\Game\\Dave\\src\\joker.mp3"));
        mp.play();
    }

    public static void main(String[] args) {


        Screen frame = new Screen();

        frame.setVisible(true);
        frame.doAnimation();
    }
    boolean isVisible = false;
    int color = 1;
    Color colorValue;
    int progressValue = 1;
    void doAnimation(){
       // mp.stop();
        timer = new Timer(25,(e)->{
            if(progressValue>=100){

                timer.stop();

                GameFrame ms = null;
				try {
					ms = new GameFrame();
					mp.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                ms.setVisible(true);
                Screen.this.setVisible(false);

            }
            progressBar.setValue(progressValue);
            progressValue++;
            if(isVisible){
                switch(color){
                    case 1:
                        colorValue = Color.RED;
                        break;
                    case 2:
                        colorValue = Color.GREEN;
                        break;
                    case 3:
                        colorValue = Color.YELLOW;
                        break;
                    case 4:
                        colorValue = Color.BLUE;
                        break;
                    case 5:
                        colorValue = Color.ORANGE;
                        break;
                    case 6:
                        colorValue = Color.BLACK;
                        break;
                    case 7:
                        colorValue = Color.WHITE;
                        break;
                }
                color++;
                if(color>=7){
                    color = 1;
                }
                lblNewLabel_1.setForeground(colorValue);
            }
            lblNewLabel_1.setVisible(isVisible);
            isVisible = !isVisible;
        });
        timer.start();
    }

    /**
     * Create the frame.
     */
    public Screen() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 398);
        contentPane = new JPanel();
        setLocationRelativeTo(null);
      //  layeredPane.add(contentPane, new Integer(3), 0);
        contentPane.setBackground(new Color(102, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        music();
        
        
                lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
                lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_1.setBounds(115, 209, 276, 35);
                contentPane.add(lblNewLabel_1);


        progressBar.setFont(new Font("Dialog", Font.BOLD, 24));
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 346, 478, 17);
        contentPane.add(progressBar);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setIcon(new ImageIcon("E:\\PROJECT\\\\Game\\Dave\\src\\main.gif"));
        lblNewLabel_2.setBounds(0, 0, 500, 398);
        contentPane.add(lblNewLabel_2);
        
       
        UIManager.put("ProgressBar.background", Color.ORANGE);
        UIManager.put("ProgressBar.foreground", Color.BLUE);
        UIManager.put("ProgressBar.selectionBackground", Color.RED);
        UIManager.put("ProgressBar.selectionForeground", Color.GREEN);
    }
}