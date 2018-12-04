package vesiputous.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vesiputous.domain.Card;
import vesiputous.domain.Deck;

public class GUI extends Application {

    private Card card;

    @Override
    public void start(Stage window) throws Exception {

        // 1. Luodaan päätason layout
        BorderPane layout = new BorderPane();
        BorderPane startLayout = new BorderPane();

        // 1.1. Luodaan päätason layout:n valikko
        HBox option = new HBox();
        option.setPadding(new Insets(20, 20, 20, 20));
        option.setSpacing(40);

        HBox optionStart = new HBox();
        optionStart.setPadding(new Insets(20, 20, 20, 20));
        optionStart.setSpacing(40);

        // 1.2. Luodaan valikon napit
        Button start = new Button("Start game");
//        Button rules = new Button("Select rules");
        Button drawCard = new Button("Draw a card");
        Button task = new Button("Show rules");

        // 1.3. Lisätään napit valikkoon
        option.getChildren().addAll(drawCard, task);
        optionStart.getChildren().addAll(start);

        layout.setTop(option);
        startLayout.setCenter(optionStart);

        // 2. Luodaan alinäkymät ja kytketään ne valikon nappeihin
        // 2.1. Luodaan alinäkymät -- tässä layout
        // Luodaan pakka ja sekoitetaan se
        Deck deck = new Deck();
        deck.suffle();
//        Label taskLayout = new Label("*Rules here*");

        // 2.2. Liitetään alinäkymät nappeihin. Napin painaminen vaihtaa alinäkymää.
        start.setOnAction((event) -> {
            Scene view = new Scene(layout);
            window.setScene(view);
            window.show();
        });
        drawCard.setOnAction((event) -> setCardLayout(layout, deck));
        task.setOnAction((event) -> {
            Label rule = new Label(deck.getRule(this.card));
            layout.setCenter(rule);
        });

        // 2.3. Näytetään aluksi cardLayout
        setCardLayout(layout, deck);

        // 3. Luodaan päänäkymä ja asetetaan päätason layout siihen
        Scene view = new Scene(startLayout);

        // 4. Näytetään sovellus
        window.setScene(view);
        window.show();
    }

    private void setCardLayout(BorderPane layout, Deck deck) {
        ImageView image = new ImageView();
        this.card = deck.drawCard();
        image.setImage(new Image("file:photos\\" + this.card.fileName()));
        image.setPreserveRatio(true);
        image.setFitHeight(300);
        layout.setCenter(image);
        layout.setBottom(new Label("Cards remaining: " + deck.cardsRemaining()));
    }
//    private StackPane createView(String text) {
//        StackPane layout = new StackPane();
//        layout.setPrefSize(300, 180);
//        layout.getChildren().add(new Label(text));
//        layout.setAlignment(Pos.CENTER);
//
//        return layout;
//    }
}
