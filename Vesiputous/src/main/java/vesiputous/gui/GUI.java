package vesiputous.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import vesiputous.dao.DaoResources;
import vesiputous.domain.Card;
import vesiputous.domain.Deck;
import vesiputous.domain.Rank;
import vesiputous.domain.Suit;

public class GUI extends Application implements DaoResources {

    private Card card;
    int i = 7;

    @Override
    public void start(Stage window) throws Exception {

        // 1. Luodaan layoutit
        BorderPane layout = new BorderPane();
        BorderPane startLayout = new BorderPane();
        GridPane ruleLayout = new GridPane();

        // 1.1 tyylitellään layoutit
        HBox option = new HBox();
        option.setPadding(new Insets(20, 20, 20, 20));
        option.setSpacing(40);

        HBox optionStart = new HBox();
        optionStart.setPadding(new Insets(20, 20, 20, 20));
        optionStart.setSpacing(40);

        ruleLayout.setPrefSize(400, 200);
        ruleLayout.setAlignment(Pos.CENTER);
        ruleLayout.setVgap(10);
        ruleLayout.setHgap(10);
        ruleLayout.setPadding(new Insets(20, 20, 20, 20));

        // 1.2. Luodaan valikoiden napit
        Button startButton = new Button("Start game");
        Button ruleButton = new Button("New ruleset");
        Label rankLab = new Label("Rank:");
        Label suitLab = new Label("Suit:");
        Label ruleLab = new Label("Rule:");
        Label nameLab = new Label("Name of the ruleset:");
        TextField tfRule = new TextField();
        TextField tfName = new TextField();
        ChoiceBox cbSuit = new ChoiceBox();
        ChoiceBox cbRank = new ChoiceBox();
        ChoiceBox cbRuleSet = new ChoiceBox();
        Button addRule = new Button("Add rule");
        Button addRule2 = new Button("Add new rule");
        Button exit = new Button("Save ruleset");
        Button drawCard = new Button("Draw a card");
        Button task = new Button("Show rules");

        cbSuit.getItems().addAll(Suit.values());
        cbRank.getItems().addAll(Rank.values());
        cbRuleSet.getItems().add("Select ruleset");
        cbRuleSet.setValue("Select ruleset");
        // 1.3. Lisätään napit valikkoon
        option.getChildren().addAll(drawCard, task);
        optionStart.getChildren().addAll(startButton, cbRuleSet, ruleButton);

        layout.setTop(option);
        startLayout.setCenter(optionStart);

        ruleLayout.add(nameLab, 0, 0);
        ruleLayout.add(tfName, 0, 1);
        ruleLayout.add(rankLab, 0, 2);
        ruleLayout.add(cbRank, 0, 3);
        ruleLayout.add(suitLab, 1, 2);
        ruleLayout.add(cbSuit, 1, 3);
        ruleLayout.add(ruleLab, 0, 4);
        ruleLayout.add(tfRule, 0, 5);
        ruleLayout.add(addRule, 0, 6);
        ruleLayout.add(exit, 1, 6);

        // 2. Luodaan alinäkymät ja kytketään ne valikon nappeihin
        // 2.1. Luodaan alinäkymät -- tässä layout
        // Luodaan pakka ja sekoitetaan se
        Deck deck = new Deck();
        deck.suffle();
//        Label taskLayout = new Label("*Rules here*");

        // 2.2. Liitetään alinäkymät nappeihin. Napin painaminen vaihtaa alinäkymää.
        Scene gameView = new Scene(layout);
        Scene startView = new Scene(startLayout);
        Scene ruleView = new Scene(ruleLayout);

        startButton.setOnAction((event) -> {
            setCardLayout(layout, deck);
            window.setScene(gameView);
            window.show();
        });
        ruleButton.setOnAction((event) -> {
            window.setScene(ruleView);
            window.show();
        });
        addRule.setOnAction((event) -> {
            ruleLayout.add(new Label(cbRank.getValue() + " of " + cbSuit.getValue() + ": " + tfRule.getText()), 0, i);
            //ruleLayout.add(addRule2, 1, 5);
            cbSuit.getSelectionModel().clearSelection();
            cbRank.getSelectionModel().clearSelection();
            tfRule.clear();
            i++;
        });
        addRule2.setOnAction((event) -> {
            window.setScene(ruleView);
            window.show();
        });
        exit.setOnAction((event) -> {
            window.setScene(startView);
            window.show();
        });
        drawCard.setOnAction((event) -> setCardLayout(layout, deck));
        task.setOnAction((event) -> {
            Label rule = new Label(deck.getRule(this.card));
            layout.setCenter(rule);
        });

        // 4. Näytetään sovellus
        window.setScene(startView);
        window.show();
    }

    private void setCardLayout(BorderPane layout, Deck deck) {
        ImageView image = new ImageView();
        this.card = deck.drawCard();
        image.setImage(new Image("photos\\" + this.card.fileName()));
        image.setPreserveRatio(true);
        image.setFitHeight(300);
        layout.setCenter(image);
        layout.setBottom(new Label("Cards remaining: " + deck.cardsRemaining()));
    }
}
