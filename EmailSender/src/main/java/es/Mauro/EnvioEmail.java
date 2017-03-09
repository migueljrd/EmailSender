package es.Mauro;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EnvioEmail
{
	 public void SendMail() {
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication("gamingvalleyurjc@gmail.com", "Davidcalvo69");
	                    }
	                });

	        try {
	        	Multipart multiparte = new MimeMultipart();
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("gamingvalleyurjc@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("m.robledod@alumnos.urjc.es"));
	            message.setSubject("Practica POO");
	            message.setText("Echale un ojo y me dices: http://bit.ly/IEN3qB");
	            BodyPart cuerpoMensaje = new MimeBodyPart();
	            cuerpoMensaje = new MimeBodyPart();
	            DataSource fuente = new FileDataSource("C:/Users/miguel/Desktop/pedido.pdf");
	            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
	            cuerpoMensaje.setFileName("pedido.pdf");
	            multiparte.addBodyPart(cuerpoMensaje);
	            message.setContent(multiparte);

	            Transport.send(message);
	            System.out.println( "Su mensaje ha sido enviado");
	            

	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
}