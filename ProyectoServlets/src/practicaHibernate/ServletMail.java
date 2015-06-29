package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMail extends HttpServlet{

	private final String DESTINO = "curso703tic@gmail.com";
	
	
	private void enviarMensaje(String destino, String mensaje, String remitente) throws AddressException, MessagingException{
		
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
		// message.setFrom(new InternetAddress(destino));

		 // A quien va dirigido
		 message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
		 //Quitar esta linea si no se desea recibir el mensaje
		 message.addRecipient(Message.RecipientType.CC, new InternetAddress(remitente));
		 
		 message.setSubject("Hola");
		 message.setText(mensaje);
		 
		 Transport t = session.getTransport("smtp");
		 t.connect("curso703tic@gmail.com","curso703curso703");
		 t.sendMessage(message,message.getAllRecipients());
		 t.close();
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		String remitente = req.getParameter("remitente");
		String mensaje = "RESPONDER A: "+ "\"" + remitente.toLowerCase() + "\"\n\n" + (req.getParameter("mensaje"));
		
		try {
			enviarMensaje(DESTINO, mensaje, remitente);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.println("Mensaje Enviado!!!!");
		//out.println("<meta http-equiv=\"Refresh\" content = 2, url = http://172.16.1.19:8090/ProyectoServlets/email.html\"/>");
		resp.sendRedirect("/ProyectoServlets/ServeltMensajeEnviado");
		
	}
	
	
}
