package com.learn4.javabasic.s10;

import java.util.ArrayList;

public class CPerson extends CAnimal {

    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private ArrayList<CPet> pets;

    public CPerson() {
        super();
    }

    /*
     * Khởi tạo Person với đầy đủ tham số
     * 
     * @param id
     * 
     * @param age
     * 
     * @param firstName
     * 
     * @param lastName
     * 
     * @param pets
     */

    public CPerson(int id, int age, String firstName, String lastName, ArrayList<CPet> pets) {
        super();
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;

    }

    /* return the id */
    public int getId() {
        return id;
    }

    /*
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * @param age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /*
     * @param firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     * @param lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * @param pets to set
     */
    public void setPets(ArrayList<CPet> paramPets) {
        this.pets = paramPets;
    }

    /*
     * @ return age
     */
    public int getAge() {
        return age;
    }

    /*
     * @ return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * @ return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * @ return pets
     */
    public ArrayList<CPet> getPets() {
        return pets;
    }

    /* @override to String */
    @Override
    public void animalSound() {
        System.out.println("Person speaking");
    }

    @Override
    public String toString() {
        return "CPerson={id:" + id + "," +
                "age:" + age + "," +
                "firstName:" + firstName + "," +
                "lastName:" + lastName + "," +
                "pets:" + pets + "}";
    }
}
