public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(
            String name,
            Author author,
            double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(
            String name,
            Author author,
            double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Book[name=" + name + ",price=" + price + ",qty=" + qty + "," + author.toString() + "]";
    }

}
