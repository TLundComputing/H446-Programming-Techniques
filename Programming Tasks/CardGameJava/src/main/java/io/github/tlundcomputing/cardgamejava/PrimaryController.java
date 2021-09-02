package io.github.tlundcomputing.cardgamejava;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
        card1Context.setFill(Color.DODGERBLUE);
        card2Context.setFill(Color.DODGERBLUE);
        card1Context.fillRect(0, 0, 100, 150);
        card2Context.fillRect(0, 0, 100, 150);
        card1Context.setFill(Color.WHITE);
        card2Context.setFill(Color.WHITE);
        card1Context.fillText("Back\nof\nCard", 25, 50);
        card2Context.fillText("Back\nof\nCard", 25, 50);
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
        Alert popup = new Alert(AlertType.INFORMATION);
        popup.setHeaderText("Information!");
        if(!deck.isEmpty()){
            p1.setCurrentCard(deck.pop());
            p2.setCurrentCard(deck.pop());
            card1Context.clearRect(0, 0, card1Canvas.getWidth(), card1Canvas.getHeight());
            card2Context.clearRect(0, 0, card1Canvas.getWidth(), card1Canvas.getHeight());
            switch(p1.getCurrentCard().getColour()){
                case "Yellow" -> card1Context.setFill(Color.YELLOW);
                case "Red" -> card1Context.setFill(Color.RED);
                case "Black" -> card1Context.setFill(Color.BLACK);
            }
            switch(p2.getCurrentCard().getColour()){
                case "Yellow" -> card2Context.setFill(Color.YELLOW);
                case "Red" -> card2Context.setFill(Color.RED);
                case "Black" -> card2Context.setFill(Color.BLACK);
            }
            card1Context.fillRect(0, 0, card1Canvas.getWidth(), card1Canvas.getHeight());
            card2Context.fillRect(0, 0, card2Canvas.getWidth(), card2Canvas.getHeight());
            card1Context.setFill(Color.PURPLE);
            card2Context.setFill(Color.PURPLE);
            card1Context.fillText(String.valueOf(p1.getCurrentCard().getValue()), 25, 50);
            card2Context.fillText(String.valueOf(p2.getCurrentCard().getValue()), 25, 50);
            if(p1.getCurrentCard().getColour().equals(p2.getCurrentCard().getColour())){
                if(p1.getCurrentCard().getValue() > p2.getCurrentCard().getValue()){
                    popup.setContentText(p1.getName() + " wins that round!");
                    popup.showAndWait();
                    p1.setWinningCards(p1.getCurrentCard(), p2.getCurrentCard());
                } else {
                    popup.setContentText(p2.getName() + " wins that round!");
                    popup.showAndWait();
                    p2.setWinningCards(p1.getCurrentCard(), p2.getCurrentCard());
                }
            } else {
                if((p1.getCurrentCard().getColour().equals("Red") && p2.getCurrentCard().getColour().equals("Black")) ||
                   (p1.getCurrentCard().getColour().equals("Yellow") && p2.getCurrentCard().getColour().equals("Red")) ||
                   (p1.getCurrentCard().getColour().equals("Black") && p2.getCurrentCard().getColour().equals("Yellow"))){
                    popup.setContentText(p1.getName() + " wins that round!");
                    popup.showAndWait();
                    p1.setWinningCards(p1.getCurrentCard(), p2.getCurrentCard());
                } else {
                    popup.setContentText(p2.getName() + " wins that round!");
                    popup.showAndWait();
                    p2.setWinningCards(p1.getCurrentCard(), p2.getCurrentCard());
                }
            }
       } else {
            Alert finalBox = new Alert(AlertType.INFORMATION);
            finalBox.setTitle("Final Result");
            finalBox.setHeaderText("The final winner!");
            StringBuilder build = new StringBuilder();
            Label label = new Label();
            if(p1.getWinningCards().size() > p2.getWinningCards().size()){
                label.setText(p1.getName() + " is the winner, here are their cards:");
                for(Card card : p1.getWinningCards()){
                    build.append(card.getColour());
                    build.append(":");
                    build.append(String.valueOf(card.getValue()));
                    build.append("\n");
                }
            } else {
                label.setText(p2.getName() + " is the winner, here are their cards:");
                for(Card card : p2.getWinningCards()){
                    build.append(card.getColour());
                    build.append(":");
                    build.append(String.valueOf(card.getValue()));
                    build.append("\n");
                }
            }
            TextArea area = new TextArea(build.toString());
            area.setMaxHeight(Double.MAX_VALUE);
            area.setMaxWidth(Double.MAX_VALUE);
            GridPane.setVgrow(area, Priority.ALWAYS);
            GridPane.setHgrow(area, Priority.ALWAYS);
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(area, 0, 1);
            finalBox.getDialogPane().setExpandableContent(expContent);
            finalBox.getDialogPane().setExpanded(true);
            nextRoundBtn.setDisable(true);
            setupBtn.setDisable(false);
            finalBox.showAndWait();
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
