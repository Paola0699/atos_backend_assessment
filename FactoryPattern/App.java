package FactoryPattern;

public class App {
	 public static void main(String[] args) {
	      ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle and call its draw method.
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call draw method of Circle
	      shape1.draw();

	      //get an object of Rectangle and call its draw method.
	      Shape shape2 = shapeFactory.getShape("TRIANGLE");

	      //call draw method of Rectangle
	      shape2.draw();
	   }
}
