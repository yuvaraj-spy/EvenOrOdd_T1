package org.studentmanagement;

public class Student {
	
	    private int id;
	    private String name;
	    private String grade;

	    // Constructor
	    public Student(int id, String name, String grade) {
	        this.id = id;
	        this.name = name;
	        this.grade = grade;
	    }

	    // Getters
	    public int getId() {
	        return id;
	    }

	    // toString method for display
	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
	    }
	}


