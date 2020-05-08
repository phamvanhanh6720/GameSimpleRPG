package projectoop;

import projectoop.entities.Entity;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Python;
import projectoop.entities.mob.enemy.Snake;
import projectoop.entities.tile.BorderTile;
import projectoop.entities.tile.GrassTile;
import projectoop.entities.tile.Tile;
import projectoop.exceptions.LoadLevelException;
import projectoop.graphics.IRender;
import projectoop.input.KeyBoard;
import projectoop.level.FileLevel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements IRender {
    private Game game;
    private KeyBoard input;

    private FileLevel level;
    private List<Mob> mobs=new ArrayList<Mob>();
    private Entity[][] entities;
    private List<Entity> foreground=new ArrayList<Entity>();
    private GrassTile grass;
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
        updateMobs();


    }

    @Override
    public void render(Graphics g) {
        renderEntities(g);
        renderForeground(g);
        renderMobs(g);

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
    public void updateMobs(){
        Iterator<Mob> itr=mobs.iterator();
        while(itr.hasNext())
            itr.next().update();
    }
    public void renderMobs(Graphics g){
        Iterator<Mob> itr=mobs.iterator();
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
    public void addMobs(Mob mob){
        mobs.add(mob);
    }




    public KeyBoard getInput(){
        return input;
    }
    public Entity getEntities(){
        return null;
    }
    public Player getPlayer(){
        Iterator<Mob> itr=mobs.iterator();
        Mob cur;
        while(itr.hasNext()){
            cur=itr.next();
            if(cur instanceof Player)
                return (Player)cur;
        }
        return null;
    }
}
