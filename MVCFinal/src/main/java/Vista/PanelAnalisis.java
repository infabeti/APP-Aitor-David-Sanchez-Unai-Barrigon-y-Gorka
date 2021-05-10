package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelAnalisis;

public class PanelAnalisis extends JPanel{

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelAnalisis controladorPanelAnalisis;
	private JButton btnVolver;
	private JComboBox comboTipo;
	private JComboBox comboLocales;
	private JScrollPane scrollProductos1;
	private JScrollPane scrollProductos2;
	private JList listaProductos1;
	private JList listaProductos2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPorcentaje;
	private JLabel lblSeleccionDeProductos;

	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);
		
		JLabel lblNombrePanel = new JLabel("Panel big data");
		lblNombrePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePanel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombrePanel.setBounds(0, 0, 450, 45);
		add(lblNombrePanel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 13));
		btnVolver.setBounds(40, 522, 83, 23);
		add(btnVolver);
		
		JLabel lblProductosAComparar = new JLabel("Productos a comparar");
		lblProductosAComparar.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosAComparar.setFont(new Font("Arial", Font.BOLD, 15));
		lblProductosAComparar.setBounds(216, 142, 220, 32);
		add(lblProductosAComparar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCalcular.setBounds(508, 522, 97, 23);
		add(btnCalcular);
		
		JLabel lblInserteLos = new JLabel("* Inserte los códigos de producto a comparar");
		lblInserteLos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInserteLos.setBounds(10, 45, 299, 32);
		add(lblInserteLos);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Global", "Local"}));
		
		comboTipo.setBounds(642, 33, 141, 22);
		add(comboTipo);
		
		comboLocales = new JComboBox (controladorPanelAnalisis.conseguirLocales());
		comboLocales.setBounds(642, 66, 141, 22);
		comboLocales.setVisible(false);
		add(comboLocales);
		
		listaProductos1 = new JList();

		scrollProductos1 = new JScrollPane();
		scrollProductos1.setBounds(40, 185, 262, 192);
		scrollProductos1.setViewportView(listaProductos1);
		add(scrollProductos1);
		
		
		
		listaProductos2 = new JList();

		scrollProductos2 = new JScrollPane();
		scrollProductos2.setBounds(343, 185, 262, 192);
		scrollProductos2.setViewportView(listaProductos2);
		add(scrollProductos2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(40, 406, 262, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(343, 406, 262, 20);
		add(textField_1);
		
		JLabel lblProducto1 = new JLabel("Producto 1");
		lblProducto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto1.setBounds(95, 381, 141, 14);
		add(lblProducto1);
		
		JLabel lblProducto2 = new JLabel("Producto 2");
		lblProducto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto2.setBounds(412, 381, 141, 14);
		add(lblProducto2);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setBounds(761, 372, 41, 32);
		add(txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje de compra conjunta: ");
		lblPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentaje.setBounds(592, 326, 252, 32);
		add(lblPorcentaje);
		
		lblSeleccionDeProductos = new JLabel("Selecci\u00F3n de productos:");
		lblSeleccionDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionDeProductos.setBounds(460, 37, 172, 14);
		add(lblSeleccionDeProductos);

		actualizarProductos();
	
		
		
		
		
		
		initializeEvents();

	}
	
	private void actualizarProductos() {
		
		if(comboTipo.equals("Global")) {
			
			listaProductos1.setListData(controladorPanelAnalisis.cogerListaPlatos());
			listaProductos2.setListData(controladorPanelAnalisis.cogerListaPlatos());
		}
		else {
			

			
			
			
		}
		
		

	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAnalisis));
		this.comboTipo.addActionListener(listenerComboTipo(this.controladorPanelAnalisis));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAnalisis.accionadoBottonVolverPanelPrincipal();
			}
		};
	}
	
	private ActionListener listenerComboTipo(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			if(comboTipo.getSelectedItem().equals("Local")) {
				
				comboLocales.setVisible(true);
			}
			else if (comboTipo.getSelectedItem().equals("Global")) {
				
				comboLocales.setVisible(false);
				
			}
				
			}
		};
	}
}
