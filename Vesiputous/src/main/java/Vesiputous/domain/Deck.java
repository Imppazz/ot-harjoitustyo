package Vesiputous.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    
    private static ArrayList<Card> deck;
    
    public Deck() {
        deck = new ArrayList<>();
        for (Suit s : Suit.values()){
            for (Rank r : Rank.values()){
               deck.add(new Card(s, r));
            }
        }
    }
    public void suffle() {
        Collections.shuffle(deck, new Random());
    }
    public Card DrawACard(){ 
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }
    public int cardsRemaining(){
        return deck.size();
    }
}