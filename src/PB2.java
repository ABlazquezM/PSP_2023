import java.io.IOException;
import java.io.InputStream;

public class PB2 {

	public static void main(String[] args) {

		Process p = null;
		try {
			p = new ProcessBuilder("CMD", "/C", "DIR C:").start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		InputStream is = p.getInputStream();
		int c;
		try {
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Camprobación de error
		int exitval;
		try {
			exitval = p.waitFor();
			System.out.println("\nValor de salida: " + exitval);
			if (exitval != 0) {
				System.out.println("\nError en la ejecución de la sentencia"); //Si poner mal el comando DIR aparecerá este mensaje
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
