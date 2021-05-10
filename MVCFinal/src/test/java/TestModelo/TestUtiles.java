package TestModelo;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import Modelo.Utiles;

public class TestUtiles {
	
	private Utiles utiles = new Utiles();

	@Test
	public void TestGetFechaHoraSys() {
		//Tengo que sacar la fecha hora actual ya que cada vez que se ejecute el test deolvera distinta fechahora
		String resultado = utiles.getFechaHoraSys();

		Date d = new Date();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		String resultadoEsperado = dateFormat.format(d);
		
		assertEquals(resultadoEsperado, resultado);

	}
	
	@Test
	public void TestCogerCantidadString() {
		//Tengo que sacar la fecha hora actual ya que cada vez que se ejecute el test deolvera distinta fechahora
		String linea = "996  - Bocata de tortilla x 2.0€";

		int resultado = utiles.cogerCantidadString(linea);
		int resultadoEsperado = 996;
		
		assertEquals(resultadoEsperado, resultado);

	}
	
}
