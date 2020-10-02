package model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.TestSendMail.MailConfig;

public class SendMail {
	
	// Mail info
	public class MailConfig {

		public static final String HOST_NAME = "smtp.gmail.com";

		public static final int SSL_PORT = 465; // Port for SSL

		public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

		public static final String APP_EMAIL = "monicalibrarian001@gmail.com"; // your email

		public static final String APP_PASSWORD = "adminmonica@001"; // your password

	}
	
	public static boolean sendMailPassword(String recepient, String password) {
		// 1) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", MailConfig.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", MailConfig.SSL_PORT);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
			}
		});
		
		// Get password
		EmployeeModel employeeModel = new EmployeeModel();
		String password_send = employeeModel.decryptPassword(password);
		
		// 2) Compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MailConfig.APP_EMAIL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

			// 3) Create HTML content
			message.setSubject("Forgot Password");
			String htmlContent = "    <h1>Monica's Library</h1>\r\n" + "    <p>We send you your password</p>\r\n"
					+ "    <p><strong>Your pass:</strong> <span style=\"color:red\"><i>"+ password_send +"</i></span></p>";
			message.setContent(htmlContent, "text/html");

			// 4) Send message
			Transport.send(message);

			return true;
		} catch (MessagingException ex) {
			// Failed
			return false;
		}
	}
	

}
