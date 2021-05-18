package Modelo;


import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class FicheroAnalisis {
	private Modelo modelo;

	public void crearFicheroHistorico(ArrayList<String[]> historicoLocal,ArrayList<String[]> historicoGlobal) {

		try {

			Path path = Paths.get("Historico");
			if (!Files.exists(path)) {
				Files.createDirectory(path);
				System.out.println("Carpeta creada");
			}
			System.out.println("Carpeta lista");

	
			// Fecha para saber de cuando es el Historico
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			String fecha = dateFormat.format(cal.getTime());
			
			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			String fecha1 = dateFormat1.format(cal.getTime());
			
			

			FileWriter fich = new FileWriter("Historico\\BayesGlobal"+ fecha + ".csv");
			String texto = "Probabilidad de compra global,,Fecha: "+fecha1+"\n";
			fich.write(texto);
				for (int i = 0; i < 10; i++) {
						fich.write(historicoGlobal.get(i)[0]+","+historicoGlobal.get(i)[1]+","+historicoGlobal.get(i)[2]+"\n");
				}
				fich.close();
		
			FileWriter fich1 = new FileWriter("Historico\\BayesLocal"+ fecha + ".csv");
			String texto1 = "Probabilidad de compra por Local,,Fecha: "+fecha1+"\n";
			fich1.write(texto1);
				int xi = 0;
				for (int i = 0; i < historicoLocal.size(); i++) {
					fich1.write(historicoLocal.get(i)[0]+"\n");
					for(int ix = 1; ix<4;ix++) {
					
						fich1.write(historicoLocal.get(i)[1]+","+historicoLocal.get(i)[2]+","+historicoLocal.get(i)[3]+"\n");//Porcentaje
					}
					xi= xi + 4;
				}
				fich1.close();
			

			System.out.println("Archivo creado");

		}catch(

	Exception ioe)
	{
		System.out.println("Incompleto");
		ioe.printStackTrace();
	}
	}
}
