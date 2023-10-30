import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
//MIRIAM Y ANDREA
public class Ejecuta {
   
    public static void main(String[] args) {
    	ProcessBuilder pb = new ProcessBuilder();
    	
    	//Para añadir argumentos debemos pinchar sobre la clase, darle a run as -> run as configuration y en la parte de argumentos porner lo que sea
    	//en este caso un comando ejecutable como cmd /c dir
    	if(args.length<=0) {
			System.out.println("No tenemos argumentos\n");
		}else {
			for(int i=0; i<args.length;i++) {
				System.out.println("Argumento "+(i+1)+": "+args[i]);
			}
			  //devuelve el nombre del programa/proceso y sus argumentos
	  		List l =pb.command();
	  		Iterator iter = l.iterator();
	  		System.out.println("\n Argumento del comando: ");
	  		while(iter.hasNext()) 
	  		{
	  			System.out.println(iter.next());
	  		}
	  		pb.command(args);
	  		try {
	  			Process p = pb.start();
	  			//Capturar la salida del proceso hijo pata mostrarla por consola
	  			
	  			try {//Esepra a que el proceso finalice
					p.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Se ha producido alguna anomalia en la ejecución:" + e.getMessage());
				}
	  			InputStream is=p.getInputStream();
	  			//Escribir linea por linea la salida del proceso hijo para mostrarlo por consola
	  			//utilizando un buffer(BufferReader)
	  			BufferedReader br=new BufferedReader(new InputStreamReader(is));
	  			String linea;
	  		// Lee la primera linea
	  			while((linea = br.readLine()) !=null){
	  				System.out.println(linea);
	  			}
	  					} catch (IOException e) {
	  						System.out.println("Se ha producido alguna anomalia en la ejecución:" + e.getMessage());
	  
	  		}
	    }
	}}