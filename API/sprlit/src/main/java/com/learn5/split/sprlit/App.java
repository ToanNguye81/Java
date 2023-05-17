package com.learn5.split.sprlit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class App {

    @CrossOrigin
    @GetMapping("/rainbow")
    public ArrayList<Rainbow> rainbows() {
        String[] colorList = { "red", "orange", "blue", "indigo", "violet", "yellow", "green" };
        ArrayList<Rainbow> rainbowColorList = new ArrayList<>();

        for (String color : colorList) {
            Rainbow rainbowColor = new Rainbow(color);
            rainbowColorList.add(rainbowColor);
        }
        return rainbowColorList;
    }

    @GetMapping("/employee")
    public ArrayList<Employee> employee() {
        Employee employee1 = new Employee(1, "Thái", "Nguyễn", 120000);
        Employee employee2 = new Employee(2, "Tuấn", "Trần", 14000);
        Employee employee3 = new Employee(3, "Nam", "Lê", 1100000);

        employee1.raiseSalary(10);
        employee2.raiseSalary(20);

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);

        return employeeArrayList;
    }

    @GetMapping("/circle-area")
    public ArrayList<Circle> circle() {
        // Circle
        Circle circle1 = new Circle(2, "red");
        Circle circle2 = new Circle(2, "green");
        Circle circle3 = new Circle(2, "blue");
        ArrayList<Circle> circleArrayList = new ArrayList<>();

        circleArrayList.add(circle1);
        circleArrayList.add(circle2);
        circleArrayList.add(circle3);
        return circleArrayList;

    }

    @GetMapping("/invoice-item")
    public ArrayList<InvoiceItem> invoice() {
        // InvoiceItem
        InvoiceItem invoiceItem1 = new InvoiceItem("1", "success", 10, 700.43);
        InvoiceItem invoiceItem2 = new InvoiceItem("2", "waiting", 10, 800.2);
        InvoiceItem invoiceItem3 = new InvoiceItem("5", "delivery", 10, 900.43);
        ArrayList<InvoiceItem> invoiceItemArrayList = new ArrayList<>();

        invoiceItemArrayList.add(invoiceItem1);
        invoiceItemArrayList.add(invoiceItem2);
        invoiceItemArrayList.add(invoiceItem3);
        return invoiceItemArrayList;

    }

    @GetMapping("/account")
    public ArrayList<Account> account() {
        // Account
        Account account1 = new Account("1", "Hải", 12000);
        Account account2 = new Account("2", "Tuấn", 14000);
        Account account3 = new Account("4", "Triều", 15000);
        ArrayList<Account> accountArrayList = new ArrayList<>();

        accountArrayList.add(account1);
        accountArrayList.add(account2);
        accountArrayList.add(account3);
        return accountArrayList;
    }

    @GetMapping("/length")
    public int length() {
        String newString = "Nguyễn Trần Quốc Toàn";
        int length = newString.length();
        return length;
    }

    @GetMapping("/checknumber")
    public ArrayList checknumber() {
        int number1 = 1;
        int number2 = 2;
        String result1 = new OddEvenChecker(number1).isEven();
        String result2 = new OddEvenChecker(number2).isEven();

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(result1);
        resultList.add(result2);

        return resultList;

    }

    @GetMapping("/country")
    public ArrayList<Country> regions() {
        String[] countryCode = { "VN", "US", "CA", "TL", "AU" };
        String[] countryName = { "Việt Nam", "America", "Campuchia", "Thái Lan", "Australia" };
        ArrayList<Country> countries = new ArrayList<>();

        for (int index = 0; index < countryCode.length; index++) {
            String name = countryName[index];
            String code = countryCode[index];
            Country country = new Country(code, name);
            countries.add(country);
        }

        String[] regionCode = { "GL", "HP", "LC" };
        String[] regionName = { "Gia Lai", "Hải Phòng", "Lào Cai" };

        ArrayList<Region> regions = new ArrayList<>();

        for (int index = 0; index < regionCode.length; index++) {
            String name = regionName[index];
            String code = regionCode[index];
            Region region = new Region(code, name);
            regions.add(region);
        }

        countries.get(0).setRegions(regions);
        countries.get(0).addCountry(new Region("Hồ Chí Minh", "HCM"));
        return countries;
    }

    @GetMapping(value = "country-info/{paramCountry}")
    public String getDetailCountry(@RequestParam String paramCountry) {
        String[] countryCode = { "VN", "US", "CA", "TL", "AU" };
        String[] countryName = { "Việt Nam", "America", "Campuchia", "Thái Lan", "Australia" };
        ArrayList<Country> countries = new ArrayList<>();

        for (int index = 0; index < countryCode.length; index++) {
            String name = countryName[index];
            String code = countryCode[index];
            Country country = new Country(code, name);
            countries.add(country);
        }

        String[] regionCode = { "GL", "HP", "LC" };
        String[] regionName = { "Gia Lai", "Hải Phòng", "Lào Cai" };

        ArrayList<Region> regions = new ArrayList<>();

        for (int index = 0; index < regionCode.length; index++) {
            String name = regionName[index];
            String code = regionCode[index];
            Region region = new Region(code, name);
            regions.add(region);
        }

        countries.get(0).setRegions(regions);
        countries.get(0).addCountry(new Region("Hồ Chí Minh", "HCM"));

        return paramCountry;

    }

    @GetMapping("/customer-invoice")
    public ArrayList<Invoice> customerInvoice() {
        Customer customer1 = new Customer(1, "Tuấn", 12);
        Customer customer2 = new Customer(2, "Hải", 20);
        Customer customer3 = new Customer(3, "Tiển", 15);

        Invoice invoice1 = new Invoice(12, customer1, 120000);
        Invoice invoice2 = new Invoice(13, customer2, 150000);
        Invoice invoice3 = new Invoice(12, customer3, 170000);
        Invoice invoice4 = new Invoice(12, new Customer(1, "special", 12), 199000);

        ArrayList<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);
        invoiceList.add(invoice4);

        return invoiceList;
    }

    @GetMapping("/customer-account")
    public ArrayList<AccountVer2> customerAccount() {

        Customer customer1 = new Customer(1, "Tuấn", 12);
        Customer customer2 = new Customer(2, "Hải", 20);
        Customer customer3 = new Customer(3, "Tiển", 15);

        AccountVer2 account1 = new AccountVer2("code1", customer1, 1223312);
        AccountVer2 account2 = new AccountVer2("code2", customer2, 1223312);
        AccountVer2 account3 = new AccountVer2("code3", customer3, 1223312);

        ArrayList<AccountVer2> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }

    @GetMapping("/tourist")
    public ArrayList<Visit> getTouristById(@RequestParam(value = "id", required = false) String vId) {
        Tourist tourist1 = new Tourist("1", "Tròn");
        Tourist tourist2 = new Tourist("2", "Tam giác");
        Tourist tourist3 = new Tourist("2", "Vuông");

        ArrayList<Visit> visitList = new ArrayList<>();
        visitList.add(new Visit(tourist1, new Date()));
        visitList.add(new Visit(tourist2, new Date()));
        visitList.add(new Visit(tourist3, new Date()));

        ArrayList<Visit> matchingVisits = new ArrayList<>();

        if (vId != null) {
            for (Visit visit : visitList) {
                if (visit.getTourist().getId().equals(vId)) {
                    matchingVisits.add(visit);
                }
            }
            if (matchingVisits.isEmpty()) {
                throw new IllegalArgumentException("Tourist with ID " + vId + " not found");
            }
        } else {
            matchingVisits = visitList;
        }

        return matchingVisits;
    }

}
