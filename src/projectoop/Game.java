package projectoop;

import projectoop.gui.Display;
import projectoop.gui.GUI;
import projectoop.gui.GameBoard;
import projectoop.input.KeyBoard;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private String title;
    public static final int WIDTH=800;
    public static final int HEIGHT=640;
    private int level=0;
    private Display display;
    private KeyBoard input;
    private GameBoard gameBoard;
    private GUI gui;
    /*
    currentState=0: Menu Game
    currentState=1: PlayingState (PlayGame)
    currentState=2: Option
    currentState=3: Choose Level
    currentState=4: How to Play

     */
    private int currentState;

    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;

    private Board board;
    public static final int TILE_SIZE=32;


/*

 */
    public Game(String title)  {
        this.title=title;
        currentState=0;

        gui=new GUI(title,this);
        gameBoard=gui.getGameBoard();

    }

    @Override
    public void run() {
        running=true;
        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; //nanosecond, 60 frames per second
        double delta = 0;

        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                switch (currentState){
                    case 0:
                        gameBoard.setShowMenu();
                        break;
                    case 1:
                        gameBoard.setShowPlay();
                        break;
                    case 2:
                        gameBoard.setShowOption();
                        break;
                    case 3:
                        gameBoard.setShowChoseLevel();
                        break;
                    case 4:
                        gameBoard.setShowHowToPlay();
                        break;
                }
                delta-=1;
            }


        }
        if(running==false){
            System.exit(0);
        }
    }
    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();

    }
    public synchronized void stop(){
        if(!running)
            return;

        running=false;
        thread.stop();
    }
    public String getTitle(){
        return title;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
