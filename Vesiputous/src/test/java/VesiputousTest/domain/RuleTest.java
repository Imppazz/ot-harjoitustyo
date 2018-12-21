package VesiputousTest.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vesiputous.domain.Card;
import vesiputous.domain.Rank;
import vesiputous.domain.Rule;
import vesiputous.domain.Suit;

public class RuleTest { 
    
    Card card;
    Rule rule;
    
    @Before
    public void setUp() {
        card = new Card(Suit.SPADES, Rank.ACE);
        rule = new Rule(card, "Lemmy", "test");
    }
    @Test
    public void getCardCorrect() {
        assertEquals("ACE of SPADES", rule.getCard().toString());
    }
    @Test
    public void getRuleCorrect() {
        assertEquals("Lemmy", rule.getRule());
    }
    @Test
    public void getRuleSetNameCorrect() {
        assertEquals("test", rule.getRuleSetName());
    }
    @Test
    public void toStringCorrect() {
        assertEquals("ACE of SPADES: Lemmy", rule.toString());
    }
}
