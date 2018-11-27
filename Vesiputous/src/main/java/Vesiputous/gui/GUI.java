package Vesiputous.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Vesiputous.domain.Deck;
import java.util.Scanner;

public class GUI extends Application{

    @Override
    public void start(Stage window) throws Exception {

        // 1. Luodaan päätason layout
        BorderPane layout = new BorderPane();

        // 1.1. Luodaan päätason layout:n valikko
        HBox option = new HBox();
        option.setPadding(new Insets(20, 20, 20, 20));
        option.setSpacing(40);

        // 1.2. Luodaan valikon napit
        Button card = new Button("Draw a card");
        Button task = new Button("Show task");

        // 1.3. Lisätään napit valikkoon
        option.getChildren().addAll(card, task);

        layout.setTop(option);


        // 2. Luodaan alinäkymät ja kytketään ne valikon nappeihin
        // 2.1. Luodaan alinäkymät -- tässä layout
        Deck deck = new Deck();
        Label taskLayout = new Label("*Task here*");

        // 2.2. Liitetään alinäkymät nappeihin. Napin painaminen vaihtaa alinäkymää.
        card.setOnAction((event) -> {
            Label cardLayout = new Label(deck.DrawACard()+ ", Cards remaining " + deck.cardsRemaining());
            layout.setCenter(cardLayout);
        });
        task.setOnAction((event) -> layout.setCenter(taskLayout));

        // 2.3. Näytetään aluksi cardLayout
        layout.setCenter(new Label(deck.DrawACard()+ ", Cards remaining " + deck.cardsRemaining()));


        // 3. Luodaan päänäkymä ja asetetaan päätason layout siihen
        Scene view = new Scene(layout);


        // 4. Näytetään sovellus
        window.setScene(view);
        window.show();
    }
//Tarvitaan ehkä myöhemmin
//    private StackPane createView(String text) {
//
//        StackPane layout = new StackPane();
//        layout.setPrefSize(300, 180);
//        layout.getChildren().add(new Label(text));
//        layout.setAlignment(Pos.CENTER);
//
//        return layout;
//    }
    public static void main(String[] args) {
        launch(GUI.class);
    }    
}
