package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

import containers.*;
import data.DataBase;
import entities.*;

public class Test {
	static DataBase db = DataBase.getInstance();
	static User foundUser;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			DataBase.deserialize();
			db = DataBase.getInstance();
			for(User u : db.getUsers()) {
				System.out.println(u);
			}
//			db.getUsers().remove(4);
//			db.getUsers().remove(5);
//			db.getUsers().add(new Admin("1", new Login("dyl", PasswordUtils.hashPassword("123")), "email", "admin", "adminov"));
//			db.getUsers().add(new StudentResearcher("1", new Login("pakita" , PasswordUtils.hashPassword("Ab1")), "pakita@uni.kz", "Pakita", "Shamoi", FacultyName.FIT));
			System.out.println("Choose your language. Выберите свой язык. Тіліңізді тандаңыз. 1 - En, 2 - Ru, 3 - Kz");
			int langChoice = Integer.parseInt(in.readLine());
			String tag = "en-US";
			switch (langChoice) {
			case 1:
				break;
			case 2:
				tag = "ru-RU";
				break;
			case 3:
				tag = "kk-KZ";
				break;
			default:
				System.out.println("Invalid input");
			}

			//		Locale l = Locale.forLanguageTag(tag);
			//		ResourceBundle r = ResourceBundleSingleton.getInstance(l);
			System.out.println("Welcome!");
			boolean isRunning = true;
			main :while(isRunning){
				try {
					login: while(true){
						System.out.println("If you want to quit press q");
						String input = in.readLine();
						if(input.equalsIgnoreCase("q")) break main;
						System.out.println("Input username");
						String username = in.readLine();
						System.out.println("Input password");
						String textPassword = in.readLine();
						foundUser = DataBase.getInstance().getUsers()
								.stream()
								.filter(u -> u.getLogin().getUsername().equals(username))
								.findFirst()
								.orElse(null);

						if (foundUser != null && entities.PasswordUtils.checkPassword(textPassword, foundUser.getLogin().getHashedPassword())) {
							break login;
						} else {
							System.out.println("User not found or incorrect password");
						}
					}
					isRunning = foundUser.startSession();
					System.out.println("Logging out of your account");
					foundUser = null;
				} catch (Exception e) {
					System.out.println("Something bad happened... \n Saving resources...");
					e.printStackTrace();
					db.serialize();
				}
			}
			System.out.println("You are exiting the University system.\nSaving files... ");
			db.serialize();
			System.out.println("Succesfull!\n exiting the programm.");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}


