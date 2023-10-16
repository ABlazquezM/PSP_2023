import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PB3 {

	public static void main(String[] args) {
		
		ProcessBuilder test = new ProcessBuilder();
		
		//Tratamiento de los argumentos/parámetros pasados al main():
		if(args.length<=0) {
			System.out.println("No tenemos argumentos\n");
		}
		else {
			for (int i = 0;i<args.length;i++) {
				System.out.println("Argumento"+(i+1)+": "+args[i]);
			}
		}
		
		//Captura la variable de entorno de Windows, las almacena en una estructura de clave/valor
		//y las escribe por pantalla
		Map entorno = test.environment();
		
		System.out.println("\nVariables de entorno: ");
		System.out.println(entorno);
		
		//Creamos un proceso 
		test = new ProcessBuilder("java","UnSaludo","\"Hola Mundo!!!\"","\n");
		
		//Devuelve el nombre del programa/proceso y sus argumentos
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("Argumentos del comando: ");
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		test.command("CMD","/C","DIR"); //Si no ponemos /C se va a quedar el control de la ejicucion en la line de comandos, para que finalice el CMD		
	
		try {
			Process p = test.start();
			
			//Capturar la salida del proceso hijo para mostrarlo por consola
			InputStream is = p.getInputStream();
			
			//Escribir linea por linea la salida del proceso hijo por conlosa utilizando un buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			String linea;
			while ((linea = br.readLine()) != null) {
				
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
