import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoPadre {

	public static void main(String[] args) {
		// crear proceso hijo
		try {
		Process hijo = new ProcessBuilder("java","-jar","C:\\Prueba\\nuevo.jar").start();
		//lectura por teclado de la infroamcion a enviar a proceso hijo
		Scanner in = new Scanner(System.in);
		
		//Obtenemos la entrada estandard del proceso hijo(stdjn)
		BufferedReader br= new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		
		//obtener la salida estandard del proceso hijo (stdout)
		PrintStream ps= new PrintStream(hijo.getOutputStream());
		
		String cadena="";
		
		while(!cadena.equalsIgnoreCase("fin")) {
			//lectura de la cadena de caracteres
			System.out.println("Introduzca una cadena de caracteres: ");
			cadena=in.nextLine();
			//Se envia la cadena de caracteres proceso hijo
			ps.println(cadena);
			//volcamos toda la informacion
			ps.flush();
			//lectura de la salida del proceso hijo
			System.out.println(br.readLine());
		}
		System.out.println("Proceso finalizado");
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
