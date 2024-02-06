package practice2;


import java.util.HashMap;
import java.util.Map;

public class Student {
	private int id;
	static int numOfStudents = 0;
	String name;
	private int yearOfStudy;
	public Map<String, Integer> grades;
	{
		grades = new HashMap<>();
	}
	public Student(){
		id = numOfStudents++;
	}
	public Student(String name, int yearOfStudy){
		this();
		this.name = name;
		this.yearOfStudy = yearOfStudy;
	}

	public void addGrade(String course, int grade) {
		grades.put(course, grade);
	}
	public int getGrade(String course) {
		return grades.get(course);
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudyYear() {
		return yearOfStudy;
	}
	public String toString() {
		return name+ " " + getId() + " " + getStudyYear();
	}
	public void incrementStudyYear() {
		yearOfStudy++;
	}
}
