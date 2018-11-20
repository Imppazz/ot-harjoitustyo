package com.mycompany.vesiputous;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Pakka pakka = new Pakka();
        pakka.sekoita();
        System.out.print("Paina enter saadaksesi kortin");
        
        while(pakka.korttejaJaljella() > 0) {
            String komento = lukija.nextLine();
            if (komento.equals("")) System.out.print(pakka.nostaPakasta() + ", Kortteja jäjellä " + pakka.korttejaJaljella());
            else System.out.print("Paina enter saadaksesi kortin");
        }
    }   
}
