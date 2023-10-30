import java.io.IOException;
import java.io.InputStream;

public class PB2 {

	public static void main(String[] args) {

		Process p = null;
		try {
			// Creación y ejecución de un proceso utilizando ProcessBuilder para ejecutar el comando "CMD /C DIR C:" en la línea de comandos de Windows.
			p = new ProcessBuilder("CMD", "/C", "DIR C:").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Captura de la salida del proceso en un InputStream.
		InputStream is = p.getInputStream();
		int c;
		// Variable para almacenar los bytes leídos.
		
		try {
			while ((c = is.read()) != -1) { // Bucle que lee byte a byte desde el InputStream hasta el final (-1).
				System.out.print((char) c); // Imprime cada byte como un carácter en la consola.
			}
			is.close();
			// Cierre del InputStream para liberar recursos.
		} catch (IOException e) {
			e.printStackTrace();
		}

		   // Comprobación de errores y valor de salida del proceso.
		int exitval;
		try {
			exitval = p.waitFor(); //// Espera a que el proceso termine y captura su valor de salida (exit code).
			System.out.println("\nValor de salida: " + exitval); //// Imprime el valor de salida en la consola.
			if (exitval != 0) {
				System.out.println("\nError en la ejecución de la sentencia"); //Si poner mal el comando DIR aparecerá este mensaje
				//// Si el valor de salida no es 0, muestra un mensaje de error.
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
