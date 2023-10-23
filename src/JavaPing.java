import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaPing {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();

		Process process = null;

		try {
			process = runtime.exec("ping "+" -t "+"www.google.es"); // Ponemos -t para que siga así de manera infinita
																// (Recordar poner espacio) //Esto es lo que se
																// ejecutara en el CMD

			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (int i = 0; i < 10; i++) {
				System.out.println("Saludo --> " + in.readLine());
			}

		} catch (IOException e) {
			System.out.println("No se puede ejecutar el comando 'ping'");
			System.exit(-1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (process != null) {
			process.destroy(); // Así se destruye el proceso si no es null
		}

		// Para saber si se a ejeutdo correctamente nuestro proceso
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			System.out.println("No se puedo esperar su finalizado");
			System.exit(-1);
			e.printStackTrace();
		}

		System.out.println("Estado de finalización "+process.exitValue());
		//System.exit(0); 
	}

}
