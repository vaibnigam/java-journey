package OOPSheet;

/*Q4. Create a program of the class called "Shape" with abstract methods for calculating area 
and perimeter, and subclasses for "Rectangle", "Circle", and "Triangle".*/

public class Q4_Shape {
	public static void main(String[] args) {

		Rectangle r1 = new Rectangle(15.5, 16.5);
		System.out.println(r1.area());
		System.out.println(r1.perimeter());

		Rectangle r2 = new Rectangle(-15.5, 16.5);
		System.out.println(r2.area());
		System.out.println(r2.perimeter());
		r1.setLength(-10);
		System.out.println(r1.getLength());

		System.out.println("\n==========================================================================\n");

		Square s1 = new Square(10);
		System.out.println(s1.area());
		System.out.println(s1.perimeter());
		s1.setSide(-5);

		System.out.println("\n==========================================================================\n");

		Triangle t1 = new Triangle(10, 20, 25);
		System.out.println(t1);
		System.out.println(t1.area());
		System.out.println(t1.perimeter());

		System.out.println("\n==========================================================================\n");

		Circle c1 = new Circle(25);
		System.out.println(c1);
		System.out.println(c1.area());
		System.out.println(c1.perimeter());
	}
}

abstract class Shape {
	public abstract double area();

	public abstract double perimeter();
}

class Circle extends Shape {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public Circle(double radius) {
		if (radius > 0) {
			this.radius = radius;
		} else {
			System.out.println("Invalid radius, must be positive");
			this.radius = 0;
		}
	}

	public void setRadius(double radius) {
		if (radius > 0) {
			this.radius = radius;
		} else {
			System.out.println("Invalid radius, must be positive");
			this.radius = 0;
		}
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

}

class Triangle extends Shape {
	private double side1;
	private double side2;
	private double side3;

	public Triangle(double side1, double side2, double side3) {
		if (side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3 && side1 + side3 > side2
				&& side2 + side3 > side1) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		} else {
			System.out.println("Invalid triangle sides");
			this.side1 = 0;
			this.side2 = 0;
			this.side3 = 0;
		}
	}

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public double area() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	@Override
	public double perimeter() {
		return side1 + side2 + side3;
	}

}

class Square extends Shape {
	private double side;

	public Square(double side) {
		if (side > 0) {
			this.side = side;
		} else {
			System.out.println("Invalid side, must be positive");
			this.side = 0;
		}
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if (side > 0) {
			this.side = side;
		} else {
			System.out.println("Invalid side, must be positive");
			this.side = 0;
		}
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}

	@Override
	public double area() {

		return side * side;
	}

	@Override
	public double perimeter() {
		return 4 * side;
	}

}

class Rectangle extends Shape {

	private double length;
	private double width;

	public Rectangle(double length, double width) {
		if (length > 0 && width > 0) {
			this.length = length;
			this.width = width;
		} else {
			System.out.println("Invalid dimensions, both length and width must be positive");
			this.length = 0;
			this.width = 0;
		}
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0) {
			this.length = length;
		} else {
			System.out.println("Invalid length, must be positive");
			this.length = 0;
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0) {
			this.width = width;
		} else {
			System.out.println("Invalid width, must be positive");
			this.width = 0;
		}
	}

	@Override
	public double area() {
		return length * width;
	}

	@Override
	public double perimeter() {
		return 2 * (length + width);
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
}