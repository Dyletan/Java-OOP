package entities;

import containers.*;
import data.*;
import messages.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


public abstract class Manager extends Employee{

	public Manager() {

	}

	public Manager(String userId, Login login, String email, String name, String surname) {
		super(userId, login, email, name, surname);
	}

	/**
	 * Displays information for all students sorted alphabetically by surname.
	 */
	public void viewAllStudentsInfoAlphabetically() {
		List<Student> sortedStudents = DataBase.getInstance().getUsers().stream()
				.filter(user -> user instanceof Student)
				.map(user -> (Student) user)
				.sorted(Comparator.comparing(Student::getSurname))
				.collect(Collectors.toList());

		System.out.println("All Students Information (Sorted Alphabetically by surname):");

		for (Student student : sortedStudents) {
			printStudentInfo(student);
		}
	}

	/**
	 * Displays information for students sorted by total GPA in descending order.
	 */
	public void viewStudentsInfoByTotalGPA() {
		List<Student> students = DataBase.getInstance().getUsers().stream()
				.filter(user -> user instanceof Student)
				.map(user -> (Student) user)
				.sorted(Comparator.comparingDouble(Student::calculateTotalGPA).reversed())     //calculateTotalGpa should be in student class
				.toList();

		System.out.println("Students Information Sorted by Total GPA:");

		for (Student student : students) {
			printStudentInfo(student);
		}
	}



	/**
	 * Prints detailed information for a given student.
	 *
	 * @param student The student for whom the information is to be displayed.
	 */
	private void printStudentInfo(Student student) {
		System.out.println("\nStudent ID: " + student.getUserId());
		System.out.println("Name: " + student.getName());
		System.out.println("Surname: " + student.getSurname());
		System.out.println("Email: " + student.getEmail());
		System.out.println("Faculty: " + student.getFaculty());

		System.out.println("\nCourses and Corresponding GPAs:");
		for (Map.Entry<Course, Mark> entry : student.getGradeBook().entrySet()) {
			Course course = entry.getKey();
			Mark mark = entry.getValue();

			System.out.println("- Course: " + course.getCourseName());
			System.out.println("  - GPA: " + mark.getGPA());
		}

		System.out.println("\nTranscripts:");
		for (Transcript transcript : student.getTranscripts()) {
			System.out.println(transcript);
		}

	}



	/**
	 * Displays information for teachers associated with a specific course.
	 *
	 * @param course The course for which teacher information is to be displayed.
	 */
	public void viewTeacherInfo(Course course) throws IOException {
		Vector<Teacher> teachers = course.getAvailableTeachers();

		if(!teachers.isEmpty()) {
			System.out.println("Teachers for the course " + course.getCourseName() + ":");
			for (Teacher teacher : teachers) {
				System.out.println(teacher.getTitle() + " " + teacher.getName() + " " + teacher.getSurname());
			} 
		} else {
			System.out.println("No teachers are associated with this course");

		}

	}



	protected String getStartMessage() {
		return super.getStartMessage()
				+ "\n10) View all students information sorted alphabetically"
				+ "\n11) View all students information sorted by gpa"
				+ "\n12) View teacher information by course";
	}



}
