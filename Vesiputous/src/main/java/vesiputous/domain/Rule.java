package vesiputous.domain;

public class Rule {
    
    private Card card;
    private String rule;
    private String ruleSetName;
    
    public Rule(Card card, String rule, String ruleSetName) {
        this.card = card;
        this.rule = rule;
        this.ruleSetName = ruleSetName;
    }
    public Card getCard() {
        return this.card;
    }
    public String getRule() {
        return this.rule;
    }
    public String getRuleSetName() {
        return this.ruleSetName;
    }
    @Override
    public String toString() {
        return this.card + ": " + this.rule;
    }
}
