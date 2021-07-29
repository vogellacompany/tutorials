package com.vogella.unittest.model;

/**
 * Race in Tolkien's Lord of the Rings.
 *
 * @author Florent Biville
 */
public enum Race {

	HOBBIT("Hobbit", false, Alignment.GOOD), MAIA("Maia", true, Alignment.GOOD), MAN("Man", false, Alignment.NEUTRAL),
	ELF("Elf", true, Alignment.GOOD), DWARF("Dwarf", false, Alignment.GOOD), ORC("Orc", false, Alignment.EVIL);

	private final String name;
	private final boolean immortal;
	private Alignment alignment;

	Race(String name, boolean immortal, Alignment alignment) {
		this.name = name;
		this.immortal = immortal;
		this.alignment = alignment;
	}

	public String getName() {
		return name;
	}

	public boolean isImmortal() {
		return immortal;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	@Override
	public String toString() {
		return "Race [name=" + name + ", immortal=" + immortal + "]";
	}
}