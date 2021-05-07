package Vista;

import java.awt.Color;import java.awt.Font;import java.awt.SystemColor;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;
import java.sql.SQLException;import java.text.NumberFormat;import javax.swing.JButton;import javax.swing.JFormattedTextField;import javax.swing.JLabel;
import javax.swing.JList;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JScrollPane;import javax.swing.JTextField;
import javax.swing.SwingConstants;import javax.swing.text.NumberFormatter;import Controlador.ControladorPanelPoblacion;import javax.swing.JComboBox;import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;import javax.swing.JFormattedTextField.AbstractFormatter;

public class PanelPoblacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private ControladorPanelPoblacion controladorPanelPoblacion;
	private JButton btnVolver, btnEliminarProd, btnFinalizar, btnSeleccionarProd, btnSeleccionarPlat, btnEliminarPlat;
	private JTextField textTrans, textFecha, textNif, textNombre, textApellido, textDomicilio, textTotal;
	private JLabel lblNombrePanel, lblTransaccion, lblProdDisp, lblProductosSeleccionados, lblNombre, lblError,
			lblLocal1, lblFecha1, lblTotal, lblNIF, lblApellido, lblCantidad, lblPlatosSeleccionados, lblPlatos,
			lblDomicilio, lblCantidad_1,lblWarningDomicilio,lblTipoOperacion;
	private JScrollPane scrollProductosSeleccionados, scrollProductos, scrollPlatos, scrollPlatosSeleccionados;
	private NumberFormat format;
	private NumberFormatter formatter;
	private JFormattedTextField TextFieldCantidad, TextCantPlat;
	private JList listaPlatosAnadidos, listaPlatos, listaProductos, listaProductosAnnadidos;
	private JComboBox comboBoxTipoActividad, comboLocal;
	private DefaultListModel<String> listaPAnnadidos = new DefaultListModel<String>();
	private DefaultListModel<String> listaPlatosAnadidosString = new DefaultListModel<String>();

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
		btnSeleccionarProd.setVisible(true);
		add(btnSeleccionarProd);

		scrollProductosSeleccionados = new JScrollPane();
		scrollProductosSeleccionados.setBounds(30, 207, 296, 153);
		scrollProductosSeleccionados.setVisible(true);
		add(scrollProductosSeleccionados);

		listaProductosAnnadidos = new JList(listaPAnnadidos);
		scrollProductosSeleccionados.setViewportView(listaProductosAnnadidos);
		listaProductosAnnadidos.setBackground(Color.WHITE);
		listaProductosAnnadidos.setVisible(true);

		scrollProductos = new JScrollPane();
		scrollProductos.setBounds(463, 207, 265, 160);
		scrollProductos.setVisible(true);
		add(scrollProductos);

		listaProductos = new JList();
		scrollProductos.setViewportView(listaProductos);
		listaProductos.setBackground(Color.WHITE);
		listaProductos.setVisible(true);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCantidad.setBounds(336, 218, 92, 22);
		lblCantidad.setVisible(true);
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
		TextFieldCantidad.setVisible(true);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		lblProdDisp = new JLabel("Productos");
		lblProdDisp.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProdDisp.setBounds(547, 185, 92, 22);
		lblProdDisp.setVisible(true);
		add(lblProdDisp);

		lblProductosSeleccionados = new JLabel("Productos Seleccionados");
		lblProductosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductosSeleccionados.setBounds(63, 185, 244, 22);
		lblProductosSeleccionados.setVisible(true);
		add(lblProductosSeleccionados);

		lblError = new JLabel("");
		lblError.setBounds(243, 371, 332, 31);
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
		btnEliminarProd.setVisible(true);
		add(btnEliminarProd);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(30, 371, 70, 15);
		lblTotal.setVisible(true);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(63, 371, 114, 19);
		textTotal.setVisible(true);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		lblNIF = new JLabel("NIF");
		lblNIF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNIF.setBounds(297, 148, 86, 14);
		lblNIF.setVisible(false);
		add(lblNIF);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(483, 78, 70, 15);
		lblNombre.setVisible(false);
		add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 15));
		lblApellido.setBounds(483, 112, 102, 15);
		lblApellido.setVisible(false);
		add(lblApellido);

		scrollPlatosSeleccionados = new JScrollPane();
		scrollPlatosSeleccionados.setBounds(30, 426, 296, 153);
		add(scrollPlatosSeleccionados);
		scrollPlatosSeleccionados.setVisible(false);
		listaPlatosAnadidos = new JList(listaPlatosAnadidosString);
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
		lblPlatosSeleccionados.setBounds(82, 401, 244, 18);
		lblPlatosSeleccionados.setVisible(false);
		add(lblPlatosSeleccionados);

		lblPlatos = new JLabel("Platos");
		lblPlatos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPlatos.setBounds(554, 400, 115, 20);
		lblPlatos.setVisible(false);
		add(lblPlatos);

		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDomicilio.setBounds(291, 148, 81, 15);
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
		textNif.setBounds(336, 146, 86, 20);
		textNif.setVisible(false);
		textNif.setColumns(10);
		add(textNif);

		textNombre = new JTextField();
		textNombre.setBounds(553, 110, 175, 20);
		textNombre.setVisible(false);
		add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(553, 78, 175, 20);
		textApellido.setVisible(false);
		add(textApellido);
		textApellido.setColumns(10);

		comboLocal = new JComboBox(controladorPanelPoblacion.conseguirLocales());
		comboLocal.setBounds(88, 138, 162, 25);
		comboLocal.setVisible(true);
		add(comboLocal);

		textDomicilio = new JTextField();
		textDomicilio.setBounds(365, 146, 363, 20);
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

		TextCantPlat = new JFormattedTextField((AbstractFormatter) null);
		TextCantPlat.setText("1");
		TextCantPlat.setFont(new Font("Arial", Font.PLAIN, 12));
		TextCantPlat.setBounds(413, 462, 40, 27);
		TextCantPlat.setVisible(false);
		add(TextCantPlat);
		
		comboBoxTipoActividad = new JComboBox<String>();
		comboBoxTipoActividad.setModel(new DefaultComboBoxModel(
				new String[] {"Ticket", "Factura", "Aprovisionamiento"}));
		
		actualizarActividadesDisponibles(controladorPanelPoblacion.conseguirActividadesLocal(comboLocal.getSelectedIndex()));
		comboBoxTipoActividad.setBounds(291, 100, 162, 27);
		add(comboBoxTipoActividad);

		lblTipoOperacion = new JLabel("Tipo de operacion");
		lblTipoOperacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipoOperacion.setBounds(307, 78, 146, 14);
		add(lblTipoOperacion);
		
		lblWarningDomicilio = new JLabel("* Si es pedido para recoger no rellenar.");
		lblWarningDomicilio.setFont(new Font("Arial", Font.PLAIN, 10));
		lblWarningDomicilio.setBounds(420, 131, 296, 15);
		lblWarningDomicilio.setVisible(false);
		add(lblWarningDomicilio);

		// Para que segun se inicie salgan los productos del primer local del combobox
		try {
			actualizarDatosPanel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPoblacion));
		this.btnSeleccionarProd.addActionListener(listenerBotonAnadir(this.controladorPanelPoblacion));
		this.comboBoxTipoActividad.addActionListener(listenerComboActividad(this.controladorPanelPoblacion));
		this.comboLocal.addActionListener(listenerComboLocal(this.controladorPanelPoblacion));
		this.btnSeleccionarPlat.addActionListener(listenerBotonAnadirPlatos(this.controladorPanelPoblacion));
		this.btnEliminarProd.addActionListener(listenerBotonEliminarProductos(this.controladorPanelPoblacion));
		this.btnEliminarPlat.addActionListener(listenerBotonEliminarPlato(this.controladorPanelPoblacion));
		this.btnFinalizar.addActionListener(listenerBotonFinalizar(this.controladorPanelPoblacion));
	}
	
	private ActionListener listenerBotonAnadirPlatos(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Anadir Plato");
				boolean existePlato = false;
				String plato = "";
				String[] platosAnadir = new String[2];
				String cantidad = TextCantPlat.getText();
				try {
					plato = (String) listaPlatos.getSelectedValue();
					if (plato != null) {
						existePlato = true;
					}
				} catch (Exception e) {
					System.out.println("No se ha seleccionado un producto");
				}
				try {
					if (controladorPanelPoblacion.existePlato(plato) == -1 && existePlato) {
						platosAnadir = controladorPanelPoblacion.accionadoBotonAnnadirPlato(plato, cantidad);
						listaPlatosAnadidosString.addElement(platosAnadir[0]);
						textTotal.setText(platosAnadir[1]);
					} else if (controladorPanelPoblacion.existePlato(plato) != -1 && existePlato) {
						int indice = controladorPanelPoblacion.existePlato(plato);
						String yaAnnadido = listaPlatosAnadidosString.get(indice);
						platosAnadir = controladorPanelPoblacion.cambiarCantidadProductos(yaAnnadido,
								Integer.parseInt(cantidad), plato, "plato");
						listaPlatosAnadidosString.set(indice, platosAnadir[0]);
						textTotal.setText(platosAnadir[1]);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("El campo cantidad no contiene un entero");
				}
			}
		};
	}

	private void llamadaInsercionBBDD(String tipoActividad) throws NumberFormatException, SQLException {
		controladorPanelPoblacion.insercionDatosBbdd(Integer.parseInt(textTrans.getText()), textFecha.getText(),
				Double.parseDouble(textTotal.getText()), comboLocal.getSelectedIndex(), listaPAnnadidos, tipoActividad,
				textNombre.getText(), textNif.getText(), textApellido.getText(), textDomicilio.getText(),listaPlatosAnadidosString);
	}
	
	private ActionListener listenerBotonEliminarProductos(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = listaProductosAnnadidos.getSelectedIndex();
					String total = controladorPanelPoblacion.accionadoBotonEliminar(pos,
							listaPAnnadidos.get(pos));
					listaPAnnadidos.remove(pos);
					textTotal.setText(total);
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado o No se seleccionado ningun producto");
				}
			}
		};
	}

	private ActionListener listenerBotonEliminarPlato(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento eliminar");
				try {
					int pos = listaPlatosAnadidos.getSelectedIndex();
					String total = controladorPanelPoblacion.accionadoBotonEliminarPlato(pos, listaPlatosAnadidosString.get(pos));
					listaPlatosAnadidosString.remove(pos);
					textTotal.setText(total);
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto seleccionado o No se seleccionado ningun producto");
				}
			}
		};
	}

	private ActionListener listenerBotonFinalizar(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Finalizar");
				String tipoActividad = comboBoxTipoActividad.getSelectedItem().toString();

				if (tipoActividad.equalsIgnoreCase("Ticket")) {
					if (Double.parseDouble(textTotal.getText()) > 0) {
						try {
							llamadaInsercionBBDD(tipoActividad);
						} catch (NumberFormatException | SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Ticket introducido correctamente");
						controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
					} else {
						JOptionPane.showMessageDialog(null, "Debes introducir articulos");
					}
				}
				if (tipoActividad.equalsIgnoreCase("Factura")) {
					// Comprobamos si los campos DNI, Nombre, Apellido y si hay algun articulo
					// metido
					if (controladorPanelPoblacion.comprobarCampos(Double.parseDouble(textTotal.getText()),
							textNif.getText(), textNombre.getText(), textApellido.getText())) {
						try {
							llamadaInsercionBBDD(tipoActividad);
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Factura introducida correctamente");
						controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
					} else {
						if (!controladorPanelPoblacion.comprobarCampos(Double.parseDouble(textTotal.getText()),
								textNif.getText(), textNombre.getText(), textApellido.getText())) {
							JOptionPane.showMessageDialog(null, "Asegurate que todos los campos son correctos");
						}
					}
				}
				if (tipoActividad.equalsIgnoreCase("Pedido")) {
					if (Double.parseDouble(textTotal.getText()) > 0) {
						try {
							llamadaInsercionBBDD(tipoActividad);
						} catch (NumberFormatException | SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Pedido introducido correctamente");
						controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
					} else {
						JOptionPane.showMessageDialog(null, "Debes introducir articulos");
					}
				}
				if (tipoActividad.equalsIgnoreCase("Comanda")) {
					if (Double.parseDouble(textTotal.getText()) > 0) {
						try {
							llamadaInsercionBBDD(tipoActividad);
						} catch (NumberFormatException | SQLException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Comanda introducida correctamente");
						controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
					} else {
						JOptionPane.showMessageDialog(null, "Debes introducir articulos");
					}
				}
			}
		};
	}

	private void actualizarDatosPanel() throws SQLException {
		// actualizar los productos y/o platos dependiendo del local que se escoja
		controladorPanelPoblacion.getModelo().actualizarListaProductosLocal(
				controladorPanelPoblacion.devolverNifLocal(comboLocal.getSelectedIndex()));
		controladorPanelPoblacion.getModelo()
				.actualizarListaPlatosLocal(controladorPanelPoblacion.devolverNifLocal(comboLocal.getSelectedIndex()));
		listaProductos.setListData(controladorPanelPoblacion.cogerListaProductos());
		listaPlatos.setListData(controladorPanelPoblacion.cogerListaPlatos());
	
		//Borrar productos y/o platos seleccionados
			controladorPanelPoblacion.borrarPlatosyProductosPanel();
			listaPAnnadidos.removeAllElements();
			listaPlatosAnadidosString.removeAllElements();
			textTotal.setText("0");		
	}
	private void actualizarActividadesDisponibles(String tipolocal) {
				
		if(comboBoxTipoActividad.getItemCount() == 4) {
			comboBoxTipoActividad.removeItemAt(3);
		}
		if(comboBoxTipoActividad.getItemCount() == 5) {
			comboBoxTipoActividad.removeItemAt(4);
			comboBoxTipoActividad.removeItemAt(3);
		}
		if(tipolocal.equalsIgnoreCase("CAFETERIA"))
		{
			comboBoxTipoActividad.addItem("Pedido");
		}		
		else if(tipolocal.equalsIgnoreCase("RESTAURANTE"))
		{
			comboBoxTipoActividad.addItem("Pedido");
			comboBoxTipoActividad.addItem("Comanda");
		}
		comboBoxTipoActividad.setSelectedIndex(0);
	}

	private ActionListener listenerComboLocal(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					actualizarDatosPanel();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				actualizarActividadesDisponibles(controladorPanelPoblacion.conseguirActividadesLocal(comboLocal.getSelectedIndex()));
			}
		};
	}

	private ActionListener listenerComboActividad(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textTotal.setVisible(true);
				lblTotal.setVisible(true);
				lblWarningDomicilio.setVisible(false);
				btnFinalizar.setVisible(true);

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
					TextCantPlat.setVisible(false);
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
					TextCantPlat.setVisible(false);
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
					lblWarningDomicilio.setVisible(true);
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
					TextCantPlat.setVisible(false);
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
					TextCantPlat.setVisible(true);
					scrollPlatosSeleccionados.setVisible(true);
					scrollPlatos.setVisible(true);
					scrollProductos.setVisible(true);
					scrollProductosSeleccionados.setVisible(true);
				} else if (comboBoxTipoActividad.getSelectedItem().toString().equals("Aprovisionamiento")) {
					btnFinalizar.setVisible(false);
					listaPlatos.setVisible(false);
					listaPlatosAnadidos.setVisible(false);
					listaProductosAnnadidos.setVisible(false);
					listaProductos.setVisible(true);
					lblLocal1.setVisible(true);
					TextFieldCantidad.setVisible(true);
					lblCantidad.setVisible(true);
					btnSeleccionarProd.setVisible(true);
					btnEliminarProd.setVisible(true);
					lblProductosSeleccionados.setVisible(false);
					lblCantidad_1.setVisible(false);
					lblPlatos.setVisible(false);
					lblPlatosSeleccionados.setVisible(false);
					btnSeleccionarPlat.setVisible(false);
					btnEliminarPlat.setVisible(false);
					lblDomicilio.setVisible(false);
					textTotal.setVisible(false);
					lblProdDisp.setVisible(true);
					TextCantPlat.setVisible(false);
					scrollPlatosSeleccionados.setVisible(false);
					scrollPlatos.setVisible(false);
					lblTotal.setVisible(false);
					btnEliminarProd.setVisible(false);
					scrollProductos.setVisible(true);
					scrollProductosSeleccionados.setVisible(false);
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

				if(listaProductos.getSelectedIndex()!=-1 && comboBoxTipoActividad.getSelectedItem().toString().equalsIgnoreCase("Aprovisionamiento"))
				{
					int seleccionado = listaProductos.getSelectedIndex();
					String nombreAlimento = (String) listaProductos.getSelectedValue();
					try {
						controladorPanelPoblacion.accionadoBotonAnadirAprovisionamiento(Integer.parseInt(cantidad), seleccionado, nombreAlimento, comboLocal.getSelectedIndex());
					} catch (NumberFormatException | SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Aprovisionado " + cantidad + " " + listaProductos.getSelectedValue() + " Correctamente");
					controladorPanelPoblacion.accionadoBottonVolverPanelPrincipal();
				}
				else if (comboBoxTipoActividad.getSelectedItem().toString().equalsIgnoreCase("Aprovisionamiento"))
				{
					JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento");
				}
				try {
					producto = (String) listaProductos.getSelectedValue();
					if (producto != null) {
						existeProd = true;
					}
				} catch (Exception e) {
					System.out.println("No se ha seleccionado un producto");
					lblError.setText("No se ha escogido un producto");
				}
				if (existeProd) {
					try {
						int stock = controladorPanelPoblacion.conseguirStock(comboLocal.getSelectedIndex(), producto);
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
											"No puedes añadir esa cantidad, el stock es de " + stock
													+ " unidades y has seleccionado ya " + cantidadEnPanel[0]
													+ " unidades");
								} else {
									productosAnadir = controladorPanelPoblacion.cambiarCantidadProductos(yaAnnadido,
											Integer.parseInt(cantidad), producto, "producto");
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
