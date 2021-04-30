package Modelo;

import bbdd.*;

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
	private Conexion conexion = new Conexion();
	private ListaProductos listaTemporal = new ListaProductos();
	private ListaPlatos listaTemporalPlatos = new ListaPlatos();
	public java.sql.Connection conexionConn = conexion.getConn();
	private TransformadorDatos transformadorDatos = new TransformadorDatos();
	private ConsultasComprobaciones consultasComprobaciones;
	private Utiles utiles;

	public ConsultasComprobaciones getConsultasComprobaciones() {
		return consultasComprobaciones;
	}

	public Consultas getConsultas() {
		return consultas;
	}

	public Inserciones getInserciones() {
		return inserciones;
	}

	public Modelo() {
		funProd = new FuncionesProductos(this);
		funPlat = new FuncionesPlatos(this);
		inserciones = new Inserciones(conexion);
		consultasComprobaciones = new ConsultasComprobaciones(conexion);
		consultas = new Consultas(conexion);
		consultasListas = new ConsultasListas(conexion);
		insercionesActividades = new InsercionesActividades(conexion);
		validaciones = new Validaciones();
		utiles = new Utiles();
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
	
	public void actualizarListaProductosLocal(String nif){
		this.listaProductos = transformadorDatos.cambiarFormatoListaProductos(consultasListas.cogerProductosLocal(nif));
	}
	
	public void actualizarListaPlatosLocal(String nif){
		this.listaPlatos = transformadorDatos.cambiarFormatoListaPlatos(consultasListas.cogerListaPlatos(nif));
	}
}
