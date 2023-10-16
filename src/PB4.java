import java.io.File;
import java.io.IOException;

public class PB4 {

	public static void main(String[] args) {

		
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIRz");
		
		//Declaración de los descriptores dfe los ficheros a donde vamos a redireccionar cada salida del proceso.
		// Standard --> stdout || errores --> stderr
		File fileOut = new File("C:\\Prueba\\salida.txt");
		File fileError = new File("C:\\Prueba\\error.txt");
		
		pb.redirectError(fileError);
		pb.redirectOutput(fileOut);
		
		//Inicio del proceso
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
