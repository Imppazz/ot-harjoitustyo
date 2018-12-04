package Vesiputous.domain;
import vesiputous.domain.Rank;
import vesiputous.domain.Card;
import vesiputous.domain.Suit;
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
    public void suitAndRankCorrect() {
        assertEquals("ACE of SPADES", card.toString());
    }
    @Test
    public void suitAndRankCorrect2() {
        assertEquals("KING of HEARTS", card2.toString());
    }
    @Test
    public void suitAndRankCorrect3() {
        assertEquals("FOUR of DIAMONDS", card3.toString());
    }
    @Test
    public void fileNameCorrect() {
        assertEquals("ACESPADES.png", card.fileName());
    }
    @Test
    public void fileNameCorrect2() {
        assertEquals("KINGHEARTS.png", card2.fileName());
    }
    @Test
    public void fileNameCorrect3() {
        assertEquals("FOURDIAMONDS.png", card3.fileName());
    }
}
