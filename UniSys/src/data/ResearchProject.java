package data;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.*;
import java.util.*;

public class ResearchProject extends Project implements Serializable {
    public ResearchProject() {
    }

    public ResearchProject(String topic, Researcher superviser) {
        super(topic);
    }
    
    public ResearchProject(String topic, Researcher superviser, Vector<ResearchPaper> researchPapers) {
        super(topic, researchPapers);
    }
    public ResearchProject(String topic, Vector<ResearchPaper> researchPapers, Vector<Researcher> participants) {
        super(topic, researchPapers, participants);
    }
}
