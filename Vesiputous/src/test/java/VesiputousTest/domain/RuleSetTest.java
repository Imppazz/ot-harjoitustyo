package VesiputousTest.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vesiputous.domain.RuleSet;

public class RuleSetTest {
    
    RuleSet ruleSet;
    
    @Before
    public void setUp() {
        this.ruleSet = new RuleSet("test");
    }
    @Test
    public void toStringCorrect() {
        assertEquals("test", ruleSet.toString());
    }
}
