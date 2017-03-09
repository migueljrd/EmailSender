package es.Mauro;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorEmail {
	private ServerSocket sServidor;
	private Socket sCliente;
	private Scanner entrada;
	private String salida;
	private int puerto;
	private String mensaje="";
	public void iniciar(){
		try{
			sServidor=new ServerSocket(9990);
			System.out.println(" - SERVIDOR INICIADO - ");
			System.out.println(" - Esperando Cliente - ");
			sCliente=sServidor.accept();
			entrada=new Scanner (sCliente.getInputStream());
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
		catch(Exception e){
			e.printStackTrace();
			finalizar();
		}
		}
	public void finalizar(){
		try{
			//salida.close();
			entrada.close();
			sCliente.close();
			sServidor.close();
			System.out.print("Conexion Finalizada!!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}