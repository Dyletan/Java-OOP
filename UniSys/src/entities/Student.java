package entities;

import data.*;
import entities.*;
import messages.*;
import test.MethodFactory;
import containers.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class Student extends User implements Cloneable {
    private static final long serialVersionUID = -6475983381244582709L;
	private FacultyName faculty;
    private Vector<Organization> organizations;
    private Schedule schedule;
    private Vector<Course> doneCourses;
    private Vector<Course> registeredCourses;
    private Vector<Course> coursesForRetake;
    private Boolean isExpelled;
    private Map<Course, Mark> gradeBook;
    private Set<Transcript> transcripts;

    {
            organizations = new Vector<Organization>();
            doneCourses = new Vector<Course>();
            gradeBook = new HashMap<Course, Mark>();
            transcripts = new HashSet<>();
            isExpelled = false;
            registeredCourses = new Vector<Course>();
            this.coursesForRetake = new Vector<Course>();
    }

    public Student() {}

    public Student(String userId, Login login, String email, String name, String surname, FacultyName faculty) {
        super(userId, login, email, name, surname);
        this.faculty = faculty;
    }
    
    protected String getStartMessage() {
    	return super.getStartMessage()
    			+ "\n6) View transcript"
    			+ "\n7) View marks"
    			+ "\n8) Rate a teacher"
    			+ "\n9) Register a new course"
    			+ "\n10) Join a student organisation"
    			+ "\n11) Leave a student organization";
    }

    public void viewTransripts(){
    	for(Transcript t : transcripts) {
			System.out.println(t); // toString for Transcript
			System.out.println();
		};
    }
    public void viewTeacherInfo(Teacher teacher){
        System.out.println(teacher);
    }
    public void joinStudentOrganization(Organization organizaiton){
        this.organizations.add(organizaiton);
    }
    public void leaveStudentOrganization(Organization organization) {
    	organizations.remove(organization);
    }
    public void rateTeacher(Teacher teacher, double rating){
        teacher.addRating(rating, this);
    }
    public void viewMarks(){
        System.out.println(gradeBook);
    }

    public double calculateTotalGPA(){
        double totalGrade = 0;
        int totalCredits = 0;
        for (Map.Entry<Course, Mark> entry : gradeBook.entrySet()) {
        	int credits = entry.getKey().getCredits();
        	totalCredits += credits;
            totalGrade += entry.getValue().getGPA()*credits;
        }
        if (totalCredits == 0) {
            return 0.0;
        }
        return totalGrade/totalCredits;
    }


    public void registerCourse(Course c){
    	this.registeredCourses.add(c);
    	c.addRegisteredStudent(this);
    }


    public Vector<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Vector<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public FacultyName getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyName faculty) {
        this.faculty = faculty;
    }

    public Vector<Organization> getOrganization() {
        return organizations;
    }

    public void setOrganization(Vector<Organization> organizations) {
        this.organizations = organizations;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

  
    public Vector<Course> getDoneCourses() {
        return doneCourses;
    }

    public void setDoneCourses(Vector<Course> doneCourses) {
        this.doneCourses = doneCourses;
    }

    public Boolean getExpelled() {
        return isExpelled;
    }

    public void setExpelled(Boolean expelled) {
        isExpelled = expelled;
    }

    public Map<Course, Mark> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(Map<Course, Mark> gradeBook) {
        this.gradeBook = gradeBook;
    }
    
    public Vector<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    // Setter
    public void setRegisteredCourses(Vector<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty) && Objects.equals(organizations, student.organizations) && Objects.equals(schedule, student.schedule) && Objects.equals(doneCourses, student.doneCourses) && Objects.equals(isExpelled, student.isExpelled) && Objects.equals(gradeBook, student.gradeBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, organizations, schedule, doneCourses, isExpelled, gradeBook);
    }

    @Override
    public String toString() {
        return super.toString() + " Faculty: " + faculty +
               " " + getName() +
                " " + getSurname();
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

	public Vector<Course> getCoursesForRetake() {
		return coursesForRetake;
	}

	public void setCoursesForRetake(Vector<Course> coursesForRetake) {
		this.coursesForRetake = coursesForRetake;
	}
}
