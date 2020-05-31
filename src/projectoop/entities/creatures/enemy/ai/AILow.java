package projectoop.entities.creatures.enemy.ai;

public class AILow implements IAI {
    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}
