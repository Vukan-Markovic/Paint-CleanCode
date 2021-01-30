package shapes;

import java.awt.*;

public class Rectangle extends SurfaceShape {
	private static final long serialVersionUID = 1L;
	private Point upperLeftPoint;
	private int height;
	private int width;

	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color borderColor,
			Color fillColor) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
		setBorderColor(borderColor);
		setFillColor(fillColor);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(getBorderColor());
		graphics.drawRect(upperLeftPoint.getXcoordinate(), upperLeftPoint.getYcoordinate(), width, height);
		fillShape(graphics);

		if (isSelected()) {
			graphics.setColor(getSelectionColor());
			drawSelection(graphics);
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
		graphics.setColor(getFillColor());
		graphics.fillRect(upperLeftPoint.getXcoordinate(), upperLeftPoint.getYcoordinate(), width, height);
	}

	@Override
	protected void drawSelection(Graphics graphics) {
		int xCoordinate = upperLeftPoint.getXcoordinate();
		int yCoordinate = upperLeftPoint.getYcoordinate();
		graphics.drawRect(xCoordinate - 3, yCoordinate - 3, 6, 6);
		graphics.drawRect(xCoordinate - 3 + getWidth(), yCoordinate - 3, 6, 6);
		graphics.drawRect(xCoordinate - 3, yCoordinate - 3 + getHeight(), 6, 6);
		graphics.drawRect(xCoordinate + getWidth() - 3, yCoordinate + getHeight() - 3, 6, 6);
	}

	@Override
	public boolean contains(int xCoordinate, int yCoordinate) {
		int upperLeftPointXcoordinate = upperLeftPoint.getXcoordinate();
		int upperLeftPointYcoordinate = upperLeftPoint.getYcoordinate();

		return upperLeftPointXcoordinate <= xCoordinate && xCoordinate <= upperLeftPointXcoordinate + width
				&& upperLeftPointYcoordinate <= yCoordinate && yCoordinate <= upperLeftPointYcoordinate + height;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) object;

			return upperLeftPoint.equals(rectangle.upperLeftPoint) && height == rectangle.height
					&& width == rectangle.width;
		}

		return false;
	}

	@Override
	public Rectangle clone() {
		return new Rectangle(upperLeftPoint.clone(), height, width, isSelected(), getBorderColor(), getFillColor());
	}

	@Override
	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", height: " + height + " , width: " + width
				+ " , Border color: " + getBorderColor().getRGB() + " , Fill color: " + getFillColor().getRGB();
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}