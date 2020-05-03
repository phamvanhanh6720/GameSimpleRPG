package projectoop;

import projectoop.entities.mob.Player;
import projectoop.graphics.Sprite;
import projectoop.gui.Display;
import projectoop.input.KeyBoard;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private String title;
    private int width,height;
    private Display display;
    private KeyBoard input;

    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;

    private Board board;

    public static final int TILE_SIZE=32;

    public final static double PLAYER_SPEED=1.0;
    public final static int PLAYER_HP=100;
    public final static int PLAYER_MP=100;

    public Game(String title, int width,int height){
        this.title=title;
        this.width=width;
        this.height=height;

        display=new Display(title, width,height);
        input=new KeyBoard();
        board=new Board(this,input);

        display.getFrame().addKeyListener(input);

    }
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
        g.clearRect(0,0,width,height);
        //g.drawImage(Sprite.grass,5*64,5*64,null);
        board.render(g);

        bs.show();
        g.dispose();

    }


    @Override
    public void run() {
        running=true;
        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 50.0; //nanosecond, 60 frames per second
        double delta = 0;

        display.getCanvas().requestFocus();
        while(running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                update();
                render();
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
}
