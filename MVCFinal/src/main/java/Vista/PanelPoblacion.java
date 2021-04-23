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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import Controlador.ControladorPanelPoblacion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class PanelPoblacion extends JPanel {

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelPoblacion controladorPanelPoblacion;
	private JButton btnVolver;
	private JTextField textTrans,textFecha,textNif,textNombre,textApellido,textDomicilio;
	private JLabel lblNombrePanel;
	private JLabel lblTransaccion;
	private JButton btnFinalizar;
	private JButton btnAnadir;
	private JScrollPane scrollPane;
	private JList listaAnnadidos;
	private JScrollPane scrollPane_1;
	private JLabel lblCantidad;
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
	private JLabel lblNIF;
	private JLabel lblApellido;
	private JScrollPane scrollPane_2;
	private JList listaAnnadidos_1;
	private JScrollPane scrollPane_1_2;
	private JList listaProductos_1;
	private JLabel lblPlatosSeleccionados;
	private JLabel lblPlatos;
	private JLabel lblDomicilio;
	private JComboBox<String> comboBoxTipoActividad;
	private JComboBox comboLocal;
	private JButton btnAnadir_1;
	private JButton btnEliminar_1;
	private JLabel lblCantidad_1;
	private JFormattedTextField TextFieldCantidad_1;
	private JButton btnAñadir2;
	private DefaultListModel<String> listaPAnnadidos = new DefaultListModel<String>();


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
		btnFinalizar.setBounds(30, 590, 117, 25);
		add(btnFinalizar);

		btnAnadir = new JButton("Seleccionar\r\n");
		btnAnadir.setBounds(336, 251, 117, 25);
		btnAnadir.setVisible(false);
		add(btnAnadir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 207, 296, 153);
		scrollPane.setVisible(false);
		add(scrollPane);

		listaAnnadidos = new JList(listaPAnnadidos);
		scrollPane.setViewportView(listaAnnadidos);
		listaAnnadidos.setBackground(Color.WHITE);
		listaAnnadidos.setVisible(false);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(463, 196, 150, 160);
		scrollPane_1.setVisible(false);
		add(scrollPane_1);

		listaProductos = new JList(new String[] {"1","2"});
		scrollPane_1.setViewportView(listaProductos);
		listaProductos.setBackground(Color.WHITE);
		listaProductos.setVisible(false);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCantidad.setBounds(336, 218, 92, 22);
		lblCantidad.setVisible(false);
		add(lblCantidad);

		format = NumberFormat.getInstance();
		formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1); // valor mï¿½nimo
		formatter.setMaximum(99); // valor mï¿½ximo
		formatter.setAllowsInvalid(false);
		// Si quieres comprobar que sea vï¿½lido, cada vez que se pulse una tecla
		formatter.setCommitsOnValidEdit(true);

		TextFieldCantidad = new JFormattedTextField(formatter);
		TextFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad.setBounds(413, 217, 40, 27);
		TextFieldCantidad.setVisible(false);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		lblProdDisp = new JLabel("Productos");
		lblProdDisp.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProdDisp.setBounds(506, 174, 92, 22);
		lblProdDisp.setVisible(false);
		add(lblProdDisp);

		lblProductosSeleccionados = new JLabel("Productos Seleccionados");
		lblProductosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductosSeleccionados.setBounds(82, 174, 244, 22);
		lblProductosSeleccionados.setVisible(false);
		add(lblProductosSeleccionados);

		lblError = new JLabel("");
		lblError.setBounds(30, 166, 332, 31);
		lblError.setVisible(false);
		add(lblError);

		lblLocal1 = new JLabel("Local");
		lblLocal1.setBounds(30, 148, 70, 15);
		lblLocal1.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblLocal1);

		lblFecha1 = new JLabel("Fecha");
		lblFecha1.setBounds(30, 112, 70, 15);
		lblFecha1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFecha1.setVisible(true);
		add(lblFecha1);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(336, 287, 117, 25);
		btnEliminar.setVisible(false);
		add(btnEliminar);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(30, 371, 70, 15);
		lblTotal.setVisible(false);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(63, 371, 114, 19);
		textTotal.setVisible(false);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		lblNIF = new JLabel("NIF");
		lblNIF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNIF.setBounds(300, 79, 86, 14);
		lblNIF.setVisible(false);
		add(lblNIF);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(300, 113, 70, 15);
		lblNombre.setVisible(false);
		add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 15));
		lblApellido.setBounds(300, 148, 102, 15);
		lblApellido.setVisible(false);
		add(lblApellido);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 426, 296, 153);
		add(scrollPane_2);
		scrollPane_2.setVisible(false);
		listaAnnadidos_1 = new JList();
		scrollPane_2.setViewportView(listaAnnadidos_1);
		listaAnnadidos_1.setBackground(Color.WHITE);

		scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(484, 426, 150, 160);
		scrollPane_1_2.setVisible(false);
		add(scrollPane_1_2);

		listaProductos_1 = new JList();
		scrollPane_1_2.setViewportView(listaProductos_1);
		listaProductos_1.setBackground(Color.WHITE);
		listaProductos_1.setVisible(false);

		lblPlatosSeleccionados = new JLabel("Platos Seleccionados");
		lblPlatosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPlatosSeleccionados.setBounds(73, 397, 308, 18);
		lblPlatosSeleccionados.setVisible(false);
		add(lblPlatosSeleccionados);

		lblPlatos = new JLabel("Platos");
		lblPlatos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPlatos.setBounds(524, 396, 115, 20);
		lblPlatos.setVisible(false);
		add(lblPlatos);

		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDomicilio.setBounds(484, 79, 81, 15);
		lblDomicilio.setVisible(false);
		add(lblDomicilio);

		textTrans = new JTextField();
		textTrans.setBounds(125, 75, 125, 23);
		textTrans.setVisible(true);
		textTrans.setColumns(10);
		textTrans.setText(controladorPanelPoblacion.leerNumTransBBDD());
		textTrans.setEditable(false);
		textTrans.setHorizontalAlignment(SwingConstants.CENTER);
		add(textTrans);

		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setBounds(88, 104, 162, 26);
		textFecha.setVisible(true);
		add(textFecha);
		textFecha.setColumns(10);
		textFecha.setText(this.controladorPanelPoblacion.devolverFechaHora());
		textFecha.setEditable(false);

		textNif = new JTextField();
		textNif.setBounds(367, 78, 86, 20);
		textNif.setVisible(false);
		textNif.setColumns(10);
		add(textNif);

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

		comboLocal = new JComboBox(controladorPanelPoblacion.conseguirLocales());
		comboLocal.setBounds(88, 138, 162, 25);
		comboLocal.setVisible(true);
		add(comboLocal);

		textDomicilio = new JTextField();
		textDomicilio.setBounds(553, 78, 86, 20);
		textDomicilio.setVisible(false);
		add(textDomicilio);
		textDomicilio.setColumns(10);

		btnAnadir_1 = new JButton("Seleccionar\r\n");
		btnAnadir_1.setBounds(336, 496, 117, 25);
		btnAnadir_1.setVisible(false);
		add(btnAnadir_1);

		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(336, 532, 117, 25);
		btnEliminar_1.setVisible(false);
		add(btnEliminar_1);

		lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCantidad_1.setBounds(336, 463, 92, 22);
		lblCantidad_1.setVisible(false);
		add(lblCantidad_1);

		TextFieldCantidad_1 = new JFormattedTextField((AbstractFormatter) null);
		TextFieldCantidad_1.setText("1");
		TextFieldCantidad_1.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad_1.setBounds(413, 462, 40, 27);
		TextFieldCantidad_1.setVisible(false);
		add(TextFieldCantidad_1);
		comboBoxTipoActividad = new JComboBox<String>();
		comboBoxTipoActividad.setModel(new DefaultComboBoxModel(
				new String[] {"Ticket", "Factura", "Pedido", "Comanda", "Aprovisionamiento" }));
		comboBoxTipoActividad.setBounds(527, 22, 126, 26);
		add(comboBoxTipoActividad);

		btnAñadir2 = new JButton("A\u00F1adir");
		btnAñadir2.setBounds(346, 252, 89, 23);
		btnAñadir2.setVisible(false);
		add(btnAñadir2);


		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPoblacion));
		this.btnAnadir.addActionListener(listenerBotonAnadir(this.controladorPanelPoblacion));
		this.comboBoxTipoActividad.addActionListener(listenerComboActividad(this.controladorPanelPoblacion));
		this.comboLocal.addActionListener(listenerComboLocal(this.controladorPanelPoblacion));
	}
	
	private ActionListener listenerComboLocal(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPoblacion.getModelo().actualizarListaProductosLocal(controladorPanelPoblacion.devolverNifLocal(comboLocal.getSelectedIndex()));
				listaProductos = new JList(controladorPanelPoblacion.cogerListaProductos());
System.out.println("*********************************************************************");

			}
		};
	}
	
	private ActionListener listenerComboActividad(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

						if (comboBoxTipoActividad.getSelectedItem().toString().equals("Ticket")) {
							listaProductos_1.setVisible(true);
							listaAnnadidos_1.setVisible(true);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnAnadir.setVisible(true);
							btnEliminar.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnAnadir_1.setVisible(false);
							btnEliminar_1.setVisible(false);
							lblDomicilio.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPane_2.setVisible(false);
							scrollPane_1_2.setVisible(false);
							textDomicilio.setVisible(false);
							scrollPane_1.setVisible(true);
							scrollPane.setVisible(true);
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							lblNombre.setVisible(false);
							lblApellido.setVisible(false);
							lblNIF.setVisible(false);
							scrollPane_2.setVisible(false);
							scrollPane_1_2.setVisible(false);
							btnAñadir2.setVisible(false);
						}

						else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Factura")) {
							listaProductos_1.setVisible(false);
							listaAnnadidos_1.setVisible(false);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnAnadir.setVisible(true);
							btnEliminar.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnAnadir_1.setVisible(false);
							btnEliminar_1.setVisible(false);
							lblDomicilio.setVisible(false);
							textDomicilio.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							btnAñadir2.setVisible(false);
							textNif.setVisible(true);
							textNombre.setVisible(true);
							textApellido.setVisible(true);
							lblNombre.setVisible(true);
							lblApellido.setVisible(true);
							lblNIF.setVisible(true);
							scrollPane_2.setVisible(false);
							scrollPane_1_2.setVisible(false);

							scrollPane_1.setVisible(true);
							scrollPane.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Pedido")) {
							listaProductos_1.setVisible(false);
							listaAnnadidos_1.setVisible(false);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnAnadir.setVisible(true);
							btnEliminar.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblDomicilio.setVisible(true);
							textDomicilio.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnAnadir_1.setVisible(false);
							btnEliminar_1.setVisible(false);
							lblDomicilio.setVisible(true);
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							lblNombre.setVisible(false);
							lblApellido.setVisible(false);
							lblNIF.setVisible(false);
							btnAñadir2.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPane_2.setVisible(false);
							scrollPane_1_2.setVisible(false);

							scrollPane_1.setVisible(true);
							scrollPane.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Comanda")) {

							listaProductos_1.setVisible(true);
							listaAnnadidos_1.setVisible(true);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnAnadir.setVisible(true);
							btnEliminar.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(true);
							lblPlatos.setVisible(true);
							lblPlatosSeleccionados.setVisible(true);
							btnAnadir_1.setVisible(true);
							btnEliminar_1.setVisible(true);
							lblDomicilio.setVisible(false);
							textDomicilio.setVisible(false);
							btnAñadir2.setVisible(false);
							TextFieldCantidad_1.setVisible(true);
							scrollPane_2.setVisible(true);
							scrollPane_1_2.setVisible(true);
							scrollPane_1.setVisible(true);
							scrollPane.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Aprovisionamiento")) {
							listaProductos_1.setVisible(false);
							listaAnnadidos_1.setVisible(false);
							listaAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnAnadir.setVisible(true);
							btnEliminar.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnAnadir_1.setVisible(false);
							btnEliminar_1.setVisible(false);
							lblDomicilio.setVisible(false);
							textTotal.setVisible(false);
							lblProdDisp.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPane_2.setVisible(false);
							scrollPane_1_2.setVisible(false);
							lblTotal.setVisible(false);
							btnEliminar.setVisible(false);
							btnAnadir.setVisible(false);
							btnAñadir2.setVisible(true);
							listaProductos.setVisible(false);
							scrollPane_1.setVisible(false);
							scrollPane.setVisible(true);
							textDomicilio.setVisible(false);
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							lblNombre.setVisible(false);
							lblApellido.setVisible(false);
							lblNIF.setVisible(false);
						}

					}
				};
			}


	private ActionListener listenerBotonAnadir(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Annadir");
				boolean existeProd = false;
				String producto = "";
				String[] productosAnadir = new String[2];
				String cantidad = TextFieldCantidad.getText();
				System.out.println(cantidad);
				try {
					producto = (String) listaProductos.getSelectedValue(); // Necesito hacer aquï¿½ el cast porque
																			// getSelectedValue() devuelve un objeto por
																			// lo que no se le puede pasar directamente
																			// a accionadoBotonAnadirProducto
					if (producto != null) {
						existeProd = true;
					}
				} catch (Exception e) {
					System.out.println("No se ha seleccionado un producto");
					lblError.setText("No se ha escogido un producto");
				}
				if (existeProd) {
					try {
						int stock = controladorPanelPoblacion.conseguirStock(comboLocal.getSelectedItem().toString(), producto);
						if (Integer.parseInt(cantidad) > stock) {
							JOptionPane.showMessageDialog(null, "No puedes solicitar " + cantidad
									+ " el stock para ese articulo es de " + stock + " unidades");

						} else {
							if (controladorPanelPoblacion.existeProducto(producto) == -1) {
								productosAnadir = controladorPanelPoblacion.accionadoBotonAnnadirProducto(producto,
										cantidad);
								listaPAnnadidos.addElement(productosAnadir[0]);
								textTotal.setText(productosAnadir[1]);
								lblError.setText("");
							} else {
								int indice = controladorPanelPoblacion.existeProducto(producto);
								String yaAnnadido = listaPAnnadidos.get(indice);
								String cantidadEnPanel[] = yaAnnadido.split(" ");

								if ((Integer.parseInt(cantidadEnPanel[0]) + Integer.parseInt(cantidad)) > stock) {
									JOptionPane.showMessageDialog(null,
											"No puedes añadir esa cantidad, el stock es de " + stock + " unidades y has seleccionado ya " + cantidadEnPanel[0] + " unidades");
								} else {
									productosAnadir = controladorPanelPoblacion.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto);
									listaPAnnadidos.set(indice, productosAnadir[0]);
									textTotal.setText(productosAnadir[1]);
								}
							}
						}
					} catch (Exception e) {
						System.out.println("El campo cantidad no contiene un entero");
						e.printStackTrace();
						lblError.setText("No se ha introducido una cantidad");
					}
				}
			}
		};
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
