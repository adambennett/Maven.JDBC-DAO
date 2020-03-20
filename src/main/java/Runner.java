import daos.*;
import models.*;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Runner {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.initialize();
    }

    public void initialize() {
        Accessor db = new Accessor();
        GameCard newCard = new GameCardBuilder()
                .setAtk(10)
                .setDef(20)
                .setEffect("Test")
                .setId(500)
                .setLvl(10)
                .setName("Test Card")
                .setType("MonsterSpell")
                .createGameCard();
        db.create(newCard);
        db.create(newCard);

        Boolean deleted = db.delete(9);


        List<GameCard> foundList = db.findAll();

        GameCard found = db.findById(3);

        GameCard newBlueEyes = new GameCardBuilder()
                .setAtk(1)
                .setDef(2)
                .setLvl(3)
                .setName("Blue Eyes White Dragon")
                .setId(2)
                .setType("Spellster")
                .createGameCard();
        Boolean updated = db.update(newBlueEyes);

        String listOfCards = "";
        for (GameCard c : foundList) {
            listOfCards += c.getName() + "(" + c.getId() + ")\n";
        }
        Logger.getGlobal().info("\n\nDELETED: " + deleted + "\nFOUND: " + found.getName() + "(" + found.getId() + ")\nUPDATED: " + updated + "\nLIST: " + listOfCards);
    }
}
