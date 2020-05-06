package projectoop.level;

import projectoop.Board;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevel {
    private int width, height;
    private Board board;
    private String[] lineTiles;
    public FileLevel(String path, Board board) throws IOException {
        loadLevel(path);
        this.board=board;
    }
    public void loadLevel(String path) throws IOException {
        URL absPath= FileLevel.class.getResource("/"+path);

        BufferedReader in=new BufferedReader(new InputStreamReader(absPath.openStream()));
        String data=in.readLine();
        StringTokenizer tokens=new StringTokenizer(data);
        width=Integer.parseInt(tokens.nextToken());
        height=Integer.parseInt(tokens.nextToken());
        lineTiles=new String[height];
        for(int i=0;i<height;i++ ){
            lineTiles[i]=in.readLine().substring(0,width);
        }
        in.close();
    }
    public void createEntities(){

    }
    public void addLevelEntity(char c,int x, int y){
        switch (c){
            case 0:

        }

    }
    public int getWidth(){
        return width;

    }
    public int getHeight(){
        return height;
    }

}
