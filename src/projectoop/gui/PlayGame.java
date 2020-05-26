package projectoop.gui;


import projectoop.Board;
import projectoop.Game;
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
        setBounds(0,0,Game.WIDTH,Game.HEIGHT);
        //setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        //setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        //setMinimumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
        setBackground(Color.WHITE);
        setLayout(null);
        setFocusable(true);
        addKeyListener(input);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        board.update();
        board.render(g2d);
    }
}
