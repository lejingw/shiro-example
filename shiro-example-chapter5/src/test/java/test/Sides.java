package test;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class Sides implements Serializable {
	private int value;

	private Sides(int newVal) {
		value = newVal;
	}

	private static final int LEFT_VALUE = 1;
	private static final int RIGHT_VALUE = 2;
	private static final int TOP_VALUE = 3;
	private static final int BOTTOM_VALUE = 4;

	public static final Sides LEFT = new Sides(LEFT_VALUE);
	public static final Sides RIGHT = new Sides(RIGHT_VALUE);
	public static final Sides TOP = new Sides(TOP_VALUE);
	public static final Sides BOTTOM = new Sides(BOTTOM_VALUE);

	private Object readResolve() throws ObjectStreamException {
		// Switch on this instance's value to figure out which class variable
		// this is meant to match
		switch (value) {
		case LEFT_VALUE:
			return LEFT;
		case RIGHT_VALUE:
			return RIGHT;
		case TOP_VALUE:
			return TOP;
		case BOTTOM_VALUE:
			return BOTTOM;
		}
		return null;
	}
}