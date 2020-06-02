package projectoop.gui;


import projectoop.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {

    private IGameBoard gameBoard;

    private JLabel lbBackGround;
    private JLabel lbPlayGame;
    private JLabel lbOption;
    private JLabel lbExit;
    private ImageIcon backgroundIcon;

    public Menu(GameBoard gameBoard){
        this.gameBoard=gameBoard;

        setBackground(Color.GREEN);
        setLayout(null);
        setBounds(0,0,Game.WIDTH,Game.HEIGHT);
        initComps(gameBoard.getGui());
        initBackground();


    }
    public void initComps(GUI gui){
        lbPlayGame=setLabel(300,150,"/textures/play.png");
        lbOption=setLabel(lbPlayGame.getX(),lbPlayGame.getY()+lbPlayGame.getHeight()+15,"/textures/option.png");
        lbExit=setLabel(lbOption.getX(),lbOption.getY()+lbOption.getHeight()+15,"/textures/exit.png");

        lbPlayGame.addMouseListener(mouseAdapter);
        lbOption.addMouseListener(mouseAdapter);
        lbExit.addMouseListener(mouseAdapter);

        add(lbPlayGame);
        add(lbOption);
        add(lbExit);

    }
    public void initBackground(){
        lbBackGround=new JLabel();
        lbBackGround.setBounds(0,0,Game.WIDTH,Game.HEIGHT);
        lbBackGround.setBackground(Color.BLACK);
        backgroundIcon=new ImageIcon(getClass().getResource("/textures/background.png"));
        lbBackGround.setIcon(backgroundIcon);
        add(lbBackGround);

    }
    public JLabel setLabel(int x, int y, String imgIconFile){
        JLabel label=new JLabel();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imgIconFile));
            label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
            label.setIcon(icon);
            return label;
        }
        catch (Exception e){
            System.out.println("Error");
            return null;
        }
    }


    private MouseAdapter mouseAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource()==lbExit){
                gameBoard.getGui().getGame().setRunning(false);

            }
            if(e.getSource()==lbPlayGame){
                // chuyen vao playing state
                gameBoard.getGui().getGame().setCurrentState(1);
            }
            if(e.getSource()==lbOption){
                //chuyen sang option State
                gameBoard.getGui().getGame().setCurrentState(2);
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == lbPlayGame) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/play2.png"));
                lbPlayGame.setIcon(playIcon);
            }
            if (e.getSource() == lbOption) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/option2.png"));
                lbOption.setIcon(optionIcon);
            }
            if (e.getSource() == lbExit) {
                ImageIcon exitIcon = new ImageIcon(getClass().getResource("/textures/exit2.png"));
                lbExit.setIcon(exitIcon);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == lbPlayGame) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/play.png"));
                lbPlayGame.setIcon(playIcon);
            }
            if (e.getSource() == lbOption) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/option.png"));
                lbOption.setIcon(optionIcon);
            }
            if (e.getSource() == lbExit) {
                ImageIcon exitIcon = new ImageIcon(getClass().getResource("/textures/exit.png"));
                lbExit.setIcon(exitIcon);
            }
        }
    };
}

