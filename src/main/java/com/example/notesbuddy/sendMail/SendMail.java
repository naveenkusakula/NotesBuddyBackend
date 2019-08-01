//<!-- Author: Dhruvi Shah -->
package com.example.notesbuddy.sendMail;

import java.io.FileReader;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendMail {
	
//	 	@Autowired
//	    private JavaMailSender javaMailSender;

	 	
		public void sendMail(String to, String subject, String messageText)  {
			try {
				FileReader fr = new FileReader("src/main/resources/application.properties");
				Properties property = new Properties();
				property.load(fr);
				Properties properties = System.getProperties();
				properties.setProperty("mail.smtp.starttls.required", property.getProperty("spring.mail.properties.mail.smtp.starttls.required"));
				properties.setProperty("mail.smtp.starttls.enabled", property.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
				properties.setProperty("mail.smtp.host", property.getProperty("spring.mail.host"));
				properties.setProperty("mail.smtp.port", property.getProperty("spring.mail.port"));
				properties.put("mail.smtp.auth",property.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));

				Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(property.getProperty("spring.mail.username"),
								property.getProperty("spring.mail.password"));
					}
				});

				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(property.getProperty("spring.mail.username")));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);

				message.setContent(messageText, "text/html");
				Transport.send(message);

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

}
