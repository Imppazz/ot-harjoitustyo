package com.mycompany.vesiputous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pakka {
    
    private static ArrayList<Kortti> kortit;
    
    public Pakka() {
        kortit = new ArrayList<>();
        for (int i = 0; i <= 12; i++){
            for (int j = 0; j <= 3; j++){
               kortit.add(new Kortti(j, i));
            }
        }
    }
    public void sekoita() {
        Collections.shuffle(kortit, new Random());
    }
    public Kortti nostaPakasta(){ 
        if (!kortit.isEmpty()) {
            return kortit.remove(0);
        }
        return null;
    }
    public int korttejaJaljella(){
        return kortit.size();
    }
}