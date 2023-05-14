public class Date {
    private int day;
    private int mouth;
    private int year;

    public Date(int day, int mouth, int year) {
        this.day = Math.max(1, Math.min(31, day)); // giới hạn giá trị của day trong khoảng từ 1 đến 31
        this.mouth = Math.max(1, Math.min(12, mouth)); // giới hạn giá trị của day trong khoảng từ 1 đến 31
        this.year = Math.max(1900, Math.min(9999, year)); // giới hạn giá trị của day trong khoảng từ 1 đến 31
    }

    public int getDay() {
        return day;
    }

    public int getMouth() {
        return mouth;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = Math.max(1, Math.min(31, day));
    }

    public void setMouth(int mouth) {
        this.mouth = Math.max(1, Math.min(12, mouth)); // giới hạn giá trị của day trong khoảng từ 1 đến 31
    }

    public void setYear(int year) {
        this.year = Math.max(1900, Math.min(9999, year)); // giới hạn giá trị của day trong khoảng từ 1 đến 31
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%d/%d/%d", day, mouth, year);
    }
}
