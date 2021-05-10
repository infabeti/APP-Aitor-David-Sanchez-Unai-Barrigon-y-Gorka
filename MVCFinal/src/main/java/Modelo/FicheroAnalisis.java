package Modelo;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FicheroAnalisis {
	private Modelo modelo;
	public FicheroAnalisis(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}
	public void crearFicheroHistorico() {
		String codigoAlimento = null;
		String niflocal = null;
		this.modelo.getConsultasAnalisis().obtenerHistoricoLocal(codigoAlimento,niflocal);
		this.modelo.getConsultasAnalisis().obtenerHistoricoGlobal(codigoAlimento);

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
			Row rowGlobal = sheetGlobal.createRow((short) 0);
			//Falta contenido a introducir
			rowGlobal.createCell(0).setCellValue(createHelper.createRichTextString("Historico Global"));
			rowGlobal.createCell(1).setCellValue(createHelper.createRichTextString("Producto"));
			rowGlobal.createCell(2).setCellValue(createHelper.createRichTextString("Producto"));
			rowGlobal.createCell(3).setCellValue(createHelper.createRichTextString("Fecha"));
			rowGlobal.createCell(4).setCellValue(createHelper.createRichTextString("Porcentaje"));
			
			
			for (int i = 0; i <5;i++) {
				rowGlobal = sheetGlobal.createRow((short) i+1);
				rowGlobal.createCell(0).setCellValue(createHelper.createRichTextString("Historico Global"));
				rowGlobal.createCell(1).setCellValue(createHelper.createRichTextString("Producto"));
				rowGlobal.createCell(2).setCellValue(createHelper.createRichTextString("Producto"));
				rowGlobal.createCell(3).setCellValue(createHelper.createRichTextString("Fecha"));
				rowGlobal.createCell(4).setCellValue(createHelper.createRichTextString("Porcentaje"));
			}
		
			// Historico Local
			Sheet sheetLocal = wb.createSheet("Historico Local");
			for (int i = 0; i < 7; i++) {
				sheetLocal.setColumnWidth(i, 4500);
			}
			Row rowLocal = sheetLocal.createRow((short) 0);
			rowLocal.createCell(0).setCellValue(createHelper.createRichTextString("Historico Local"));
			rowLocal.createCell(1).setCellValue(createHelper.createRichTextString("NIF Local"));
			rowLocal.createCell(2).setCellValue(createHelper.createRichTextString("NIF Local"));
			rowLocal.createCell(3).setCellValue(createHelper.createRichTextString("Producto"));
			rowLocal.createCell(4).setCellValue(createHelper.createRichTextString("Producto"));
			rowLocal.createCell(5).setCellValue(createHelper.createRichTextString("Fecha"));
			rowLocal.createCell(6).setCellValue(createHelper.createRichTextString("Porcentaje"));
			
			for (int i = 0; i <7;i++) {
				rowLocal = sheetLocal.createRow((short) i+1);
				// Falta contenido a introducir
				rowLocal.createCell(0).setCellValue(createHelper.createRichTextString("Historico Local"));
				rowLocal.createCell(1).setCellValue(createHelper.createRichTextString("NIF Local"));
				rowLocal.createCell(2).setCellValue(createHelper.createRichTextString("NIF Local"));
				rowLocal.createCell(3).setCellValue(createHelper.createRichTextString("Producto"));
				rowLocal.createCell(4).setCellValue(createHelper.createRichTextString("Producto"));
				rowLocal.createCell(5).setCellValue(createHelper.createRichTextString("Fecha"));
				rowLocal.createCell(6).setCellValue(createHelper.createRichTextString("Porcentaje"));
			}
			

			
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
