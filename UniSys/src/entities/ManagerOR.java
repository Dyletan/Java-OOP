package entities;

import data.*;
import messages.*;
import test.AcademicFactory;
import containers.*;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ManagerOR extends Manager{
	private static final long serialVersionUID = -6929371805056058925L;

	public ManagerOR() {}
	public ManagerOR(String userId, Login login, String email, String name, String surname) {
		super(userId, login, email, name, surname);
	}


	/**
	 * Creates a new course using the AcademicFactory.
	 *
	 * @return The newly created Course object.
	 * @throws IOException 
	 */
	public Course createCourse() throws IOException{
		return AcademicFactory.createCourse();
	}


	/**
	 * Adds a newly created course to the database.
	 *
	 * @throws IOException If an I/O error occurs while accessing the database.
	 */
	public void addCourse() throws IOException {
		DataBase.getInstance().getCourses().add(createCourse());
	}

	/**
	 * Adds a course to the specified faculty's list of mandatory, major, or minor electives for registration.
	 *
	 * @param faculty    The faculty to which the course is added.
	 * @param coursetype The type of course (Mandatory, Major, Minor).
	 * @param course     The course to be added.
	 */
	public void addCoursesForRegistration(Faculty faculty, CourseType coursetype, Course course) {
		switch (coursetype) {
		case MANDATORY:
			faculty.addMandatoryCourse(course);
			break;
		case MAJOR:
			faculty.addAvailableMajorElective(course);
			break;
		case MINOR:
			faculty.addAvailableMinorElective(course);
			break;
		default:
			System.out.println("No such coursetype");
			break;
		}
	}

	/**
	 * Assigns a teacher to a specific course based on manager's input.
	 *
	 * @param teacher The teacher to be assigned.
	 * @param course  The course to which the teacher is assigned.
	 */
	public void assignCourseToTeacher(Teacher teacher, Course course) {
		course.addAvailableTeacher(teacher);
		teacher.getRegisteredCourses().add(course);
	}

	/**
	 * Creates a new lesson using the AcademicFactory.
	 *
	 * @return The newly created Lesson object.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public Lesson createLesson(Teacher teacher) throws NumberFormatException, IOException{
		return AcademicFactory.createLesson(teacher);
	}

	/**
	 * Assigns a lesson to a teacher for a specific course based on user input.
	 *
	 * @param teacher The teacher to whom the lesson is assigned.
	 * @param course  The course for which the lesson is assigned.
	 * @throws OverlappingLessonException If the lesson overlaps with existing lessons.
	 * @throws CourseNotRegisteredException If the course is not registered.
	 */
	public void assignLesson(Teacher teacher, Lesson lesson) throws OverlappingLessonException, CourseNotRegisteredException {
		teacher.getSchedule().addLesson(lesson);
		lesson.getCourse().addLesson(lesson);
	}

	protected String getStartMessage() {
		return super.getStartMessage() 
				+ "\n13) Add course to a collection of all viable courses"
				+ "\n14) Add courses for registration to a particular faculty"
				+ "\n15) Assign course to teacher"
				+ "\n16) Assign lesson";
	}


}
