# Käyttöohje

Lataa tiedosto [Vesiputous.jar](https://github.com/Imppazz/ot-harjoitustyo/releases/tag/Viikko5)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on on tietokanta VesiputousDatabase.db. Jos tietokantaa ole käynnistyshakemistossa, ohjelma luo uuden ja toimii normaalisti, mutta silloin ohjelmasta ei löydy valmiiksi luotuja sääntösettejä ja käyttäjän pitää itse luoda sääntösettu päästäkseen pelaamaan.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar Vesiputous.jar
```

## Alkunäkymä

Sovellus käynnistyy alkunäkymään:

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/alkunakyma.PNG" width="400">

Alkunäkymän nappuloista _Start game_ aloittaa pelin valitulla sääntösetillä, _Delete chosen ruleset_ poistaa valitun sääntösetin ja _New ruleset_ avaa näkymän uuden sääntösetin luomiselle.

## Uuden sääntösetin luominen

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/lisaasaantoja.PNG" width="400">

Sääntösetinluomisnäkymässä pitää ensin antaa sääntösetille uniikki 1-50 kirjaiminen nimi. Nimen kirjoittamisen jälkeen nappi _Next_ mahdollistaa sääntöjen lisäämisen korteille. 

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/lisaasaantoja2.PNG" width="400">

Kun kaikille korteille on annettu sääntö nappi _Save ruleset_ tallentaa sääntösetin ja palauttaa käyttäjän alkunäkymään. Nappi _Cancel_ palauttaa käyttäjän, missä vain vaiheessa takaisin alkunäkymään tallentamatta mitään.

## Pelinäkymä

Kun käyttäjä on valinnut sääntösetin nappi _Start game_ avaa pelinäkymän.

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/pelinalku.PNG" width="200">

Nappi _Draw card_ nostaa virtuaalisesta korttipakasta uuden kortin. Nappi _Show rule_ näyttää valitusta sääntösetistä kortille annetun säännön. 

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/saanto.PNG" width="200">

Näkymän alareunassa näkyy jatkuvasti jäljellä olevien korttien määrä.
