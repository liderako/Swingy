package com.student.asvirido.swingy.module.artefact.helm;

import com.student.asvirido.swingy.module.GameObject;

public class Helm extends GameObject {
	private final int bonusHp;

	public Helm(final int bonusHp, final String type) {
		super(type);
		this.bonusHp = bonusHp;
	}

	public int getBonusHp() {
		return (this.bonusHp);
	}
}
