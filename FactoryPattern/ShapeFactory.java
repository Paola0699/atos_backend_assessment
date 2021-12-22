package FactoryPattern;

public class ShapeFactory {
	   public Shape getShape(String shapeType){
		   switch(shapeType) {
			   case "CIRCLE":
				   return new Circle();
			   case "TRIANGLE":
				   return new Triangle();
			   default:
				   return null;
		   }
	   }
}
