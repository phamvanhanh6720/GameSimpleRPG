package projectoop.level;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Python;
import projectoop.entities.mob.enemy.Snake;
import projectoop.entities.tile.*;
import projectoop.exceptions.LoadLevelException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevel {
    private int width, height;
    private Board board;
    private String[] lineTiles;
    public FileLevel(String path, Board board) throws LoadLevelException {
        loadLevel(path);
        this.board=board;
    }
    public void loadLevel(String path) throws LoadLevelException {
        try {
            URL absPath = FileLevel.class.getResource("/" + path);

            BufferedReader in = new BufferedReader(new InputStreamReader(absPath.openStream()));
            String data = in.readLine();
            StringTokenizer tokens = new StringTokenizer(data);
            width = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            lineTiles = new String[height];
            for (int i = 0; i < height; i++) {
                lineTiles[i] = in.readLine().substring(0, width);
            }
            in.close();

        }
        catch (IOException e){
            throw new LoadLevelException("Error loading level"+path,e);
        }

    }
    public void createEntities(){
        for(int y=0;y<getHeight();y++)
            for (int x=0;x<getWidth();x++)
                addLevelEntity(lineTiles[y].charAt(x),x,y);
    }
    public void addLevelEntity(char c,int x, int y){
        switch (c){
            case '0':
                board.addEntities(x,y,new BorderTile(x,y));
                break;
            case '1':
                board.addEntities(x,y,new Grass0Tile(x,y));
                break;
            case '2':
                board.addEntities(x,y, new GrassTile(x,y));
                break;
            case '3':
                board.addEntities(x,y,new Grass1Tile(x,y));
                break;
            case '4':
                board.addEntities(x,y, new GroundTile(x,y));
                break;
            case '5':
                board.addEntities(x,y, new LakeTile(x,y));
                break;
            case '6':
                board.addEntities(x,y, new Lake1Tile(x,y));
                break;
            case '7':
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addForeground(new PortTile(x,y));
                break;
            case 'b':
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addForeground(new BigTree(x,y));
                break;
            case '8':
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addForeground(new Tree01(x,y));
                break;
            case '9':
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addForeground(new Tree0(x,y));
                break;
            case '#':
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addMobs(new Player(x* Game.TILE_SIZE,y*Game.TILE_SIZE,board));
                break;
            case 's':
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addMobs(new Snake(x*Game.TILE_SIZE,y*Game.TILE_SIZE,board));
                break;
            case 'p':
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addMobs(new Python(x*Game.TILE_SIZE,y*Game.TILE_SIZE,board));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }

    }
    public int getWidth(){
        return width;

    }
    public int getHeight(){
        return height;
    }

}
