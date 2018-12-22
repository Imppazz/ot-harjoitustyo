# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/perusrakenne.PNG" width="400">

Pakkaus _vesiputous.gui_ sisältää JavaFX:llä toteutetun graafisen käyttöliittymän, _vesiputous.domain_ sovelluslogiikan ja _vesiputous.dao_ tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

Käyttöliittymässä on kolme erillistä näkymää
- alkunäkymä (päävalikko)
- uuden sääntösetin luominen
- pelinäkymä ja sen mukana sääntönäkymä

jokainen näkymä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. Näkymät on sijoitettu yksikerrallaan samaan [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html), paitsi sääntönäkymä, joka on näkyvillä pelinäkymän kanssa samaan aikaan omassa stagessaan. Käyttöliittymän koodi löytyy luokasta [vesiputous.gui.GUI](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/main/java/vesiputous/gui/GUI.java).

## Sovelluslogiikka

Sovelluslogiikka on pyritty toteuttamaan pakkauksen _vesiputous.domain_ luokissa [Card](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/main/java/vesiputous/domain/Card.java), [Deck](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/main/java/vesiputous/domain/Deck.java), [Rule](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/main/java/vesiputous/domain/Rule.java) ja [RuleSet](https://github.com/Imppazz/ot-harjoitustyo/blob/master/Vesiputous/src/main/java/vesiputous/domain/RuleSet.java)

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Sovelluslogiikka.PNG" width="400">

## Tietojen pysyväistallennus

Pakkauksen _vesiputous.dao_ luokat _RuleDao_ ja _RuleSetDao_ huolehtivat tietojen tallettamisesta tiedostoihin.

Luokat tallentavat ja hakevat tietoa tietokannan _VesiputousDatabase.db_ tauluista _Rule_ ja _RuleSet_

### Päätoiminnallisuudet

Päätoiminnallisuudet sekvenssikaavioina.

#### Kortien hakeminen pelinäkymässä

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/Sekvenssikaavio.PNG" width="400">

#### Säännön hakeminen pelinäkymässä

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/saannonhaku.PNG" width="750">

#### Sääntösetin tallennus

Ensin painamalla nappia next, tarkistetaan löytyykö syötetty nimi varattu.

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/next.PNG" width="750">

Sitten kun kaikille korteille on määritetty sääntö nappi _Save ruleset_ tallentaa säännöt tauluun _Rule_ ja sääntösetin tauluun _RuleSet_

<img src="https://github.com/Imppazz/ot-harjoitustyo/blob/master/dokumentaatio/Kuvat/saantotallennus.PNG" width="750">


## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Graafinen käyttöliittymä on kokonaan yhdessä luokassa ja siellä yhdessä metodissa (lukuunottamatta metodia setCardLayout, joka on luotu siksi, että sen sisältämä koodi oli GUI:n koodissa kahteen kertaan). Tästä johtuen koodi sisältää erittäin monta muuttujaa ja koodiriviä, mikä tekee koodista vaikealukuisen.
