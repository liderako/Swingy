package com.student.asvirido.swingy.module.hero;

import com.student.asvirido.swingy.module.AliveObject;
import com.student.asvirido.swingy.module.artefact.Inventory;
import com.student.asvirido.swingy.module.artefact.armor.Armor;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.weapon.Weapon;

public class Hero extends AliveObject{
    private String name;
    private int level;
    private Position position;
    private Position oldPosition;
    private Inventory inventory;

    public Hero(final HeroBuilder heroBuilder) {
        super(heroBuilder.getType());
        this.setAttack(heroBuilder.getAttack());
        this.setDefence(heroBuilder.getDefence());
        this.setExp(heroBuilder.getExperience());
        this.setHp(heroBuilder.getHp());
        this.setMaxHp(heroBuilder.getMaxHp());
        this.name = heroBuilder.getName();
        this.level = heroBuilder.getLevel();
        this.inventory = heroBuilder.getInventory();
        super.setHp(super.getHp() + this.inventory.getHelm().getBonusHp());
        initPosition();
    }

    public int getLevel() {
        return (level);
    }

    public String getName() {
        return (name);
    }

    public int getDefence() {
        return (super.getDefence() + inventory.getArmor().getDefence());
    }

    public int getAttack() {
        return (super.getAttack() + inventory.getWeapon().getDamage());
    }

    public int getHp() {
        return (super.getHp());
    }

    public Position getPosition() {
        return (position);
    }

    public Inventory getInventory() {
        return (inventory);
    }

    public void setHp(final int hp) {
        super.setHp(hp);
    }

    public void increaseExp(final int exp) {
        if (exp > 0) {
            setExp(getExp() + exp);
            increaseLevel();
        }
    }

    public void increaseLevel() {
        int needExp = getNeedExp();

        if (this.getExp() > needExp) {
           this.level += 1;
           super.setMaxHp(super.getMaxHp() + 25);
           super.setHp(super.getMaxHp());
           super.setAttack(super.getAttack() + 25);
           super.setDefence(super.getDefence() + 25);
           super.setExp(this.getExp() - needExp);
        }
    }

    public void equipHelm(final Helm helm) {
        Helm oldHelm = inventory.getHelm();

        super.setHp(super.getHp() - oldHelm.getBonusHp());
        inventory.setHelm(helm);
        super.setHp(super.getHp() + helm.getBonusHp());
    }

    public void equipArmor(final Armor armor) {
        inventory.setArmor(armor);
    }

    public void equipWeapon(final Weapon weapon) {
        inventory.setWeapon(weapon);
    }

    public void moveUp() {
        oldPosition = new Position(position.getX(), position.getY());
        position.setY(position.getY() - 1);
    }

    public void moveDown() {
        oldPosition = new Position(position.getX(), position.getY());
        position.setY(position.getY() + 1);
    }

    public void moveRight() {
        oldPosition = new Position(position.getX(), position.getY());
        position.setX(position.getX() + 1);
    }

    public void moveLeft() {
        oldPosition = new Position(position.getX(), position.getY());
        position.setX(position.getX() - 1);
    }

    public void run() {
        Position tmp;

        tmp = position;
        position = oldPosition;
        oldPosition = tmp;
    }

    public void log() {
        System.out.println("Type:" + super.getType());
        System.out.println("Name:" + name);

        System.out.println("Hp all:" + getHp());
        System.out.println("Hp hero:" + (super.getMaxHp()));
        System.out.println("Hp bonus:" + getInventory().getHelm().getBonusHp());

        System.out.println("Attack all: " + this.getAttack());
        System.out.println("Attack hero:" + (this.getAttack() - getInventory().getWeapon().getDamage()));
        System.out.println("Damage Weapon:" + getInventory().getWeapon().getDamage());

        System.out.println("Defence all:" + this.getDefence());
        System.out.println("Defence hero:" + (this.getDefence() - getInventory().getArmor().getDefence()));
        System.out.println("Defence Armor:" + getInventory().getArmor().getDefence());

        System.out.println("Exp:" + super.getExp() + "/" + getNeedExp());
        System.out.println("Level:" + level);
        System.out.println("Weapon:" + getInventory().getWeapon().getType());
        System.out.println("Armor:" + getInventory().getArmor().getType());
        System.out.println("Helm:" + getInventory().getHelm().getType());
    }

    public String getLog() {
        String s = "";

        s += (" Type:" + super.getType() + "\n");
        s +=(" Name:" + name + "\n");

        s += (" Hp all:" + getHp() + "\n");
        s += (" Hp hero:" + (super.getMaxHp()) + "\n");
        s += (" Hp bonus:" + getInventory().getHelm().getBonusHp() + "\n");

        s += (" Attack all: " + this.getAttack() + "\n");
        s += (" Attack hero:" + (this.getAttack() - getInventory().getWeapon().getDamage()) + "\n");
        s += (" Damage Weapon:" + getInventory().getWeapon().getDamage() + "\n");

        s += (" Defence all:" + this.getDefence() + "\n");
        s += (" Defence hero:" + (this.getDefence() - getInventory().getArmor().getDefence()) + "\n");
        s += (" Defence Armor:" + getInventory().getArmor().getDefence() + "\n");

        s += (" Exp:" + super.getExp() + "/" + getNeedExp() + "\n");
        s += (" Level:" + level + "\n");
        s += (" Weapon:" + getInventory().getWeapon().getType() + "\n");
        s += (" Armor:" + getInventory().getArmor().getType() + "\n");
        s += (" Helm:" + getInventory().getHelm().getType() + "\n");
        return (s);
    }

    public int getNeedExp() {
        return ((level * 1000 + (level - 1) * (level - 1) * 450));
    }

    public void initPosition() {
        int sizeMap = ((getLevel() - 1) * 5 + 10 - (getLevel() % 2));
        this.position = new Position( sizeMap / 2, sizeMap / 2  );
    }
}