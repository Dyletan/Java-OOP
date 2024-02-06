package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import containers.*;
import data.*;
import entities.*;
import messages.*;

public class MethodFactory {
	static DataBase db = DataBase.getInstance();
	protected static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void doMethod(int i, User u) throws IOException, PasswordsDoNotMatchException, WeakPasswordException, NumberFormatException, OverlappingLessonException, CourseNotRegisteredException{
		userCase(i, u);
		if(u instanceof Student) {
			Student s = (Student) u;
			studentCase(i, s);
			if (s instanceof StudentResearcher) {
				StudentResearcher s1 = (StudentResearcher) u;
				ResearcherCase(i, s1);
				if (s1 instanceof GraduateStudent) {
					GraduateStudent g = (GraduateStudent) u;
					graduateStudentCase(i, g);
				}
			}
		}
		else if(u instanceof Employee) {
			Employee e = (Employee) u;
			employeeCase(i, e);
			if (e instanceof Teacher) {
				Teacher t = (Teacher) u;
				teacherCase(i, t);
				if (t instanceof TeacherResearcher) {
					TeacherResearcher t1 = (TeacherResearcher) u;
					ResearcherCase(i, t1);
				}
			}
			else if (e instanceof EmployeeResearcher) {
				EmployeeResearcher e1 = (EmployeeResearcher) u;
				ResearcherCase(i, e1);
			}
			else if(e instanceof Manager) {
				Manager m = (Manager) e;
				managerCase(i, m);
				if (m instanceof ManagerDepartment) {
					ManagerDepartment m1 = (ManagerDepartment) m;
					managerDepartmentCase(i, m1);
				}
				else if (u instanceof ManagerOR) {
					ManagerOR m2 = (ManagerOR) m;
					managerORCase(i, m2);
				}

			}
			else if (e instanceof TechSupport) {
				TechSupport t = (TechSupport) e;
				techSupportCase(i, t);
			}
			else if (e instanceof Dean) {
				Dean d = (Dean) e;
				deanCase(i, d);
			}
			else if(e instanceof Admin) {
				Admin a = (Admin) e;
				adminCase(i, a);
			}
		}	
	}

	private static void userCase(int i, User u) throws IOException, PasswordsDoNotMatchException, WeakPasswordException {
		switch(i) {
		case 1:
			u.viewNews();
			break;
		case 2:
			u.viewNotifications();
			break;
		case 3:
			// view subscribed journal
			int choice0 = u.viewSubscribedJournalList();
			System.out.println(db.getJournals().get(choice0-1));
			break;
		case 4:
			// subscribe to journal
			int choice = u.viewJournalList();
			if(choice == -1) System.out.println("Didn't subscribe");
			else {
				Journal j = db.getJournals().get(choice-1);
				u.subscribeToJournal(j);
			}
			break;
		case 5:
			// unsubscribe from journal
			int choice2 = u.viewSubscribedJournalList();
			if(choice2 == -1) System.out.println("Didn't unsubscribe");
			else {
				Journal j = db.getJournals().get(choice2-1);
				u.unsubscribeFromJournal(j);
			}
			break;
		case 100:
			System.out.println("Type your previous password");
			String oldPass = reader.readLine();
			System.out.println("Type the new password");
			String newPass = reader.readLine();
			u.getLogin().changePassword(oldPass, newPass);
			break;
		}
	}

	private static void employeeCase(int i, Employee e) throws IOException {
		switch(i) {
		case 6:
			e.viewInbox();
			break;
		case 7:
			// send message
			int k = 1;
			System.out.println("To which Employee you want to send the message");
			Vector<Employee> employees = DataBase.getInstance().getEmployees();
			for(Employee employee: employees){
				System.out.println(k + ") " + employee.getSurname() + employee.getName());
				k++;
			}
			System.out.println("Choose from 1 to " + (k-1) + " (q to quit)");
			String input = reader.readLine();
			if(input.equalsIgnoreCase("q")) {
				System.out.println("Didn't send message");
			}else {
				int choice = Integer.parseInt(input);
				for(Employee employee: employees) {
					Employee receiver = employees.get(choice-1);
					System.out.println("Choose a title for your message");
					String title = reader.readLine();
					System.out.println("Choose the contents of your message");
					String message = reader.readLine();

					Message m = new Message(title, message, receiver, e);
					e.sendMessage(m, receiver);
				}
			}
			break;
		case 8:
			// send request
			int k1 = 1;
			System.out.println("To which Dean you want to send the complaint");
			Vector<Dean> deans = DataBase.getInstance().getDeans();
			for(Dean d: deans) {
				System.out.println(k1 + ") " + d.getName() + " " + d.getFaculty());
				k1++;
			}
			System.out.println("Choose from 1 to " + (k1-1) + " (q to quit)");
			String input1 = reader.readLine();
			if(input1.equalsIgnoreCase("q")) {
				System.out.println("Didn't send request");
			}else {
				int choice = Integer.parseInt(input1);
				Dean receiver = deans.get(choice-1);
				System.out.println("Choose a title for your request");
				String title = reader.readLine();
				System.out.println("Choose the contents of your request");
				String message = reader.readLine();
				boolean providedCorrectPriority = false;
				Priority priority = Priority.LOW;
				while(!providedCorrectPriority) {
					System.out.println("What is the priority of your request 1 - High, 2 - Medium, 3 - Low");
					int p = Integer.parseInt(reader.readLine());
					switch(p) {
					case 1: 
						priority = Priority.HIGH;
						providedCorrectPriority = true;
						break;
					case 2:
						priority = Priority.MEDIUM;
						providedCorrectPriority = true;
						break;
					case 3: 
						providedCorrectPriority = true;
					default:
						System.out.println("You've provided incorrect priority");
					}
				}
				Request r = new Request(title, message, receiver, e, priority);
				e.sendRequest(r, receiver);
			}
			break;
		case 9:
			// send order
			int j = 1;
			System.out.println("To which Dean you want to send the complaint");
			Vector<TechSupport> techSupports = DataBase.getInstance().getTechSupports();
			for(TechSupport tech : techSupports){

				System.out.println(j + ") " + tech.getName() + " " + tech.getSurname());
				j++;

			}

			System.out.println("Choose from 1 to " + (j-1) + " (q to quit)");

			String input3 = reader.readLine();
			if(input3.equalsIgnoreCase("q")) {
				System.out.println("Didn't send order");
			}else {
				int choice = Integer.parseInt(input3);

				for(User user: techSupports) {
					if(user instanceof TechSupport) {
						TechSupport receiver = (TechSupport) techSupports.get(choice-1);
						System.out.println("Choose a title for your complaint");
						String title = reader.readLine();
						System.out.println("Choose the contents of your complaint");
						String message = reader.readLine();

						Order o = new Order(title, message, receiver, e);
						e.sendOrder(o, receiver);
					}

				}
			}
			break;	
		}
	}

	private static void ResearcherCase(int i, Researcher t1) throws IOException {
		int[] cases = null;

		if(t1 instanceof EmployeeResearcher) {
			cases = new int[]{10, 11, 12, 13};
		}
		if(t1 instanceof TeacherResearcher) {
			cases = new int[]{16, 17, 18, 19};
		}
		else{
			cases = new int[]{11, 12, 13, 14};
		}
		if (i == cases[0]) { // print paper
			t1.printPapers();
		} else if (i == cases[1]) { // view H-index
			System.out.println(t1.calculateHIndex());
		} else if (i == cases[2]) { // add Research paper
			t1.addResearchPaper(AcademicFactory.createResearchPaper());
		} else if (i == cases[3]) {
			t1.addResearchProject(AcademicFactory.createResearchProject());
		}		
	}
	private static void managerCase(int i, Manager m) throws IOException {
		switch(i) {
		case 10:
			// View student info alphabetically
			m.viewAllStudentsInfoAlphabetically();
			break;
		case 11:
			// View student info by gpa
			m.viewStudentsInfoByTotalGPA();
			break;
		case 12:
			// view teacher info by course
			int k = 1;
			System.out.println("Which course teacher information you want to see?");
			Vector<Course> courses = DataBase.getInstance().getCourses();
			for(Course c : courses) {
				System.out.println(k + ") " + c.getCourseCode() + ", " + c.getCourseName());
				k++;
			}
			System.out.println("Choose from 1 to " + (k-1) + " (q to quit)");
			String input = reader.readLine();
			if(input.equalsIgnoreCase("q")) {
				System.out.println("No course chosen");
			}else {
				int choice = Integer.parseInt(input);
				Course course = courses.get(choice-1);
				m.viewTeacherInfo(course);
				Vector<Teacher> teachers = course.getAvailableTeachers();
			}
			break;
		}
	}

	private static void studentCase(int i, Student s) throws NumberFormatException, IOException {
		switch(i) {
		case 6:
			// View transcripts
			s.viewTransripts();
			break;
		case 7:
			// View marks
			s.viewMarks();
			break;
		case 8:
			// Rate Teacher
			HashSet<Teacher> teachers = new LinkedHashSet<Teacher>(); // to maintain order
			for(Lesson l : s.getSchedule().getLessons()) {
				teachers.add(l.getTeacher());
			}
			System.out.println("Which teacher would you like to rate?");
			int k = 1;
			for(Teacher t : teachers) {
				System.out.println(k+") " + t.getName() + " " + t.getSurname());
				k++;
			}

			break;
		case 9:
			// Register new course
			Vector<Course> availableCourses = new Vector<Course>();
	        Faculty faculty = db
	                .getFaculties()
	                .stream()
	                .filter(n -> n.getName().equals(s.getFaculty()))
	                .findFirst()
	                .orElse(null);
	        System.out.println("Do you want to register mandatory course(1), major elective (2) or minor elective(3)"); 
	        int ch = Integer.parseInt(reader.readLine());
	        switch(ch) {
	        case 1:
	        	availableCourses.addAll(faculty.getMandatoryCourses());
	        	break;
	        case 2:
	        	availableCourses.addAll(faculty.getAvailableMajorElectives());
	        	break;
	        case 3:
	        	availableCourses.addAll(faculty.getAvailableMinorElectives());
	        	break;
	        }
	        System.out.println("Which course do you want to choose?");
	        int j = 1;
	        for(Course c : availableCourses) {
	        	System.out.println(j+") " + c.getCourseName() + " " + c.getCourseCode() + "num of credits: " + c.getCredits());
	        	j++;
	        }
	        System.out.println("Pick from 1 to " + (j-1));
	        int choice = Integer.parseInt(reader.readLine());
	        Course chosen = availableCourses.get(choice-1);
	        int totalCredits = chosen.getCredits();
	        for(Course c : s.getRegisteredCourses()) {
	        	totalCredits += c.getCredits();
	        }
	        if(totalCredits > 21) {
	        	System.out.println("Cannot have more than overall 21 credits, choose something else");
	        	break;
	        }
	        s.registerCourse(chosen);
			break;
		case 10:
			// Join a new organization
			System.out.println("Choose what organization you want to join");
			int h = 1;
			for(Organization o : Organization.values()) {
				System.out.println(h+") " + o);
				h++;
			}
			System.out.println("Choose from 1 to " + (h-1));
			int choice2 = Integer.parseInt(reader.readLine());
			Organization o = Organization.FACES;
			switch(choice2) {
			case 1:
				o = Organization.FACES;
			case 2:
				o = Organization.OSIT;
			case 3:
				o = Organization.BSL;
			case 4:
				o = Organization.ARTHOUSE;
			}
			s.getOrganizations().add(o);
			break;
		}
	}
	private static void deanCase(int i, Dean d) throws IOException {
		switch(i) {
		case 10:
			d.viewRequests();
			break;
		case 11:
			d.viewComplaints();
			break;
		case 12:
			int k  = 1;
			System.out.println("Which request you want to accept: ");
			Vector<Request> requests = d.getRequests();
			for(Request r: requests){
				System.out.println(k + ") " + r);
				k++;
			}
			String input = reader.readLine();
			int choice = Integer.parseInt(input);
			d.accept(requests.get(choice-1));
			System.out.println("You have accepted request number " + k);
			break;
		case 13:
			int j  = 1;
			System.out.println("Which request you want to reject: ");
			Vector<Request> requests1 = d.getRequests();
			for(Request r: requests1){
				System.out.println(j + ") " + r);
				j++;
			}
			String input3 = reader.readLine();
			int choice3 = Integer.parseInt(input3);
			d.reject(requests1.get(choice3-1));
			System.out.println("You have rejected request number " + j);
			break;
		case 14:
			int kk  = 1;
			System.out.println("Which complaint you want to accept: ");
			TreeSet<Complaint> complaints = d.getComplaints();
			for(Complaint r: complaints){
				System.out.println(kk + ") " + r);
				kk++;
			}
			String input2 = reader.readLine();
			int choice2 = Integer.parseInt(input2)-1;
			Iterator<Complaint> iterator = complaints.iterator();
			int currentIndex = 0;
			while (iterator.hasNext()) {
				Complaint currentElement = iterator.next();
				if (currentIndex == choice2) {
					d.accept(currentElement);
					break;
				}
				currentIndex++;
			}
			System.out.println("You have accepted complaint number " + kk);
			break;
		case 15:
			int jj  = 1;
			System.out.println("Which complaint you want to reject: ");
			TreeSet<Complaint> complaint = d.getComplaints();
			for(Complaint r: complaint){
				System.out.println(jj + ") " + r);
				jj++;
			}
			String input33 = reader.readLine();
			int choice33 = Integer.parseInt(input33)-1;
			Iterator<Complaint> iterator2 = complaint.iterator();
			int currentIndex2 = 0;
			while (iterator2.hasNext()) {
				Complaint currentElement = iterator2.next();
				if (currentIndex2 == choice33) {
					d.reject(currentElement);
					break;
				}
				currentIndex2++;
			}
			System.out.println("You have rejected complaint number " + jj);
			break;
		}

	}


	private static void techSupportCase(int i, TechSupport t) throws IOException {
		switch(i) {
		case 10:
			t.viewNewOrders();
			break;
		case 11:
			t.viewAcceptedOrders();
			break;
		case 12:
			t.viewDoneOrders();
			break;
		case 13:
			t.viewRejectedOrders();
			break;
		case 14:
			t.viewAllOrders();
			break;
		case 15:
			int k  = 1;
			System.out.println("Which order you want to accept: ");
			Vector<Order> orders = t.getTechSupportOrders();
			for(Order r: orders){
				System.out.println(k + ") " + r);
				k++;
			}
			String input = reader.readLine();
			int choice = Integer.parseInt(input);
			t.setOrderAsAccepted(orders.get(choice-1));
			System.out.println("You have accepted order number " + k);
			break;
		case 16:
			int k1  = 1;
			System.out.println("Which order you want to reject: ");
			Vector<Order> orders1 = t.getTechSupportOrders();
			for(Order r: orders1){
				System.out.println(k1 + ") " + r);
				k1++;
			}
			String input1 = reader.readLine();
			int choice1 = Integer.parseInt(input1);
			t.setOrderAsRejected(orders1.get(choice1-1));
			System.out.println("You have rejected order number " + k1);
			break;
		case 17:
			int k2  = 1;
			System.out.println("Which order you want to complete: ");
			Vector<Order> orders2 = t.getTechSupportOrders();
			for(Order r: orders2){
				System.out.println(k2 + ") " + r);
				k2++;
			}
			String input2 = reader.readLine();
			int choice2 = Integer.parseInt(input2);
			t.setOrderAsDone(orders2.get(choice2-1));
			System.out.println("You have completed order number " + k2);
			break;
		}

	}



	private static void managerORCase(int i, ManagerOR m) throws NumberFormatException, IOException, OverlappingLessonException, CourseNotRegisteredException {
		// TODO Auto-generated method stub
		switch(i) {
		case 13:
			// add course to db
			m.addCourse();
			break;
		case 14:
			// add course for registration
			int k = 1;
			System.out.println("To which faculty you want to add course");
			if(db.getFaculties().isEmpty()) {
				db.getFaculties().add(new Faculty(FacultyName.FIT));
				db.getFaculties().add(new Faculty(FacultyName.BS));
				db.getFaculties().add(new Faculty(FacultyName.ISE));
			}
			Set<Faculty> allFaculties = db.getFaculties();
			for(Faculty f: allFaculties) {
				System.out.println(k + ") " + f.getName());
				k++;
			}
			System.out.println("Choose from 1 to " + (k-1) + " (q to quit)");
			String input = reader.readLine();
			if(input.equalsIgnoreCase("q")) {
				System.out.println("Didn't complete");
			}else {
				int choice = Integer.parseInt(input);
				List<Faculty> faculties = new ArrayList<>(allFaculties);
				Faculty chosenFaculty = faculties.get(choice-1);

				int j = 1;
				System.out.println("Which course you want to add\n");
				Vector<Course> courses = db.getCourses();
				for(Course c: courses) {
					System.out.println(j + ") " + c.getCourseCode() + ", " + c.getCourseName());
					j++;
				}
				System.out.println("Choose from 1 to " + (j-1));
				choice = Integer.parseInt(reader.readLine());
				Course chosenCourse = courses.get(choice-1);
				boolean providedCourseType = false;
				CourseType coursetype = CourseType.MINOR;
				while(!providedCourseType) {
					System.out.println("What is the type of the course? 1 - Mandatory, 2 - Major, 3 - Minor");
					int p = Integer.parseInt(reader.readLine());
					switch(p) {
					case 1:
						coursetype = CourseType.MANDATORY;
						providedCourseType = true;
						break;
					case 2:
						coursetype = CourseType.MAJOR;
						providedCourseType = true;
						break;
					case 3:
						providedCourseType = true;
					default: 
						System.out.println("You've provided incorrect course type");
					}
				}
				m.addCoursesForRegistration(chosenFaculty, coursetype, chosenCourse);
			}
			break;
		case 15:
			// assign course for teacher
			while(true) {
				int f = 1;
				System.out.println("Which teacher you want to assign");
				Vector<Teacher> allTeachers = db.getTeachers();
				for(Teacher t: allTeachers) {
					System.out.println(f + ") " + t.getSurname() + " " + t.getName());
					f++;
				}
				System.out.println("Choose from 1 to " + (f-1) + " (q to quit)");
				String input2 = reader.readLine();
				if(input2.equalsIgnoreCase("q")) {
					System.out.println("Didn't complete");
				}else {
					int choice = Integer.parseInt(input2);
					Teacher teacher = allTeachers.get(choice-1);

					int j = 1;
					System.out.println("Which course you want to assingn teacher to\n");
					Vector<Course> courses = db.getCourses();
					for(Course c: courses) {
						System.out.println(j + ") " + c.getCourseCode() + ", " + c.getCourseName());
						j++;
					}
					System.out.println("Choose from 1 to " + (j-1));
					int choice2 = Integer.parseInt(reader.readLine());
					Course course = courses.get(choice2-1);

					m.assignCourseToTeacher(teacher, course);

					System.out.println("\n1) Assign new course \n2)Quit ");
					choice = Integer.parseInt(input2);
					if(choice == 1) continue;
					if(choice == 2) break;
				}
			}
			break;
		case 16:
			// assign lessons to teacher
			Vector<Teacher> teachers= db.getTeachers();
			int g = 1;

			for(Teacher t : teachers) {
				System.out.println(g+") " + t.getTitle() + " " + t.getName() + " " + t.getSurname());
			}
			System.out.println("Choose from 1 to " + (g-1));
			int choice = Integer.parseInt(reader.readLine());
			Teacher teacher = teachers.get(choice-1);
			while(true) {
				System.out.println("Type 'q' to stop assigning lessons");
				String input3 = reader.readLine();
				if(input3.equalsIgnoreCase("q")) break;

				m.assignLesson(teacher, m.createLesson(teacher));
			}
			break;
		}

	}

	  private static void managerDepartmentCase(int i, ManagerDepartment m) throws IOException {
		    switch(i) {
		    case 13:
		      //publish news
		      boolean pinned = false;
		      Topic topic = Topic.LESSON_INFO;
		      System.out.println("Choose topic for news 1 - Research, 2 - Event, 3 - Lesson_info(q to quit)");
		      String input = reader.readLine();
		      if(input.equalsIgnoreCase("q")) {
		        System.out.println("Didn't complete");
		      } else {
		        int p = Integer.parseInt(input);
		        switch (p) {
		        case 1: 
		          topic = Topic.RESEARCH;
		          pinned = true;
		          break;
		        case 2:
		          topic = Topic.EVENT;
		          break;
		        case 3:
		          topic = Topic.LESSON_INFO;
		          break;
		        default:
		          System.out.println("You've provided incorrect topic");
		        }  
		      }
		      System.out.println("Enter title of the news: ");
		      String title = reader.readLine();
		      System.out.println("Enter the contents: ");
		      String content = reader.readLine();
		      News news = new News(topic, title, content, pinned);
		      DataBase.getInstance().getNews().add(news);  
		      break;
		    case 14:
		      //remove news
		      int i1 = 1;
		      System.out.println("Which news you want to remove?");

		      Vector<News> news1 = db.getNews();
		      for(News n: news1) {
		        System.out.println(i1 + ") " + n.getTopic() + ", " + n.getContent());
		        i1++;
		      }
		      System.out.println("Choose from 1 to " + (i1-1) + " (q to quit)");
		      String input1 = reader.readLine();
		      if(input1.equalsIgnoreCase("q")) {
		        System.out.println("Didn't complete");
		      }else {
		        int choice1 = Integer.parseInt(input1);
		        News chosenNews = news1.get(choice1-1);
		        DataBase.getInstance().getNews().remove(chosenNews);
		      }
		      break;
		    case 15:
		      //view signed requests
		      m.viewRequests();
		      break;
		    case 16:
		      //View statistical course report on academic performance
		      int i2 = 1;
		      System.out.println("Which course performance report you want to see?");
		      Vector<Course> courses = DataBase.getInstance().getCourses();
		      for(Course c : courses) {
		        System.out.println(i2 + ") " + c.getCourseCode() + ", " + c.getCourseName());
		        i2++;
		      }
		      System.out.println("Choose from 1 to " + (i2-1) + " (q to quit)");
		      String input3 = reader.readLine();
		      if(input3.equalsIgnoreCase("q")) {
		        System.out.println("Didn't complete");
		      }else {
		        int choice = Integer.parseInt(input3);
		        Course course = courses.get(choice-1);
		        m.coursePerformanceReport(course);
		      }
		      break;

		    }

		  }


	  private static void teacherCase(int i, Teacher t) throws IOException {
			switch(i){
				case 10://Put mark to a student
					t.putMark();
					break;
				case 11: //Send complaint
					t.sendComplaint();
					break;
				case 12: //View Schedule
					t.viewSchedule();
					break;
				case 13: //View sent complaints
					t.viewSentComplaints();
					break;
				case 14: //View student info
					t.viewStudentInfo();
					break;
				case 15: //View taught courses
					t.viewTaughtCourses();
					break;
			}

		}

	private static void graduateStudentCase(int i, GraduateStudent g) {

	}

	private static void adminCase(int i, Admin a) throws IOException {
	    switch(i) {
	    case 10:
	      a.addDean();
	      break;
	    case 11:
	      a.addManagerOR();
	      break;
	    case 12:
	      a.addManagerDepartment();
	      break;
	    case 13:
	      a.addTechSupport();
	      break;
	    case 14:
	      a.addTeacher();
	      break;
	    case 15:
	      a.addStudent();
	      break;
	    case 16:
	      a.addGraduateStudent();
	      break;
	    case 17:
	      a.addEmployeeResearcher();
	      break;
	    case 18:
	      a.addTeacherResearcher();
	      break;
	    case 19:
	      a.addStudentResearcher();
	      break;
	    case 20:
	      int k  = 1;
	      System.out.println("Which teacher you want to make a researcher: ");
	      Vector<Teacher> teachers = db.getTeachers();
	      for(Teacher r: teachers){
	        System.out.println(k + ") " + r);
	        k++;
	      }
	      String input = reader.readLine();
	      int choice = Integer.parseInt(input);
	      a.makeTeacherResearcher(teachers.get(choice-1));
	      System.out.println("You have made teacher a researcher " + k);
	      break;
	    case 21:
	      int k1  = 1;
	      System.out.println("Which student you want to make a researcher: ");
	      Vector<Student> students = db.getStudents();
	      for(Student r: students){
	        System.out.println(k1 + ") " + r);
	        k1++;
	      }
	      String input1 = reader.readLine();
	      int choice1 = Integer.parseInt(input1);
	      a.makeStudentResearcher(students.get(choice1-1));
	      System.out.println("You have made student a researcher " + k1);
	      break;
	    }
	  }
}
