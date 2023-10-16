import java.io.File;
import java.io.IOException;

public class PB5 {

	public static void main(String[] args) {

		//Crear un fichero .bat en la carpeta prueba con esto: (sin comentarios)
		
		//C:\Prueba\fichero.bat
		//mkdir C:\Prueba\NUEVO --->Creamos directorio NUEVO dentro del directorio Prueba
		//cd C:\Prueba\NUEVO --> me ubico en el directorio creado NUEVO
		//echo FICHERO CREADO!!! --> Mensaje por consola de creacion de fichero
		//echo CREACION FICHERO > C:\Prueba\MiFichero.txt
		//dir C:\Prueba
		//dirz C:\Prueba
		//echo FIN DE EJECUCIÓN COMANDOS!!!
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		
		//Ubn descriptor por cada fichero, salida, error, entradas
		File fileOut = new File("C:\\Prueba\\salida1.txt");
		File fileError = new File("C:\\Prueba\\error1.txt");
		File fileBat = new File("C:\\Prueba\\fichero.bat");
		
		//Redireccionar
		pb.redirectError(fileError);
		pb.redirectInput(fileBat);
		pb.redirectOutput(fileOut);
		
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
