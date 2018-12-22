package VesiputousTest.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vesiputous.domain.Card;
import vesiputous.domain.Rank;
import vesiputous.domain.Rule;
import vesiputous.domain.RuleSet;
import vesiputous.domain.Suit;

public class RuleTest {

    Card card;
    Rule rule;
    RuleSet ruleSet;

    @Before
    public void setUp() {
        card = new Card(Suit.SPADES, Rank.ACE);
        ruleSet = new RuleSet("test");
        rule = new Rule(card, "Lemmy", ruleSet);
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
        assertEquals("test", rule.getRuleSet().toString());
    }

    @Test
    public void toStringCorrect() {
        assertEquals("ACE of SPADES: Lemmy", rule.toString());
    }
}
