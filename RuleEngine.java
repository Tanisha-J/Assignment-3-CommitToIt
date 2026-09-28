public class RuleEngine {

    public Result determineWinner(Move humanMove, Move computerMove) {
        if (humanMove == computerMove) {
            return Result.DRAW;
        }

        if ((humanMove == Move.ROCK && computerMove == Move.SCISSORS)
                || (humanMove == Move.PAPER && computerMove == Move.ROCK)
                || (humanMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return Result.HUMAN_WINS;
        }

        return Result.COMPUTER_WINS;
    }

    public enum Result {
        HUMAN_WINS,
        COMPUTER_WINS,
        DRAW
    }
}
