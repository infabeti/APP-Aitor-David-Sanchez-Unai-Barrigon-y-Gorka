package TestModelo;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import Modelo.Aprovisionamiento;

public class TestAprovisionamiento {


	@Test
	public void testConstructor() {
		int numTrans = 99;
		Date fecha = new Date(0); //Fecha de tipo Date para insertar en las actividades
		String local = "Ristorante Dr Otker";
		
		Aprovisionamiento aprov = new Aprovisionamiento(numTrans, fecha, local);

		assertEquals(99, aprov.getNumTransaccion());
		assertEquals(fecha, aprov.getFecha());
		assertEquals("Ristorante Dr Otker", aprov.getLocal());
	}
	
}
