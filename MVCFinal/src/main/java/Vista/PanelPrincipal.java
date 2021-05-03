package Vista;

import javax.swing.JPanel;

import Controlador.ControladorPanelPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class PanelPrincipal extends JPanel {


	private static final long serialVersionUID = -2457862673139031544L;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	
	private JButton btnAnalisis;
	private JButton btnPoblacion;


	public PanelPrincipal(ControladorPanelPrincipal controladorPanelPrincipal) {
		setBackground(SystemColor.activeCaption);

		
			this.controladorPanelPrincipal = controladorPanelPrincipal;
			
			setLayout(null);
			
			JLabel lblNombrePanel = new JLabel("Panel principal");
			lblNombrePanel.setFont(new Font("Arial", Font.BOLD, 30));
			lblNombrePanel.setBounds(316, 44, 450, 45);
			add(lblNombrePanel);
			
			
			btnPoblacion = new JButton("POBLACI\u00D3N");
			btnPoblacion.setFont(new Font("Arial", Font.BOLD, 17));
			btnPoblacion.setBounds(231, 198, 386, 74);
			add(btnPoblacion);
			
			btnAnalisis = new JButton("AN\u00C1LISIS");
			btnAnalisis.setFont(new Font("Arial", Font.BOLD, 17));
			btnAnalisis.setBounds(231, 309, 386, 81);
			add(btnAnalisis);
			
		

			initializeEvents();
		
	}
	
	private void initializeEvents() {
		this.btnAnalisis.addActionListener(listenerBotonAnalisis(this.controladorPanelPrincipal));
		this.btnPoblacion.addActionListener(listenerBotonPoblacion(this.controladorPanelPrincipal));
	}
	
	
	
	private ActionListener listenerBotonAnalisis(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Analisis");
				controladorPanelPrincipal.accionadoBottonMostrarPanelAnalisis();
			}
		};
	}
	private ActionListener listenerBotonPoblacion(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Poblacion");
				controladorPanelPrincipal.accionadoBottonMostrarPanelPoblacion();
			}
		};
	}
}
