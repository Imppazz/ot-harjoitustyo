package vesiputous.domain;

public class Rule {
    
    private Card card;
    private String rule;
    
    public Rule(Card card, String rule) {
        this.card = card;
        this.rule = rule;
    }
    public Card getCard() {
        return this.card;
    }
    public String getRule() {
        return this.rule;
    }
    @Override
    public String toString() {
        return this.card + ": " + this.rule;
    }
}
