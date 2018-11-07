package com.student.asvirido.swingy.module.hero;

import com.student.asvirido.swingy.module.AliveObject;
import com.student.asvirido.swingy.module.Position;
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
        this.setMaxHp(heroBuilder.getHp());
        this.name = heroBuilder.getName();
        this.level = heroBuilder.getLevel();
        this.inventory = heroBuilder.getInventory();
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
        return (super.getHp() + inventory.getHelm().getBonusHp());
    }

    public Position getPosition() {
        return (position);
    }

    public Inventory getInventory() {
        return (inventory);
    }

    public void setHp(final int hp) {
        if (hp > 0) {
            super.setHp(hp);
        }
    }

    public void increaseExp(final int exp) {
        if (exp > 0) {
            setExp(getExp() + exp);
            increaseLevel();
        }
    }

    public void increaseLevel() {
        int needExp = (level * 1000 + (level - 1) * (level - 1) * 450);
        if (this.getExp() > needExp) {
           this.level += 1;
           super.setMaxHp(super.getMaxHp() + 25);
           super.setHp(super.getMaxHp());
           super.setAttack(super.getAttack() + 10);
           super.setDefence(super.getDefence() + 10);
           super.setExp(0);
        }
    }

    public Helm equipHelm(final Helm helm) {
        Helm oldHelm = inventory.getHelm();

        inventory.setHelm(helm);
        return (oldHelm);
    }

    public Armor equipArmor(final Armor armor) {
        Armor oldArmor = inventory.getArmor();

        inventory.setArmor(armor);
        return (oldArmor);
    }

    public Weapon equipWeapon(final Weapon weapon) {
        Weapon oldWeapon = inventory.getWeapon();

        inventory.setWeapon(weapon);
        return (oldWeapon);
    }

    public void moveUp() {
        oldPosition = position;
        position.setY(position.getY() - 1);
    }

    public void moveDown() {
        oldPosition = position;
        position.setY(position.getY() + 1);
    }

    public void moveRight() {
        oldPosition = position;
        position.setX(position.getX() + 1);
    }

    public void moveLeft() {
        oldPosition = position;
        position.setX(position.getX() - 1);
    }

    public void run() {
        Position tmp;

        tmp = position;
        position = oldPosition;
        oldPosition = tmp;
    }
}
