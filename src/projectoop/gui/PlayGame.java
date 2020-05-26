package projectoop.gui;


import projectoop.Board;

import javax.swing.*;
import java.awt.*;


public class PlayGame extends JPanel   {
    private Board board;
    private GameBoard gameBoard;


    public PlayGame(GameBoard gameBoard){
        this.gameBoard=gameBoard;
        setBackground(Color.WHITE);
        setLayout(null);
        setFocusable(true);



    }


}
