package projectoop;

import projectoop.exceptions.SimpleRPGException;

import java.io.IOException;

public class SimpleRPG {
    public static void main(String[] args) throws SimpleRPGException {
        Game game;
        game = new Game("SimpleRPG",800,640);
        game.start();
    }
}
