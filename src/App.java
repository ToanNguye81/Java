
// import class
import java.lang.String;
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

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting : " + myDateObj);

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatter);
        System.out.println("After formatting : " + formattedDate);

        App app = new App();
        System.out.println(app.niceDay());
        System.out.println(app.getVietNamDate());

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
