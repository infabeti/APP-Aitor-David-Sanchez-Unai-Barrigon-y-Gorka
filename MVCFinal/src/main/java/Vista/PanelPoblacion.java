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
	private JButton btnVolver,btnEliminarProd,btnFinalizar,btnSeleccionarProd,btnSeleccionarPlat,btnEliminarPlat,btnAñadir2;
	private JTextField textTrans,textFecha,textNif,textNombre,textApellido,textDomicilio,textTotal;
	private JLabel lblNombrePanel,lblTransaccion,lblProdDisp,lblProductosSeleccionados,lblNombre,lblError,
	lblLocal1,lblFecha1,lblTotal,lblNIF,lblApellido,lblCantidad,lblPlatosSeleccionados,lblPlatos,lblDomicilio,lblCantidad_1;
	private JScrollPane scrollProductosSeleccionados,scrollProductos,scrollPlatos,scrollPlatosSeleccionados;
	private NumberFormat format;
	private NumberFormatter formatter;
	private JFormattedTextField TextFieldCantidad,TextFieldCantidad_1;
	private JList listaPlatosAnadidos,listaPlatos,listaProductos,listaProductosAnnadidos;
	private JComboBox comboBoxTipoActividad,comboLocal;
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

		btnSeleccionarProd = new JButton("Seleccionar\r\n");
		btnSeleccionarProd.setBounds(336, 251, 117, 25);
		btnSeleccionarProd.setVisible(false);
		add(btnSeleccionarProd);

		scrollProductosSeleccionados = new JScrollPane();
		scrollProductosSeleccionados.setBounds(30, 207, 296, 153);
		scrollProductosSeleccionados.setVisible(false);
		add(scrollProductosSeleccionados);

		listaProductosAnnadidos = new JList(listaPAnnadidos);
		scrollProductosSeleccionados.setViewportView(listaProductosAnnadidos);
		listaProductosAnnadidos.setBackground(Color.WHITE);
		listaProductosAnnadidos.setVisible(false);

		scrollProductos = new JScrollPane();
		scrollProductos.setBounds(463, 196, 265, 160);
		scrollProductos.setVisible(false);
		add(scrollProductos);

		listaProductos = new JList();
		scrollProductos.setViewportView(listaProductos);
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

		btnEliminarProd = new JButton("Eliminar");
		btnEliminarProd.setBounds(336, 287, 117, 25);
		btnEliminarProd.setVisible(false);
		add(btnEliminarProd);

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

		scrollPlatosSeleccionados = new JScrollPane();
		scrollPlatosSeleccionados.setBounds(30, 426, 296, 153);
		add(scrollPlatosSeleccionados);
		scrollPlatosSeleccionados.setVisible(false);
		listaPlatosAnadidos = new JList();
		scrollPlatosSeleccionados.setViewportView(listaPlatosAnadidos);
		listaPlatosAnadidos.setBackground(Color.WHITE);

		scrollPlatos = new JScrollPane();
		scrollPlatos.setBounds(463, 426, 265, 160);
		scrollPlatos.setVisible(false);
		add(scrollPlatos);

		listaPlatos = new JList();
		scrollPlatos.setViewportView(listaPlatos);
		listaPlatos.setBackground(Color.WHITE);
		listaPlatos.setVisible(false);

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

		btnSeleccionarPlat = new JButton("Seleccionar\r\n");
		btnSeleccionarPlat.setBounds(336, 496, 117, 25);
		btnSeleccionarPlat.setVisible(false);
		add(btnSeleccionarPlat);

		btnEliminarPlat = new JButton("Eliminar");
		btnEliminarPlat.setBounds(336, 532, 117, 25);
		btnEliminarPlat.setVisible(false);
		add(btnEliminarPlat);

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
		comboBoxTipoActividad.setBounds(645, 37, 126, 26);
		add(comboBoxTipoActividad);

		btnAñadir2 = new JButton("A\u00F1adir");
		btnAñadir2.setBounds(346, 252, 89, 23);
		btnAñadir2.setVisible(false);
		add(btnAñadir2);


		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPoblacion));
		this.btnSeleccionarProd.addActionListener(listenerBotonAnadir(this.controladorPanelPoblacion));
		this.comboBoxTipoActividad.addActionListener(listenerComboActividad(this.controladorPanelPoblacion));
		this.comboLocal.addActionListener(listenerComboLocal(this.controladorPanelPoblacion));
	}
	
	private ActionListener listenerComboLocal(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//actualizar los productos y/o platos dependiendo del local que se escoja
				controladorPanelPoblacion.getModelo().actualizarListaProductosLocal(controladorPanelPoblacion.devolverNifLocal(comboLocal.getSelectedIndex()));
				controladorPanelPoblacion.getModelo().actualizarListaPlatosLocal(controladorPanelPoblacion.devolverNifLocal(comboLocal.getSelectedIndex()));
				listaProductos.setListData(controladorPanelPoblacion.cogerListaProductos());
				listaPlatos.setListData(controladorPanelPoblacion.cogerListaPlatos());
			}
		};
	}
	
	private ActionListener listenerComboActividad(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

						if (comboBoxTipoActividad.getSelectedItem().toString().equals("Ticket")) {
							listaPlatos.setVisible(true);
							listaPlatosAnadidos.setVisible(true);
							listaProductosAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnSeleccionarProd.setVisible(true);
							btnEliminarProd.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnSeleccionarPlat.setVisible(false);
							btnEliminarPlat.setVisible(false);
							lblDomicilio.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPlatosSeleccionados.setVisible(false);
							scrollPlatos.setVisible(false);
							textDomicilio.setVisible(false);
							scrollProductos.setVisible(true);
							scrollProductosSeleccionados.setVisible(true);
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							lblNombre.setVisible(false);
							lblApellido.setVisible(false);
							lblNIF.setVisible(false);
							scrollPlatosSeleccionados.setVisible(false);
							scrollPlatos.setVisible(false);
							btnAñadir2.setVisible(false);
						}

						else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Factura")) {
							listaPlatos.setVisible(false);
							listaPlatosAnadidos.setVisible(false);
							listaProductosAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnSeleccionarProd.setVisible(true);
							btnEliminarProd.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnSeleccionarPlat.setVisible(false);
							btnEliminarPlat.setVisible(false);
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
							scrollPlatosSeleccionados.setVisible(false);
							scrollPlatos.setVisible(false);

							scrollProductos.setVisible(true);
							scrollProductosSeleccionados.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Pedido")) {
							listaPlatos.setVisible(false);
							listaPlatosAnadidos.setVisible(false);
							listaProductosAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnSeleccionarProd.setVisible(true);
							btnEliminarProd.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblDomicilio.setVisible(true);
							textDomicilio.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnSeleccionarPlat.setVisible(false);
							btnEliminarPlat.setVisible(false);
							lblDomicilio.setVisible(true);
							textNif.setVisible(false);
							textNombre.setVisible(false);
							textApellido.setVisible(false);
							lblNombre.setVisible(false);
							lblApellido.setVisible(false);
							lblNIF.setVisible(false);
							btnAñadir2.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPlatosSeleccionados.setVisible(false);
							scrollPlatos.setVisible(false);

							scrollProductos.setVisible(true);
							scrollProductosSeleccionados.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Comanda")) {

							listaPlatos.setVisible(true);
							listaPlatosAnadidos.setVisible(true);
							listaProductosAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnSeleccionarProd.setVisible(true);
							btnEliminarProd.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(true);
							lblPlatos.setVisible(true);
							lblPlatosSeleccionados.setVisible(true);
							btnSeleccionarPlat.setVisible(true);
							btnEliminarPlat.setVisible(true);
							lblDomicilio.setVisible(false);
							textDomicilio.setVisible(false);
							btnAñadir2.setVisible(false);
							TextFieldCantidad_1.setVisible(true);
							scrollPlatosSeleccionados.setVisible(true);
							scrollPlatos.setVisible(true);
							scrollProductos.setVisible(true);
							scrollProductosSeleccionados.setVisible(true);
						} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Aprovisionamiento")) {
							listaPlatos.setVisible(false);
							listaPlatosAnadidos.setVisible(false);
							listaProductosAnnadidos.setVisible(true);
							listaProductos.setVisible(true);
							lblLocal1.setVisible(true);
							TextFieldCantidad.setVisible(true);
							lblCantidad.setVisible(true);
							btnSeleccionarProd.setVisible(true);
							btnEliminarProd.setVisible(true);
							lblProductosSeleccionados.setVisible(true);
							lblProdDisp.setVisible(true);
							lblCantidad_1.setVisible(false);
							lblPlatos.setVisible(false);
							lblPlatosSeleccionados.setVisible(false);
							btnSeleccionarPlat.setVisible(false);
							btnEliminarPlat.setVisible(false);
							lblDomicilio.setVisible(false);
							textTotal.setVisible(false);
							lblProdDisp.setVisible(false);
							TextFieldCantidad_1.setVisible(false);
							scrollPlatosSeleccionados.setVisible(false);
							scrollPlatos.setVisible(false);
							lblTotal.setVisible(false);
							btnEliminarProd.setVisible(false);
							btnSeleccionarProd.setVisible(false);
							btnAñadir2.setVisible(true);
							listaProductos.setVisible(false);
							scrollProductos.setVisible(false);
							scrollProductosSeleccionados.setVisible(true);
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
