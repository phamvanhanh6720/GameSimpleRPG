package projectoop.gui;


import projectoop.Board;
import projectoop.input.KeyBoard;

import javax.swing.*;
import java.awt.*;


public class PlayGame extends JPanel   {
    private Board board;
    private GameBoard gameBoard;
    private KeyBoard input;


    public PlayGame(GameBoard gameBoard){
        this.gameBoard=gameBoard;
        input=new KeyBoard();
        board=new Board(input);
        setBackground(Color.WHITE);
        setLayout(null);
        setFocusable(true);
        addKeyListener(input);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.update();
        board.render(g);
    }
}
