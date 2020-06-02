package projectoop.gui;


import projectoop.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlay extends JPanel implements ActionListener {
    private IGameBoard gameBoard;
    private JLabel lbBackGround;
    private ImageIcon backgroundIcon;
    private JButton btnOk;

    public HowToPlay(GameBoard gameBoard){
        this.gameBoard=gameBoard;
        setBackground(Color.GREEN);
        setBounds(0,0,Game.WIDTH,Game.HEIGHT);
        setLayout(null);
        initComps();

    }
    public void initComps(){

        btnOk=new JButton();
        btnOk.setText("OK");
        btnOk.setBounds(350,560,100,50);
        btnOk.addActionListener(this);
        add(btnOk);

        lbBackGround=new JLabel();
        lbBackGround.setBounds(0,0, Game.WIDTH,Game.HEIGHT);
        lbBackGround.setBackground(Color.BLACK);
        backgroundIcon=new ImageIcon(getClass().getResource("/textures/background_option.png"));
        lbBackGround.setIcon(backgroundIcon);

        add(lbBackGround);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnOk){
            //set ve menu
            gameBoard.getGui().getGame().setCurrentState(0);
        }
    }
}
