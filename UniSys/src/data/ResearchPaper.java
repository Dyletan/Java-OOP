package data;
import containers.*;
import entities.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class ResearchPaper implements Serializable {
    private String title;
    private Vector<Researcher> authors;
    private Journal journal;
    private LocalDateTime datePublished;
    private Integer numOfCitations;
    private String doi;
    private Integer pages;

    public ResearchPaper() {
    }

    public ResearchPaper(String title, Vector<Researcher> authors, Journal journal, LocalDateTime datePublished, Integer numOfCitations, String doi, Integer pages) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.datePublished = datePublished;
        this.numOfCitations = numOfCitations;
        this.doi = doi;
        this.pages = pages;
        if (journal != null) {
            journal.publishNewPaper(this);;
        }
    }


    public String getCitation(Format format){
        switch (format){
            case BIBTEX:
                return "This is BIBTEX formatted " + title + " research paper";
            case PLAIN:
                return "This is PLAIN formatted " + title + " research paper";
            default:
                return "This is " + title + " research paper";
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Vector<Researcher> getAuthors() {
        return authors;
    }

    public void setAuthors(Vector<Researcher> authors) {
        this.authors = authors;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public LocalDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public Integer getNumOfCitations() {
        return numOfCitations;
    }

    public void setNumOfCitations(Integer numOfCitations) {
        this.numOfCitations = numOfCitations;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", journal=" + journal +
                ", datePublished=" + datePublished +
                ", numOfCitations=" + numOfCitations +
                ", doi='" + doi + '\'' +
                ", pages=" + pages +
                '}';
    }
}
