package daos;

import models.*;

import java.sql.*;
import java.util.*;

public class Accessor implements IAccess<GameCard> {

    public GameCard findById(int id) {
        Connection connection = Transferer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM yugioh WHERE id=" + id);
            if(rs.next())
            {
                GameCard card = null;
                try {
                    card = new GameCardBuilder()
                            .setId(rs.getInt("id"))
                            .setAtk(Integer.parseInt(rs.getString("attack")))
                            .setDef(Integer.parseInt(rs.getString("defense")))
                            .setName(rs.getString("name"))
                            .setLvl(Integer.parseInt(rs.getString("level")))
                            .setType(rs.getString("type"))
                            .setEffect(rs.getString("effect"))
                            .createGameCard();
                } catch (NumberFormatException ignored) {}
                return card;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<GameCard> findAll() {
        Connection connection = Transferer.getConnection();
        ArrayList<GameCard> cards = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM yugioh");
            if(rs.next())
            {
                GameCard card = null;
                try {
                    card = new GameCardBuilder()
                            .setAtk(Integer.parseInt(rs.getString("attack")))
                            .setDef(Integer.parseInt(rs.getString("defense")))
                            .setName(rs.getString("name"))
                            .setLvl(Integer.parseInt(rs.getString("level")))
                            .setType(rs.getString("type"))
                            .setEffect(rs.getString("effect"))
                            .createGameCard();
                    cards.add(card);
                } catch (NumberFormatException ignored) {}
                return cards;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cards;
    }

    public Boolean update(GameCard dto) {
        Connection connection = Transferer.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE yugioh SET name=?, attack=?, defense=?, level=?,type=?,effect=? WHERE id=?");
            String atk;
            String def;
            String lvl;
            String eff;
            if (dto.getAtk() == null) {
                atk = "";
                def = "";
                lvl = "";
            } else {
                atk = "" + dto.getAtk();
                def = "" + dto.getDef();
                lvl = "" + dto.getLvl();
            }
            if (dto.getEffect() == null) {
                eff = "";
            } else {
                eff = dto.getEffect();
            }
            ps.setString(1, dto.getName());
            if (atk.equals("")) {
                ps.setNull(1, 1);
            } else {
                ps.setString(2, atk);
                ps.setString(3, def);
                ps.setString(4, lvl);
            }
            ps.setString(5, dto.getType());
            if (eff.equals("")) {
                ps.setNull(6, 1);
            } else {
                ps.setString(6, eff);
            }
            ps.setInt(7, dto.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean create(GameCard dto) {
        Connection connection = Transferer.getConnection();
        String name = dto.getName();
        String atk;
        String def;
        String lvl;
        if (dto.getAtk() == null) {
            atk = "";
            def = "";
            lvl = "";
        } else {
            atk = "" +dto.getAtk();
            def = "" + dto.getDef();
            lvl = "" + dto.getLvl();
        }
        String type = dto.getType();
        String eff;
        if (dto.getEffect() == null) {
            eff = "";
        } else {
            eff = dto.getEffect();
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO yugioh (name, attack, defense, level, type, effect) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            if (atk.equals("")) {
                ps.setNull(2, 1);
                ps.setNull(3, 1);
                ps.setNull(4, 1);
            } else {
                ps.setString(2, atk);
                ps.setString(3, def);
                ps.setString(4, lvl);
            }
            ps.setString(5, type);
            if (eff.equals("")) {
                ps.setNull(6, 1);
            } else {
                ps.setString(6, eff);
            }

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public Boolean delete(int id) {
        Connection connection = Transferer.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM yugioh WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
