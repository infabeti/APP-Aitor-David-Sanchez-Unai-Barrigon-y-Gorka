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
	private JLabel lblNombrePanel;
	private JLabel lblTransaccion;
	private JButton btnFinalizar;
	private JButton btnAnadir;
	private JScrollPane scrollPane;
	private JList listaAnnadidos;
	private JScrollPane scrollPane_1;
	private JLabel lblCantidad ;
	private JList listaProductos;
	private NumberFormat format;
	private NumberFormatter formatter;
	private JFormattedTextField TextFieldCantidad;
	private JLabel lblProdDisp;
	private JLabel lblProductosSeleccionados;
	private JLabel lblNombre;
	private JLabel lblError;
	private JLabel lblLocal1;
	private JLabel lblFecha1;
	private JButton btnEliminar;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2 ;
	private JScrollPane scrollPane_2;
	private JList listaAnnadidos_1;
	private JScrollPane scrollPane_1_2;
	private JList listaProductos_1;
	private JLabel lblPlatosSeleccionados;
	private JLabel lblPlatos;
	private JLabel lblDomicilio;
	private JComboBox comboBox;
	private JComboBox comboLocal;
	private JButton btnAnadir_1; 
	private JButton btnEliminar_1;
	private JLabel lblCantidad_1;
	private JFormattedTextField TextFieldCantidad_1;
	

	public PanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelPoblacion = controladorPanelPoblacion;

		setLayout(null);
		
		lblNombrePanel = new JLabel("Panel poblacion de datos");
		lblNombrePanel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombrePanel.setBounds(115, 22, 450, 45);
		add(lblNombrePanel);
		
		

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(173, 591, 89, 23);
		add(btnVolver);


		lblTransaccion = new JLabel("Transaccion");
		lblTransaccion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTransaccion.setBounds(30, 78, 102, 15);
		add(lblTransaccion);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(40, 590, 117, 25);
		add(btnFinalizar);

		btnAnadir = new JButton("Seleccionar\r\n");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnadir.setBounds(336, 251, 117, 25);
		add(btnAnadir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 207, 296, 153);
		add(scrollPane);
		
		listaAnnadidos = new JList(/*listaPAnnadidos*/);
		scrollPane.setViewportView(listaAnnadidos);
		listaAnnadidos.setBackground(Color.WHITE);
		
		ListModel listaPAnnadidos;

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(463, 196, 150, 160);
		add(scrollPane_1);
		
		listaProductos = new JList(/*controladorPanelPoblacion.cogerListaProductos()*/);
		scrollPane_1.setViewportView(listaProductos);
		listaProductos.setBackground(Color.WHITE);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCantidad.setVisible(false);
		lblCantidad.setBounds(336, 218, 92, 22);
		add(lblCantidad);

		format = NumberFormat.getInstance();
		formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor m�nimo
		formatter.setMaximum(99); // valor m�ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea v�lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		TextFieldCantidad = new JFormattedTextField(formatter);
		TextFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad.setBounds(413, 217, 40, 27);
		
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		lblProdDisp = new JLabel("Productos");
		lblProdDisp.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProdDisp.setBounds(506, 174, 92, 22);
		add(lblProdDisp);

		lblProductosSeleccionados = new JLabel("Productos Seleccionados");
		lblProductosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductosSeleccionados.setBounds(82, 174, 244, 22);
		add(lblProductosSeleccionados);

		lblError = new JLabel("");
		lblError.setBounds(30, 166, 332, 31);
		add(lblError);


		lblLocal1 = new JLabel("Local");
		lblLocal1.setBounds(30, 148, 70, 15);
		lblLocal1.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblLocal1);

		lblFecha1 = new JLabel("Fecha");
		lblFecha1.setBounds(30, 112, 70, 15);
		lblFecha1.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblFecha1);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(336, 287, 117, 25);
		add(btnEliminar);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(30, 371, 70, 15);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(63, 371, 114, 19);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		lblNewLabel = new JLabel("NIF");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(300, 79, 86, 14);
		lblNewLabel.setVisible(false);
		add(lblNewLabel);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(300, 113, 70, 15);
		lblNombre.setVisible(false);
		add(lblNombre);

		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(300, 148, 102, 15);
		lblNewLabel_2.setVisible(false);
		add(lblNewLabel_2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 426, 296, 153);
		add(scrollPane_2);
		
		listaAnnadidos_1 = new JList();
		scrollPane_2.setViewportView(listaAnnadidos_1);
		listaAnnadidos_1.setBackground(Color.WHITE);
		
				
				scrollPane_1_2 = new JScrollPane();
				scrollPane_1_2.setBounds(484, 426, 150, 160);
				add(scrollPane_1_2);
				
				listaProductos_1 = new JList();
				scrollPane_1_2.setViewportView(listaProductos_1);
				listaProductos_1.setBackground(Color.WHITE);
			
				
				lblPlatosSeleccionados = new JLabel("Platos Seleccionados");
				lblPlatosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
				lblPlatosSeleccionados.setBounds(73, 397, 308, 18);
				add(lblPlatosSeleccionados);
				
				lblPlatos = new JLabel("Platos");
				lblPlatos.setFont(new Font("Arial", Font.PLAIN, 15));
				lblPlatos.setBounds(524, 396, 115, 20);
				add(lblPlatos);
				
				lblDomicilio = new JLabel("Domicilio");
				lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 15));
				lblDomicilio.setBounds(484, 79, 81, 15);
				lblDomicilio.setVisible(false);
				add(lblDomicilio);
				
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ticket", "Factura", "Pedido", "Comanda", "Aprovisionamiento"}));
				comboBox.setBounds(527, 22, 126, 26);
				comboBox.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						if(comboBox.getSelectedItem().toString().equals("Ticket")) {
							listaProductos_1.setVisible(false);
							listaAnnadidos_1.setVisible(false);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							textDomicilio.setVisible(false);
							lblNewLabel.setVisible(false);
							lblNombre.setVisible(false);
							lblNewLabel_2.setVisible(false);
							
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnAnadir_1.setVisible(false);	
							btnEliminar_1.setVisible(false);	
							lblDomicilio.setVisible(false);
							lblDomicilio.setVisible(false);
							lblDomicilio.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							
						}
					
						else if(comboBox.getSelectedItem().toString().equals("Comanda")) {
							listaProductos_1.setVisible(true);
							listaAnnadidos_1.setVisible(true);
							listaAnnadidos.setVisible(false);
							listaProductos.setVisible(false);
							lblLocal1.setVisible(true);
						}
					}
				});
				
				
				
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
				textNif.setVisible(false);
				add(textNif);
				textNif.setColumns(10);
				
				textNombre = new JTextField();
				textNombre.setBounds(367, 110, 86, 20);
				textNombre.setVisible(false);
				add(textNombre);
				textNombre.setColumns(10);
				
				textApellido = new JTextField();
				textApellido.setBounds(367, 146, 86, 20);
				textApellido.setVisible(false);
				add(textApellido);
				textApellido.setColumns(10);
				
				comboLocal = new JComboBox();
				comboLocal.setBounds(88, 145, 86, 18);
				add(comboLocal);
				
				textDomicilio = new JTextField();
				textDomicilio.setBounds(553, 78, 86, 20);
				textDomicilio.setVisible(false);
				add(textDomicilio);
				textDomicilio.setColumns(10);
				
				btnAnadir_1 = new JButton("Seleccionar\r\n");
				btnAnadir_1.setBounds(336, 496, 117, 25);
				add(btnAnadir_1);
				
				btnEliminar_1 = new JButton("Eliminar");
				btnEliminar_1.setBounds(336, 532, 117, 25);
				add(btnEliminar_1);
				
				
				lblCantidad_1 = new JLabel("Cantidad");
				lblCantidad_1.setFont(new Font("Arial", Font.PLAIN, 15));
				lblCantidad_1.setBounds(336, 463, 92, 22);
				add(lblCantidad_1);
				
				TextFieldCantidad_1 = new JFormattedTextField((AbstractFormatter) null);
				TextFieldCantidad_1.setText("1");
				TextFieldCantidad_1.setFont(new Font("Arial", Font.PLAIN, 12));
				TextFieldCantidad_1.setBounds(413, 462, 40, 27);
				TextFieldCantidad_1.setVisible(false);
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

