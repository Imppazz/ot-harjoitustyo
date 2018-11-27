package Vesiputous.domain;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CardTest {
    
    Card card;
    Card card2;
    Card card3;
    
    @Before
    public void setUp() {
        card = new Card(Suit.SPADES, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.KING);
        card3 = new Card(Suit.DIAMONDS, Rank.FOUR);
    }
    @Test
    public void maaJaArvoOikein() {
        assertEquals("ACE of SPADES", card.toString());
    }
    @Test
    public void maaJaArvoOikein2() {
        assertEquals("KING of HEARTS", card2.toString());
    }
    @Test
    public void maaJaArvoOikein3() {
        assertEquals("FOUR of DIAMONDS", card3.toString());
    }
}
