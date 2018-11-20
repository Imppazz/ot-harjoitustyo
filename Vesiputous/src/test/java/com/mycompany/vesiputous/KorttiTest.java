package com.mycompany.vesiputous;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KorttiTest {
    
    Kortti kortti;
    Kortti kortti2;
    Kortti kortti3;
    
    @Before
    public void setUp() {
        kortti = new Kortti(1,3);
        kortti2 = new Kortti(0,12);
        kortti3 = new Kortti(3,0);
    }
    @Test
    public void maaJaArvoOikein() {
        assertEquals("Pata 4", kortti.toString());
    }
    @Test
    public void maaJaArvoOikein2() {
        assertEquals("Hertta Kuningas", kortti2.toString());
    }
    @Test
    public void maaJaArvoOikein3() {
        assertEquals("Risti Ässä", kortti3.toString());
    }
}
