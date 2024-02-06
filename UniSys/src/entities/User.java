package entities;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import containers.*;
import data.*;
import entities.*;
import messages.*;
import test.MethodFactory;


public abstract class User implements Serializable, Observer {
	private String userId;
	private Login login;
	private String email;
	private String name;
	private String surname;
	private Vector<Notification> notifications;
	private Vector<Journal> subscribedJournals;
	protected static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	{
		subscribedJournals = new Vector<Journal>();
		notifications = new Vector<Notification>();
	}

	public User() {}

	public User(String userId, Login login, String email, String name, String surname) {
		this.userId = userId;
		this.login = login;
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	public boolean startSession() throws NumberFormatException, IOException, PasswordsDoNotMatchException, WeakPasswordException, OverlappingLessonException, CourseNotRegisteredException {
		return startSession(this);
	}
	
	public static boolean startSession(User u) throws NumberFormatException, IOException, PasswordsDoNotMatchException, WeakPasswordException, OverlappingLessonException, CourseNotRegisteredException {
		System.out.println(u.getStartMessage());
		String input = reader.readLine();
		while(!input.equals("0")) {
			if(input.equalsIgnoreCase("q")) return false;
			int choice = Integer.parseInt(input);
			MethodFactory.doMethod(choice, u);
			System.out.println(u.getStartMessage());
			input = reader.readLine();
		}
		return true;
	}
	
	protected String getStartMessage() {
		return "What do you want to do? (press 'q' to quit the system)"
				+ "\n If you want to change password type '100'"
				+ "\n0) log out"
				+ "\n1) View news"
				+ "\n2) View notifications"
				+ "\n3) View a subscribed journal"
				+ "\n4) Subscribe to journal"
				+ "\n5) Unsubscribe from journal";
	}


	public void subscribeToJournal(Journal j) throws IOException {
		subscribedJournals.add(j);
		j.addSubscriber(this);
		System.out.println("You've subscribed to " + j.getName() + " journal");
	}
	public void unsubscribeFromJournal(Journal j) throws IOException {
		subscribedJournals.remove(j);
		j.addSubscriber(this);
		System.out.println("You've subscribed to " + j.getName() + " journal");
	}
	@Override
	public void notifyNewPaper(Notification notification) {
		notifications.add(notification);
	}

	public void viewNotifications() {
		for(Notification n : notifications){
			System.out.println(n);
			System.out.println("-------------------------------");
		}
	}

	public void viewJournal() throws IOException {
		int choice = viewSubscribedJournalList();
		if(choice == -1) System.out.println("Didn't view any journal");
		else{
			System.out.println(DataBase.getInstance().getJournals().get(choice));
		}
	}
	public void viewNews() {
		for (News n : DataBase.getInstance().getNews()) {
			System.out.println(n);
		}
	}

	
	public int viewJournalList() throws IOException {
		int i = 1;
		System.out.println("There are these journals:");
		for(Journal j : DataBase.getInstance().getJournals()){
			System.out.println(i+") "+ j.getName());
			i++;
		}
		System.out.println("Which one do you want to pick, from 1 to " + i + " (to quit press q)");
		String userInput = reader.readLine();
		if(userInput.equalsIgnoreCase("q")) return -1;
		return Integer.parseInt(userInput);
	}
	public int viewSubscribedJournalList() throws IOException {
		int i = 1;
		System.out.println("You are subscribed to these journals:");
		for(Journal j : subscribedJournals){
			System.out.println(i+") "+ j.getName());
			i++;
		}
		System.out.println("Which one do you want to pick, from 1 to " + i + " (to quit press q)");
		String userInput = reader.readLine();
		if(userInput.equalsIgnoreCase("q")) return -1;
		return Integer.parseInt(userInput);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Vector<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Vector<Notification> notifications) {
		this.notifications = notifications;
	}

	public Vector<Journal> getSubscribedJournals() {
		return subscribedJournals;
	}

	public void setSubscribedJournals(Vector<Journal> subscribedJournals) {
		this.subscribedJournals = subscribedJournals;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(notifications, user.notifications) && Objects.equals(subscribedJournals, user.subscribedJournals);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, login, email, name, surname, notifications, subscribedJournals);
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", login=" + login +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", notifications=" + notifications +
				", subscribedJournals=" + subscribedJournals +
				'}';
	}


}
