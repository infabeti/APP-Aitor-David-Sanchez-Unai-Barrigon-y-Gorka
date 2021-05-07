package TestControlador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import Controlador.Controlador;
import Controlador.ControladorPanelPoblacion;
import Modelo.Consultas;
import Modelo.FuncionesPlatos;
import Modelo.FuncionesProductos;
import Modelo.ListaPlatos;
import Modelo.Modelo;
import Modelo.Validaciones;
import Vista.Vista;

public class TestControladorPanelPoblacion {

	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private Consultas consultasMock = mock(Consultas.class);
	private Validaciones validacionesMock = mock(Validaciones.class);
	private FuncionesProductos funcionesProductosMock = mock(FuncionesProductos.class);
	private FuncionesPlatos funcionesPlatosMock = mock(FuncionesPlatos.class);
	private ListaPlatos listaPlatosMock = mock(ListaPlatos.class);


	private ControladorPanelPoblacion controladorPanelPoblacion;
	
	@Before
	public void preparaciones() {
		modeloMock.validaciones = validacionesMock;
		modeloMock.funProd = funcionesProductosMock;
		modeloMock.funPlat = funcionesPlatosMock;

	}

	@Test
	public void testConseguirLocales() {
		// La otra branch del metodo no puedo probarla ya que requiere datos de la bbdd
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		String[] resultado = controladorPanelPoblacion.conseguirLocales();
		String[] resultadoEsperado = new String[] {};

		assertArrayEquals(resultadoEsperado, resultado);
	}
	

	@Test
	public void testConseguirActividadesLocal() {
		// La otra branch del metodo no puedo probarla ya que requiere datos de la bbdd
		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);
		
		assertEquals(controladorPanelPoblacion.conseguirActividadesLocal(-1), "Error de  lectura");

	}
	
	@Test
	public void testcomprobarCamposFALSE() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		double total = 2;
		String nif = "12h";
		String nombre = "Joni";
		String apellido = "Joni";
		
		when(validacionesMock.comprobarCamposString(nif, nombre, apellido)).thenReturn(false);

		
		boolean resultado = controladorPanelPoblacion.comprobarCampos(total, nif, nombre, apellido);
		
		assertEquals(false,resultado);

	}
	
	@Test
	public void testcomprobarCamposTRUE() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		double total = 10;
		String nif = "78945621S";
		String nombre = "Joni";
		String apellido = "Joni";
		
		when(validacionesMock.comprobarCamposString(nif, nombre, apellido)).thenReturn(true);

		boolean resultado = controladorPanelPoblacion.comprobarCampos(total, nif, nombre, apellido);
		
		assertEquals(true,resultado);

	}
	
	@Test
	public void testcomprobarCamposAMBOSFALSE() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		double total = -1;
		String nif = "78945621S";
		String nombre = "Joni";
		String apellido = "Joni";
		
		when(validacionesMock.comprobarCamposString(nif, nombre, apellido)).thenReturn(false);

		boolean resultado = controladorPanelPoblacion.comprobarCampos(total, nif, nombre, apellido);
		
		assertEquals(false,resultado);

	}
	
	@Test
	public void testAccionadoBotonEliminar() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		int pos = 1;
		String eliminar = "Patatas";
		
		when(funcionesProductosMock.funcionalidadeliminarProducto(pos, eliminar, 0.0)).thenReturn(0.0);

		String resultado = controladorPanelPoblacion.accionadoBotonEliminar(pos, eliminar);
		String resultadoEsperado = "0.0";
		assertEquals(resultadoEsperado,resultado);

	}
	
	@Test
	public void testExistePlato() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		String plato = "Patatas";
		
		when(modeloMock.getListaTemporalPlatos()).thenReturn(listaPlatosMock);
		when(listaPlatosMock.devolverPosPlatoString(plato)).thenReturn(1);
		
		int resultado = controladorPanelPoblacion.existePlato(plato);
		int resultadoEsperado = 1;
		assertEquals(resultadoEsperado,resultado);

	}
	
	@Test
	public void testAccionadoBotonAnnadirPlato() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		String plato = "Patatas";
		String cantidad = "1";
		Double total = 0.0;
		
		String[] resultadoEsperado = new String[] {"1 - Patatas 2.0€","2"};

		
		when(funcionesPlatosMock.funcionalidadAnadirPlato(plato, cantidad, total)).thenReturn(resultadoEsperado);
		
		String[] resultado = controladorPanelPoblacion.accionadoBotonAnnadirPlato(plato, cantidad);
		
		assertArrayEquals(resultadoEsperado,resultado);

	}
}
