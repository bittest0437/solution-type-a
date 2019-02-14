package problem03;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		System.out.println("Rectangle 초기화");
	}

	@Override
	public void resize(double rate) {
		width = width * rate;
		height = height * rate;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}
}