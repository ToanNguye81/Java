package com.learn4.javabasic.interfaceclass;

/*   Đây là một interface có tên là "IBarkable", có chứa hai phương thức "bark()"
 * và "barkBark()". Các lớp có implements interface này sẽ phải định nghĩa lại
 * cả hai phương thức này theo logic và nghiệp vụ riêng của từng lớp. */
public interface IBarkable {
    /*
     * Phương thức "bark()" được định nghĩa là void, có nghĩa là không trả về giá
     * trị gì. Phương thức này có thể được hiểu là "sủa" bởi các đối tượng của lớp.
     */
    void bark();

    /*
     * Phương thức "barkBark()" cũng được định nghĩa là void và cũng có thể được
     * hiểu là "sủa" nhưng có nghĩa là "sủa thật lớn" hơn so với phương thức
     * "bark()".
     */
    void barkBark();
}
