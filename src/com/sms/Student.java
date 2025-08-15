package com.sms;

public class Student {
    private int id;
    private String firstName, lastName, gender, address, pinNumber;
    private int age;
    private float marks10th, marksInter;
    private String email;
    private String phoneNumber;

    public Student(int id, String firstName, String lastName, String gender,
                   int age, String address, String pinNumber, float marks10th, float marksInter,
                   String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.pinNumber = pinNumber;
        this.marks10th = marks10th;
        this.marksInter = marksInter;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + firstName + " " + lastName +
                ", Gender: " + gender +
                ", Age: " + age +
                ", Address: " + address +
                ", PIN: " + pinNumber +
                ", 10th Marks: " + marks10th +
                ", Inter Marks: " + marksInter +
                ", Email: " + email +
                ", Phone: " + phoneNumber;
    }
}

