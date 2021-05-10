package TestModelo;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import Modelo.Ticket;

public class TestTicket {

	@Test
	public void testConstructor() {
		int numTrans = 99;
		Date fecha = new Date(0); //Fecha de tipo Date para insertar en las actividades
		String local = "Ristorante Dr Otker";
		
		Ticket ticket = new Ticket(numTrans, fecha, local);

		assertEquals(99, ticket.getNumTransaccion());
		assertEquals(fecha, ticket.getFecha());
		assertEquals("Ristorante Dr Otker", ticket.getLocal());
	}
	
}
