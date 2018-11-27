package Vesiputous.domain;

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
    public void nostaminenVahentaaKortteja() {
        deck.drawCard();
        deck.drawCard();
        deck.drawCard();
        assertEquals(deck.cardsRemaining(), 49);
    }
    @Test
    public void nostaminenPalauttaaNostetunKortin() {
        assertEquals(deck.drawCard().toString(), "ACE of HEARTS");
    }
    @Test
    public void nostaminenPalauttaaNullKunPakkaLoppuu() {
        for (int i = 1; i <= 52; i++) {
            deck.drawCard();
        }
        assertEquals(deck.drawCard(), null);
    }
}
