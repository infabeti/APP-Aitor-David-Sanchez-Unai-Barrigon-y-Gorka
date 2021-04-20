package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import Controlador.ControladorPanelAnalisis;
import javax.swing.JFormattedTextField;

public class PanelAnalisis extends JPanel{

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelAnalisis controladorPanelAnalisis;
	private JButton btnVolver;
	private JFormattedTextField formattedTextFieldTrans1;
	private JFormattedTextField formattedTextFieldTrans2;

	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);
		
		JLabel lblNombrePanel = new JLabel("Panel big data");
		lblNombrePanel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombrePanel.setBounds(0, 0, 450, 45);
		add(lblNombrePanel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 13));
		btnVolver.setBounds(507, 406, 121, 32);
		add(btnVolver);
		
		JLabel lblTrans1 = new JLabel("Transaccion 1:");
		lblTrans1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTrans1.setBounds(40, 81, 121, 32);
		add(lblTrans1);
		
		JLabel lblTrans2 = new JLabel("Transaccion 2\r\n:");
		lblTrans2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTrans2.setBounds(270, 81, 121, 32);
		add(lblTrans2);
		
		formattedTextFieldTrans1 = new JFormattedTextField();
		formattedTextFieldTrans1.setFont(new Font("Arial", Font.PLAIN, 12));
		formattedTextFieldTrans1.setBounds(140, 85, 97, 26);
		add(formattedTextFieldTrans1);
		
		formattedTextFieldTrans2 = new JFormattedTextField();
		formattedTextFieldTrans2.setFont(new Font("Arial", Font.PLAIN, 12));
		formattedTextFieldTrans2.setBounds(369, 85, 97, 26);
		add(formattedTextFieldTrans2);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCalcular.setBounds(489, 87, 97, 23);
		add(btnCalcular);
		
		JLabel lblInserteLos = new JLabel("* Inserte los codigos de transacci\u00F3n a analizar");
		lblInserteLos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInserteLos.setBounds(10, 45, 299, 32);
		add(lblInserteLos);
		
		initializeEvents();

	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAnalisis));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAnalisis.accionadoBottonVolverPanelPrincipal();
			}
		};
	}
}
