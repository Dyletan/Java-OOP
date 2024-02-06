package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.*;

public class UserFactory {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public UserFactory() {
	}

	public static String createUserId() throws IOException {
		System.out.println("Enter userId: ");
		return reader.readLine();
	}

	public static Login createLogin() throws IOException {
		System.out.println("Enter username: ");
		String username = reader.readLine();
		String password = "";
		while(true) {
			System.out.println("Enter password: ");
			password = reader.readLine();
			if(PasswordUtils.isStrongPassword(password)) {
				break;
			}else {
				System.out.println("Not strong enough password");
			}
			
		}

		return new Login(username, PasswordUtils.hashPassword(password));
	}

	public static String createEmail() throws IOException {
		System.out.println("Enter email: ");
		return reader.readLine();
	}

	public static String createName() throws IOException {
		System.out.println("Enter name: ");
		return reader.readLine();
	}

	public static String createSurname() throws IOException {
		System.out.println("Enter surname: ");
		return reader.readLine();
	}

	public static TeacherTitle createTitle() throws IOException {
		System.out.println("Choose one of the title of teacher: \n1)TUTOR \n2)LECTOR \n3)SENIOR \n4)PROFESSOR");
		TeacherTitle t = TeacherTitle.TUTOR;
		String input = reader.readLine();
		switch(input) {
		case "1":
			t = TeacherTitle.TUTOR;
			break;
		case "2":
			t = TeacherTitle.LECTOR;
			break;
		case "3":
			t = TeacherTitle.SENIOR;
			break;
		case "4":
			t = TeacherTitle.PROFESSOR;
			break;
		}
		return t;
	}

	public static FacultyName createFaculty() throws IOException {
		System.out.println("Choose one of the faculty:"
				+ "\n1)FIT "
				+ "\n2)BS "
				+ "\n3)ISE ");
		FacultyName f = FacultyName.FIT;
		String input = reader.readLine(); 
		switch(input) {
		case "1":
			f = FacultyName.FIT;
			break;
		case "2":
			f = FacultyName.BS;
			break;
		case "3":
			f = FacultyName.ISE;
			break;
		}
		return f;
	}

	public static DegreeType createDegree() throws IOException {
		System.out.println("Choose one of the degree types of graduate student: \n1)MASTER \n2)PHD");
		DegreeType t = DegreeType.MASTER;
		String input = reader.readLine();
		switch(input) {
		case "1":
			t = DegreeType.MASTER;
			break;
		case "2":
			t = DegreeType.PHD;
			break;
		}
		return t;
	}

	public static User createUser(String user) throws IOException {
		switch (user){
		case "Manager OR":
			return new ManagerOR(createUserId(), createLogin(), createEmail(), createName(), createSurname());
		case "Manager Department":
			return new ManagerDepartment(createUserId(), createLogin(), createEmail(), createName(), createSurname());
		case "Tech Support":
			return new TechSupport(createUserId(), createLogin(), createEmail(), createName(), createSurname());
		case "Teacher":
			return new Teacher(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createTitle());
		case "Student":
			return new Student(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createFaculty());
		case "Dean":
			return new Dean(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createFaculty());
		case "Graduate Student":
			return new GraduateStudent(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createFaculty(), createDegree());
		case "Employee Researcher":
			return new EmployeeResearcher(createUserId(), createLogin(), createEmail(), createName(), createSurname());
		case "Student Researcher":
			return new StudentResearcher(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createFaculty());
		case "Teacher Researcher":
			return new TeacherResearcher(createUserId(), createLogin(), createEmail(), createName(), createSurname(), createTitle());
		default:
			return null;
		}
	}
}