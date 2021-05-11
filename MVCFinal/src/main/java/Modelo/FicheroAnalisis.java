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

	public void crearFicheroHistorico(String tipo) {

		try {

			Path path = Paths.get("Historico");
			if (!Files.exists(path)) {
				Files.createDirectory(path);
				System.out.println("Carpeta creada");
			}
			System.out.println("Carpeta lista");

			Workbook wb = new HSSFWorkbook();

			CreationHelper createHelper = wb.getCreationHelper();
			
			Row row = null;

			// Fecha para saber de cuando es el Historico
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			String fecha = dateFormat.format(cal.getTime());
/*
			if (niflocal.equals(null)) {
				
				// Historico Global
				Sheet sheetGlobal = wb.createSheet("Historico Global");
				for (int i = 0; i < 5; i++) {
					sheetGlobal.setColumnWidth(i, 4500);
				}				
				
				row = sheetGlobal.createRow((short) 0);
				row.createCell(0).setCellValue(createHelper.createRichTextString("Historico Global"));
				row.createCell(1).setCellValue(createHelper.createRichTextString("Producto"));
				row.createCell(2).setCellValue(createHelper.createRichTextString("Producto"));
				row.createCell(3).setCellValue(createHelper.createRichTextString("Fecha"));
				row.createCell(4).setCellValue(createHelper.createRichTextString("Porcentaje"));

				for (int i = 0; i < HistoricoGlobal.get(0).length; i++) {
					row = sheetGlobal.createRow((short) i + 1);
					row.createCell(0).setCellValue(i + 1);
					row.createCell(1).setCellValue(createHelper.createRichTextString());//IDProducto
					row.createCell(2).setCellValue(createHelper.createRichTextString());//IDProducto
					row.createCell(3).setCellValue(createHelper.createRichTextString());//Fecha
					row.createCell(4).setCellValue(createHelper.createRichTextString());//Porcentaje
				}
				FileOutputStream fileOut = new FileOutputStream("Historico\\BayesGlobal"+tipo + fecha + ".xls");
				wb.write(fileOut);
				fileOut.close();

			} else {

				// Historico Local
				Sheet sheetLocal = wb.createSheet("Historico Local");
				for (int i = 0; i < 7; i++) {
					sheetLocal.setColumnWidth(i, 4500);
				}

				row = sheetLocal.createRow((short) 0);
				row.createCell(0).setCellValue(createHelper.createRichTextString("Historico Local"));
				row.createCell(1).setCellValue(createHelper.createRichTextString("NIF Local"));
				row.createCell(2).setCellValue(createHelper.createRichTextString("NIF Local"));
				row.createCell(3).setCellValue(createHelper.createRichTextString("Producto"));
				row.createCell(4).setCellValue(createHelper.createRichTextString("Producto"));
				row.createCell(5).setCellValue(createHelper.createRichTextString("Fecha"));
				row.createCell(6).setCellValue(createHelper.createRichTextString("Porcentaje"));

				for (int i = 0; i < HistoricoLocal.get(0).length; i++) {
					row = sheetLocal.createRow((short) i + 1);
					row.createCell(0).setCellValue(i + 1);
					row.createCell(1).setCellValue(createHelper.createRichTextString());//LOcal
					row.createCell(2).setCellValue(createHelper.createRichTextString());//Local
					row.createCell(3).setCellValue(createHelper.createRichTextString());//Producto
					row.createCell(4).setCellValue(createHelper.createRichTextString());//Producto
					row.createCell(5).setCellValue(createHelper.createRichTextString());//Fecha
					row.createCell(6).setCellValue(createHelper.createRichTextString());//Porcentaje
				}
				FileOutputStream fileOut = new FileOutputStream(
						"Historico\\BayesLocal" + niflocal + tipo + fecha + ".xls");
				wb.write(fileOut);
				fileOut.close();
			}
*/
			System.out.println("Archivo creado");

		} catch (Exception ioe) {
			System.out.println("Incompleto");
			ioe.printStackTrace();
		}
	}
}
