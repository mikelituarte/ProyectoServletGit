package practicaHibernate;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		
		Properties props = new Properties();

		// Nombre del host de correo, es smtp.gmail.com
		 props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si está disponible
		 props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		 props.setProperty("mail.smtp.port","587");

		// Nombre del usuario
		 props.setProperty("mail.smtp.user", "curso703tic@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		 props.setProperty("mail.smtp.auth", "true");
		 
		 
		 Session session = Session.getDefaultInstance(props);
		 session.setDebug(true);
		 
		 MimeMessage message = new MimeMessage(session);
		 
		// Quien envia el correo
		 message.setFrom(new InternetAddress("curso703tic@gmail.com"));

		 // A quien va dirigido
		 message.addRecipient(Message.RecipientType.TO, new InternetAddress("mikelituarte@gmail.com"));
		 
		 message.setSubject("Hola");
		 message.setText("Mensaje de prueba!!!!!");
		 
		 Transport t = session.getTransport("smtp");
		 t.connect("curso703tic@gmail.com","curso703curso703");
		 t.sendMessage(message,message.getAllRecipients());
		 t.close();
	}
}
