package TestControlador;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Controlador.ControladoresPaneles;
import Modelo.ListaPlatos;
import Modelo.ListaProductos;
import Modelo.Modelo;
import Vista.Vista;

public class TestControladoresPaneles {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private ListaProductos listaProductosMock = mock(ListaProductos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);



	ControladoresPaneles controladorPanelesMock = Mockito.mock(ControladoresPaneles.class);
	
	@Test
	public void accionadoBottonVolverPanelPrincipal() {
		when(controladorPanelesMock.getModelo()).thenReturn(modeloMock);
		when(controladorPanelesMock.getVista()).thenReturn(vistaMock);
		when(controladorPanelesMock.getControlador()).thenReturn(controladorMock);
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);


		doCallRealMethod().when(controladorPanelesMock).accionadoBottonVolverPanelPrincipal();
		
		controladorPanelesMock.accionadoBottonVolverPanelPrincipal();
		
		verify(controladorMock, times(1)).navegarPanelPrincipal();
		
	}
	
}
