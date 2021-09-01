package io.github.tlundcomputing.cardgamejava;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PrimaryController implements Initializable {

    @FXML
    private Canvas card1Canvas;
    @FXML
    private Canvas card2Canvas;
    @FXML
    private Button setupBtn;
    @FXML
    private Button nextRoundBtn;
    @FXML private Label p1Lbl;
    @FXML private Label p2Lbl;
    private GraphicsContext card1Context;
    private GraphicsContext card2Context;
    private Stack<Card> deck;
    private Player p1;
    private Player p2;

    @FXML
    private void setup(ActionEvent event) {
        ArrayList<Card> cards = new ArrayList<>();
        deck = new Stack<>(30);
        for (int x = 1; x < 4; x++) {
            for (int y = 1; y < 11; y++) {
                switch (x) {
                    case 1:
                        cards.add(new Card("Red", y));
                        break;
                    case 2:
                        cards.add(new Card("Yellow", y));
                        break;
                    case 3:
                        cards.add(new Card("Black", y));
                        break;
                    default:
                        System.out.println("Error");
                }
            }
        }
        Collections.shuffle(cards);
        for (Card card : cards) {
            deck.push(card);
        }
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Input Data");
        td.setContentText("Enter the name for player 1");
        Optional<String> result = td.showAndWait();
        p1 = new Player(result.get());
        td.setContentText("Enter the name for player 2");
        result = td.showAndWait();
        p2 = new Player(result.get());
        p1Lbl.setText(p1.getName());
        p2Lbl.setText(p2.getName());
        setupBtn.setDisable(true);
        nextRoundBtn.setDisable(false);
    }

    @FXML
    private void nextRound(ActionEvent event) {
        if(!deck.isEmpty()){
            
        } else {
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nextRoundBtn.setDisable(true);
        card1Context = card1Canvas.getGraphicsContext2D();
        card2Context = card2Canvas.getGraphicsContext2D();
        card1Context.setFont(new Font("Arial", 16));
        card2Context.setFont(new Font("Arial", 16));
        card1Context.setFill(Color.DODGERBLUE);
        card2Context.setFill(Color.DODGERBLUE);
        card1Context.fillRect(0, 0, 100, 150);
        card2Context.fillRect(0, 0, 100, 150);
        card1Context.setFill(Color.WHITE);
        card2Context.setFill(Color.WHITE);
        card1Context.fillText("Back\nof\nCard", 25, 50);
        card2Context.fillText("Back\nof\nCard", 25, 50);
    }

}
