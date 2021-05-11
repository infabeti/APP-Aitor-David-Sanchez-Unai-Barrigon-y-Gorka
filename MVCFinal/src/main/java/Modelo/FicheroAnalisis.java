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
	public FicheroAnalisis() throws SQLException {
		this.modelo = modelo;
	}
	public void crearFicheroHistorico(String codigoAlimento, String niflocal) {

		ArrayList<String[]> HistoricoLocal = this.modelo.getConsultasAnalisis().obtenerHistoricoLocal(codigoAlimento,niflocal);
		ArrayList<String[]> HistoricoGlobal = this.modelo.getConsultasAnalisis().obtenerHistoricoGlobal(codigoAlimento);

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
			
			
			for (int i = 0; i <HistoricoGlobal.get(0).length;i++) {
				rowGlobal = sheetGlobal.createRow((short) i+1);
				rowGlobal.createCell(0).setCellValue(i);
				rowGlobal.createCell(1).setCellValue(createHelper.createRichTextString(HistoricoGlobal.get(0)[i]));
				rowGlobal.createCell(2).setCellValue(createHelper.createRichTextString(HistoricoGlobal.get(1)[i]));
				rowGlobal.createCell(3).setCellValue(createHelper.createRichTextString(HistoricoGlobal.get(2)[i]));
				rowGlobal.createCell(4).setCellValue(createHelper.createRichTextString(HistoricoGlobal.get(3)[i]));
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
			
			for (int i = 0; i <HistoricoLocal.get(0).length;i++) {
				rowLocal = sheetLocal.createRow((short) i+1);
				// Falta contenido a introducir
				rowLocal.createCell(0).setCellValue(i);
				rowLocal.createCell(1).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(0)[i]));
				rowLocal.createCell(2).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(1)[i]));
				rowLocal.createCell(3).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(2)[i]));
				rowLocal.createCell(4).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(3)[i]));
				rowLocal.createCell(5).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(4)[i]));
				rowLocal.createCell(6).setCellValue(createHelper.createRichTextString(HistoricoLocal.get(5)[i]));
			}
			

			
			// Fecha para saber de cuando es el Historico
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			String fecha = dateFormat.format(cal.getTime());

			FileOutputStream fileOut = new FileOutputStream("Historico\\Bayes" + fecha + ".xls");
			wb.write(fileOut);
			fileOut.close();
			System.out.println("Archivo creado");

		} catch (Exception ioe) {
			System.out.println("Incompleto");
			ioe.printStackTrace();
		}

	}
}
