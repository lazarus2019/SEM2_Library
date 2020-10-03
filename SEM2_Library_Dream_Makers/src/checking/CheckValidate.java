package checking;

import java.util.regex.Pattern;

public class CheckValidate {
	
	// Check email validate
	public static boolean checkEmail(String email) {
		if(email.length() > 18) {
			return Pattern.matches("^[a-zA-Z][\\w-]+@(gmail.com|GMAIL.COM)$", email);		
		}else {
			return false;
		}
	}
//	
//	// Check password validate
//	public static boolean checkPassword(String password) {
//		
//	}
//	
	// Check username validate
	public static boolean checkUsername(String username) {
		if(username.length() > 18) {
			return Pattern.matches("^emp[\\d]{1,}$", username);		
		}else {
			return false;
		}
	}
}
