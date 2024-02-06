package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import containers.*;
import data.*;
import entities.*;
import messages.*;

public class AcademicFactory {
	static DataBase db = DataBase.getInstance();
	protected static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static Lesson createLesson(Teacher teacher) throws NumberFormatException, IOException {
		System.out.println("Enter start time (HH:mm): ");
		String startTimeInput = reader.readLine();
		Time startTime;

		startTime = parseTime(startTimeInput);


		System.out.println("Enter end time (HH:mm): ");
		String endTimeInput = reader.readLine();
		Time endTime = parseTime(endTimeInput);

		System.out.println("Choose day of the week by index (1) MONDAY, 2) TUESDAY, 3) WEDNESDAY, 4) THURSDAY, 5) FRIDAY, 6) SATURDAY, 7) SUNDAY): ");
		int dayChoice = Integer.parseInt(reader.readLine());
		WeekDay chosenDay = WeekDay.MONDAY; // Default value, you can choose any default

		switch (dayChoice) {
		case 1:
			chosenDay = WeekDay.MONDAY;
			break;
		case 2:
			chosenDay = WeekDay.TUESDAY;
			break;
		case 3:
			chosenDay = WeekDay.WEDNESDAY;
			break;
		case 4:
			chosenDay = WeekDay.THURSDAY;
			break;
		case 5:
			chosenDay = WeekDay.FRIDAY;
			break;
		case 6:
			chosenDay = WeekDay.SATURDAY;
			break;
		case 7:
			chosenDay = WeekDay.SUNDAY;
			break;
		default:
			System.out.println("Invalid choice. Using default value (MONDAY).");
		}
		System.out.println("Choose a course for which you want to make a lesson");
		int j = 1;
		Vector<Course> courses = teacher.getRegisteredCourses();
		for(Course c : courses) {
			System.out.println(j+") " + c);
		}
		System.out.println("Choose from 1 to " + (j-1));
		int choice1 = Integer.parseInt(reader.readLine());
		Course course = courses.get(choice1-1);
		System.out.println("Choose lesson type by index ( 1) LECTURE, 2) PRACTICE, 3) LAB_WORK): ");
		int choice = Integer.parseInt(reader.readLine());
		LessonType lessonType = LessonType.LECTURE;

		switch(choice){
		case 1:
			lessonType = LessonType.LECTURE;
		case 2:
			lessonType = LessonType.PRACTICE;
		case 3:
			lessonType = LessonType.LAB_WORK;
		}

		final LessonType finalLessonType = lessonType;

		Vector<Cabinet> cabinets = (Vector<Cabinet>) db.getCabinets().stream()
				.filter(n -> n.getCabinetType().equals(finalLessonType))
				.collect(Collectors.toCollection(Vector::new));
		System.out.println("Choose a cabinet by entering the index:");

		for (int i = 0; i < cabinets.size(); i++) {
			System.out.println(i + ") " + cabinets.get(i));
		}
		int cabinetIndex = Integer.parseInt(reader.readLine());
		Cabinet selectedCabinet = cabinets.get(cabinetIndex);

		// Now you can create the Lesson object
		return new Lesson(startTime, endTime, finalLessonType, selectedCabinet, chosenDay, teacher, course);
	}
	public static Course createCourse() throws IOException {
		System.out.println("Enter course name");
		String name = reader.readLine();
		System.out.println("Enter course code");
		String code = reader.readLine();
		System.out.println("Enter number of credits (1-5)");
		int credits = Integer.parseInt(reader.readLine());
		int i = 1;
		Vector<Course> prereqs = new Vector<Course>();
		System.out.println("Choose prerequisites");
		Vector<Course> courses = db.getCourses();
		for(Course c : courses) {
			System.out.println(i+") " + c);
			i++;
		}
		while(true) {
			System.out.println("Press q if you want to quit");
			if(reader.readLine().equalsIgnoreCase("q")) break;
			System.out.println("Choose course to become prereq from 1 to " + (i-1));
			int choice = Integer.parseInt(reader.readLine());
			prereqs.add(courses.get(choice-1));
		}
		return new Course(code, name, credits, prereqs);
	}

	public static Cabinet createCabinet() throws IOException {
		System.out.println("Enter cabinet number");
		int number = Integer.parseInt(reader.readLine());
		System.out.println("Enter cabinet capacity");
		int capacity = Integer.parseInt(reader.readLine());
		LessonType cabType;
		loop : while(true) {
			int i = 1;
			for (LessonType type : LessonType.values()) {
				System.out.println(i + ")" + type);
				i++;
			}
			System.out.println("Choose cabinet type from 1 to" + (i-1));
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
				cabType = LessonType.LECTURE;
				break loop;
			case 2:
				cabType = LessonType.PRACTICE;
				break loop;
			case 3:
				cabType = LessonType.LAB_WORK;
				break loop;
			default:
				System.out.println("Error! Try again");
			}
		}
		return new Cabinet(number, capacity, cabType);
	}

	public static Journal createJournal() throws IOException {
		System.out.println("Enter journal name");
		String name = reader.readLine();
		List<Researcher> researchers =  db.getUsers().stream().filter(u -> u instanceof Researcher).map(u-> (Researcher) u).sorted(Comparator.comparingInt(Researcher::calculateHIndex)).collect(Collectors.toList());
		Researcher chosenResearcher;
		loop: while(true){
			int i = 1;
			for (Researcher r : researchers) {
				User u = (User) r;
				System.out.println(i + ")" + u.getName());
				i++;
			}
			System.out.println("Choose researcher from 1 to " + i);
			int choice = Integer.parseInt(reader.readLine());
			chosenResearcher = researchers.get(choice - 1);
			break loop;
		}
		return new Journal(name, chosenResearcher);
	}

	public static ResearchPaper createResearchPaper() throws IOException {
		System.out.println("Enter research paper name");
		String title = reader.readLine();
		List<Researcher> researchers =  db.getUsers().stream().filter(u -> u instanceof Researcher).map(u-> (Researcher) u).sorted(Comparator.comparingInt(Researcher::calculateHIndex)).collect(Collectors.toList());
		Vector<Researcher> chosenResearchers = new Vector<Researcher>();
		loop: while(true){
			int i = 1;
			for (Researcher r : researchers) {
				User u = (User) r;
				System.out.println(i + ")" + u.getName());
				i++;
			}
			System.out.println("Choose researchers from 1 to " + (i-1) + ". Enter one by one! (enter e when done)");
			String input = reader.readLine();
			if(input.equals("e")){
				break loop;
			}
			int choice = Integer.parseInt(input);
			chosenResearchers.add(researchers.get(choice - 1));
		}
		Journal journal;
		int i = 0;
		for (Journal j : db.getJournals()) {
			System.out.println(i + ")" + j.getName());
			i++;
		}
		System.out.println("Choose journal where you're publishing");
		System.out.println("Enter from 1 to " + (i-1));
		return new ResearchPaper(title, chosenResearchers, db.getJournals().get(Integer.parseInt(reader.readLine())), LocalDateTime.now(), 0, "", 0);
	}

	public static ResearchProject createResearchProject() throws IOException{
		System.out.println("Enter research project name");
		String topic = reader.readLine();
		Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
		Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
		db.getJournals().stream().map(v-> v.getPapers()).map(v-> papers.addAll(v));
		Vector<ResearchPaper> chosenResearchPapers = new Vector<ResearchPaper>();
		loop: while(true){
			int i = 1;
			for (ResearchPaper r : papers) {
				System.out.println(i + ")" + r.getTitle());
				i++;
			}
			System.out.println("Choose paper from 1 to " + (i-1) + ". Enter one by one! (enter e when done)");
			String input = reader.readLine();
			if(input.equals("e")){
				break loop;
			}
			int choice = Integer.parseInt(input);
			publishedPapers.add(papers.get(choice - 1));
		}
		List<Researcher> researchers =  db.getUsers().stream().filter(u -> u instanceof Researcher).map(u-> (Researcher) u).sorted(Comparator.comparingInt(Researcher::calculateHIndex)).collect(Collectors.toList());
		Vector<Researcher> chosenResearchers = new Vector<Researcher>();
		loop: while(true){
			int i = 1;
			for (Researcher r : researchers) {
				User u = (User) r;
				System.out.println(i + ")" + u.getName());
				i++;
			}
			System.out.println("Choose researchers from 1 to " + (i-1) + ". Enter one by one! (enter e when done)");
			String input = reader.readLine();
			if(input.equals("e")){
				break loop;
			}
			int choice = Integer.parseInt(input);
			chosenResearchers.add(researchers.get(choice - 1));
		}
		return new ResearchProject(topic, publishedPapers, chosenResearchers);
	}
	/**
	 * Parses a time input in the format HH:mm and returns a Time object.
	 *
	 * @param timeInput The time input string.
	 * @return The parsed Time object.
	 */
	private static Time parseTime(String timeInput) {
		String[] timeParts = timeInput.split(":");
		int hour = Integer.parseInt(timeParts[0]);
		int minute = Integer.parseInt(timeParts[1]);
		return new Time(hour, minute);
	}
}
