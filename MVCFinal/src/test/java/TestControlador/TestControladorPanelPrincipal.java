package TestControlador;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import Controlador.Controlador;
import Controlador.ControladorPanelPrincipal;
import Modelo.Modelo;
import Vista.Vista;

public class TestControladorPanelPrincipal {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);	
	private ControladorPanelPrincipal controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock, vistaMock,
			controladorMock);
	
	@Test
	public void testConstructorControladorPrincipal() {
		assertEquals(controladorPanelPrincipal.getControlador(), controladorMock);
		assertEquals(controladorPanelPrincipal.getVista(), vistaMock);
		assertEquals(controladorPanelPrincipal.getModelo(), modeloMock);
	}
	
	@Test
	public void testAccionadoBottonMostrarPanelAnalisis() {
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelAnalisis();
			
		verify(controladorMock).controladorAnalisisMostrarPanelAnalisis();

	}
	
	@Test
	public void testAccionadoBottonMostrarPanelPoblacion() {
		
		controladorPanelPrincipal = new ControladorPanelPrincipal(modeloMock,
				vistaMock, controladorMock);
			
		controladorPanelPrincipal.accionadoBottonMostrarPanelPoblacion();
			
		verify(controladorMock).controladorPoblacionMostrarPanelPoblacion();

	}
	
}
