package vesiputous.domain;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }

    public String fileName() {
        return this.getRank() + "" + this.getSuit() + ".png";
    }
}
