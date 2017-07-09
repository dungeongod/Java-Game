
import java.io.IOException;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {

    public GameFrame() throws IOException{
        setSize(GAME_WIDTH,GAME_HEIGHT);

        Board board = new Board();
        add(board);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        GameFrame obj = new GameFrame();

    }

}