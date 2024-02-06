package lab1;
import java.util.Vector;

import practcie2.Student;

public class GradeBook {
	Course course;
	public Vector<Student> students;
	
	public GradeBook(){
		course = new Course();
	}
	public GradeBook(Course course){
		this.course = course;
	}
	
	{
		students = new Vector<Student>();
	}
	
	public void addStudent(Student a) {
		students.add(a);;
	}
	public void addGrade(Student a, int grade) {
		a.addGrade(course.getName(), grade);
	}
	public void displayMessage() {
		System.out.println("Fill in the grades (0-100) of students for course \"Art and Pottery\"");
	}
	
	public void displayGradeReport() {
		Student minGradeStudent = getLowestGrade();
		Student maxGradeStudent = getMaxGrade();
		String average = String.format("%.2f", determineClassAverage());
		
		System.out.println("The average grade is: " + average);
		System.out.println( "Lowest grade is: " + minGradeStudent.getGrade(course.getName()) + " ("+minGradeStudent.toString()+" ).");
		System.out.println("Highest grade is: " + maxGradeStudent.getGrade(course.getName())+ " (" + maxGradeStudent.toString() + ").\n");
		System.out.println(outputBarChart());
	}
	public double determineClassAverage() {
		double sum = 0;
		int count = 0;
		for(Student student : students) {
			sum += student.grades.get(course.getName());
			count++;
		};
		
		return sum / count;
	}
	public Student getMaxGrade() {
		int maxGrade = Integer.MIN_VALUE;
		Student maxGradeStudent = new Student();
		for(Student student : students) {
			int curGrade = student.grades.get(course.getName());
			 if(curGrade>maxGrade) {
				 maxGrade = curGrade;
				 maxGradeStudent = student;
			 }
		};
		return maxGradeStudent;
	}
	private Student getLowestGrade() {
		int minGrade = Integer.MAX_VALUE;
		Student minGradeStudent = new Student();
		for(Student student : students) {
			int curGrade = student.grades.get(course.getName());
			 if(curGrade<minGrade) {
				 minGrade = curGrade;
				 minGradeStudent = student;
			 }
		};
		return minGradeStudent;
	}
	private String outputBarChart() {
		int countGrades[] = new int[11];
		String result = "";
		for(Student student : students) {
			int curGrade = student.grades.get(course.getName());
			countGrades[curGrade/10]++;
		}
		int count = 0;
		String temp = "";
		for(int i = 0; i < 11; i++) {
			if(i == 10) {
				temp = "100:   ";
			}
			else {
				temp = String.format("%02d-%02d: ", count, count+9);
			}
			result += temp;
			
			for(int j = 0; j < countGrades[i]; j++) {
				result+="*";
			}
			
			result+="\n";
			count+=10;
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		for(Student student : students) {
			result += student.toString() + "\n";
		}
		return "This is a " + course.getName() + " course gradebook with following students:\n" + result; 
	}
}
