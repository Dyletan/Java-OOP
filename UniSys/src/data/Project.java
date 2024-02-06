package data;
import entities.*;

import java.io.*;
import java.util.*;

public abstract class Project implements Serializable {
    private String topic;
    private Vector<ResearchPaper> publishedPapers;
    private Vector<Researcher> participants;
    {
    	publishedPapers = new Vector<ResearchPaper>();
    	participants = new Vector<Researcher>();
    }

    public Project() {
    }

    public Project(String topic) {
        this.topic = topic;
    }
    public Project(String topic, Vector<ResearchPaper> researchPapers) {
        this(topic);
        publishedPapers = researchPapers;
    }
    public Project(String topic, Vector<ResearchPaper> researchPapers, Vector<Researcher> participants) {
        this(topic, researchPapers);
        this.participants = participants;
    }
   
    
    public void addParticipant(Researcher participant) {
        if (participant != null && !participants.contains(participant)) {
            participants.add(participant);
        } else {
            System.out.println("Invalid participant or participant already exists in the project.");
        }
    }

    public void addResearchPaper(ResearchPaper researchPaper) {
        if (researchPaper != null && !publishedPapers.contains(researchPaper)) {
            publishedPapers.add(researchPaper);
        } else {
            System.out.println("Invalid research paper or research paper already exists in the project.");
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Vector<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public Vector<Researcher> getParticipants() {
        return participants;
    }

    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(topic, project.topic) && Objects.equals(publishedPapers, project.publishedPapers) && Objects.equals(participants, project.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, publishedPapers, participants);
    }

    @Override
    public String toString() {
        return "Project{" +
                "topic='" + topic + '\'' +
                ", publishedPapers=" + publishedPapers +
                ", participants=" + participants +
                '}';
    }
}
