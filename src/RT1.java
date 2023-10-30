import java.io.IOException;

//Recuerda que al crear el proyecto debemos desmarcar la casilla Create module-info.java file

public class RT1 {

	public static void main(String[] args) {
//		Captura el entorno de ejecución de la aplicación, captura
//		el curso de ejecudión de la aplicación Java
		Runtime r = Runtime.getRuntime();
		//La clase Runtime es una clase en Java que te permite interactuar con el entorno en tiempo de ejecución del sistema. Runtime.getRuntime() te proporciona una instancia de la clase Runtime.

		String comando = "NOTEPAD";
		// se ha definido el comando "NOTEPAD", que abrirá el Bloc de notas en sistemas Windows cuando se ejecute
		
//		String comando = "cmd /c dir"; no se obtiene ninguna salida, porque la 
//		salida de nuestro programa se redirige a nuestro programa Java, no
//		a la pantalla
		
		Process p;

		try {
			p = r.exec(comando);
			//se utiliza el método exec de la instancia de Runtime para ejecutar el comando especificado
		} catch (IOException e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}

		
	}

}
