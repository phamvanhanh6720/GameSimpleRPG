package projectoop.entities.creatures.enemy.ai;

import java.util.Random;

public interface IAI {
    public static final Random random=new Random();
    public int calculateDirection();
}
