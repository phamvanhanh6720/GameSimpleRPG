package projectoop.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {
    private GUI gui;
    private GameBoard gameBoard;

    private JLabel lbBackGround;
    private JLabel lbPlayGame;
    private JLabel lbOption;
    private JLabel lbExit;
    private ImageIcon backgroundIcon;

    public Menu(GameBoard gameBoard){
        this.gameBoard=gameBoard;
        this.gui=gameBoard.getGui();
        setBackground(Color.GREEN);
        setLayout(null);
        initComps(gui);
        initBackground();

    }
    public void initComps(GUI gui){
        lbPlayGame=setLabel(300,150,"/textures/Play.png");
        lbOption=setLabel(lbPlayGame.getX(),lbPlayGame.getY()+15,"/textures/Option.png");
        lbExit=setLabel(lbOption.getX(),lbOption.getY()+15,"/textures/Exit.png");

        lbPlayGame.addMouseListener(mouseAdapter);
        lbOption.addMouseListener(mouseAdapter);
        lbExit.addMouseListener(mouseAdapter);

        add(lbPlayGame);
        add(lbOption);
        add(lbExit);

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
        ImageIcon icon=new ImageIcon(getClass().getResource(imgIconFile));
        label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
        label.setIcon(icon);
        return label;
    }


    private MouseAdapter mouseAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource()==lbExit){

            }
            if(e.getSource()==lbPlayGame){
                gameBoard.setShowPlay();
            }
            if(e.getSource()==lbOption){
                gameBoard.setShowOption();
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == lbPlayGame) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/Play2.png"));
                lbPlayGame.setIcon(playIcon);
            }
            if (e.getSource() == lbOption) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/Option2.png"));
                lbOption.setIcon(optionIcon);
            }
            if (e.getSource() == lbExit) {
                ImageIcon exitIcon = new ImageIcon(getClass().getResource("/textures/Exit2.png"));
                lbExit.setIcon(exitIcon);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == lbPlayGame) {
                ImageIcon playIcon = new ImageIcon(getClass().getResource("/textures/Play.png"));
                lbPlayGame.setIcon(playIcon);
            }
            if (e.getSource() == lbOption) {
                ImageIcon optionIcon = new ImageIcon(getClass().getResource("/textures/Option.png"));
                lbOption.setIcon(optionIcon);
            }
            if (e.getSource() == lbExit) {
                ImageIcon exitIcon = new ImageIcon(getClass().getResource("/textures/Exit.png"));
                lbExit.setIcon(exitIcon);
            }
        }
    };
}

