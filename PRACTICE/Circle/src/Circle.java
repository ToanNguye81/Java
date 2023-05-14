public class Circle {

    private double radius = 1.0;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle have radius  =" + radius + ", Area =" + new Circle(radius).getArea() + "and Circumference = "
                + new Circle(radius).getCircumference();
    }

}
