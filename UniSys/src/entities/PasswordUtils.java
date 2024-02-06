package entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
	public static final int MIN_LENGTH = 3; 

	public PasswordUtils() {}

	/**
	 * 
	 * @param the password which we want to hash
	 * @return the method returns hashed form of password
	 */
	public static String hashPassword(String password) {
		try {
			if(isStrongPassword(password)) {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] encodedHash = digest.digest(
						password.getBytes(StandardCharsets.UTF_8));

				StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
				for (byte b : encodedHash) {
					String hex = Integer.toHexString(0xff & b);
					if (hex.length() == 1) {
						hexString.append('0');
					}
					hexString.append(hex);
				}

				return hexString.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * 
	 * @param the password that we want to compare with current password
	 * @param current password in hashed form 
	 * @return boolean result of matching
	 */
	public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
		return (Objects.equals(hashPassword(plainTextPassword), hashedPassword));
	}

	/**
	 * 
	 * @param the password that we want to check for strong level
	 * @return boolean result of matching
	 */
	public static boolean isStrongPassword(String password) {
		return password.length()>=MIN_LENGTH && containsUppercaseLetter(password) && containsDigit(password);
	}

	/**
	 * 
	 * @param the password that we want to check for containing of upper case letter
	 * @return boolean result of matching
	 */
	private static boolean containsUppercaseLetter(String password) {
		Pattern uppercasePattern = Pattern.compile("[A-Z]");
		Matcher matcher = uppercasePattern.matcher(password);
		return matcher.find();
	}

	/**
	 * 
	 * @param the password that we want to check for containing of digit
	 * @return boolean result of matching
	 */
	private static boolean containsDigit(String password) {
		Pattern digitPattern = Pattern.compile("\\d");
		Matcher matcher = digitPattern.matcher(password);
		return matcher.find();
	}
}
