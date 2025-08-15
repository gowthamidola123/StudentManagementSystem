package com.sms;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Add Student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter PIN Number: ");
        String pin = sc.nextLine();
        System.out.print("Enter 10th Marks: ");
        float marks10th = sc.nextFloat();
        System.out.print("Enter Inter Marks: ");
        float marksInter = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (id, first_name, last_name, gender, age, address, pin_number, marks_10th, marks_inter, email, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, gender);
            stmt.setInt(5, age);
            stmt.setString(6, address);
            stmt.setString(7, pin);
            stmt.setFloat(8, marks10th);
            stmt.setFloat(9, marksInter);
            stmt.setString(10, email);
            stmt.setString(11, phone);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View Students
    static void viewStudents() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name") +
                                ", Gender: " + rs.getString("gender") +
                                ", Age: " + rs.getInt("age") +
                                ", Address: " + rs.getString("address") +
                                ", PIN: " + rs.getString("pin_number") +
                                ", 10th Marks: " + rs.getFloat("marks_10th") +
                                ", Inter Marks: " + rs.getFloat("marks_inter") +
                                ", Email: " + rs.getString("email") +
                                ", Phone: " + rs.getString("phone_number")

                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Student
    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter PIN Number: ");
        String pin = sc.nextLine();
        System.out.print("Enter 10th Marks: ");
        float marks10th = sc.nextFloat();
        System.out.print("Enter Inter Marks: ");
        float marksInter = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE students SET first_name=?, last_name=?, gender=?, age=?, address=?, pin_number=?, marks_10th=?, marks_inter=?, email=?, phone=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);       // first_name
            stmt.setString(2, lastName);        // last_name
            stmt.setString(3, gender);          // gender
            stmt.setInt(4, age);                // age
            stmt.setString(5, address);         // address
            stmt.setString(6, pin);             // pin_number
            stmt.setFloat(7, marks10th);        // marks_10th
            stmt.setFloat(8, marksInter);       // marks_inter
            stmt.setString(9, email);           // email
            stmt.setString(10, phone);          // phone_number
            stmt.setInt(11, id);                // WHERE id
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
