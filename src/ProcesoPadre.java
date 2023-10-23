import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoPadre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos el proceso hijo
		try {
			Process hijo = new ProcessBuilder("java", "-jar", "C:\\Prueba\\miProcesoHijo.jar").start();

			// Lectura por teclado de la info a envia al proceso hijo
			Scanner sc = new Scanner(System.in);

			// Obtenemos la entreada standard del proceso del hijo (stdin)
			InputStream is = hijo.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			// Salida standrad del proceso (stdout)
			// PrintStream ps = new PrintStream(hijo.getOutputStream());
			OutputStream os = hijo.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

			String cadena = "";

			while (!cadena.equalsIgnoreCase("fin")){
				// Lectura de la cadena de caracteres por teclado
				System.out.println("Introduce una cadea de caracteres: ");
				cadena = sc.nextLine();

				// Se envía la cadena de caracteres proceso hijo
				bw.write(cadena); 
				bw.newLine();
				// ps.println(cadena);

				// Volcado de toda la info
				bw.flush();
				// ps.flush();

				// Lectura de salida del proceso hijo
				System.out.println(br.readLine());

			}
			System.out.println("Proceso finalizado");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
