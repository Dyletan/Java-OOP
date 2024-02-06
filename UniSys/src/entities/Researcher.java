package entities;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;


public interface Researcher {
    default void printPapers(){
        for(ResearchPaper p : getResearchPapers()){
            System.out.println(p); // need to implement toString() of paper
        }
    }
    default int calculateHIndex(){
        List<Integer> citations = new ArrayList<Integer>();

        for (ResearchPaper paper: getResearchPapers()) {
            citations.add(paper.getNumOfCitations());
        }

        // Sort in descending order
        citations.sort((a, b) -> b.compareTo(a));

        int hIndex = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        return hIndex;
    };
    default void addResearchPaper(ResearchPaper paper){
        getResearchPapers().add(paper);
    }
    default void addResearchProject(ResearchProject project){
        getResearchProjects().add(project);
    }

    default Vector<ResearchPaper> getResearchPapers(){
        return DataBase.getInstance().getDataOfResearchers().get(this).getResearchPapers();
    }

    default Vector<ResearchProject> getResearchProjects(){
        return DataBase.getInstance().getDataOfResearchers().get(this).getResearchProjects();
    }
}
