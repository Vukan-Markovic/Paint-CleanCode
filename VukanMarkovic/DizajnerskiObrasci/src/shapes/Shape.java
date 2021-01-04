package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private Color outerColor = Color.BLACK;
	public static final int SELECT_RECTANGLE_GAP = 3;

	public Shape() {
	}

	Shape(boolean selected, Color innerColor) {
		this.selected = selected;
		this.outerColor = innerColor;
	}

	public abstract boolean contains(int xCoordinate, int yCoordinate);

	public abstract void draw(Graphics graphics);
	
	public abstract void drawSelection(Graphics graphics);

	public boolean isSelected() {
		return selected;
	}

	public Color getOuterColor() {
		return outerColor;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}
}