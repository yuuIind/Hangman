import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class HangMenuBar extends JMenuBar{
    HangMenuBar(ActionListener listener){
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem scoreTable = new JMenuItem("Score Table");
        JMenuItem quit = new JMenuItem("Quit");

        newGame.addActionListener(listener);
        resetGame.addActionListener(listener);
        scoreTable.addActionListener(listener);
        quit.addActionListener(listener);

        KeyStroke newGameKey = KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK);
        KeyStroke resetGameKey = KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK);
        KeyStroke scoreTableKey = KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK);
        KeyStroke quitKey = KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK);

        newGame.setAccelerator(newGameKey);
        resetGame.setAccelerator(resetGameKey);
        scoreTable.setAccelerator(scoreTableKey);
        quit.setAccelerator(quitKey);

        fileMenu.add(newGame);
        fileMenu.add(resetGame);
        fileMenu.add(scoreTable);
        fileMenu.add(quit);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(listener);
        helpMenu.add(about);

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
