package TestControlador;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelAnalisis;
import Controlador.ControladorPanelPoblacion;
import Modelo.Modelo;
import Vista.Vista;

public class TestControlador {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	
	private ControladorPanelAnalisis controladorPanelAnalisisMock = mock(ControladorPanelAnalisis.class);
	private ControladorPanelPoblacion controladorPanelPoblacionMock = mock(ControladorPanelPoblacion.class);

	private Controlador spyControlador;
	
	
	@Test
	public void navegarPanelPrincipal() {

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelPrincipal();

		verify(spyControlador).controladorPanelPrincipalMostrarPanelPrincipal();;
	}
	
	@Test
	public void navegarPanelPoblacion() {

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelPoblacion();

		verify(spyControlador).controladorPoblacionMostrarPanelPoblacion();;
	}
	
	@Test
	public void navegarPanelAnalisis() {

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelAnalisis();

		verify(spyControlador).controladorAnalisisMostrarPanelAnalisis();
	}
	
	

}
