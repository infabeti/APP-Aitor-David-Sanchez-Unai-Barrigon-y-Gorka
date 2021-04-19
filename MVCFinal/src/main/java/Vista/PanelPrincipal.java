package Vista;

import javax.swing.JPanel;


import Controlador.ControladorPanelPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class PanelPrincipal extends JPanel {


	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	
	private JButton btnAnalisis;
	private JButton btnPoblacion;


	public PanelPrincipal(ControladorPanelPrincipal controladorPanelPrincipal, String tipoLocal, String nombreUsuario, String nombreLocal) {
		setBackground(SystemColor.activeCaption);

		
			this.controladorPanelPrincipal = controladorPanelPrincipal;
			
			setLayout(null);
			
			
			btnPoblacion = new JButton("Poblacion");
			btnPoblacion.setBounds(60, 123, 89, 23);
			add(btnPoblacion);
			
			btnAnalisis = new JButton("Analisis");
			btnAnalisis.setBounds(221, 123, 89, 23);
			add(btnAnalisis);
			
			
		
	}
	
	private void initializeEvents() {
		this.btnAnalisis.addActionListener(listenerBotonAnalisis(this.controladorPanelPrincipal));
		this.btnPoblacion.addActionListener(listenerBotonPoblacion(this.controladorPanelPrincipal));
	}
	
	
	
	private ActionListener listenerBotonAnalisis(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				controladorPanelPrincipal.accionadoBottonMostrarPanelAnalisis();
			}
		};
	}
	private ActionListener listenerBotonPoblacion(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				controladorPanelPrincipal.accionadoBottonMostrarPanelPoblacion();
			}
		};
	}
}
