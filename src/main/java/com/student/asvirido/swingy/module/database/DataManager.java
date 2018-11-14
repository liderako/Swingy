package com.student.asvirido.swingy.module.database;

import com.student.asvirido.swingy.module.artefact.Inventory;
import com.student.asvirido.swingy.module.artefact.armor.FactoryArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;

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

    public boolean saveHero(final Hero hero) throws SQLException {
        String sql;
            sql = "insert into heroes(id, type, name, level, exp, hp, max_hp, attack, defence, weapon, armor, helm)" +
                    "values(" +
                    "'" + getIdType(hero.getType()) + "'," +
                    "'" + hero.getType() + "'," +
                    "'" + hero.getName() + "'," +
                    hero.getLevel() + "," +
                    hero.getExp() + "," +
                    hero.getHp() + "," +
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

    public Hero loadHero(final String type) throws SQLException {
        String sql = "SELECT COUNT(*) FROM online WHERE ID";

        ResultSet r = statement.executeQuery("select * from heroes where " + "heroes.ID = " + getIdType(type));
        Inventory i = new Inventory();

        i.setWeapon(FactoryWeapon.newWeapon(r.getString(10)));
        i.setArmor(FactoryArmor.newArmor(r.getString(11)));
        i.setHelm(FactoryHelm.newHelm(r.getString(12)));

        Hero hero = new HeroBuilder()
                .type(r.getString(2))
                .name(r.getString(3))
                .level(r.getInt(4))
                .experience(r.getInt(5))
                .hp(r.getInt(6))
                .maxHp(r.getInt(7))
                .attack(r.getInt(8))
                .defence(r.getInt(9))
                .inventory(i)
                .build();
        return hero;
    }

    private void createTable() throws SQLException {
        String sql = "create table if not exists heroes (" +
                "ID int NOT NULL," +
                "type varchar(32) NOT NULL," +
                "name varchar(32) not null," +
                "level int not null," +
                "exp int not null," +
                "hp int not null," +
                "max_hp int not null," +
                "attack int not null," +
                "defence int not null," +
                "weapon varchar(64) not null," +
                "armor varchar(64) not null," +
                "helm varchar(64) not null," +
                "PRIMARY KEY(ID)" +
                ");";
        this.statement.executeUpdate(sql);
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
