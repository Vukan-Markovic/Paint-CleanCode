package shapes;

import java.awt.*;

public class Circle extends SurfaceShape {
	private static final long serialVersionUID = 1L;
	private Point center;
	private int radius;

	public Circle(Point center, int radius, boolean selected, Color outerColor, Color innerColor) {
		super(selected, outerColor, innerColor);
		this.center = center;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(getOuterColor());
		graphics.drawOval(center.getXcoordinate() - radius, center.getYcoordinate() - radius, radius * 2, radius * 2);
		fillShape(graphics);

		if (isSelected())
			drawSelection(graphics);
	}

	@Override
	protected void fillShape(Graphics graphics) {
		graphics.setColor(getInnerColor());
		graphics.fillOval(center.getXcoordinate() - radius, center.getYcoordinate() - radius, radius * 2, radius * 2);
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		new Line(new Point(center.getXcoordinate(), center.getYcoordinate() - radius, true, Color.WHITE),
				new Point(center.getXcoordinate(), center.getYcoordinate() + radius, true, Color.WHITE), true,
				Color.WHITE).drawSelection(graphics);
		
		new Line(new Point(center.getXcoordinate() - radius, center.getYcoordinate(), true, Color.WHITE),
				new Point(center.getXcoordinate() + radius, center.getYcoordinate(), true, Color.WHITE), true,
				Color.WHITE).drawSelection(graphics);
	}

	public boolean contains(int xCoordinate, int yCoordinate) {
		return center.calculateDistance(xCoordinate, yCoordinate) <= radius;
	}

	public boolean equals(Object object) {
		if (object instanceof Circle) {
			Circle circle = (Circle) object;
			return center.equals(circle.center) && this.radius == circle.radius;
		}

		return false;
	}

	public Circle clone() {
		return new Circle(center.clone(), radius, isSelected(), getOuterColor(), getInnerColor());
	}

	public String toString() {
		return "Center: " + center + ", radius: " + radius + " , Outer color: " + getOuterColor().getRGB()
				+ " , Inner color: " + getInnerColor().getRGB();
	}

	public Point getCenter() {
		return center;
	}

	public int getRadius() {
		return radius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}