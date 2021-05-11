
package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private JScrollPane scrollProductos;
	private JScrollPane scrollPorcentajes;
	private JList listaProductos;
	private JList listaPorcentajes;
	private JTextField productoSeleccionado;
	private JLabel lblSeleccionDeProductos;
	private JButton btnCalcular;
	private JLabel lblRangoFechas;
	private JComboBox comboFecha;
	private JLabel lblLocal;

	public PanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelAnalisis = controladorPanelAnalisis;

		setLayout(null);
		
		JLabel lblNombrePanel = new JLabel("Panel An\u00E1lisis");
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
		lblProductosAComparar.setBounds(60, 142, 220, 32);
		add(lblProductosAComparar);
		
		 btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCalcular.setBounds(428, 412, 97, 23);
		add(btnCalcular);
		
		JLabel lblInserteLos = new JLabel("*Seleccione el producto a comparar");
		lblInserteLos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInserteLos.setBounds(10, 45, 299, 32);
		add(lblInserteLos);
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Global", "Local"}));
		
		comboTipo.setBounds(642, 33, 141, 22);
		add(comboTipo);
		
		comboLocales = new JComboBox (controladorPanelAnalisis.conseguirLocales());
		comboLocales.setBounds(642, 99, 141, 22);
		comboLocales.setVisible(false);
		add(comboLocales);

		scrollProductos = new JScrollPane();
		scrollProductos.setBounds(40, 185, 262, 192);
		add(scrollProductos);
		
		listaProductos = new JList();
		scrollProductos.setViewportView(listaProductos);
		
				listaProductos.setListData(controladorPanelAnalisis.cogerListaProductos());	
		
		productoSeleccionado = new JTextField();
		productoSeleccionado.setEditable(false);
		productoSeleccionado.setBounds(40, 413, 262, 20);
		add(productoSeleccionado);
		productoSeleccionado.setColumns(10);
		
		JLabel lblProducto1 = new JLabel("Producto seleccionado");
		lblProducto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto1.setBounds(103, 388, 141, 14);
		add(lblProducto1);

		lblSeleccionDeProductos = new JLabel("Selecci\u00F3n de productos:");
		lblSeleccionDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionDeProductos.setBounds(460, 37, 172, 14);
		add(lblSeleccionDeProductos);
		
		scrollPorcentajes = new JScrollPane();
		scrollPorcentajes.setBounds(350, 185, 262, 192);
		add(scrollPorcentajes);
		
		listaPorcentajes = new JList();
		scrollPorcentajes.setViewportView(listaPorcentajes);
		
		JLabel lblNewLabel = new JLabel("Porcentaje de compra");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(379, 151, 212, 14);
		add(lblNewLabel);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocal.setBounds(496, 103, 116, 14);
		lblLocal.setVisible(false);
		add(lblLocal);
		
		 comboFecha = new JComboBox();
		comboFecha.setBounds(642, 66, 141, 22);
		comboFecha.setModel(new DefaultComboBoxModel(new String[] {"Diario", "Semanal","Mensual"}));
		add(comboFecha);
		
		
		
		 lblRangoFechas = new JLabel("Rango de fechas: ");
		lblRangoFechas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRangoFechas.setBounds(496, 70, 116, 14);
		add(lblRangoFechas);
		


		try {
			actualizarDatos();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		initializeEvents();

	}
	
	private void actualizarDatos() throws SQLException {
		
		
		controladorPanelAnalisis.getModelo().actualizarListaProductosLocal("12345678H");
		listaProductos.setListData(controladorPanelAnalisis.cogerListaProductos());
	}
	
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAnalisis));
		this.comboTipo.addActionListener(listenerComboTipo(this.controladorPanelAnalisis));
		this.btnCalcular.addActionListener(listenerbotonCalcular(this.controladorPanelAnalisis));
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
				String nif;
			if(comboTipo.getSelectedItem().equals("Local")) {
				try {
					controladorPanelAnalisis.getModelo().actualizarListaProductosLocal(
						nif = 	controladorPanelAnalisis.devolverNifLocal(comboLocales.getSelectedIndex()));
					listaProductos.setListData(controladorPanelAnalisis.cogerListaProductos());
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
				comboLocales.setVisible(true);
				lblLocal.setVisible(true);
			}
			else if (comboTipo.getSelectedItem().equals("Global")) {
				nif = "Global";
				comboLocales.setVisible(false);
				lblLocal.setVisible(false);

				
			}
			
				
			}
		};
	}
	
	private ActionListener listenerbotonCalcular(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String nombreAlimento = (String) listaProductos.getSelectedValue();
				productoSeleccionado.setText(nombreAlimento);
				
	
				
				
				
				String nif = "";
				
				if(nombreAlimento==null) {
					
					JOptionPane.showMessageDialog(null, "Debes seleccionar algún producto");
					
				}
				else {
					
					if(comboTipo.getSelectedItem().equals("Local")) {
						
						nif = controladorPanelAnalisis.devolverNifLocal(comboLocales.getSelectedIndex());
					}
					else if (comboTipo.getSelectedItem().equals("Global")) {
						
						nif = "Global";
						
					}
					
													
					if(comboFecha.getSelectedItem().equals("Diario")) {
						
						controladorPanelAnalisis.cogerFechaAnalisis("Diario");
					}
					else if(comboFecha.getSelectedItem().equals("Semanal")) {
						
						controladorPanelAnalisis.cogerFechaAnalisis("Semanal");
					}
					else if (comboFecha.getSelectedItem().equals("Mensual")) {
						
						controladorPanelAnalisis.cogerFechaAnalisis("Mensual");
					}
					
					String tipoFecha = (String) comboFecha.getSelectedItem();

					controladorPanelAnalisis.consultaListaPorcentaje(nif,controladorPanelAnalisis.getModelo().getConsultas().obtenerCodigoAlimentoProducto(nombreAlimento),tipoFecha);
					
					
				}
				
				
				
				
			}
		};
	}
}
