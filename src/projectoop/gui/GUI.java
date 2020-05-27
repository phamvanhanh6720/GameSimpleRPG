package projectoop.gui;

import projectoop.Game;
import projectoop.input.KeyBoard;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        gameBoard=new GameBoard(this,game);
        add(gameBoard);
        setVisible(true);


    }
    public GameBoard getGameBoard(){
        return gameBoard;
    }

}
