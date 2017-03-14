package es.Mauro;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ServidorEmail {
	private ServerSocket sServidor;
	private Socket sCliente;
	private Scanner entrada;
	
	public void iniciar(){
		try{
			sServidor=new ServerSocket(9990);
			while(true){
				System.out.println(" - SERVIDOR INICIADO - ");
				System.out.println(" - Esperando Cliente - ");
				sCliente=sServidor.accept();
				new Thread(){
					public void run(){
						try {
							entrada=new Scanner (sCliente.getInputStream());
						}catch (IOException e) {
							e.printStackTrace();
						}
						if(entrada.hasNext()){
							String email=entrada.next();
							System.out.println("Email destinatario:"+email);
							EnvioEmail m=new EnvioEmail();
							m.SendMail(email);
						}else{
							System.out.println("error al obtener email");
						}
						finalizar();
					}
				}.start();
			}
		}catch(Exception e){
			e.printStackTrace();
			finalizar();
		}	
	}

	public void finalizar(){
		try{
			entrada.close();
			sCliente.close();
			System.out.print("¡Conexion finalizada!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}