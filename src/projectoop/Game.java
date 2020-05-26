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
     */
    private int currentState=0;

    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;

    private Board board;
    public static final int TILE_SIZE=32;

    public final static double PLAYER_SPEED=1.0;
    public final static int PLAYER_HP=100;
    public final static int PLAYER_MP=100;
/*

 */
    public Game(String title)  {
        this.title=title;

        //display=new Display(title);
        //input=new KeyBoard();
        //board=new Board(input);

        //display.getFrame().addKeyListener(input);
        gui=new GUI(title,this);
        gameBoard=gui.getGameBoard();

    }
    /*
    public void update(){
        input.update();
        board.update();
    }
    public void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return ;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0,0,Game.WIDTH,Game.HEIGHT);
        board.render(g);

        bs.show();
        g.dispose();

    }


     */

    @Override
    public void run() {
        running=true;
        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; //nanosecond, 60 frames per second
        double delta = 0;

        //display.getCanvas().requestFocus();
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                //update();
                //render();
                //gameBoard.setShowPlay();
                gameBoard.setShowMenu();

                delta-=1;
            }


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
