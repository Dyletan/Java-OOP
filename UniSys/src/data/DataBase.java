package data;
import entities.*;
import containers.*;
import messages.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataBase implements Serializable {
    private static final long serialVersionUID = -2639818736582000399L;

	private static DataBase instance;

    private Vector<Log> logs;
    private Vector<News> news;
    private HashMap<String, String> logins; // String - username, String2 - hashedPassword
    private Vector<User> users;
    private Vector<Journal> journals;
    private HashMap<Researcher, ResearcherData> dataOfResearchers;
    private Vector<Cabinet> cabinets;
    private HashMap<Teacher, Complaint> complaints; 
    private Map<Course, Vector<Teacher>> teachersByCourse;
    private Set<Faculty> faculties;
    private Vector<Course> courses;

    {
        logs = new Vector<Log>();
        news = new Vector<News>();
        logins = new HashMap<String, String>();
        users = new Vector<User>();
        journals = new Vector<Journal>();
        dataOfResearchers = new HashMap<Researcher, ResearcherData>();
        cabinets = new Vector<Cabinet>();
        complaints = new HashMap<Teacher, Complaint>();
        teachersByCourse = new TreeMap<Course, Vector<Teacher>>();
        faculties = new HashSet<Faculty>();
        courses = new Vector<Course>();
    }
    private DataBase(){};

    public DataBase(Vector<Log> logs, Vector<News> news, HashMap<String, String> logins, Vector<User> users, Vector<Journal> journals, HashMap<Researcher, ResearcherData> dataOfResearchers, Vector<Cabinet> cabinets, HashMap<Teacher, Complaint> complaints, Map<Course, Vector<Teacher>> teachersByCourse, HashSet<Faculty> faculties, Vector<Course> courses) {
        this.logs = logs;
        this.news = news;
        this.logins = logins;
        this.users = users;
        this.journals = journals;
        this.dataOfResearchers = dataOfResearchers;
        this.cabinets = cabinets;
        this.complaints = complaints;
        this.teachersByCourse = teachersByCourse;
        this.faculties = faculties;
        this.courses = courses;
    }

    public static DataBase getInstance() {
        if(instance == null){
            instance = new DataBase();
        }
        return instance;
    }
    public static DataBase getInstance(Vector<Log> logs, Vector<News> news, HashMap<String, String> logins, Vector<User> users, Vector<Journal> journals, HashMap<Researcher, ResearcherData> dataOfResearchers, Vector<Cabinet> cabinets, HashMap<Teacher, Complaint> complaints, Map<Course, Vector<Teacher>> teachersByCourse, HashSet<Faculty> faculties, Vector<Course> courses){
        if(instance == null){
            instance = new DataBase(logs, news, logins, users, journals, dataOfResearchers,  cabinets,  complaints, teachersByCourse,  faculties,  courses);
        }
        return instance;
    }

    public void sendLog(Log log){
        logs.add(log);
    }

    public Vector<Log> getLogs() {
        return logs;
    }

    public void setLogs(Vector<Log> logs) {
        this.logs = logs;
    }

    public Vector<News> getNews() {
        return news;
    }

    public void setNews(Vector<News> news) {
        this.news = news;
    }

    public HashMap<String, String> getLogins() {
        return logins;
    }

    public void setLogins(HashMap<String, String> logins) {
        this.logins = logins;
    }

    public Vector<User> getUsers() {
        return users;
    }

    public void setUsers(Vector<User> users) {
        this.users = users;
    }

    public Vector<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Vector<Journal> journals) {
        this.journals = journals;
    }

    public HashMap<Researcher, ResearcherData> getDataOfResearchers() {
        return dataOfResearchers;
    }

    public void setDataOfResearchers(HashMap<Researcher, ResearcherData> dataOfResearchers) {
        this.dataOfResearchers = dataOfResearchers;
    }

    public Vector<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(Vector<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    public HashMap<Teacher, Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(HashMap<Teacher, Complaint> complaints) {
        this.complaints = complaints;
    }

    public Map<Course, Vector<Teacher>> getTeachersByCourse() {
        return teachersByCourse;
    }

    public void setTeachersByCourse(Map<Course, Vector<Teacher>> teachersByCourse) {
        this.teachersByCourse = teachersByCourse;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(HashSet<Faculty> faculties) {
        this.faculties = faculties;
    }

    public static void setInstance(DataBase instance) {
        DataBase.instance = instance;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }


    public void serialize() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("database.ser"))) {
            out.writeObject(instance);
        }
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("database.ser"))) {
            instance = (DataBase) in.readObject();
        }
    }
    public Vector<Student> getStudents(){
        return users.stream()
                .filter(user -> user instanceof Student)
                .map(user -> (Student) user)
                .collect(Collectors.toCollection(Vector::new));
    }

    public Vector<Teacher> getTeachers(){
        return users.stream()
                .filter(user -> user instanceof Teacher)
                .map(user -> (Teacher) user)
                .collect(Collectors.toCollection(Vector::new));
    }
    public Vector<TechSupport> getTechSupports(){
        return users.stream()
                .filter(user -> user instanceof TechSupport)
                .map(user -> (TechSupport) user)
                .collect(Collectors.toCollection(Vector::new));
    }

    public Vector<Manager> getManagers(){
        return users.stream()
                .filter(user -> user instanceof Manager)
                .map(user -> (Manager) user)
                .collect(Collectors.toCollection(Vector::new));
    }

    public Vector<Dean> getDeans(){
        return users.stream()
                .filter(user -> user instanceof Dean)
                .map(user -> (Dean) user)
                .collect(Collectors.toCollection(Vector::new));
    }
    
    public Vector<Employee> getEmployees(){
        return users.stream()
                .filter(user -> user instanceof Employee)
                .map(user -> (Employee) user)
                .collect(Collectors.toCollection(Vector::new));
    }
    
    public Vector<ManagerDepartment> getManagerDepartment(){
        return users.stream()
                .filter(user -> user instanceof ManagerDepartment)
                .map(user -> (ManagerDepartment) user)
                .collect(Collectors.toCollection(Vector::new));
    }
}
