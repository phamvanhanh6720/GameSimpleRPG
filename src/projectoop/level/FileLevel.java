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
                BorderTile border=new BorderTile(x,y);
                board.addEntities(x,y,border);
                board.addStaticRectangles(border.getRectangle());
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
                LakeTile lake=new LakeTile(x,y);
                board.addEntities(x,y, lake);
                board.addStaticRectangles(lake.getRectangle());
                break;
            case '6':
                Lake1Tile lake1=new Lake1Tile(x,y);
                board.addEntities(x,y, lake1);
                board.addStaticRectangles(lake1.getRectangle());
                break;
            case '7':
                PortTile portTile=new PortTile(x,y);
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addForeground(portTile);
                board.addStaticRectangles(portTile.getRectangle());
                break;
            case 'b':
                BigTree bigTree=new BigTree(x,y);
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addForeground(bigTree);
                board.addStaticRectangles(bigTree.getRectangle());
                break;
            case '8':
                Tree01 tree01=new Tree01(x,y);
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addForeground(tree01);
                board.addStaticRectangles(tree01.getRectangle());
                break;
            case '9':
                Tree0 tree0=new Tree0(x,y);
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addForeground(tree0);
                board.addStaticRectangles(tree0.getRectangle());
                break;
            case '#':
                Player player=new Player(x* Game.TILE_SIZE,y*Game.TILE_SIZE,board);
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addMobs(player);
                break;
            case 's':
                Snake snake=new Snake(x* Game.TILE_SIZE,y*Game.TILE_SIZE,board);
                board.addEntities(x,y, new Grass0Tile(x,y));
                board.addMobs(snake);

                break;
            case 'p':
                Python python=new Python(x* Game.TILE_SIZE,y*Game.TILE_SIZE,board);
                board.addEntities(x,y,new Grass0Tile(x,y));
                board.addMobs(python);

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
