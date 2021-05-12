package Modelo;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FicheroAnalisis {
	private Modelo modelo;

	public void crearFicheroHistorico() {

		try {

			Path path = Paths.get("Historico");
			if (!Files.exists(path)) {
				Files.createDirectory(path);
				System.out.println("Carpeta creada");
			}
			System.out.println("Carpeta lista");

			Workbook wb = new HSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();
			
			Workbook wb1 = new HSSFWorkbook();
			CreationHelper createHelper1 = wb1.getCreationHelper();
			
			Row row = null;
			Row row1 = null;

			// Fecha para saber de cuando es el Historico
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			String fecha = dateFormat.format(cal.getTime());
			
			DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal1 = Calendar.getInstance();
			String fecha1 = dateFormat.format(cal.getTime());
			
				// Historico Global
				Sheet sheetGlobal = wb.createSheet("Historico Global");
				for (int i = 0; i < 5; i++) {
					sheetGlobal.setColumnWidth(i, 4500);
				}				
				
				row = sheetGlobal.createRow((short) 0);
				row.createCell(0).setCellValue(createHelper.createRichTextString("Probabilidad de compra global del producto"));
				row.createCell(3).setCellValue(createHelper.createRichTextString("Fecha: "+fecha1));

				for (int i = 0; i < 10; i++) {
					row = sheetGlobal.createRow((short) i + 1);
						row.createCell(0).setCellValue(createHelper.createRichTextString("pro"+i));//Producto
						row.createCell(1).setCellValue(createHelper.createRichTextString("pro"+i+1));//Producto
						row.createCell(2).setCellValue(createHelper.createRichTextString("porcentaje"));//Porcentaje
						
				}
				FileOutputStream fileOut = new FileOutputStream("Historico\\BayesGlobal"+ fecha + ".xls");
				wb.write(fileOut);
				fileOut.close();

			
				// Historico Local
				Sheet sheetLocal = wb1.createSheet("Historico por Local");
				for (int i = 0; i < 3; i++) {
					sheetLocal.setColumnWidth(i, 4500);
				}
				row = sheetLocal.createRow((short) 0);
				row.createCell(0).setCellValue(createHelper1.createRichTextString("Probabilidad de compra por Local"));
				row.createCell(2).setCellValue(createHelper1.createRichTextString("Fecha: "+fecha1));
				
				int x = 0;
				for (int i = 0; i < 3; i++) {
					row = sheetLocal.createRow((short) x + 1);
					row.createCell(0).setCellValue(createHelper1.createRichTextString("NombreLocal"));//Local
					for(int ix = 1; ix<4;ix++) {
					row = sheetLocal.createRow((short) x + ix + 1);
					row.createCell(0).setCellValue(createHelper1.createRichTextString("pro"+ix));//Producto
					row.createCell(1).setCellValue(createHelper1.createRichTextString("pro"+ix+1));//Producto
					row.createCell(2).setCellValue(createHelper1.createRichTextString("porcentaje"));//Porcentaje
					}
					x= x + 4;
				}
				FileOutputStream fileOut1 = new FileOutputStream("Historico\\BayesLocal"+ fecha + ".xls");
				wb1.write(fileOut1);
				fileOut.close();
			

			System.out.println("Archivo creado");

		}catch(

	Exception ioe)
	{
		System.out.println("Incompleto");
		ioe.printStackTrace();
	}
	}
}
