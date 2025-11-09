import edu.project3.game.Card;
import edu.project3.game.NumberCard;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        Card card  = new NumberCard(Card.Suit.Clubs, 10);

    }

}
