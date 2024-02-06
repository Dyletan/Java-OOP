package entities;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Teacher extends Employee implements Serializable, Cloneable {
	private static final long serialVersionUID =-8483669438840731250L;
	private Schedule schedule;
	private Vector<Complaint> sentComplaints;
	private Vector<Course> registeredCourses;
	private TeacherTitle title;
	private HashMap<Student, Double> ratings;
	{
		schedule = new Schedule();
		sentComplaints = new Vector<Complaint>();
		registeredCourses = new Vector<Course>();
		ratings = new HashMap<Student, Double>();
	}

	public Teacher() {
	}

	public Teacher(String userid, Login login, String email, String name, String surname, TeacherTitle teacherTitle) {
		super(userid, login, email, name, surname);
		this.title = teacherTitle;
	}

	public double calculateRating() {
		double totalRating = 0;
		int count = 0;
		for(Double d : ratings.values()) {
			totalRating += d;
			count++;
		}
		if(count == 0) return 0;
		return totalRating/count;
	}

	public void putMark() throws IOException {
		int k = 1;
		System.out.println("Please choose course");

		for(Course c: registeredCourses) {
			System.out.println(k + ") " + c.getCourseName());
			k++;
		}
		System.out.println("Choose from 1 to " + k + " (q to quit)");
		String input = reader.readLine();
		if(input.equalsIgnoreCase("q")) {
			System.out.println("Didn't complete");
		}else {
			int choice = Integer.parseInt(input);

			Course chosenCourse = registeredCourses.get(choice - 1);

			int j = 1;
			System.out.println("Choose student\n");
			Vector<Student> students = new Vector<Student>();
			for(Student s: chosenCourse.getRegisteredStudents()) {
				students.add(s);
			}

			for (Student s : students) {
				System.out.println(j + ") " + s.getUserId() + " - " + s.getName());
				j++;
			}
			System.out.println("Choose from 1 to " + (j-1) + "press e to cancel and exit to the menu");
			input = reader.readLine();
			if (input.equals("e")) {
				return;
			}
			choice = Integer.parseInt(input);
			Student chosenStudent = students.get(choice - 1);
			System.out.println("Enter a point to put");
			int point = Integer.parseInt(reader.readLine());
			System.out.println("Choose a type of point");
			j = 1;
			for (PointType t : PointType.values()) {
				System.out.println(j + ")" + t.name());
				j++;
			}
			input = reader.readLine();
			choice = Integer.parseInt(input);
			PointType chosenType;
			type: while(true){
				switch (choice){
				case 1:
					chosenType = PointType.FIRST_ATTESTATION;
					break type;
				case 2:
					chosenType = PointType.SECOND_ATTESTATION;
					break type;
				case 3:
					chosenType = PointType.FINAL;
					break type;
				default:
					System.out.println("You've entered number that is out of range, try again");
				}
			}
			if(chosenStudent.getGradeBook().get(chosenCourse)== null) {
				chosenStudent.getGradeBook().put(chosenCourse, new Mark());
			}
			putMark(chosenStudent, chosenCourse, new Point(point, chosenType));
			if(chosenType.equals(PointType.FINAL)) {
				if(point < 20 || chosenStudent.getGradeBook().get(chosenCourse).getNumericalPoints() - point < 30) {
					chosenStudent.getCoursesForRetake().add(chosenCourse);
				}else {
					chosenStudent.getDoneCourses().add(chosenCourse);
				}
			}
		}
	}

	public void putMark(Student s, Course c, Point p) {
		s.getGradeBook().get(c).putMark(p);
	}

	public void sendComplaint() throws IOException {
		Vector<Dean> deans = DataBase.getInstance().getDeans();
		int i = 1;
		for (Dean dean : deans) {
			System.out.println(i + ")" + dean.getName() + ", " + dean.getFaculty());
			i++;
		}
		System.out.println("Please choose dean from 1 to " + deans.size() +1 + "\n press e to exit");
		String input = reader.readLine();
		if(input.equals("e")){
			return;
		}
		int choise = Integer.parseInt(input);
		Dean chosenDean = deans.elementAt(choise+1);
		System.out.println("Enter a title of a complaint");
		String title = reader.readLine();
		System.out.println("Enter a text of a complaint");
		String message = reader.readLine();
		System.out.println("Choose a priority");
		i = 1;
		for(Priority p : Priority.values()){
			System.out.println(i + ")" + p.name());
			i++;
		}
		input = reader.readLine();
		choise = Integer.parseInt(input);
		Priority chosenPriority;
		switch (choise){
		case 1:
			chosenPriority =  Priority.HIGH;
		case 2:
			chosenPriority =  Priority.MEDIUM;
		case 3:
			chosenPriority =  Priority.LOW;
		default:
			System.out.println("you're out of range, so by default it will be of low priority");
			chosenPriority =  Priority.LOW;
		}
		chosenDean.getComplaints().add(new Complaint(title,message, chosenDean, this, chosenPriority));
		System.out.println("Complaint sent to " + chosenDean.getName() + ".");
	}

	public void viewSchedule() {
		System.out.println(schedule);
	}

	public void viewSentComplaints() {
		System.out.println(sentComplaints);
	}

	public void viewStudentInfo() throws IOException {
		int k = 1;
		Vector<Student> students = DataBase.getInstance().getStudents();
		for (Student s : students) {
			System.out.println(k + ")" + s.getUserId() + " - " + s.getName());
			k++;
		}
		System.out.println("Choose student from 1 to " + k + " (press e to return back to menu)");
		String input = reader.readLine();
		if(input.equals("e")){
			return;
		}
		int choice = Integer.parseInt(input);
		Student chosenStudent = students.elementAt(choice+1);
		System.out.println(chosenStudent);
	}

	public void viewTaughtCourses() {
		schedule.getLessons().stream().map(l->l.getTeacher().equals(this)).forEach(System.out::println);
	}

	public void addRating(double d, Student s) {
		ratings.put(s, d);
	}

	protected String getStartMessage() {
		return super.getStartMessage()
				+ "\n10) Put mark to a student"
				+ "\n11) Send complaint"
				+ "\n12) View Schedule"
				+ "\n13) View sent complaints"
				+ "\n14) View student info"
				+ "\n15) View taught courses";
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Vector<Complaint> getSentComplaints() {
		return sentComplaints;
	}

	public void setSentComplaints(Vector<Complaint> sentComplaints) {
		this.sentComplaints = sentComplaints;
	}

	public TeacherTitle getTitle() {
		return title;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}

	public HashMap<Student, Double> getRatings() {
		return ratings;
	}

	public void setRatings(HashMap<Student, Double> ratings) {
		this.ratings = ratings;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Teacher teacher = (Teacher) o;
		return Objects.equals(schedule, teacher.schedule) && Objects.equals(sentComplaints, teacher.sentComplaints)
				&& title == teacher.title && Objects.equals(ratings, teacher.ratings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(schedule, sentComplaints, title, ratings);
	}

	@Override
	public String toString() {
		return super.toString() + " Teacher{" +
				", title=" + title +
				", rating=" + calculateRating() +
				'}';
	}

	@Override
	public Teacher clone() {
		try {
			Teacher clone = (Teacher) super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public Vector<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(Vector<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

}
