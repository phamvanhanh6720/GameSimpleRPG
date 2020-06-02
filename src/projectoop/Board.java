package projectoop;

import projectoop.entities.Entity;
import projectoop.entities.tile.PortTile;
import projectoop.entities.tile.Tile;
import projectoop.entities.weapon.Weapon;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.Player;
import projectoop.exceptions.LoadLevelException;
import projectoop.graphics.IRender;
import projectoop.gui.GameBoard;
import projectoop.gui.PlayGame;
import projectoop.input.KeyBoard;
import projectoop.level.FileLevel;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.util.*;
import java.util.List;

public class Board implements IRender {

    private KeyBoard input;
    private PlayGame playGame;
    private int level=0;
    private boolean pause=false;
    private boolean endGame=false;
    private boolean win=false;
    private boolean exit=false;

    private String round;

    private int timeAfterGameOver=100;
    private int timeAfterGameWin=100;

    //so lan load map
    private int count;

    private FileLevel map;
    private List<Creature> creatures=new ArrayList<Creature>();
    private Entity[][] entities;
    private List<Entity> foreground=new ArrayList<Entity>();
    private List<Rectangle> staticRectangles=new ArrayList<Rectangle>();
    private List<Weapon> bullets=new ArrayList<Weapon>();


    public Board(KeyBoard input,PlayGame playGame)  {

        this.input=input;
        this.playGame=playGame;
        round="a";
        count=1;




    }
    /*
    |-----------------------------
    |Load Map
    |------------------------------
     */
    public void loadMap(String basePath,int level,String round){
        String fileName= Integer.toString(level)+"map"+round+".txt";
        String path=basePath+"/"+fileName;
        try {
            map = new FileLevel(path, this,level);
            entities = new Entity[map.getHeight()][map.getWidth()];
            map.createEntities();
        }
        catch (LoadLevelException e){
        }

    }
    public void changeMapB(){
        int mp=getPlayer().getMp();
        int hp=getPlayer().getHp();
        resetAllAttributes("b",level);
        loadMap("map",level,round);
        getPlayer().setMp(mp);
        getPlayer().setHp(hp);
        input.update();
        count--;

    }

    // reset all arrtributes: thuc hien khi chuyen giua cac trang thai tu gameover-> menu, gamewin->menu, changemap, exit->menu
    public void resetAllAttributes(String round,int level){
        count=1;
        pause=false;
        win=false;
        endGame=false;
        exit=false;
        timeAfterGameOver=100;
        timeAfterGameWin=100;
        this.level=level;
        playGame.getGameBoard().getGui().getGame().setLevel(level);

        this.round=round;
        input=new KeyBoard();
        playGame.setInput(input);
        playGame.addKeyListener(input);

        bullets.clear();
        foreground.clear();
        staticRectangles.clear();
        creatures.clear();

    }
    /*
   |-----------------------------
   |Draw
   |------------------------------
   */
    //draw game over or game win or pause
    public void drawUniqueScreen(Graphics g){
        if(exit==true){
            playGame.getGameBoard().getGui().getGame().setCurrentState(0);
            resetAllAttributes("a",0);
            return;
        }
        if(endGame==true){
            drawGameOver(g);
            if(timeAfterGameOver>=0){
                timeAfterGameOver--;
            }
            else{
                playGame.getGameBoard().getGui().getGame().setCurrentState(0);
                resetAllAttributes("a",0);
            }
            return;
        }
        if(pause==true){
            drawPause(g);
            return;
        }
        if(win==true){
            drawGameWin(g);
            if(timeAfterGameWin>=0){
                timeAfterGameWin--;
            }
            else {
                playGame.getGameBoard().getGui().getGame().setCurrentState(0);
                resetAllAttributes("a",0);
            }
            return;
        }

    }
    public void drawGameOver(Graphics g){
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.setColor(Color.BLACK);
        g.drawString("Game Over",250,300);
    }
    public void drawPause(Graphics g){
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.setColor(Color.BLACK);
        g.drawString("Pause",300,300);
    }
    public void drawGameWin(Graphics g){
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.setColor(Color.BLACK);
        g.drawString("You Win!",250,300);
    }

    /*
    |-----------------------------
    |Check
    |------------------------------
    */
    public void checkExit(){
        if(input.exit==true){
            exit=true;
            return;
        }
        exit=false;
    }
    public void checkEndGame(){
        if(getPlayer().isRemoved()==true){
            endGame=true;
        }
    }

    public void checkPause(){
        if(input.pause==true){
            pause=true;
            return;
        }
        if(input.pause==false&&endGame==false){
            pause=false;
            return;
        }

    }
    public boolean checkEmptyEnemy(){
        if(creatures.size()==1){
            return true;
        }
        return false;
    }
    public boolean checkChangeMap(){
        if(checkEmptyEnemy()==true&&round=="a"){
            if(getPlayer().getRectangle().intersects(getPortTile().getRectangle())){
                return true;
            }
        }
        return false;
    }
    public void checkGameWin(){
        if(checkEmptyEnemy()==true&&round=="b"){
            win=true;
            return;
        }
    }


    /*
    |-----------------------------
    |Update & Render
    |------------------------------
    */
    @Override
    public void update() {
        //load map A
        if(count>=1&&playGame.getGameBoard().getGui().getGame().getCurrentState()==1){
            level=playGame.getGameBoard().getGui().getGame().getLevel();
            loadMap("map",level,round);
            count--;
        }

        input.update();
        checkExit();
        checkEndGame();
        checkPause();
        checkGameWin();
        //check va chuyen sang map B
        if(checkChangeMap()==true){
            changeMapB();
        }

        updateEntities();
        updateForeground();
        updateBullets();
        if(pause==true){
            return;
        }
        updateCreatures();


    }

    @Override
    public void render(Graphics g) {
        renderEntities(g);
        renderForeground(g);
        //thu tu render
        if(getPlayer().getDirection()==0){
            renderCreatures(g);
            renderBullets(g);
        }
        else {
            renderBullets(g);
            renderCreatures(g);
        }

        drawUniqueScreen(g);
    }
    public void updateEntities(){
        for (int y=0;y<map.getHeight();y++)
            for (int x=0;x<map.getWidth();x++)
                entities[y][x].update();
    }
    public void updateForeground(){
        Iterator<Entity> itr=foreground.iterator();
        while(itr.hasNext())
            itr.next().update();
    }
    public void updateCreatures(){
        Collections.sort(creatures);
        Iterator<Creature> itr=creatures.iterator();
        Creature creature;
        while(itr.hasNext()){
            creature=itr.next();
            if(creature.isRemoved()==true){
                itr.remove();
            }
            else{
                creature.update();
            }

        }
    }

    public void updateBullets(){
        Iterator<Weapon> itr=bullets.iterator();
        Weapon bullet;
        while(itr.hasNext()){
            bullet=itr.next();
            if(bullet.isRemoved()==true){
                itr.remove();
            }
            else{
                bullet.update();
            }
        }
    }


    public void renderCreatures(Graphics g){
        Iterator<Creature> itr=creatures.iterator();
        while(itr.hasNext())
            itr.next().render(g);
    }
    public void renderEntities(Graphics g){
        for (int y=0;y<map.getHeight();y++)
            for (int x=0;x<map.getWidth();x++)
                entities[y][x].render(g);

    }
    public void renderForeground(Graphics g){
        Iterator<Entity> itr=foreground.iterator();
        while(itr.hasNext())
            itr.next().render(g);
    }
    public void renderBullets(Graphics g){
        Iterator<Weapon> itr=bullets.iterator();
        while(itr.hasNext()){
            itr.next().render(g);
        }
    }
    /*
    |--------------------------------
    |Add Entity
    |--------------------------------
     */
    public void addEntities(int x, int y, Entity entity){
        entities[y][x]=entity;
    }
    public void addForeground(Entity entity){
        foreground.add(entity);
    }
    public void addCreatures(Creature creature){
        creatures.add(creature);
    }
    public void addBullets(Weapon bullet){
        bullets.add(bullet);
    }
    /*
    |--------------------------------
    |Add Rectangle
    |--------------------------------
     */
    public void addStaticRectangles(Rectangle rectangle){
        staticRectangles.add(rectangle);
    }

    /*
    |-------------------------------------
    |Get and Set
    |-------------------------------------
    */
    public KeyBoard getInput(){
        return input;
    }
    public Entity getEntities(){
        return null;
    }
    public Player getPlayer(){
        Iterator<Creature> itr=creatures.iterator();
        Creature cur;
        while(itr.hasNext()){
            cur=itr.next();
            if(cur instanceof Player)
                return (Player)cur;
        }
        return null;
    }
    public PortTile getPortTile(){
        Iterator<Entity> itr=foreground.iterator();
        Entity cur;
        while(itr.hasNext()){
            cur=itr.next();
            if(cur instanceof PortTile)
                return (PortTile) cur;
        }
        return null;
    }
    public List<Rectangle> getStaticRectangles(){
        return staticRectangles;
    }
    public List<Creature> getCreatures(){
        return creatures;
    }
    public void setPause(boolean pause){this.pause=pause;};
}
