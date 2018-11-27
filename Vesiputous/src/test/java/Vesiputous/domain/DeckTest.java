package Vesiputous.domain;

import Vesiputous.domain.Deck;
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
        deck.DrawACard();
        deck.DrawACard();
        deck.DrawACard();
        assertEquals(deck.cardsRemaining(), 49);
    }
    @Test
    public void nostaminenPalauttaaNostetunKortin() {
        assertEquals(deck.DrawACard().toString(), "ACE of HEARTS");
    }
    @Test
    public void nostaminenPalauttaaNullKunPakkaLoppuu() {
        for (int i = 1; i <= 52; i++) {
            deck.DrawACard();
        }
        assertEquals(deck.DrawACard(), null);
    }
}
