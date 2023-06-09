
// import class
import java.lang.String;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.text.DateFormatter;

import com.learn.j50.NewDevcampApp;
import com.learn3.javabasic.s10.Order;
import com.learn3.javabasic.s10.Person;
import com.learn4.javabasic.s10.CAnimal;
import com.learn4.javabasic.s10.CBird;
import com.learn4.javabasic.s10.CDog;
import com.learn4.javabasic.s10.CFish;
import com.learn4.javabasic.s10.CPerson;
import com.learn4.javabasic.s10.CPet;

public class App {
    public static void main(String[] args) throws Exception {
        // String type
        // System.out.println = "sout" + tab
        // Check error = F5
        // Run not check error = Ctrl + F5
        // String myName = "Nguyen tran quoc Toan";

        // System.out.println("My name is" + myName);

        // System.out.println(myName.toUpperCase());
        // System.out.println(myName.toLowerCase());
        // System.out.println("Length of string (contain spacing) " + myName.length());
        // // System.out.println(myName.toTitleCase()); Java version > 11
        // System.out.println("========================");
        // System.out.println("Hello, First Java!");
        // System.out.println("Tui là Toàn nè");

        // ArrayList abc = new ArrayList();
        // NewDevcampApp text = new NewDevcampApp();
        // System.out.println(
        // "Hello, World! My name is " + text.name4(" TOAN ", 20,
        // "toan@gmail.com").toUpperCase().toLowerCase());
        // System.out.println("Hello, World! My name is " + text.name3(" TOAN",
        // 20).toUpperCase().toLowerCase());
        // System.out.println("Hello, World! My name is " + text.name2(" TOAN
        // ").length());

        // ==============================================
        // // Learn 3.1
        // LocalDateTime myDateObj = LocalDateTime.now();
        // System.out.println("Before formatting : " + myDateObj);

        // DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy
        // HH:mm:ss");

        // String formattedDate = myDateObj.format(myFormatter);
        // System.out.println("After formatting : " + formattedDate);

        // App app = new App();
        // System.out.println(app.niceDay());
        // System.out.println(app.getVietNamDate());

        // ArrayList<Person> arrayList3 = new ArrayList<>();
        // // Khởi tạo các tham số
        // Person person0 = new Person();
        // Person person1 = new Person("Toan");
        // Person person2 = new Person("Toàn2", 55, 23.4);
        // Person person3 = new Person("Nam", 44, 332.5, 3440505, new String[] {
        // "Monkey", "Dog" });
        // Person person4 = new Person("Hải", 44, 332.5, 438333, new String[] { "Cat",
        // "Dog", "Snake" });

        // // Add person obj to Array list
        // arrayList3.add(person0);
        // arrayList3.add(person1);
        // arrayList3.add(person2);
        // arrayList3.add(person3);
        // arrayList3.add(person3);
        // arrayList3.add(person4);

        // // Print to screen
        // for (Person person : arrayList3) {
        // System.out.println(person);
        // }

        // Lean 3.2
        ArrayList<Order> orderArrayList = new ArrayList<>();
        Order order1 = new Order();
        Order order2 = new Order("Nguyen");
        Order order3 = new Order(1, "Toan", 4334322);
        Order order4 = new Order(33, "Tran", 398239, new Date(), false, new String[] { "Hot Dog", "Bugerking" });

        orderArrayList.add(order1);
        orderArrayList.add(order2);
        orderArrayList.add(order3);
        orderArrayList.add(order4);

        for (Order order : orderArrayList) {
            System.out.println(order);
        }

        // Learn 4.1
        CAnimal nameA2 = new CFish();
        CPet nameP2 = new CBird();
        CPet dog2 = new CDog(4, "Lucky");

        CPerson namePerson = new CPerson();
        namePerson.setAge(40);
        namePerson.setFirstName("Tokuda");
        ArrayList<CPet> petsList = new ArrayList();
        petsList.add(nameP2);
        petsList.add((CPet) nameA2);
        namePerson.setPets(petsList);
        System.out.println(namePerson);
    }

    public String niceDay() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        Date now = new Date();
        return String.format("Have a nice day. It is %s!.", dateFormat.format(now));
    }

    public String getVietNamDate() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE,dd-MMMM-yyyy")
                .localizedBy(Locale.forLanguageTag("vi"));
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        return String.format("Hôm nay là %s là ngày con khỉ leo cây.", myFormatObj.format(today));
    }

}
