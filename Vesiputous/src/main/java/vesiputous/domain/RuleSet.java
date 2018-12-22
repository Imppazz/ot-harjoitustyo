package vesiputous.domain;

/**
 *
 * @author Ilmari
 */
public class RuleSet {

    private String name;

    /**
     *
     * @param name
     */
    public RuleSet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
