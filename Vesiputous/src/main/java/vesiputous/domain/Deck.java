package vesiputous.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Deck {

    private static ArrayList<Card> deck;
    private static HashMap<Card, String> rules;

    public Deck() {
        deck = new ArrayList<>();
        rules = new HashMap<>();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                Card card = new Card(s, r);
                deck.add(card);
                rules.put(card, card.toString() + ": *Rule here*");
            }
        }
    }

    public void suffle() {
        Collections.shuffle(deck, new Random());
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return new Card(null, null);
    }

    public int cardsRemaining() {
        return deck.size();
    }

    public String getRule(Card card) {
        return rules.get(card);
    }
}
