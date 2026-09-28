import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random;

    public RandomPlayer() {
        random = new Random();
    }

    @Override
    public Move chooseMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }
}
