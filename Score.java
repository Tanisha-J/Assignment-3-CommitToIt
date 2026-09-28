public class Score {
    private int humanWins;
    private int computerWins;
    private int draws;

    public void record(RuleEngine.Result result) {
        switch (result) {
            case HUMAN_WINS:
                humanWins++;
                break;

            case COMPUTER_WINS:
                computerWins++;
                break;

            case DRAW:
                draws++;
                break;
        }
    }

    public int getHumanWins() {
        return humanWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getDraws() {
        return draws;
    }
}

