package projectoop.gui;

import projectoop.Game;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private GameBoard gameBoard;
    private Game game;

    public GUI(String title,Game game){
        this.game=game;
        setTitle(title);
        setSize(Game.WIDTH,Game.HEIGHT);
        setLayout(new CardLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        gameBoard=new GameBoard(this,game);
        add(gameBoard);


    }

}
