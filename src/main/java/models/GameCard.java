package models;

public class GameCard {

    private final Integer id;
    private final Integer atk;
    private final Integer def;
    private final Integer lvl;
    private final String name;
    private final String type;
    private final String effect;

    public GameCard(Integer id, Integer atk, Integer def, Integer lvl, String name, String type, String effect) {
        this.id = id;
        this.atk = atk;
        this.def = def;
        this.lvl = lvl;
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAtk() {
        return atk;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }
}
