package entities;

import java.io.Serializable;

import data.ResearchPaper;

public class GraduateStudent extends StudentResearcher{
	DegreeType degree;
	Diploma diploma;

	public GraduateStudent(String userId, Login login, String email, String name,
			String surname, FacultyName faculty, DegreeType degree) {
		super(userId, login, email, name, surname, faculty);
		this.degree = degree;
	}
	
	public void startWritingDiploma(Researcher superviser, String topic) {
		diploma = new Diploma(topic, superviser);
	}
	public void addResearchPaperToDiploma(ResearchPaper paper) {
		if (diploma == null) {
            System.out.println("Diploma has not been initialized. Use startWritingDiploma method first.");
		}else {
			diploma.addResearchPaper(paper);
		}
	}
	
	protected String getStartMessage() {
		return super.getStartMessage();
	}
}
