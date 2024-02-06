package entities;

import data.*;
import entities.*;
import messages.*;
import test.UserFactory;
import containers.*;

import java.io.IOException;
import java.io.Serializable;

public class Admin extends Employee{
	private static final long serialVersionUID = -8775704004550437870L;

  
  
  public Admin() {}
  
  public Admin(String userId, Login login, String email, String name, String surname) {
    super(userId, login, email, name, surname);
  }
  
  /**
   * to add new account manager to the database
   * @throws IOException 
   */
  public void addManagerOR() throws IOException {
    addUser(UserFactory.createUser("Manager OR"));
  }
  
  public void addManagerDepartment() throws IOException  {
    addUser(UserFactory.createUser("Manager Department"));
  }
  
  /**
   * to add new account teacher to the database
   * @throws IOException 
   */
  public void addTeacher() throws IOException {
    addUser(UserFactory.createUser("Teacher"));
  }
  
  /**
   * to add new account student to the database
   * @throws IOException 
   */
  public void addStudent() throws IOException {
    addUser(UserFactory.createUser("Student"));
  }
  
  /**
   * to add new account researcher to the database
   * @throws IOException 
   */
  public void addEmployeeResearcher() throws IOException {
    addUser(UserFactory.createUser("Employee Researcher"));
  }
  
  /**
   * to add new account student researcher to the database
   * @throws IOException 
   */
  public void addStudentResearcher() throws IOException {
    addUser(UserFactory.createUser("Student Researcher"));
  }
  
  /**
   * to add new account graduate student to the database
   * @throws IOException 
   */
  public void addGraduateStudent() throws IOException {
    addUser(UserFactory.createUser("Graduate Student"));
  }
  
  /**
   * to add new account teacher researcher to the database
   * @throws IOException 
   */
  public void addTeacherResearcher() throws IOException {
    addUser(UserFactory.createUser("Teacher Researcher"));
  }
  
  /**
   * to add new account dean to the database
   * @throws IOException 
   */
  public void addDean() throws IOException {
    addUser(UserFactory.createUser("Dean"));
  }
  
  /**
   * to add new account techSupport to the database
   * @throws IOException 
   */
  public void addTechSupport() throws IOException {
    addUser(UserFactory.createUser("Tech Support"));
  }
  
  /**
   * 
   * @param to create new user in the database
   */
  public void addUser(User u) {
    DataBase.getInstance().getUsers().add(u);
  }
  /**
   * 
   * @param to remove user in the database
   */
  public void removeUser(User u) {
    DataBase.getInstance().getUsers().remove(u);
  }
  
  /**
   * this method create a new account student researcher and remove old student account
   * @param an object of class Student that get role researcher
   */
  public void makeStudentResearcher(Student s) {
    StudentResearcher sr = (StudentResearcher) s.clone();
    addUser(sr);
    removeUser(s);
  }
  
  /**
   * this method create a new account teacher researcher and remove old teacher account
   * @param an object of class Teacher that get role researcher
   */
  public void makeTeacherResearcher(Teacher t) {
    TeacherResearcher ts = (TeacherResearcher) t.clone();
    addUser(ts);
    removeUser(t);
  }
  
  /**
   * the method prints all log files
   */
  public void seeLogFiles() {
    for(Log l : DataBase.getInstance().getLogs()) {
      System.out.println(l);
    }
  }
  
  protected String getStartMessage() {
       return super.getStartMessage()
         + "\n10) Create dean account"
         + "\n11) Create manager OR account"
         + "\n12) Create manager depatment account"
         + "\n13) Create techSupport account"
         + "\n14) Create teacher account"
         + "\n15) Create student account"
         + "\n16) Create graduate student account"
         + "\n17) Create researcher account"
         + "\n18) Create teacher researcher account"
         + "\n19) Create student researcher account"
         + "\n20) Change teacher to teacher researcher account"
         + "\n21) Change student to student researcher account";
  }
  
}