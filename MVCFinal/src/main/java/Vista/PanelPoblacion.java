package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.text.NumberFormatter;

import Controlador.ControladorPanelPoblacion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField.AbstractFormatter;


public class PanelPoblacion extends JPanel {

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelPoblacion controladorPanelPoblacion;
	private JButton btnVolver;
	private JTextField textTrans;
	private JTextField textFecha;
	private JTextField textNif;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDomicilio;

	public PanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelPoblacion = controladorPanelPoblacion;

		setLayout(null);
		
		JLabel lblNombrePanel = new JLabel("Panel poblacion de datos");
		lblNombrePanel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombrePanel.setBounds(115, 22, 450, 45);
		add(lblNombrePanel);
		
		

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(168, 707, 89, 23);
		add(btnVolver);


		JLabel lblTransaccion = new JLabel("Transaccion");
		lblTransaccion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTransaccion.setBounds(30, 78, 102, 15);
		add(lblTransaccion);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(30, 706, 117, 25);
		add(btnFinalizar);

		JButton btnAnadir = new JButton("Seleccionar\r\n");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnadir.setBounds(336, 299, 117, 25);
		add(btnAnadir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 244, 296, 153);
		add(scrollPane);
		JList listaAnnadidos = new JList(/*listaPAnnadidos*/);
		scrollPane.setViewportView(listaAnnadidos);
		listaAnnadidos.setBackground(Color.WHITE);

		ListModel listaPAnnadidos;

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 237, 150, 160);
		add(scrollPane_1);
		
				JList listaProductos = new JList(/*controladorPanelPoblacion.cogerListaProductos()*/);
				scrollPane_1.setViewportView(listaProductos);
				listaProductos.setBackground(Color.WHITE);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCantidad.setBounds(336, 266, 92, 22);
		add(lblCantidad);

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m�nimo
		formatter.setMaximum(99); // valor m�ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		JFormattedTextField TextFieldCantidad = new JFormattedTextField(formatter);
		TextFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad.setBounds(411, 265, 40, 27);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		JLabel lblProdDisp = new JLabel("Productos");
		lblProdDisp.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProdDisp.setBounds(507, 209, 92, 22);
		add(lblProdDisp);

		JLabel lblProductosSeleccionados = new JLabel("Productos Seleccionados");
		lblProductosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductosSeleccionados.setBounds(71, 209, 244, 22);
		add(lblProductosSeleccionados);

		JLabel lblError = new JLabel("");
		lblError.setBounds(30, 166, 332, 31);
		add(lblError);


		JLabel lblLocal1 = new JLabel("Local");
		lblLocal1.setBounds(30, 148, 70, 15);
		lblLocal1.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblLocal1);

		JLabel lblFecha1 = new JLabel("Fecha");
		lblFecha1.setBounds(30, 112, 70, 15);
		lblFecha1.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblFecha1);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(336, 335, 117, 25);
		add(btnEliminar);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(30, 420, 70, 15);
		add(lblTotal);

		JTextField textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(60, 417, 114, 19);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(300, 79, 86, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(300, 113, 70, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(300, 148, 102, 15);
		add(lblNewLabel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 514, 296, 153);
		add(scrollPane_2);
		
		JList listaAnnadidos_1 = new JList();
		scrollPane_2.setViewportView(listaAnnadidos_1);
		listaAnnadidos_1.setBackground(Color.WHITE);
				
				JScrollPane scrollPane_1_2 = new JScrollPane();
				scrollPane_1_2.setBounds(481, 518, 150, 160);
				add(scrollPane_1_2);
				
				JList listaProductos_1 = new JList();
				listaProductos_1.setBackground(Color.WHITE);
				scrollPane_1_2.setViewportView(listaProductos_1);
				
				JLabel lblPlatosSeleccionados = new JLabel("Platos Seleccionados");
				lblPlatosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
				lblPlatosSeleccionados.setBounds(78, 485, 308, 18);
				add(lblPlatosSeleccionados);
				
				JLabel lblPlatos = new JLabel("Platos");
				lblPlatos.setFont(new Font("Arial", Font.PLAIN, 15));
				lblPlatos.setBounds(516, 484, 115, 20);
				add(lblPlatos);
				
				JLabel lblDomicilio = new JLabel("Domicilio");
				lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 15));
				lblDomicilio.setBounds(484, 79, 81, 15);
				add(lblDomicilio);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ticket", "Factura", "Pedido", "Comanda", "Aprovisionamiento"}));
				comboBox.setBounds(527, 22, 126, 26);
				add(comboBox);
				
				textTrans = new JTextField();
				textTrans.setBounds(125, 78, 86, 20);
				add(textTrans);
				textTrans.setColumns(10);
				
				textFecha = new JTextField();
				textFecha.setBounds(88, 110, 86, 20);
				add(textFecha);
				textFecha.setColumns(10);
				
				textNif = new JTextField();
				textNif.setBounds(367, 78, 86, 20);
				add(textNif);
				textNif.setColumns(10);
				
				textNombre = new JTextField();
				textNombre.setBounds(367, 110, 86, 20);
				add(textNombre);
				textNombre.setColumns(10);
				
				textApellido = new JTextField();
				textApellido.setBounds(367, 146, 86, 20);
				add(textApellido);
				textApellido.setColumns(10);
				
				JComboBox comboLocal = new JComboBox();
				comboLocal.setBounds(88, 145, 86, 18);
				add(comboLocal);
				
				textDomicilio = new JTextField();
				textDomicilio.setBounds(553, 78, 86, 20);
				add(textDomicilio);
				textDomicilio.setColumns(10);
				
				JButton btnAnadir_1 = new JButton("Seleccionar\r\n");
				btnAnadir_1.setBounds(336, 579, 117, 25);
				add(btnAnadir_1);
				
				JButton btnEliminar_1 = new JButton("Eliminar");
				btnEliminar_1.setBounds(336, 611, 117, 25);
				add(btnEliminar_1);
				
				JLabel lblCantidad_1 = new JLabel("Cantidad");
				lblCantidad_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblCantidad_1.setBounds(336, 546, 92, 22);
				add(lblCantidad_1);
				
				JFormattedTextField TextFieldCantidad_1 = new JFormattedTextField((AbstractFormatter) null);
				TextFieldCantidad_1.setText("1");
				TextFieldCantidad_1.setFont(new Font("Arial", Font.PLAIN, 12));
				TextFieldCantidad_1.setBounds(411, 545, 40, 27);
				add(TextFieldCantidad_1);
		
		
		initializeEvents();

	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPoblacion));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
			}
		};
	}
}
