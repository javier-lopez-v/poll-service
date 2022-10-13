package com.mx.poll.model;

public enum Selection {

	A_FAVOR("A FAVOR"), EN_CONTRA("EN CONTRA"), PREFIERO_NO_CONTESTAR("PREFIERO NO CONTESTAR");

	private final String displayName;

	Selection(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
