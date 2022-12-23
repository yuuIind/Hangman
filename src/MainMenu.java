import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    JFrame frame;
    JButton playButton;
    JButton exitButton;
    MainMenu(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setTitle("CSE-212 Term Project - Hangman Game");
        ImageIcon frameLogo = new ImageIcon(getClass().getResource("./images./head.png"));
        frame.setIconImage(frameLogo.getImage());
        frame.getContentPane().setBackground(new Color(50,50,50));

        //<-----------------------------------------Title Label-------------------------------------------------------->
        JLabel title = new JLabel();
        title.setText("Hangman");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(new Color(241, 255, 250));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(title,BorderLayout.NORTH);
        //<-----------------------------------------Title Label-------------------------------------------------------->

        //<-----------------------------------------Center Panel------------------------------------------------------->
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setOpaque(false);

        JLabel gameTitle = new JLabel();
        gameTitle.setText("Hang on There!");
        gameTitle.setFont(new Font("Arial", Font.BOLD, 16));
        gameTitle.setForeground(new Color(241, 255, 250));
        gameTitle.setIcon(frameLogo);
        gameTitle.setHorizontalTextPosition(JLabel.RIGHT);
        gameTitle.setVerticalTextPosition(JLabel.TOP);
        gameTitle.setIconTextGap(15);
        gameTitle.setBounds(300,100,400,100);
        centerPanel.add(gameTitle);

        playButton = new JButton();
        playButton.setBounds(275,250,250,75);
        playButton.setText("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 16));
        playButton.setBackground(new Color(241, 255, 250));
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        centerPanel.add(playButton);

        exitButton = new JButton();
        exitButton.setBounds(275,350,250,75);
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setBackground(new Color(241, 255, 250));
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        centerPanel.add(exitButton);

        frame.add(centerPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitButton){
            System.exit(0);
        }
        else if(e.getSource() == playButton){
            new Game();
            frame.dispose();
        }

    }
}
