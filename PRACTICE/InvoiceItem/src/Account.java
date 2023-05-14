public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        if (amount > balance) {
            System.out.println(" amount exceeds balance!");
            return -1;
        } else {
            this.balance -= amount;
            return this.balance;
        }
    }

    public int transferTo(int amount, Account anotherAccount) {
        if (amount > balance) {
            System.out.println("Aount exceeded balance");
            return -1;// bất thường, không thành công
        } else {
            debit(amount);
            anotherAccount.credit(amount);
            return balance;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Account[id=" + id + ",name=" + name + ",balance=" + balance + "]";
    }

}
