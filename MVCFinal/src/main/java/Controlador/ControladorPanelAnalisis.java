package Controlador;

import java.util.ArrayList;

import Modelo.Modelo;
import Vista.PanelAnalisis;
import Vista.Vista;

public class ControladorPanelAnalisis extends ControladoresPaneles {

	private PanelAnalisis panelAnalisis;
	private ArrayList<String[]> locales;

	public ControladorPanelAnalisis(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
		this.locales = this.getModelo().getConsultas().conseguirLocales();
	}

	public void mostrarPanel() {
		this.panelAnalisis = makePanelAnalisis(this);
		super.getVista().mostrarPanel(this.panelAnalisis);
		try {
			ArrayList<String[]> historicoLocal = new ArrayList<String[]>();
			for (int j = 0; j < locales.size(); j++) {
				 
				 this.getModelo().getFicheroAnalisis().crearFicheroHistorico(this.getModelo().getConsultasAnalisis().conseguirTopAlimentosLocal(locales.get(j)[0]));
			}
			
			
			
			this.getModelo().getConsultasAnalisis().ejecutarAlgoritmosCalculoProbabilidades();

		} catch (Exception e) {
			System.out.println("Los procedimientos no estan creados en la BBDD");
		}
	}

	public String[] conseguirLocales() {
		String[] nombreLocales = new String[locales.size()];
		int i = 0;
		for (String[] array : locales) {
			nombreLocales[i] = array[1];
			i++;
		}
		return nombreLocales;
	}

	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new PanelAnalisis(controladorPanelAnalisis);
	}

	public String[] cogerListaProductos() {
		return this.getModelo().getListaProductos().getListaProductosString();
	}

	public int conseguirStock(int indexSelected, String producto) {
		return this.getModelo().getConsultas().obtenerStock(devolverNifLocal(indexSelected), producto);
	}

	public String devolverNifLocal(int selectedIndex) {
		if (locales.size() <= 0)
			return "Error de  lectura";
		else
			return locales.get(selectedIndex)[0];
	}
	
	public String[] devolverAnalisis(String codigoAlimento, String nif) {
		
		ArrayList<String> historico;
		
		
		if(nif.equalsIgnoreCase("Global"))
		{
			historico = this.getModelo().getConsultasAnalisis().obtenerHistoricoGlobal(codigoAlimento);

		}
		else
		{
			historico = this.getModelo().getConsultasAnalisis().obtenerHistoricoLocal(codigoAlimento, nif);

		}
		String[] historicoString = new String[historico.size()];
		for (int i = 0; i < historico.size(); i++) {
			historicoString[i] = historico.get(i);
		}
		
		return historicoString;
	}
	

	/*
	 * public ArrayList<String> consultaListaPorcentaje(String nif, String
	 * codProducto) throws SQLException {
	 * 
	 * if (nif =="Global") {
	 * 
	 * return
	 * this.getModelo().getFuncionalidadAnalisis().procedimientoBayesGlobal(); }
	 * else {
	 * 
	 * return this.getModelo().getFuncionalidadAnalisis().procedimientoBayesLocal();
	 * }
	 * 
	 * 
	 * 
	 * }
	 */
}
