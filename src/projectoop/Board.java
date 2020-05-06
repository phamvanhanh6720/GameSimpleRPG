package projectoop;

import projectoop.entities.Entity;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Dragon;
import projectoop.entities.mob.enemy.Snake;
import projectoop.entities.tile.GrassTile;
import projectoop.entities.tile.Tile;
import projectoop.graphics.IRender;
import projectoop.input.KeyBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements IRender {
    private Game game;
    private KeyBoard input;


    private List<Mob> mobs=new ArrayList<Mob>();
    private Entity[][] entities;
    public Board(Game game, KeyBoard input){
        this.game=game;
        this.input=input;

        mobs.add(new Player(10,10,this));
        mobs.add(new Snake(200,200,this));
        mobs.add(new Dragon(500,500,this));
        //entities=new GrassTile(5,5);
    }

    @Override
    public void update() {
        //entities.update();
        updateMobs();

    }

    @Override
    public void render(Graphics g) {
        //entities.render(g);
        renderMobs(g);

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
    public void addEntities(int x, int y, Entity entity){
        entities[x][y]=entity;
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
