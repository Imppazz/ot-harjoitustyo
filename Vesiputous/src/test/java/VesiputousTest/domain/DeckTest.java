package VesiputousTest.domain;

import vesiputous.domain.Deck;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    
    Deck deck;
    
    @Before
    public void setUp() {
        deck = new Deck();
    }
    @Test
    public void drawCardReducesCards() {
        deck.drawCard();
        deck.drawCard();
        deck.drawCard();
        assertEquals(deck.cardsRemaining(), 49);
    }
    @Test
    public void drawCardReturnsCorrectCard() {
        assertEquals(deck.drawCard().toString(), "ACE of HEARTS");
    }
    @Test
    public void drawCardReturnNullCardWhenOutOfCards() {
        for (int i = 1; i <= 52; i++) {
            deck.drawCard();
        }
        assertEquals(deck.drawCard().toString(), "null of null");
    }
}
