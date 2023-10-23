import java.io.IOException;

public class DestruyoProceso {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		Process miProceso = null;

		try {
			miProceso = runtime.exec("NOTEPAD");
			Thread.sleep(10000);
			System.out.println("Destruyendo el proceso...");
			miProceso.destroy();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}//Proceso padre qu intercambia info on un proceos hijo y este se la envía al padre