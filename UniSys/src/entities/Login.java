package entities;

import java.io.Serializable;

public class Login implements Serializable{
	private String hashedPassword;
	private String username;

	public Login() {}
	
	public Login(String username, String hashedPassword) {
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	/**
	 * 
	 * @return the method returns hashed form of password
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * 
	 * @param a new hashed password for setter
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	/**
	 * 
	 * @return the method returns user name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param a new user name for setter
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @param old password for checking
	 * @param new password to change
	 * @throws PasswordsDoNotMatchException if the entered old password do not match with current password
	 * @throws WeakPasswordException if new password does not correspond the requirements
	 */
	public void changePassword(String oldPass, String newPass) throws PasswordsDoNotMatchException, WeakPasswordException {
		if (PasswordUtils.checkPassword(PasswordUtils.hashPassword(oldPass), hashedPassword)) {
			if(PasswordUtils.isStrongPassword(newPass)) {
				hashedPassword = PasswordUtils.hashPassword(newPass);
			}
			else {
				throw new WeakPasswordException("The password must have at least 8 letters, upper case letter(s) and digit(s)");
			}
		}else{
			throw new PasswordsDoNotMatchException("The password do not match!!!");
		};
	}
	
	public String toString() {
		return username + " " + hashedPassword;
	}

}
