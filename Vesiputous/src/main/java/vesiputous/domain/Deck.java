package vesiputous.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Ilmari
 */
public class Deck {

    private static ArrayList<Card> deck;

    /**
     *
     */
    public Deck() {
        deck = new ArrayList<>();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                Card card = new Card(s, r);
                deck.add(card);
            }
        }
    }

    /**
     *
     */
    public void suffle() {
        Collections.shuffle(deck, new Random());
    }

    /**
     *
     * @return
     */
    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return new Card(null, null);
    }

    /**
     *
     * @return
     */
    public int cardsRemaining() {
        return deck.size();
    }
}
