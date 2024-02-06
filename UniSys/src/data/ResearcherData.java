package data;

import java.io.Serializable;
import java.util.*;

public class ResearcherData implements Serializable {
    private Vector<ResearchPaper> researchPapers;
    private Vector<ResearchProject> researchProjects;

    public ResearcherData() {
    }

    public ResearcherData(Vector<ResearchPaper> researchPapers, Vector<ResearchProject> researchProjects) {
        this.researchPapers = researchPapers;
        this.researchProjects = researchProjects;
    }
    
    public void addResearchPaper(ResearchPaper researchPaper) {
        if (researchPaper != null) {
            researchPapers.add(researchPaper);
            System.out.println("Research paper titled '" + researchPaper.getTitle() + "' has been added.");
        } else {
            System.out.println("Invalid research paper. Cannot add null research paper.");
        }
    }

    public void addResearchProject(ResearchProject researchProject) {
        if (researchProject != null) {
            researchProjects.add(researchProject);
            System.out.println("Research project titled '" + researchProject.getTopic() + "' has been added.");
        } else {
            System.out.println("Invalid research project. Cannot add null research project.");
        }
    }

    public Vector<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(Vector<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    public Vector<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void setResearchProjects(Vector<ResearchProject> researchProjects) {
        this.researchProjects = researchProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearcherData that = (ResearcherData) o;
        return Objects.equals(researchPapers, that.researchPapers) && Objects.equals(researchProjects, that.researchProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(researchPapers, researchProjects);
    }

    @Override
    public String toString() {
        return "ResearcherData{" +
                "researchPapers=" + researchPapers +
                ", researchProjects=" + researchProjects +
                '}';
    }
}
