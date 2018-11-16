package com.student.asvirido.swingy.module.database;

import com.student.asvirido.swingy.module.artefact.Inventory;
import com.student.asvirido.swingy.module.artefact.InventoryBuilder;
import com.student.asvirido.swingy.module.artefact.armor.FactoryArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;
import org.json.simple.JSONObject;

import java.sql.*;

public class DataManager {
    private Connection connection;
    private Statement statement;

    public DataManager() throws Exception {
        Class.forName("org.sqlite.JDBC");
        this.connection = DriverManager.getConnection("jdbc:sqlite:gameBase.db");
        this.statement = connection.createStatement();
        createTable();
    }

    public void end() throws Exception {
        this.connection.close();
    }

    public boolean createHero(final Hero hero) throws SQLException {
        String sql;
            sql = "insert into heroes(id, type, name, level, exp, hp, attack, defence, weapon, armor, helm)" +
                    "values(" +
                    "'" + getIdType(hero.getType()) + "'," +
                    "'" + hero.getType() + "'," +
                    "'" + hero.getName() + "'," +
                    hero.getLevel() + "," +
                    hero.getExp() + "," +
                    hero.getMaxHp() + "," +
                    hero.getAttack() + "," +
                    hero.getDefence() + "," +
                    "'" + hero.getInventory().getWeapon().getType() + "'," +
                    "'" + hero.getInventory().getArmor().getType() + "'," +
                    "'" + hero.getInventory().getHelm().getType() + "'" +
                    ");";
        this.statement.execute(sql);
        return (true);
    }

    public boolean deleteHero(final String type) throws SQLException {
        String sql = "delete from heroes" +
                " where id = " + getIdType(type) + ";";
        this.statement.executeUpdate(sql);
        return (true);
    }

    public boolean saveHero(final Hero hero) throws SQLException {
        String sql;
        sql = "update heroes" +
                " set level = " + hero.getLevel() +
                ", exp = " + hero.getExp() +
                ", hp = " + hero.getMaxHp() +
                ", attack = " + (hero.getAttack() - hero.getInventory().getWeapon().getDamage()) +
                ", defence = " + (hero.getDefence() - hero.getInventory().getArmor().getDefence()) +
                ", weapon = '" + hero.getInventory().getWeapon().getType() +
                "', armor = '" + hero.getInventory().getArmor().getType() +
                "', helm = '" + hero.getInventory().getHelm().getType() +
                "' where id = " + getIdType(hero.getType()) +";";
        System.out.println(sql);
        this.statement.executeUpdate(sql);
        return (true);
    }

    public Hero loadHero(final String type) throws SQLException {

        ResultSet r = statement.executeQuery("select * from heroes where " + "heroes.ID = " + getIdType(type));
        Hero hero = new HeroBuilder()
                .type(r.getString(2))
                .name(r.getString(3))
                .level(r.getInt(4))
                .experience(r.getInt(5))
                .hp(r.getInt(6))
                .maxHp(r.getInt(6))
                .attack(r.getInt(7))
                .defence(r.getInt(8))
                .inventory(new InventoryBuilder()
                        .weapon(r.getString(9))
                        .armor(r.getString(10))
                        .helm(r.getString(11))
                        .build())
                .build();
        return (hero);
    }

    private void createTable() throws SQLException {
        String sql = "create table if not exists heroes (" +
                "ID int NOT NULL," +
                "type varchar(32) NOT NULL," +
                "name varchar(32) not null," +
                "level int not null," +
                "exp int not null," +
                "hp int not null," +
                "attack int not null," +
                "defence int not null," +
                "weapon varchar(64) not null," +
                "armor varchar(64) not null," +
                "helm varchar(64) not null," +
                "PRIMARY KEY(ID)" +
                ");";
        this.statement.executeUpdate(sql);
    }

    public JSONObject getHeroes() throws SQLException{
        JSONObject obj = new JSONObject();
        ResultSet rType = statement.executeQuery("select type, name from heroes");

        while (rType.next()) {
            String type = rType.getString("type");
            String name = rType.getString("name");
            obj.put(type, name);
        }
        if (obj.get("Monk") == null) {
            obj.put("Monk", "not exists");
        }
        if (obj.get("Warrior") == null) {
            obj.put("Warrior", "not exists");
        }
        if (obj.get("Archer") == null) {
            obj.put("Archer", "not exists");
        }
        if (obj.get("Rogue") == null) {
            obj.put("Rogue", "not exists");
        }
        return (obj);
    }

    private int getIdType(final String type) {
        if (type.equals("Warrior")) {
            return (1);
        }
        else if (type.equals("Archer")) {
            return (2);
        }
        else if (type.equals("Rogue")) {
            return (3);
        }
        else if (type.equals("Monk")) {
            return (4);
        }
        return (0);
    }
}
