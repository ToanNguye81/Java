// import class
import com.learn.j50_javabasic.s10.NewDevcampApp;

public class App {
    public static void main(String[] args) throws Exception {
        // String type
        // System.out.println = "sout" + tab
        // Check error = F5
        // Run not check error = Ctrl + F5
        String myName = "Nguyen tran quoc Toan";
        
        System.out.println("My name is"+myName);

        System.out.println(myName.toUpperCase()); 
        System.out.println(myName.toLowerCase());
        System.out.println("Length of string (contain spacing) "+myName.length());
        // System.out.println(myName.toTitleCase()); Java version > 11
        System.out.println("========================");
        System.out.println("Hello, First Java!");
        System.out.println("Tui là Toàn nè");
        

        NewDevcampApp.name("Hoan", 24);
    }
}
