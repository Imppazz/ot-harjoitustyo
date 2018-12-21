package VesiputousTest.domain;
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
    Card card4;
    Card card5;
    Card card6;
    
    @Before
    public void setUp() {
        card = new Card(Suit.SPADES, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.KING);
        card3 = new Card(Suit.DIAMONDS, Rank.FOUR);
        card4 = new Card("ACE;SPADES");
        card5 = new Card("KING;HEARTS");
        card6 = new Card("FOUR;DIAMONDS");
    }
    @Test
    public void suitAndRankCorrect() {
        assertEquals("ACE of SPADES", card.toString());
        assertEquals("ACE of SPADES", card4.toString());
    }
    @Test
    public void suitAndRankCorrect2() {
        assertEquals("KING of HEARTS", card2.toString());
        assertEquals("KING of HEARTS", card5.toString());
    }
    @Test
    public void suitAndRankCorrect3() {
        assertEquals("FOUR of DIAMONDS", card3.toString());
        assertEquals("FOUR of DIAMONDS", card6.toString());
    }
    @Test
    public void fileNameCorrect() {
        assertEquals("ACESPADES.png", card.fileName());
        assertEquals("ACESPADES.png", card4.fileName());
    }
    @Test
    public void fileNameCorrect2() {
        assertEquals("KINGHEARTS.png", card2.fileName());
        assertEquals("KINGHEARTS.png", card5.fileName());
    }
    @Test
    public void fileNameCorrect3() {
        assertEquals("FOURDIAMONDS.png", card3.fileName());
        assertEquals("FOURDIAMONDS.png", card6.fileName());
    }
    @Test
    public void cardAsStringCorrect() {
        assertEquals("ACE;SPADES", card.cardAsString());
        assertEquals("ACE;SPADES", card4.cardAsString());
    }
    @Test
    public void cardAsStringCorrect2() {
        assertEquals("KING;HEARTS", card2.cardAsString());
        assertEquals("KING;HEARTS", card5.cardAsString());
    }
    @Test
    public void cardAsStringCorrect3() {
        assertEquals("FOUR;DIAMONDS", card3.cardAsString());
        assertEquals("FOUR;DIAMONDS", card6.cardAsString());
    }
}
