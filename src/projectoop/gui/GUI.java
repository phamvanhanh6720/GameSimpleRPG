package projectoop.gui;

import projectoop.Game;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private GameBoard gameBoard;

    public GUI(String title){
        setTitle(title);
        setSize(Game.WIDTH,Game.HEIGHT);
        setLayout(new CardLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        gameBoard=new GameBoard(this);
        add(gameBoard);


    }

}
