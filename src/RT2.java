import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RT2 {

	public static void main(String[] args) {

		// Campturamos la ejecición de la aplicación:
		Runtime r = Runtime.getRuntime();

		// Ejecuata el comando y luego finaliza
		String comando = "CMD /C DIR";

		// Instaciamos la clase process e inicializamos:
		Process p = null;

		try {
			// Para leer salida, lo que devuelve el método del Runtime, hay que usar el
			// objeto 'Process', que se obtiene con el siguiente comando
			p = r.exec(comando);

			// Capturamos la salida normal que es lo que queremos obtener
			// La clase 'Process' proporciona el método 'getInputStream, para leer el stream
			// de la salida del proceso y así leer lo que el comando ejecuta y lo escriba en
			// consola
			InputStream is = p.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String linea;

			// Leemos linea por linea con el metodo 'readLine()'
			while ((linea = br.readLine()) != null) { // va leyendo líneas, y cuando devulve null para
				System.out.println(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int exitval;
		try {
			exitval = p.waitFor(); // DEvuelve 0 se se ejecuta correctamente o 1 se hay error
			System.out.println("Valor de salida: " + exitval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
