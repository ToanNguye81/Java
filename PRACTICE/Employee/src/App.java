public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Employee employee = new Employee(0, null, null, 0);
        System.out.println(employee);
        Employee employee1 = new Employee(1, "Toàn", "Nguyễn", 20000);
        System.out.println(employee1);
    }
}
