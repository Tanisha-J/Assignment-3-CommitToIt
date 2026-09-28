import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player humanPlayer = new HumanPlayer(scanner);
        Player computerPlayer = new RandomPlayer();
        RuleEngine ruleEngine = new RuleEngine();
        Score score = new Score();

        Game game = new Game(
                humanPlayer,
                computerPlayer,
                ruleEngine,
                score
        );

        game.play();

        scanner.close();
    }
}
