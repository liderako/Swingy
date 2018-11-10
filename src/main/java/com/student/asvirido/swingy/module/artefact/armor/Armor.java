package com.student.asvirido.swingy.module.artefact.armor;

import com.student.asvirido.swingy.module.GameObject;

public class Armor extends GameObject {
	private final int defence;

	public Armor(final int defence, final String type) {
		super(type);
		this.defence = defence;
	}

	public int getDefence() {
		return (this.defence);
	}
}
