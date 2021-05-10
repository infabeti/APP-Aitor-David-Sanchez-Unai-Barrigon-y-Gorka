package Modelo;

import java.sql.SQLException;

import bbdd.Conexion;
import bbdd.EjecutarAccion;

public class Modelo {

	private ListaProductos listaProductos = new ListaProductos();
	private ListaPlatos listaPlatos = new ListaPlatos();
	public FuncionesProductos funProd;
	public FuncionesPlatos funPlat;
	private Inserciones inserciones;
	private Consultas consultas;
	private ConsultasListas consultasListas;
	public InsercionesActividades insercionesActividades;
	public Validaciones validaciones;
	private Conexion conexion;
	private ListaProductos listaTemporal = new ListaProductos();
	private ListaPlatos listaTemporalPlatos = new ListaPlatos();
	private TransformadorDatos transformadorDatos = new TransformadorDatos();
	private ConsultasComprobaciones consultasComprobaciones;
	private Utiles utiles;
	private FuncionalidadPoblacion funcionalidadPoblacion;
	private ConseguirDatosBbdd conseguirDatosBbdd;
	private EjecutarAccion ejecutarAccion;
	private ConsultasAnalisis conAnalisis;

	public FuncionalidadPoblacion getFuncionalidadPoblacion() {
		return funcionalidadPoblacion;
	}

	public ConsultasComprobaciones getConsultasComprobaciones() {
		return consultasComprobaciones;
	}

	public Consultas getConsultas() {
		return consultas;
	}

	public Inserciones getInserciones() {
		return inserciones;
	}

	public ConseguirDatosBbdd getConseguirDatosBbdd() {
		return conseguirDatosBbdd;
	}

	public Modelo() throws SQLException {
		conexion = new Conexion();
		funProd = new FuncionesProductos(this);
		funPlat = new FuncionesPlatos(this);
		funcionalidadPoblacion = new FuncionalidadPoblacion(this);
		inserciones = new Inserciones(this);
		consultasComprobaciones = new ConsultasComprobaciones(this);
		consultas = new Consultas(this);
		consultasListas = new ConsultasListas(this);
		insercionesActividades = new InsercionesActividades(this);
		validaciones = new Validaciones();
		utiles = new Utiles();
		conseguirDatosBbdd = new ConseguirDatosBbdd();
		ejecutarAccion = new EjecutarAccion();
		conAnalisis = new ConsultasAnalisis(this);

	}
	
	public ConsultasAnalisis getConsultasAnalisis() {
		return conAnalisis;
	}

	public EjecutarAccion getEjecutarAccion() {
		return ejecutarAccion;
	}

	public Utiles getUtiles() {
		return utiles;
	}

	public ConsultasListas getConsultasListas() {
		return consultasListas;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return this.conexion;
	}

	public void setListaTemporal(ListaProductos listaTemporal) {
		this.listaTemporal = listaTemporal;
	}

	public ListaProductos getListaTemporal() {
		return this.listaTemporal;
	}
	
	public void setListaTemporalPlatos(ListaPlatos listaTemporalPlatos) {
		this.listaTemporalPlatos = listaTemporalPlatos;
	}
	
	public ListaPlatos getListaTemporalPlatos() {
		return this.listaTemporalPlatos;
	}

	public ListaProductos getListaProductos() {
		return this.listaProductos;
	}
	
	public ListaPlatos getListaPlatos() {
		return this.listaPlatos;
	}
	
	public void setListaPlatos(ListaPlatos listaPlatos) {
		this.listaPlatos = listaPlatos;
	}
	
	public void actualizarListaProductosLocal(String nif) throws SQLException{
		this.listaProductos = transformadorDatos.cambiarFormatoListaProductos(consultasListas.cogerProductosLocal(nif));		
	}
	
	public void actualizarListaPlatosLocal(String nif) throws SQLException{
		this.listaPlatos = transformadorDatos.cambiarFormatoListaPlatos(consultasListas.cogerListaPlatos(nif));
	}
}
