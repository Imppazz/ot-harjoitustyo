package vesiputous.domain;

/**
 *
 * @author Ilmari
 */
public class Card {

    private final Suit suit;
    private final Rank rank;

    /**
     *
     * @param suit
     * @param rank
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     *
     * @param card
     */
    public Card(String card) {
        String[] parts = card.split(";");
        this.rank = Rank.valueOf(parts[0]);
        this.suit = Suit.valueOf(parts[1]);
    }

    /**
     *
     * @return
     */
    public String cardAsString() {
        return this.rank + ";" + this.suit;
    }

    /**
     *
     * @return
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     *
     * @return
     */
    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }

    /**
     *
     * @return
     */
    public String fileName() {
        return this.getRank() + "" + this.getSuit() + ".png";
    }
}
