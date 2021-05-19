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
import Modelo.ListaProductos;
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
	private ListaProductos listaProductosMock = mock(ListaProductos.class);



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
	
	@Test
	public void testAccionadoBotonEliminarPlato() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		int posicion = 1;
		String eliminar = "3  - Filete de ternera con patatas 15.99€";
		
		
		Double resultadoEsperado = 10.5;

		
		when(funcionesPlatosMock.funcionalidadeliminarPlato(posicion, eliminar, 0)).thenReturn(resultadoEsperado);
		
		String resultado = controladorPanelPoblacion.accionadoBotonEliminarPlato(posicion, eliminar);
		
		assertEquals(String.valueOf(resultadoEsperado),resultado);

	}
	
	@Test
	public void testExisteProducto() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);
		when(modeloMock.getListaTemporal()).thenReturn(listaProductosMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		int resultadoEsperado = 99;
		String nombreProducto = "Patatas Lays";
		when(listaProductosMock.devolverPosProductoString(nombreProducto)).thenReturn(99);
		
		int resultado = controladorPanelPoblacion.existeProducto(nombreProducto);
		
		assertEquals(resultadoEsperado,resultado);

	}
	
	@Test
	public void testCambiarCantidadProductos() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);

		
		String nombreProductoAnadido = "2  - Coca-cola x 3.6€";
		int cantidadAnadir= 1;
		String nombreProducto = "Coca-cola";
		String tipo = "producto";
		
		String[] resultadoEsperado = new String[] {"3  - Coca-cola x 4.8€","4.8"};
		
		when(funcionesProductosMock.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, 0, tipo)).thenReturn(
				new String[] {"3  - Coca-cola x 4.8€","4.8"});

		
		String[] resultado = controladorPanelPoblacion.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, tipo);
				
		assertArrayEquals(resultadoEsperado,resultado);

	}
	@Test
	public void testAccionadoBotonAnnadirProducto() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);
		
		String producto = "Aquarius";
		String cantidad = "10";
		Double total = 0.0;
		
		when(funcionesProductosMock.funcionalidadAnadirProducto(producto, cantidad, total)).thenReturn(new String[] {
				"10 - Aquarius 18€", "18"
		});

		
		String[] resultado = controladorPanelPoblacion.accionadoBotonAnnadirProducto(producto, cantidad);
				
		String[] resultadoEsperado = new String[] {"10 - Aquarius 18€", "18"};
				
		assertArrayEquals(resultadoEsperado,resultado);

	}
	
	@Test
	public void testDevolverFechaFormateada() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);
		
		String input = "10/05/2021";
		
		String resultadoEsperado = "11/11/1111";
		
		when(validacionesMock.devolverFechaFormateada(input)).thenReturn(resultadoEsperado);
		
		String resultado = controladorPanelPoblacion.devolverFechaFormateada(input);
		
		assertEquals(resultadoEsperado,resultado);
	}
	
	@Test
	public void testConseguirStock() {
		when(modeloMock.getConsultas()).thenReturn(consultasMock);

		controladorPanelPoblacion = new ControladorPanelPoblacion(modeloMock, vistaMock, controladorMock);
		
		int selectedIndex = 3;
		String producto = "Aquarius";
		
		when(consultasMock.obtenerStock(controladorPanelPoblacion.devolverNifLocal(selectedIndex), producto)).thenReturn(777);
		

		int resultado = controladorPanelPoblacion.conseguirStock(selectedIndex,producto);
		int resultadoEsperado = 777;
		
		
		assertEquals(resultadoEsperado,resultado);
	}
}
