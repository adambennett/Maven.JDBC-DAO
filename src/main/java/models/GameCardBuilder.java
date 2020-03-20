package models;

public class GameCardBuilder {
    private Integer id;
    private Integer atk;
    private Integer def;
    private Integer lvl;
    private String name;
    private String type;
    private String effect;

    public GameCardBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public GameCardBuilder setAtk(Integer atk) {
        this.atk = atk;
        return this;
    }

    public GameCardBuilder setDef(Integer def) {
        this.def = def;
        return this;
    }

    public GameCardBuilder setLvl(Integer lvl) {
        this.lvl = lvl;
        return this;
    }

    public GameCardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GameCardBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public GameCardBuilder setEffect(String effect) {
        this.effect = effect;
        return this;
    }

    public GameCard createGameCard() {
        return new GameCard(id, atk, def, lvl, name, type, effect);
    }
}