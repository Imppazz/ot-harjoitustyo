package vesiputous.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vesiputous.dao.DaoResources;
import vesiputous.domain.Card;
import vesiputous.domain.Deck;
import vesiputous.domain.Rank;
import vesiputous.domain.Rule;
import vesiputous.domain.RuleSet;
import vesiputous.domain.Suit;

/**
 *
 * @author Ilmari
 */
public class GUI extends Application implements DaoResources {

    private Card localCard;
    private Rule localRule;
    ArrayList<String> cardList = new ArrayList<>();
    ArrayList<Rule> ruleList = new ArrayList<>();
    Label ruleListLab;
    int labelIndex = 11;
    String RSname;
    Deck deck;

    @Override
    public void start(Stage window) throws Exception {
        // Luodaan layoutit
        BorderPane gameLayout = new BorderPane();
        BorderPane startLayout = new BorderPane();
        BorderPane ruleLayout = new BorderPane();
        GridPane addRuleLayout = new GridPane();

        // Luodaan Hboxit ja tyylitellään layoutit
        HBox option = new HBox();
        option.setPadding(new Insets(20, 20, 20, 20));
        option.setSpacing(40);

        HBox optionStart = new HBox();
        optionStart.setPadding(new Insets(20, 20, 20, 20));
        optionStart.setSpacing(40);

        addRuleLayout.setPrefSize(600, 300);
        addRuleLayout.setAlignment(Pos.CENTER);
        addRuleLayout.setVgap(10);
        addRuleLayout.setHgap(10);
        addRuleLayout.setPadding(new Insets(20, 20, 20, 20));

        ruleLayout.setMinSize(50, 50);

        // Luodaan valikoiden napit, tekstit yms.
        Button startButton = new Button("Start game");
        Button newRuleSet = new Button("New ruleset");
        Button deleteRS = new Button("Delete chosen ruleset");
        Label ruleLab = new Label("Rule:");
        Label cardLab = new Label("Card:");
        Label nameLab = new Label("Name of the ruleset:");
        Label addedRules = new Label("Added rules:");
        Label fillAll = new Label("Choose rank and suit of a card and type a rule for that card");
        Label hasRule = new Label("You already assigned a rule for this card");
        Label addRuleLab = new Label("Add a rule for every card");
        Label addRuleLab2 = new Label("Add a rule for every card");
        Label noRuleSet = new Label("Select ruleset");
        Label RSnameTaken = new Label("Given name is taken");
        Label RSnotValid = new Label("Name has to be 1-50 letters");
        fillAll.setTextFill(Color.RED);
        hasRule.setTextFill(Color.RED);
        noRuleSet.setTextFill(Color.RED);
        RSnameTaken.setTextFill(Color.RED);
        RSnotValid.setTextFill(Color.RED);
        addRuleLab2.setTextFill(Color.RED);
        TextField tfRule = new TextField();
        TextField tfName = new TextField();
        ChoiceBox cbSuit = new ChoiceBox();
        ChoiceBox cbRank = new ChoiceBox();
        ChoiceBox cbRuleSet = new ChoiceBox();
        Button addRule = new Button("Add rule");
        Button addRule2 = new Button("Add new rule");
        Button saveRuleSet = new Button("Save ruleset");
        Button cancel = new Button("Cancel");
        Button drawCard = new Button("Draw a card");
        Button showRule = new Button("Show rule");
        Button newGame = new Button("New game");
        Button next = new Button("Next");
        ScrollPane rulesSP = new ScrollPane();

        cbSuit.getItems().addAll(Suit.values());
        cbRank.getItems().addAll(Rank.values());
        cbRuleSet.getItems().add("Select ruleset");
        cbSuit.getItems().add("Select suit");
        cbRank.getItems().add("Select rank");
        cbRuleSet.setValue("Select ruleset");
        cbSuit.setValue("Select suit");
        cbRank.setValue("Select rank");
        cbRuleSet.getItems().addAll(RULESETDAO.findAll());

        //Lisätään napit yms. layoutteihin
        option.getChildren().addAll(drawCard, showRule);
        optionStart.getChildren().addAll(startButton, cbRuleSet, deleteRS, newRuleSet);

        gameLayout.setTop(option);
        startLayout.setCenter(optionStart);

        addRuleLayout.add(nameLab, 0, 0);
        addRuleLayout.add(tfName, 0, 1);
        addRuleLayout.add(next, 1, 1);
        addRuleLayout.add(addRuleLab, 0, 3);
        addRuleLayout.add(cardLab, 0, 4);
        addRuleLayout.add(cbRank, 0, 5);
        addRuleLayout.add(cbSuit, 1, 5);
        addRuleLayout.add(ruleLab, 0, 6);
        addRuleLayout.add(tfRule, 0, 7);
        addRuleLayout.add(addRule, 0, 8);
        addRuleLayout.add(saveRuleSet, 1, 8);
        addRuleLayout.add(cancel, 2, 8);
        addRuleLayout.add(addedRules, 0, 10);
        cbRank.setDisable(true);
        cbSuit.setDisable(true);
        tfRule.setDisable(true);
        addRule.setDisable(true);
        saveRuleSet.setDisable(true);
        rulesSP.setContent(addRuleLayout);
        rulesSP.setPannable(true);
        
        // Luodaan näkymät ja toinen ikkuna säännön näyttämistä varten. 
        Scene gameView = new Scene(gameLayout);
        Scene startView = new Scene(startLayout);
        Scene addRuleView = new Scene(rulesSP);
        Scene ruleView = new Scene(ruleLayout);
        Stage window2 = new Stage();

        //Määritellään nappien toiminnot
        startButton.setOnAction((event) -> {
            startLayout.setTop(null);
            deck = new Deck();
            deck.suffle();
            if (cbRuleSet.getValue().equals("Select ruleset")) {
                startLayout.setTop(noRuleSet);
            } else {
                RSname = cbRuleSet.getValue().toString();
                setCardLayout(gameLayout, deck);
                window.setScene(gameView);
                window.show();
            }
        });
        newRuleSet.setOnAction((event) -> {
            window.setScene(addRuleView);
            window.show();
        });
        addRule.setOnAction((event) -> {
            addRuleLayout.getChildren().remove(fillAll);
            addRuleLayout.getChildren().remove(hasRule);
            addRuleLayout.getChildren().remove(addRuleLab2);
            if (cbRank.getValue().equals("Select rank") || cbSuit.getValue().equals("Select suit") || tfRule.getText().isEmpty()) {
                addRuleLayout.add(fillAll, 0, 9);
            } else {
                RuleSet ruleSet = new RuleSet(RSname);
                addRuleLayout.getChildren().remove(fillAll);
                Card card = new Card(cbRank.getValue() + ";" + cbSuit.getValue());
                Rule rule = new Rule(card, tfRule.getText(), ruleSet);
                if (cardList.contains(card.toString())) {
                    addRuleLayout.add(hasRule, 0, 9);
                } else {
                    cardList.add(card.toString());
                    ruleList.add(rule);
                    Label ruleLab2 = new Label(rule.toString()); 
                    addRuleLayout.add(ruleLab2, 0, labelIndex, 10, 1);
                    
                    labelIndex++;
                }
            }
        });
        addRule2.setOnAction((event) -> {
            window.setScene(addRuleView);
            window.show();
        });
        saveRuleSet.setOnAction((event) -> {
            if (cardList.size() < 52) {
                addRuleLayout.add(addRuleLab2, 0, 9);
            } else {
                try {
                    RULESETDAO.add(new RuleSet(RSname));
                    for (int i = 0; i < ruleList.size(); i++) {
                        RULEDAO.add(ruleList.get(i));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                addRuleLayout.getChildren().remove(13, labelIndex+2);
                tfName.setText("");
                tfName.setDisable(false);
                next.setDisable(false);
                cbRank.setDisable(true);
                cbSuit.setDisable(true);
                tfRule.setDisable(true);
                addRule.setDisable(true);
                saveRuleSet.setDisable(true);
                cbRuleSet.getItems().add(RSname);
                labelIndex = 11;
                cardList.clear();
                ruleList.clear();
                window.setScene(startView);
                window.show();
            }
        });
        cancel.setOnAction((event) -> {
            addRuleLayout.getChildren().remove(13, labelIndex+2);
            tfName.setText("");
            tfName.setDisable(false);
            next.setDisable(false);
            cbRank.setDisable(true);
            cbSuit.setDisable(true);
            tfRule.setDisable(true);
            addRule.setDisable(true);
            saveRuleSet.setDisable(true);
            labelIndex = 11;
            cardList.clear();
            ruleList.clear();
            window.setScene(startView);
            window.show();
        });
        deleteRS.setOnAction((event) -> {
            if (cbRuleSet.getValue().equals("Select ruleset")) {
                startLayout.setTop(noRuleSet);
            } else {
                startLayout.setTop(null);
                RSname = cbRuleSet.getValue().toString();
                try {
                    RULEDAO.delete(RSname);
                    RULESETDAO.delete(RSname);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                RSname = cbRuleSet.getValue().toString();
                cbRuleSet.setValue(cbRuleSet.getItems().get(0));
                int index = cbRuleSet.getItems().indexOf(RSname);
                cbRuleSet.getItems().remove(index);
            }
        });
        drawCard.setOnAction((event) -> {
            setCardLayout(gameLayout, deck);
            if (deck.cardsRemaining() == 0) {
                gameLayout.setTop(newGame);
            }
        });    
        showRule.setOnAction(
                (event) -> {
                    try {
                        localRule = (Rule) RULEDAO.findOne(localCard.cardAsString() + " " + RSname);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Label ruleLab3 = new Label(localRule.getRule());
                    ruleLayout.setCenter(ruleLab3);
                    window2.setScene(ruleView);
                    window2.show();
                }
        );
        newGame.setOnAction((event) -> {
            gameLayout.setTop(option);
            window.setScene(startView);
            window.show();
        });
        next.setOnAction(
                (event) -> {
                    addRuleLayout.getChildren().remove(RSnotValid);
                    addRuleLayout.getChildren().remove(RSnameTaken);
                    String name = tfName.getText();
                    int n = cbRuleSet.getItems().size();
                    boolean equals = false;
                    for (int i = 0; i < n; i++) {
                        if (cbRuleSet.getItems().get(i).toString().equals(name)) equals = true;
                    }
                    if (name.length() == 0 || name.length() > 50) {
                        addRuleLayout.add(RSnotValid, 0, 2);
                    } else if (equals) {
                        addRuleLayout.add(RSnameTaken, 0, 2);
                    } else {
                        addRuleLayout.getChildren().remove(RSnameTaken);
                        RSname = tfName.getText();
                        Label RSlabel = new Label(tfName.getText());
                        tfName.setDisable(true);
                        next.setDisable(true);
                        cbRank.setDisable(false);
                        cbSuit.setDisable(false);
                        tfRule.setDisable(false);
                        addRule.setDisable(false);
                        saveRuleSet.setDisable(false);
                    }
                }
        );

        //Näytetään sovellus
        window.setScene(startView);

        window.show();
    }

    private void setCardLayout(BorderPane layout, Deck deck) {
        ImageView image = new ImageView();
        this.localCard = deck.drawCard();
        image.setImage(new Image("photos/" + this.localCard.fileName()));
        image.setPreserveRatio(true);
        image.setFitHeight(300);
        layout.setCenter(image);
        layout.setBottom(new Label("Cards remaining: " + deck.cardsRemaining()));
    }
}
