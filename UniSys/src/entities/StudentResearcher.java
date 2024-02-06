package entities;

import java.io.Serializable;

public class StudentResearcher extends Student implements Researcher, Serializable{
	public StudentResearcher(String userId, Login login, String email, String name, String surname, FacultyName faculty) {
		super(userId, login, email, name, surname, faculty);
	}
	protected String getStartMessage() {
		return super.getStartMessage()
				+ "\n11) View all published papers"
				+ "\n12) View current H-index"
				+ "\n13) Add a new Research paper"
				+ "\n14) Start a new research project";
	}
}
