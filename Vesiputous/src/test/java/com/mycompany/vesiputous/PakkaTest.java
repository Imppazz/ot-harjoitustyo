package com.mycompany.vesiputous;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PakkaTest {
    
    Pakka pakka;
    
    @Before
    public void setUp() {
        pakka = new Pakka();
    }
    @Test
    public void nostaminenVahentaaKortteja() {
        pakka.nostaPakasta();
        pakka.nostaPakasta();
        pakka.nostaPakasta();
        assertEquals(pakka.korttejaJaljella(), 49);
    }
    @Test
    public void nostaminenPalauttaaNostetunKortin() {
        assertEquals(pakka.nostaPakasta().toString(), "Hertta Ässä");
    }
    @Test
    public void nostaminenPalauttaaNullKunPakkaLoppuu() {
        for (int i = 1; i <= 52; i++) {
            pakka.nostaPakasta();
        }
        assertEquals(pakka.nostaPakasta(), null);
    }
}
