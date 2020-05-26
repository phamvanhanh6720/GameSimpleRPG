package projectoop.gui;

import projectoop.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Option extends  JPanel{

        private Game game;
        private GUI gui;
        private GameBoard gameBoard;

        private JLabel lbBackGround;
        private JLabel lbChooseLevel;
        private JLabel lbHowToPlay;

        private ImageIcon backgroundIcon;

        public Option(GameBoard gameBoard){
            this.gameBoard=gameBoard;
            this.gui=gameBoard.getGui();
            this.game=gameBoard.getGame();

            setBackground(Color.GREEN);
            setLayout(null);
            initComps(gui);
            initBackground();

        }
        public void initComps(GUI gui){
            lbChooseLevel=setLabel(300,150,"/textures/Play.png");
            lbHowToPlay=setLabel(lbChooseLevel.getX(),lbChooseLevel.getY()+15,"/textures/Option.png");


            lbChooseLevel.addMouseListener(mouseAdapter);
            lbHowToPlay.addMouseListener(mouseAdapter);

            add(lbChooseLevel);
            add(lbHowToPlay);

        }
        public void initBackground(){
            lbBackGround=new JLabel();
            lbBackGround.setBounds(0,0,gui.getWidth(),gui.getHeight());
            lbBackGround.setBackground(Color.BLACK);
            backgroundIcon=new ImageIcon(getClass().getResource("/textures/background.png"));
            lbBackGround.setIcon(backgroundIcon);

        }
        public JLabel setLabel(int x, int y, String imgIconFile){
            JLabel label=new JLabel();
            ImageIcon icon=new ImageIcon(imgIconFile);
            label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
            label.setIcon(icon);
            return label;
        }


        private MouseAdapter mouseAdapter=new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if(e.getSource()==lbHowToPlay){
                    gameBoard.setShowHowToPlay();
                }
                if(e.getSource()==lbChooseLevel){
                    gameBoard.setShowChoseLevel();
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == lbChooseLevel) {
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/Play2.png"));
                    lbChooseLevel.setIcon(playIcon);
                }
                if (e.getSource() == lbHowToPlay) {
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/Option2.png"));
                    lbHowToPlay.setIcon(optionIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == lbChooseLevel) {
                    ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/Play.png"));
                    lbChooseLevel.setIcon(playIcon);
                }
                if (e.getSource() == lbHowToPlay) {
                    ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/Option.png"));
                    lbHowToPlay.setIcon(optionIcon);
                }
            }
        };
    }


