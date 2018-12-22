# Testausdokumentti

### sovelluslogiikka

Sovelluslogiikkaa eli pakkauksen _vesiputous.domain_ luokkia testaavat testiluokat [CardTest](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/test/java/VesiputousTest/domain/CardTest.java), [DeckTest](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/test/java/VesiputousTest/domain/DeckTest.java), [RuleTest](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/test/java/VesiputousTest/domain/RuleTest.java) ja [RuleSetTest](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/test/java/VesiputousTest/domain/RuleSetTest.java)

### DAO-luokat

DAO-luokkien testaus on suoritettu manuaalisesti.

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on vain 45% ja haarautumakattavuus vain 30%, koska en ehtinyt tehdä testejä dao-luokille.

<image src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/jacoco.PNG" width="800">

## Järjestelmätestaus

Järjestelmätestaus on suoritettu manuaalisesti.

### Toiminnallisuudet

Kaikki [määrittelydokumentissa](https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) ja [käyttöohjeessa](https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) mainitut toiminnot on testattu, joko automaattisilla testeillä tai manuaalisesti.

## Sovellukseen jääneet laatuongelmat

Sääntösetin poistaminen ei jostain syystä aina poista sääntösettiä valikosta, missä valitaan sääntösetti. En keksinyt miksi se välillä toimi ja välillä ei. Poistaminen kuitenkin poistaa sääntösetin ja säännöt tietokannasta aina, ja jos sovelluksen käynnistää uudelleen, poistettu sääntösetti on poistunut valikosta.
