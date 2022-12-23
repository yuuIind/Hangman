import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Game {
    ArrayList<Question> questionList = new ArrayList<>();
    ArrayList<JTextField> textBoxList = new ArrayList<>();
    JFrame gamePage;
    JPanel keyboardPanel;
    JPanel answerPanel;
    JLabel countdownTimerLabel;
    JLabel tipLabel;
    JLabel notInStringLabel;
    JLabel gameStatusLabel;
    JLabel poleLabel;
    JLabel headLabel;
    JLabel torsoLabel;
    JLabel leftArmLabel;
    JLabel rightArmLabel;
    JLabel leftLegLabel;
    JLabel rightLegLabel;
    private int emptyCase;
    private int limbs;

    private int countdownValue;
    private int question;

    Timer countdownTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getCountdownValue() <= 0){
                gameStateController();
            }
            else {
                setCountdownValue(getCountdownValue() - 1);
                countdownTimerLabel.setText(getCountdownValue() + "s");
            }
        }
    });


    Game(){
        String questionFile = String.valueOf(getClass().getClassLoader().getResource("./data./questions.csv"));
        System.out.println(questionFile);
        questionList.add(new Question(
                "Bruce Willis's Space Movie","I U X T S J","ARMAGEDDON", 10));
        questionList.add(new Question(
                "Benim Adım","M U T E D F","HAKAN", 10));
        question = new Random().nextInt(2);
        emptyCase = questionList.get(question).getKey().length();
        limbs = 0;
        setGamePage();
    }

    public void gameStateController(){
        if (limbs == 6){
            countdownTimer.stop();
            setGameStatusLabel(-1);
            int saveResponse = JOptionPane.showConfirmDialog(gamePage,
                    "OH NO!\nYou've lost!\nGood luck next time.\nWould you like save your score?",
                    "You've lost!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            saveRecord(saveResponse);
        }
        else if (emptyCase <= 0){
            countdownTimer.stop();
            setGameStatusLabel(1);
            int saveResponse = JOptionPane.showConfirmDialog(gamePage,
                    "Congrats!\nYou have won!\nWould you like save your score?",
                    "You've won!", JOptionPane.YES_NO_OPTION,  JOptionPane.PLAIN_MESSAGE);
            saveRecord(saveResponse);
        }
        else if (getCountdownValue() <= 0){
            countdownTimer.stop();
            setGameStatusLabel(-1);
            int saveResponse = JOptionPane.showConfirmDialog(gamePage,
                    "Time out!\nHow unfortunate!\nYou were quite close\nWould you like save your score?",
                    "You've lost!", JOptionPane.YES_NO_OPTION,  JOptionPane.PLAIN_MESSAGE);
            saveRecord(saveResponse);
        }
    }
    public void setGamePage(){
        setCountdownValue(questionList.get(question).getCdTime());
        gamePageInit();
        textBoxList.clear();
        setAnswerTextBoxes(questionList.get(question).getKey().length(), textBoxList);
        setTipLabel(question);
        setNotInStringLabel(question);
        setCountdownTimerLabel(question);
        setGameStatusLabel(0);
        countdownTimer.start();
        gamePage.setVisible(true);
    }

    public void saveRecord(int response){
        if(response == 0){
            String name = JOptionPane.showInputDialog(gamePage,
                    "Enter your name, please.",
                    null,
                    JOptionPane.PLAIN_MESSAGE);

        }
    }

    public int getCountdownValue() {
        return countdownValue;
    }

    public void setCountdownValue(int countdownValue) {
        this.countdownValue = countdownValue;
    }

    private void setTipLabel(int index){
        tipLabel.setText(questionList.get(index).getTip().toUpperCase(Locale.ENGLISH));
    }
    private void setNotInStringLabel(int index){
        notInStringLabel.setText(questionList.get(index).getNotInLetters().toUpperCase(Locale.ENGLISH));
    }

    private void setCountdownTimerLabel(int index){
        countdownTimerLabel.setText(String.valueOf(questionList.get(index).getCdTime()));
    }
    private void setGameStatusLabel(int state){
        if (state > 0){
            gameStatusLabel.setText("You WON!");
            gameStatusLabel.setForeground(new Color(12, 245, 116));
        }
        else if (state < 0){
            gameStatusLabel.setText("You LOSE!");
            gameStatusLabel.setForeground(new Color(208, 0, 0));
        }
        else {
            gameStatusLabel.setText("In Progress");
            gameStatusLabel.setForeground(new Color(47, 151, 193));
        }
    }

    public void correctGuess(String s){
        String key = questionList.get(question).getKey().toLowerCase();
        for(int i = 0; i < key.length(); i++){
            if(String.valueOf(key.charAt(i)).equals(s)){
                emptyCase--;
                textBoxList.get(i).setText(s.toUpperCase(Locale.ENGLISH));
            }
        }
        gameStateController();
    }
    public void wrongGuess(){
        switch (limbs){
            case 0:
                headLabel.setVisible(true);
                limbs++;
                break;
            case 1:
                torsoLabel.setVisible(true);
                limbs++;
                break;
            case 2:
                leftArmLabel.setVisible(true);
                limbs++;
                break;
            case 3:
                rightArmLabel.setVisible(true);
                limbs++;
                break;
            case 4:
                leftLegLabel.setVisible(true);
                limbs++;
                break;
            case 5:
                limbs++;
                rightLegLabel.setVisible(true);
                gameStateController();
                break;
        }
    }

    private void setAnswerTextBoxes(int len, ArrayList<JTextField> textFieldArrayList){
        for (int i = 0; i < len; i++) {
            JTextField answer = new JTextField();
            answer.setFont(new Font("Arial", Font.BOLD, 16));
            answer.setPreferredSize(new Dimension(25, 25));
            answer.setHorizontalAlignment(JTextField.CENTER);
            answer.setText("W");
            answer.setFocusable(false);
            answer.setEditable(false);
            answer.setBackground(new Color(221, 196, 221));
            textFieldArrayList.add(answer);
            answerPanel.add(answer);
        }
    }

    public void setPoleLabel() {
        poleLabel = new JLabel();
        ImageIcon poleIcon = new ImageIcon(getClass().getResource("/images/pole.png"));
        poleLabel.setIcon(poleIcon);
        poleLabel.setBounds(600,100,230,270);
        gamePage.add(poleLabel);
    }

    public void setHeadLabel() {
        headLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/head.png"));
        headLabel.setIcon(headIcon);
        headLabel.setBounds(700,140,62,62);
        headLabel.setVisible(false);
        gamePage.add(headLabel);
    }

    public void setTorsoLabel() {
        torsoLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/torso.png"));
        torsoLabel.setIcon(headIcon);
        torsoLabel.setBounds(700,205,63,87);
        torsoLabel.setVisible(false);
        gamePage.add(torsoLabel);
    }

    public void setLeftArmLabel() {
        leftArmLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/left-arm.png"));
        leftArmLabel.setIcon(headIcon);
        leftArmLabel.setBounds(643,205,55,17);
        leftArmLabel.setVisible(false);
        gamePage.add(leftArmLabel);
    }

    public void setRightArmLabel() {
        rightArmLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/right-arm.png"));
        rightArmLabel.setIcon(headIcon);
        rightArmLabel.setBounds(763,205,56,17);
        rightArmLabel.setVisible(false);
        gamePage.add(rightArmLabel);
    }

    public void setLeftLegLabel() {
        leftLegLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/left-leg.png"));
        leftLegLabel.setIcon(headIcon);
        leftLegLabel.setBounds(695,293,29,42);
        leftLegLabel.setVisible(false);
        gamePage.add(leftLegLabel);
    }

    public void setRightLegLabel() {
        rightLegLabel = new JLabel();
        ImageIcon headIcon = new ImageIcon(getClass().getResource("/images/right-leg.png"));
        rightLegLabel.setIcon(headIcon);
        rightLegLabel.setBounds(740,293,30,42);
        rightLegLabel.setVisible(false);
        gamePage.add(rightLegLabel);
    }

    public class KeyboardHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = ((JButton)e.getSource()).getText().toLowerCase();
            if(questionList.get(question).FrequencyOf(s) == 0){
                ((JButton) e.getSource()).setEnabled(false);
                wrongGuess();
            }
            else {
                ((JButton) e.getSource()).setEnabled(false);
                correctGuess(s);
            }
        }
    }

    public class MenuBarHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( ( (JMenuItem)e.getSource() ).getText() == "New Game"){
                gamePage.dispose();
                question = new Random().nextInt(2);
                emptyCase = questionList.get(question).getKey().length();
                limbs = 0;
                setGamePage();
            }
            else if ( ( (JMenuItem)e.getSource() ).getText() == "Reset Game" ){
                gamePage.dispose();
                emptyCase = questionList.get(question).getKey().length();
                limbs = 0;
                setGamePage();
            }
            else if ( ( (JMenuItem)e.getSource() ).getText() == "Score Table" ){
                System.out.println("Score Table");
            }
            else if ( ( (JMenuItem)e.getSource() ).getText() == "Quit" ){
                System.exit(0);
            }
            else{
                String s = "Name: Muhammet Hakan\n"
                        + "Surname: Taştan\n"
                        + "School Number: 20190701009-071\n"
                        + "email: muhammethakan.tastan@std.yeditepe.edu.tr";
                JOptionPane.showMessageDialog(gamePage, s, "About", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

    void gamePageInit(){
        //<-----------------------------------------Game Page Frame---------------------------------------------------->
        gamePage = new JFrame();
        gamePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePage.setSize(900,600);
        gamePage.setResizable(false);
        gamePage.setTitle("CSE-212 Term Project - Hangman Game");
        ImageIcon frameLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("./images./head.png")));
        gamePage.setIconImage(frameLogo.getImage());
        gamePage.getContentPane().setBackground(new Color(79, 81, 125));
        gamePage.setLayout(null);
        //<-----------------------------------------Game Page Frame---------------------------------------------------->

        //<--------------------------------------------Menu Bar-------------------------------------------------------->
        MenuBarHandler menuBarHandler = new MenuBarHandler();
        HangMenuBar menuBar = new HangMenuBar(menuBarHandler);
        gamePage.setJMenuBar(menuBar);

        //<--------------------------------------------Menu Bar-------------------------------------------------------->

        //<-------------------------------------------Tip Panel-------------------------------------------------------->
        tipLabel = new JLabel();
        tipLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tipLabel.setForeground(new Color(241, 255, 250));
        tipLabel.setBounds(10, 10, 150, 20);
        gamePage.add(tipLabel);
        //<-------------------------------------------Tip Panel-------------------------------------------------------->

        //<----------------------------------------Not in String Label------------------------------------------------->
        notInStringLabel = new JLabel();
        notInStringLabel.setFont(new Font("Arial", Font.BOLD, 16));
        notInStringLabel.setForeground(new Color(241, 255, 250));
        notInStringLabel.setBounds(10, 50, 150, 20);
        gamePage.add(notInStringLabel);
        //<----------------------------------------Not in String Label------------------------------------------------->

        //<----------------------------------------Status Label-------------------------------------------------------->
        JLabel statusInd = new JLabel("Status: ");
        statusInd.setFont(new Font("Arial", Font.BOLD, 16));
        statusInd.setForeground(new Color(241, 255, 250));
        statusInd.setBounds(10, 90, 60, 20);
        gamePage.add(statusInd);

        gameStatusLabel = new JLabel();
        gameStatusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gameStatusLabel.setBounds(70, 90, 150, 20);
        gamePage.add(gameStatusLabel);
        //<----------------------------------------Status Label-------------------------------------------------------->

        //<---------------------------------------------Timer---------------------------------------------------------->
        JLabel countdownText = new JLabel("Countdown: ");
        countdownText.setFont(new Font("Arial", Font.BOLD, 24));
        countdownText.setForeground(new Color(241, 255, 250));
        countdownText.setBounds(10, 140, 150, 20);
        gamePage.add(countdownText);

        countdownTimerLabel = new JLabel();
        countdownTimerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        countdownTimerLabel.setForeground(new Color(241, 255, 250));
        countdownTimerLabel.setBounds(160, 140, 250, 20);
        gamePage.add(countdownTimerLabel);
        //<---------------------------------------------Timer---------------------------------------------------------->

        //<-------------------------------------Answer Text Area Panel------------------------------------------------->
        answerPanel = new JPanel();
        answerPanel.setBounds(10,200,590,35);
        answerPanel.setBackground(new Color(79, 81, 125));//new Color(79, 81, 125));
        answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));
        gamePage.add(answerPanel);
        //<-------------------------------------Answer Text Area Panel------------------------------------------------->

        //<-----------------------------------------Keyboard Panel----------------------------------------------------->
        KeyboardHandler keyboardHandler = new KeyboardHandler();
        keyboardPanel = new JPanel();
        keyboardPanel.setBounds(30,300,500,200);
        keyboardPanel.setBackground(new Color(79, 81, 125));
        for (int i = 0; i < 26; i++){
            JButton key = new JButton();
            key.addActionListener(keyboardHandler);
            char letter = (char) (65 + i);
            key.setText(String.valueOf(letter));
            key.setPreferredSize(new Dimension(50,50));
            key.setFocusable(false);
            key.setBackground(new Color(221, 196, 221));
            keyboardPanel.add(key);
        }
        gamePage.add(keyboardPanel);
        //<-----------------------------------------Keyboard Panel----------------------------------------------------->

        //<-----------------------------------------Hangman Panel------------------------------------------------------>
        setPoleLabel();
        setHeadLabel();
        setTorsoLabel();
        setRightArmLabel();
        setLeftArmLabel();
        setRightLegLabel();
        setLeftLegLabel();
        //<-----------------------------------------Hangman Panel------------------------------------------------------>
        gamePage.setLocationRelativeTo(null);
    }

}
