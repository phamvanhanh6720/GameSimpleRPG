package projectoop;

import projectoop.entities.Entity;
import projectoop.entities.weapon.Weapon;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.Player;
import projectoop.exceptions.LoadLevelException;
import projectoop.graphics.IRender;
import projectoop.input.KeyBoard;
import projectoop.level.FileLevel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements IRender {
    private Game game;
    private KeyBoard input;

    private FileLevel level;
    private List<Creature> creatures=new ArrayList<Creature>();
    private Entity[][] entities;
    private List<Entity> foreground=new ArrayList<Entity>();
    private List<Rectangle> staticRectangles=new ArrayList<Rectangle>();

    private List<Weapon> bullets=new ArrayList<Weapon>();


    public Board(Game game, KeyBoard input)  {
        this.game=game;
        this.input=input;

        try {
            level = new FileLevel("map/mapdemo2.txt", this);
            entities = new Entity[level.getHeight()][level.getWidth()];
            level.createEntities();
        }
        catch (LoadLevelException e){
        }




    }
/*
|-----------------------------
|Update & Render
|------------------------------
 */
    @Override
    public void update() {
        updateEntities();
        updateForeground();
        updateCreatures();
        updateBullets();



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
    }
    public void updateEntities(){
        for (int y=0;y<level.getHeight();y++)
            for (int x=0;x<level.getWidth();x++)
                entities[y][x].update();
    }
    public void updateForeground(){
        Iterator<Entity> itr=foreground.iterator();
        while(itr.hasNext())
            itr.next().update();
    }
    public void updateCreatures(){
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
        for (int y=0;y<level.getHeight();y++)
            for (int x=0;x<level.getWidth();x++)
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
    public List<Rectangle> getStaticRectangles(){
        return staticRectangles;
    }
    public List<Creature> getCreatures(){
        return creatures;
    }

}
