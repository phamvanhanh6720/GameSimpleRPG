package projectoop.gui;

import projectoop.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Option extends  JPanel{

        private GUI gui;
        private GameBoard gameBoard;

        private JLabel lbBackGround;
        private JLabel lbChooseLevel;
        private JLabel lbHowToPlay;

        private ImageIcon backgroundIcon;

        public Option(GameBoard gameBoard){
            this.gameBoard=gameBoard;
            this.gui=gameBoard.getGui();

            setBackground(Color.GREEN);
            setLayout(null);
            initComps(gui);
            initBackground();

        }
        public void initComps(GUI gui){
            lbChooseLevel=setLabel(300,150,"/textures/chooselevel.png");
            lbHowToPlay=setLabel(lbChooseLevel.getX(),lbChooseLevel.getY()+lbChooseLevel.getHeight()+15,"/textures/howtoplay.png");


            lbChooseLevel.addMouseListener(mouseAdapter);
            lbHowToPlay.addMouseListener(mouseAdapter);

            add(lbChooseLevel);
            add(lbHowToPlay);

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
            ImageIcon icon=new ImageIcon(getClass().getResource(imgIconFile));
            label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
            label.setIcon(icon);
            return label;
        }


        private MouseAdapter mouseAdapter=new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if(e.getSource()==lbHowToPlay){
                    // currentState=4 : How To Play
                    gameBoard.getGame().setCurrentState(4);

                }
                if(e.getSource()==lbChooseLevel){
                    // currentState=3: Choose Level
                    gameBoard.getGame().setCurrentState(3);

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == lbChooseLevel) {
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/chooselevel2.png"));
                    lbChooseLevel.setIcon(playIcon);
                }
                if (e.getSource() == lbHowToPlay) {
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/howtoplay2.png"));
                    lbHowToPlay.setIcon(optionIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == lbChooseLevel) {
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/chooselevel.png"));
                    lbChooseLevel.setIcon(playIcon);
                }
                if (e.getSource() == lbHowToPlay) {
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/howtoplay.png"));
                    lbHowToPlay.setIcon(optionIcon);
                }
            }
        };
    }


