package entities;


import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

public class Dean extends Employee implements Serializable{
  private static final long serialVersionUID = -4442310344275875906L;
private Vector<Request> requests;
  private TreeSet<Complaint> complaints;
  private FacultyName faculty;
  {
    requests = new Vector<Request>();
    complaints = new TreeSet<Complaint>(new CompareByPriority());
  }
  public Dean() {
  }
  
  public Dean(String userId, Login login, String email, String name, String surname, FacultyName faculty) {
    super(userId, login, email, name, surname);
    this.faculty = faculty;
  }
  
  /**
   * 
   * @param a object of the class Acceptable(request/complaint) which dean want to accept
   */
  public void accept (Acceptable a) {
    a.makeAccepted(1);
    if(a instanceof Request) {
      Request aa = (Request)a;
      Vector<ManagerDepartment> md = DataBase.getInstance().getManagerDepartment();
      int randomIndex = new Random().nextInt(md.size());
      ManagerDepartment i = md.get(randomIndex);
      sendToManager(aa, i);
    }
  }
  
  /**
   * 
   * @param a object of the class Acceptable(request/complaint) which dean want to reject
   */
  public void reject(Acceptable a) {
    a.makeAccepted(-1);
  }

  @Override
  /**
   * 
   * @return the method for hashing fields
   */
  public int hashCode() {
    return Objects.hash(super.hashCode(), requests, complaints);
  }

  @Override
  /**
   * 
   * @return the method for checking equality
   */
  public boolean equals(Object obj) {
    if(!super.equals(obj)) return false;
    Dean d = (Dean)obj;
    return d.requests.equals(this.requests) && d.complaints.equals(this.complaints);
  }

  @Override
  /**
   * 
   * @return the method which returns only accepted requests and complaints
   */
  public String toString() {
    return super.toString();
  }

  public void viewRequests() {
    for(Request r: requests) {
      System.out.println(r);
    }
  }

  /**
   * 
   * @param requests new vector of requests for setter
   */
  public void setRequests(Vector<Request> requests) {
    this.requests = requests;
  }

  public void viewComplaints() {
    for(Complaint c: complaints) {
      System.out.println(c);
    };
  }

  /**
   * 
   * @param complaints new vector of complaints for setter
   */
  public void setComplaints(TreeSet<Complaint> complaints) {
    this.complaints = complaints;
  }

  public FacultyName getFaculty() {
    return faculty;
  }

  public void setFaculty(FacultyName faculty) {
    this.faculty = faculty;
  }
  
  public void sendToManager(Request r, ManagerDepartment m) {
    m.addRequest(r);
  }
  
  public Vector<Request> getRequests(){
    return requests;
  }
  
  public TreeSet<Complaint> getComplaints(){
    return complaints;
  }
  
  protected String getStartMessage() {
       return super.getStartMessage()
         + "\n10) View requests"
         + "\n11) View complaints"
         + "\n12) Accept request"
         + "\n13) Reject request"
         + "\n14) Accept complaint"
         + "\n15) Reject complaint";
      }
}