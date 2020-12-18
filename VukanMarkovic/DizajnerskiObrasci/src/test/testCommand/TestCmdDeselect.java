package test.testCommand;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import command.CmdDeselect;
import geometry.Point;
import geometry.Shape;
import mvc.DrawingModel;

public class TestCmdDeselect {
	private Shape shape;
	private DrawingModel model;
	private CmdDeselect cmdDeselect;
	
	@Before 
	public void setUp() {
		model = new DrawingModel();
		shape = new Point();
		model.add(shape);
		cmdDeselect = new CmdDeselect(shape, model);
	}

	@Test 
	public void testExecuteShapeUnselected() {
		cmdDeselect.execute();
		assertFalse(model.get(model.indexOfShape(shape)).isSelected());
	}
	
	@Test 
	public void testExecuteShapeRemovedFromSelectedShapes() {
		cmdDeselect.execute();
		assertFalse(model.getSelectedShapes().contains(shape));
	}
	
	@Test 
	public void testUnexecuteShapeSelected() {
		cmdDeselect.unexecute();
		assertTrue(model.get(model.indexOfShape(shape)).isSelected());
	}
	
	@Test 
	public void testUnexecuteShapeAddedToSelectedShapes() {
		cmdDeselect.unexecute();
		assertTrue(model.getSelectedShapes().contains(shape));
	}
}