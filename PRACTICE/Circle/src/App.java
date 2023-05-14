public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2);
        System.out.println("Information circle 1: " + circle1);
        System.out.println("Area Circle 1 = " + circle1.getArea());
        System.out.println("Information circle 2: " + circle2);
        System.out.println("Circuference Circle2 = " + circle1.getCircumference());
    }
}
