package Modelo;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FicheroAnalisis {
	public void crearFicheroHistorico() {

		try {
			Path path = Paths.get("Historico");
			if (!Files.exists(path)) {
				Files.createDirectory(path);
				System.out.println("Carpeta creada");
			}
			System.out.println("Carpeta lista");

			Workbook wb = new HSSFWorkbook();
			// Workbook wb = new XSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();

			// Historico Global
			Sheet sheetGlobal = wb.createSheet("Historico Global");
			for (int i = 0; i < 5; i++) {
				sheetGlobal.setColumnWidth(i, 4500);
			}
			// Create a row and put some cells in it. Rows are 0 based.
			Row row1Global = sheetGlobal.createRow((short) 0);
			// Create a cell and put a value in it.
			row1Global.createCell(0).setCellValue(createHelper.createRichTextString("Historico Global"));
			row1Global.createCell(1).setCellValue(createHelper.createRichTextString("Producto"));
			row1Global.createCell(2).setCellValue(createHelper.createRichTextString("Producto"));
			row1Global.createCell(3).setCellValue(createHelper.createRichTextString("Fecha"));
			row1Global.createCell(4).setCellValue(createHelper.createRichTextString("Porcentaje"));

			// Historico Local
			Sheet sheetLocal = wb.createSheet("Historico Local");
			for (int i = 0; i < 7; i++) {
				sheetLocal.setColumnWidth(i, 4500);
			}
			// Create a row and put some cells in it. Rows are 0 based.
			Row row1Local = sheetLocal.createRow((short) 0);
			// Create a cell and put a value in it.
			row1Local.createCell(0).setCellValue(createHelper.createRichTextString("Historico Local"));
			row1Local.createCell(1).setCellValue(createHelper.createRichTextString("NIF Local"));
			row1Local.createCell(2).setCellValue(createHelper.createRichTextString("NIF Local"));
			row1Local.createCell(3).setCellValue(createHelper.createRichTextString("Producto"));
			row1Local.createCell(4).setCellValue(createHelper.createRichTextString("Producto"));
			row1Local.createCell(5).setCellValue(createHelper.createRichTextString("Fecha"));
			row1Local.createCell(6).setCellValue(createHelper.createRichTextString("Porcentaje"));

			// Fecha para saber de cuando es el Historico
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			String fecha = dateFormat.format(cal.getTime());

			FileOutputStream fileOut = new FileOutputStream("Historico\\Analisis" + fecha + ".xls");
			wb.write(fileOut);
			fileOut.close();
			System.out.println("Archivo creado");

		} catch (Exception ioe) {
			System.out.println("Incompleto");
			ioe.printStackTrace();
		}

	}
}
