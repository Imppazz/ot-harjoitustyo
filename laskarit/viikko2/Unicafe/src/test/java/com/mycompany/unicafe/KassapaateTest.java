package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti2 = new Maksukortti(100);
    }
    
    @Test
    public void kassapaateAlussaOikein() {
        assertTrue(paate.kassassaRahaa() == 100000 && paate.edullisiaLounaitaMyyty() == 0 && paate.maukkaitaLounaitaMyyty() == 0);
    }
    @Test
    public void maksuRiittavaEdullinen() {
        paate.syoEdullisesti(300);
        assertTrue(paate.kassassaRahaa() == 100240 && paate.edullisiaLounaitaMyyty() == 1);
    }
    @Test
    public void maksuRiittavaEdullinen2() {
        assertTrue(paate.syoEdullisesti(300) == 60);
    }
    @Test
    public void maksuEiRiittavaEdullinen() {
        paate.syoEdullisesti(200);
        assertTrue(paate.kassassaRahaa() == 100000 && paate.edullisiaLounaitaMyyty() == 0);
    }
    @Test
    public void maksuEiRiittavaEdullinen2() {
        assertTrue(paate.syoEdullisesti(200) == 200);
    }
    @Test
    public void maksuRiittavaMaukas() {
        paate.syoMaukkaasti(550);
        assertTrue(paate.kassassaRahaa() == 100400 && paate.maukkaitaLounaitaMyyty() == 1);
    }
    @Test
    public void maksuRiittavaMaukas2() {
        assertTrue(paate.syoMaukkaasti(550) == 150);
    }
    @Test
    public void maksuEiRiittavaMaukas() {
        paate.syoMaukkaasti(350);
        assertTrue(paate.kassassaRahaa() == 100000 && paate.maukkaitaLounaitaMyyty() == 0);
    }
    @Test
    public void maksuEiRiittavaMaukas2() {
        assertTrue(paate.syoMaukkaasti(350) == 350);
    }
    @Test
    public void kortillaTarpeeksiEdullinen() {
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 760 && paate.edullisiaLounaitaMyyty() == 1 && paate.kassassaRahaa() == 100000);
    }
    @Test
    public void kortillaTarpeeksiEdullinen2() {
        assertTrue(paate.syoEdullisesti(kortti));
    }
    @Test
    public void kortillaEiTarpeeksiEdullinen() {
        paate.syoEdullisesti(kortti2);
        assertTrue(kortti2.saldo() == 100 && paate.edullisiaLounaitaMyyty() == 0);
    }
    @Test
    public void kortillaEiTarpeeksiEdullinen2() {
        assertTrue(!paate.syoEdullisesti(kortti2));
    }
    @Test
    public void kortillaTarpeeksiMaukas() {
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 600 && paate.maukkaitaLounaitaMyyty() == 1 && paate.kassassaRahaa() == 100000);
    }
    @Test
    public void kortillaTarpeeksiMaukas2() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }
    @Test
    public void kortillaEiTarpeeksiMaukas() {
        paate.syoMaukkaasti(kortti2);
        assertTrue(kortti2.saldo() == 100 && paate.maukkaitaLounaitaMyyty() == 0);
    }
    @Test
    public void kortillaEiTarpeeksiMaukas2() {
        assertTrue(!paate.syoMaukkaasti(kortti2));
    }
    @Test
    public void kortilleLatausToimii() {
        paate.lataaRahaaKortille(kortti, 250);
        assertTrue(kortti.saldo() == 1250 && paate.kassassaRahaa() == 100250);
    }
    @Test
    public void kortilleLatausEiNegatiivisia() {
        paate.lataaRahaaKortille(kortti, -50);
        assertTrue(kortti.saldo() == 1000 && paate.kassassaRahaa() == 100000);
    }
}
