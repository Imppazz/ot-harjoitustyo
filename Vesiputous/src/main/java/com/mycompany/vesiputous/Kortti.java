package com.mycompany.vesiputous;

public class Kortti {
    private int maa, arvo;
    private String[] maat = {"Hertta", "Pata", "Ruutu", "Risti"};
    private String[] arvot  = {"Ässä", "2", "3", "4", "5", "6", "7", "8",
                                "9", "10", "Jätkä", "Kuningatar", "Kuningas"};
    
    public Kortti(int maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }
    public String getMaa() {
        return maat[maa];
    }
    public String getArvo() {
        return arvot[arvo];
    }
    @Override
    public String toString(){
        return this.getMaa() + " " + this.getArvo();
    }
}
