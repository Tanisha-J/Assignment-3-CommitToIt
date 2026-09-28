public class Game {
    private static final int TOTAL_ROUNDS = 20;

    private final Player humanPlayer;
    private final Player computerPlayer;
    private final RuleEngine ruleEngine;
    private final Score score;

    public Game(Player humanPlayer, Player computerPlayer,
                RuleEngine ruleEngine, Score score) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.ruleEngine = ruleEngine;
        this.score = score;
    }

    public void play() {
        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            System.out.println("Round " + round);

            Move humanMove = humanPlayer.chooseMove();
            Move computerMove = computerPlayer.chooseMove();

            RuleEngine.Result result =
                    ruleEngine.determineWinner(humanMove, computerMove);

            score.record(result);

            printRoundResult(humanMove, computerMove, result);
            printScore();
        }
    }

    private void printRoundResult(Move humanMove, Move computerMove,
                                  RuleEngine.Result result) {
        System.out.println("You chose " + formatMove(humanMove)
                + ". The computer chose " + formatMove(computerMove) + ".");
        System.out.println(resultMessage(result));
    }

    private void printScore() {
        System.out.println("Score: Human:" + score.getHumanWins()
                + " Computer:" + score.getComputerWins()
                + " Draws=" + score.getDraws());
        System.out.println();
    }

    private String formatMove(Move move) {
        String name = move.name().toLowerCase();
        return Character.toUpperCase(name.charAt(0))
                + name.substring(1);
    }

    private String resultMessage(RuleEngine.Result result) {
        switch (result) {
            case HUMAN_WINS:
                return "Human Wins!";
            case COMPUTER_WINS:
                return "Computer Wins!";
            case DRAW:
                return "Draw!";
            default:
                throw new IllegalStateException("Unknown result");
        }
    }
}
