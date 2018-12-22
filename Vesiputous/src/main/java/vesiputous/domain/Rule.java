package vesiputous.domain;

/**
 *
 * @author Ilmari
 */
public class Rule {

    private Card card;
    private String rule;
    private RuleSet ruleSet;

    /**
     *
     * @param card
     * @param rule
     * @param ruleSet
     */
    public Rule(Card card, String rule, RuleSet ruleSet) {
        this.card = card;
        this.rule = rule;
        this.ruleSet = ruleSet;
    }

    public Card getCard() {
        return this.card;
    }

    public String getRule() {
        return this.rule;
    }

    public RuleSet getRuleSet() {
        return this.ruleSet;
    }

    @Override
    public String toString() {
        return this.card + ": " + this.rule;
    }
}
