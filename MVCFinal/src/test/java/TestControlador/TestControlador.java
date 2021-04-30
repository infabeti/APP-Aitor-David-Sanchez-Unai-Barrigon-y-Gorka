package TestControlador;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.Test;
import Controlador.Controlador;
import Controlador.ControladorPanelAnalisis;
import Controlador.ControladorPanelPoblacion;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Utiles;
import Vista.Vista;
import bbdd.Consultas;

public class TestControlador {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);
	private Utiles utilesMock = mock(Utiles.class);
	private ControladorPanelAnalisis controladorPanelAnalisisMock = mock(ControladorPanelAnalisis.class);
	private ControladorPanelPoblacion controladorPanelPoblacionMock = mock(ControladorPanelPoblacion.class);
	private Consultas consultasMock = mock(Consultas.class);
	private Controlador spyControlador;
	private ArrayList<String[]> locales = new ArrayList<String[]>();

	@Test
	public void navegarPanelPrincipal() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelPrincipal();

		verify(spyControlador).controladorPanelPrincipalMostrarPanelPrincipal();
		
	}

	@Test
	public void navegarPanelPoblacion() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		when(modeloMock.getConsultas().conseguirLocales()).thenReturn(locales);
		locales.add(new String[] { "Bar pedro", "12345678h", "bar" });
		// when(controladorPanelPoblacionMock.cogerListaProductos()).thenReturn(new
		// String[] {"1","2"});
		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		when(modeloMock.getListaPlatos()).thenReturn(listaPlatosMock);
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);



		when(modeloMock.getUtiles()).thenReturn(utilesMock);

		when(modeloMock.getListaProductos().getListaProductosString()).thenReturn(new String[] { "1", "2" });

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelPoblacion();

		verify(spyControlador).controladorPoblacionMostrarPanelPoblacion();
	}

	@Test
	public void navegarPanelAnalisis() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		spyControlador = spy(new Controlador(modeloMock, vistaMock));
		doReturn(controladorPanelAnalisisMock).when(spyControlador).makeControladorPanelAnalisis(any(Modelo.class),
				any(Vista.class), any(Controlador.class));
		doReturn(controladorPanelPoblacionMock).when(spyControlador).makeControladorPanelPoblacion(any(Modelo.class),
				any(Vista.class), any(Controlador.class));

		spyControlador.navegarPanelAnalisis();

		verify(spyControlador).controladorAnalisisMostrarPanelAnalisis();
	}

}
