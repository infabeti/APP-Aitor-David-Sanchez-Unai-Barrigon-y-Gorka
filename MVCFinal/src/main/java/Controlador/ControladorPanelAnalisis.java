package Controlador;

import java.util.ArrayList;

import Modelo.Modelo;
import Vista.PanelAnalisis;
import Vista.Vista;

public class ControladorPanelAnalisis extends ControladoresPaneles{

	private PanelAnalisis panelAnalisis;
	private ArrayList<String[]> locales;

	public ControladorPanelAnalisis(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
		this.locales = this.getModelo().getConsultas().conseguirLocales();
	}

	public void mostrarPanel() {
		this.panelAnalisis = makePanelAnalisis(this);
		super.getVista().mostrarPanel(this.panelAnalisis);
	}
	
	public String[] conseguirLocales() {
		String[] nombreLocales = new String[locales.size()];
		int i = 0;
		for (String[] array : locales) {
			nombreLocales[i] = array[1];
			i++; }
		return nombreLocales;
	}

	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new PanelAnalisis(controladorPanelAnalisis);
	}
	
	public String[] cogerListaProductos() {
		return this.getModelo().getListaProductos().getListaProductosString();}
	
	public String[] cogerListaPlatos() {
		return this.getModelo().getListaPlatos().getListaPlatosString(); }
}
	

