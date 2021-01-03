package mvc;

import java.util.ArrayList;
import java.util.List;

import shapes.Shape;

public class DrawingModel {
	private List<Shape> shapes;
	private List<Shape> selectedShapes;

	public DrawingModel() {
		shapes = new ArrayList<Shape>();
		selectedShapes = new ArrayList<Shape>();
	}

	public void selectShape(Shape shape) {
		for (int indexOfShape = 0; indexOfShape < shapes.size(); indexOfShape++) {
			if (shapes.get(indexOfShape).equals(shape)) {
				shapes.get(indexOfShape).setSelected(true);
				selectedShapes.add(shape);
			}
		}
	}

	public Shape getFirstSelectedShape() {
		for (Shape shape : shapes) {
			if (shape != null && shape.isSelected())
				return shape;
		}

		return null;
	}

	public int getIndexOfShape(Shape shape) {
		return shapes.indexOf(shape);
	}

	public List<Shape> getSelectedShapes() {
		return selectedShapes;
	}

	public void setSelectedShapes(List<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	public Shape getShapeByIndex(int indexOfShape) {
		return shapes.get(indexOfShape);
	}
}