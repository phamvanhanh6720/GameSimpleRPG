package projectoop.gui;

import projectoop.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseLevel extends JPanel {
    private GUI gui;
    private GameBoard gameBoard;

    private JLabel lbBackGround;
    private JLabel lbEasy;
    private JLabel lbHard;

    private ImageIcon backgroundIcon;

    public ChooseLevel(GameBoard gameBoard){
        this.gameBoard=gameBoard;
        this.gui=gameBoard.getGui();

        setBackground(Color.GREEN);
        setLayout(null);
        initComps(gui);
        initBackground();

    }
    public void initComps(GUI gui){
        lbEasy=setLabel(300,150,"/textures/easy.png");
        lbHard=setLabel(lbEasy.getX(),lbEasy.getY()+lbEasy.getHeight()+15,"/textures/hard.png");

        lbEasy.addMouseListener(mouseAdapter);
        lbHard.addMouseListener(mouseAdapter);

        add(lbEasy);
        add(lbHard);

    }
    public void initBackground(){
        lbBackGround=new JLabel();
        lbBackGround.setBounds(0,0,gui.getWidth(),gui.getHeight());
        lbBackGround.setBackground(Color.BLACK);
        backgroundIcon=new ImageIcon(getClass().getResource("/textures/background.png"));
        lbBackGround.setIcon(backgroundIcon);
        add(lbBackGround);

    }
    public JLabel setLabel(int x, int y, String imgIconFile){
        JLabel label=new JLabel();
        ImageIcon icon= new ImageIcon(getClass().getResource(imgIconFile));
        label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
        label.setIcon(icon);
        return label;
    }


    private MouseAdapter mouseAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {

            if(e.getSource()==lbEasy){
                gameBoard.getGame().setLevel(0);
                //set ve menu
                gameBoard.getGame().setCurrentState(0);
            }
            if(e.getSource()==lbHard){
                gameBoard.getGame().setLevel(1);
                // set ve menu
                gameBoard.getGame().setCurrentState(0);
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == lbEasy) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/easy2.png"));
                lbEasy.setIcon(playIcon);
            }
            if (e.getSource() == lbHard) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/hard2.png"));
                lbHard.setIcon(optionIcon);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == lbEasy) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/easy.png"));
                lbEasy.setIcon(playIcon);
            }
            if (e.getSource() == lbHard) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/hard.png"));
                lbHard.setIcon(optionIcon);
            }
        }
    };
}
