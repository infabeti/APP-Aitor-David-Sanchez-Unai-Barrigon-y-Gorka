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
import Modelo.ConseguirDatosBbdd;
import Modelo.Consultas;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Modelo.Utiles;
import Vista.Vista;

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
	private ConseguirDatosBbdd conseguirDatosBbddMock = mock(ConseguirDatosBbdd.class);

	
	@Test
	public void navegarPanelPrincipal() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		when(modeloMock.getConseguirDatosBbdd()).thenReturn(conseguirDatosBbddMock);


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

		when(modeloMock.getListaProductos()).thenReturn(listaProductosMock);
		when(modeloMock.getListaPlatos()).thenReturn(listaPlatosMock);
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		when(modeloMock.getConseguirDatosBbdd()).thenReturn(conseguirDatosBbddMock);

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
		when(modeloMock.getConseguirDatosBbdd()).thenReturn(conseguirDatosBbddMock);

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
