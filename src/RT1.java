import java.io.IOException;

//Recuerda que al crear el proyecto debemos desmarcar la casilla Create module-info.java file

public class RT1 {

	public static void main(String[] args) {
//		Captura el entorno de ejecución de la aplicación, captura
//		el curso de ejecudión de la aplicación Java
		Runtime r = Runtime.getRuntime();

		String comando = "NOTEPAD";
//		String comando = "cmd /c dir"; no se obtiene ninguna salida, porque la 
//		salida de nuestro programa se redirige a nuestro programa Java, no
//		a la pantalla
		
		Process p;

		try {
			p = r.exec(comando);
		} catch (IOException e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}

	}

}
