package problem03;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		System.out.println("");
	}

	@Override
	public void resize(double rate) {
	}

	@Override
	public double getArea() {
		return 0.;
	}

	@Override
	public double getPerimeter() {
		return 0.;
	}
}