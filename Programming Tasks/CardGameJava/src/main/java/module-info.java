module io.github.tlundcomputing.cardgamejava {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.tlundcomputing.cardgamejava to javafx.fxml;
    exports io.github.tlundcomputing.cardgamejava;
}
