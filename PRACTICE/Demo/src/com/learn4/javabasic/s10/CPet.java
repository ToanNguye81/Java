package com.learn4.javabasic.s10;

/* Đoạn code này định nghĩa lớp CPet là một lớp con của lớp trừu tượng CAnimal.
 CPet có thêm hai thuộc tính là age và name để lưu trữ tuổi và tên của động vật. */
public class CPet extends CAnimal {

    protected int age;
    protected String name;

    /*
     * Lớp CPet triển khai phương thức abstract animalSound() của lớp CAnimal bằng
     * cách ghi đè phương thức đó và hiển thị "Pet sound..."
     */
    @Override
    public void animalSound() {
        // TODO Auto-generated method stub
        System.out.println("Pet sound...");
    }

    /*
     * Nó cũng ghi đè phương thức ăn của lớp CAnimal bằng phương thức eat() của
     * riêng nó, hiển thị "Pet eating....".
     */
    @Override
    public void eat() {
        System.out.println("Pet eating ....");
    }

    /*
     * Lớp CPet có hai phương thức print() và play(), nhưng hai phương thức này
     * không được triển khai.
     */
    protected void print() {

    }

    protected void play() {

    }

    public static void main(String[] args) {

        /* CPet được khởi tạo */
        CPet myPet = new CPet();
        /* gán giá trị cho các thuộc tính của nó */
        myPet.name = "KIYA";
        myPet.age = 2;
        myPet.animClass = AnimalClass.mammals;

        /*
         * gọi phương thức animalSound(), eat() và drink() của đối tượng myPet và hiển
         * thị kết quả.
         */
        myPet.animalSound();
        myPet.eat();
        myPet.drink();
        myPet.print();
        myPet.play();

    }

}
