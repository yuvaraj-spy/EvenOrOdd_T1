package org.studentmanagement;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class StudentManagement {
	    private ArrayList<Student> students = new ArrayList<>();
	    private Scanner scanner = new Scanner(System.in);

	    public void addStudent() {
	        System.out.print("Enter Student ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Enter Name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter Grade: ");
	        String grade = scanner.nextLine();

	        students.add(new Student(id, name, grade));
	        System.out.println("Student added successfully!\n");
	    }

	    public void removeStudent() {
	        System.out.print("Enter Student ID to remove: ");
	        int id = scanner.nextInt();

	        boolean removed = students.removeIf(s -> s.getId() == id);
	        if (removed) {
	            System.out.println("Student removed successfully!\n");
	        } else {
	            System.out.println("Student not found!\n");
	        }
	    }

	    public void displayStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students to display.\n");
	        } else {
	            System.out.println("List of Students:");
	            for (Student s : students) {
	                System.out.println(s);
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        StudentManagement sm = new StudentManagement();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Display Students");
	            System.out.println("4. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> sm.addStudent();
	                case 2 -> sm.removeStudent();
	                case 3 -> sm.displayStudents();
	                case 4 -> {
	                    System.out.println("Exiting program...");
	                    sc.close();
	                    return;
	                }
	                default -> System.out.println("Invalid choice! Please try again.\n");
	            }
	        }
	    }
	}


