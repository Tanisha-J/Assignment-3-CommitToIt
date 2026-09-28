public class RuleEngineTest {
    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();

        check(
                engine.determineWinner(Move.ROCK, Move.SCISSORS),
                RuleEngine.Result.HUMAN_WINS,
                "Rock beats Scissors"
        );

        check(
                engine.determineWinner(Move.PAPER, Move.ROCK),
                RuleEngine.Result.HUMAN_WINS,
                "Paper beats Rock"
        );

        check(
                engine.determineWinner(Move.SCISSORS, Move.PAPER),
                RuleEngine.Result.HUMAN_WINS,
                "Scissors beats Paper"
        );

        check(
                engine.determineWinner(Move.ROCK, Move.PAPER),
                RuleEngine.Result.COMPUTER_WINS,
                "Paper beats Rock"
        );

        check(
                engine.determineWinner(Move.PAPER, Move.SCISSORS),
                RuleEngine.Result.COMPUTER_WINS,
                "Scissors beats Paper"
        );

        check(
                engine.determineWinner(Move.SCISSORS, Move.ROCK),
                RuleEngine.Result.COMPUTER_WINS,
                "Rock beats Scissors"
        );

        check(
                engine.determineWinner(Move.ROCK, Move.ROCK),
                RuleEngine.Result.DRAW,
                "Matching moves create a draw"
        );

        Score score = new Score();

        score.record(RuleEngine.Result.HUMAN_WINS);
        score.record(RuleEngine.Result.COMPUTER_WINS);
        score.record(RuleEngine.Result.DRAW);

        check(score.getHumanWins(), 1, "Human score");
        check(score.getComputerWins(), 1, "Computer score");
        check(score.getDraws(), 1, "Draw score");

        System.out.println("All tests passed.");
    }

    private static void check(
            Object actual,
            Object expected,
            String testName) {

        if (!actual.equals(expected)) {
            throw new AssertionError(
                    testName + " failed."
            );
        }
    }
}
