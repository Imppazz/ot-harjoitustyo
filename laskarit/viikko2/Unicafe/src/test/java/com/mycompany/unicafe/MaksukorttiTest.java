package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void saldoAlussaOikein() {
        assertTrue(kortti.saldo() == 10);      
    }
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(150);
        assertEquals("saldo: 1.60", kortti.toString());
    }
    @Test
    public void saldoVaheneeOikeinKunTarpeeksiRahaa() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo() == 5);
    }
    @Test
    public void saldoEiVaheneKunEiTarpeeksiRahaa() {
        kortti.otaRahaa(15);
        assertTrue(kortti.saldo() == 10);
    }
    @Test
    public void palauttaaTrueKunRahatRiittavat() {
        kortti.otaRahaa(4);
        assertTrue(kortti.otaRahaa(5) == true);
    }
    @Test
    public void palauttaaFalseKunRahatEivatRiita() {
        assertTrue(kortti.otaRahaa(12) == false);
    }
}
