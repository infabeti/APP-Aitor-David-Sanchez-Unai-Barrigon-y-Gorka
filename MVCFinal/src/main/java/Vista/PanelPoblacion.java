package Vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelPoblacion;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;

public class PanelPoblacion extends JPanel {

	private static final long serialVersionUID = -4866340972661290326L;
	private ControladorPanelPoblacion controladorPanelPoblacion;
	private JLabel lblTextoPanel;
	private JButton btnVolver;
	private JTextField textFieldNumTrans;
	private JButton btnFinalizar;
	private JLabel lblTransaccion;
	private JList listaProductos;
	private JButton btnAnadir;
	private JList listaAnnadidos;
	private JScrollPane scrollPane;
	private DefaultListModel<String> listaPAnnadidos = new DefaultListModel<String>();
	private JScrollPane scrollPane_1;
	private JFormattedTextField TextFieldCantidad;
	private JLabel lblCantidad;
	private JLabel lblError;
	private JTextField textLocal;
	private JButton btnEliminar;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JTextField textFieldFecha;

	public PanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		setBackground(SystemColor.activeCaption);

		this.controladorPanelPoblacion = controladorPanelPoblacion;

		setLayout(null);
		
		/*
		lblTextoPanel = new JLabel("PANEL POBLACION");
		lblTextoPanel.setFont(new Font("Arial", Font.PLAIN, 31));
		lblTextoPanel.setBounds(290, 11, 450, 67);
		add(lblTextoPanel);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(168, 569, 89, 23);
		add(btnVolver);

		textFieldNumTrans = new JTextField();
		textFieldNumTrans.setBounds(120, 76, 114, 19);
		add(textFieldNumTrans);
		textFieldNumTrans.setColumns(10);
		textFieldNumTrans.setText(controladorPanelTickets.leerNumTransBBDD());
		textFieldNumTrans.setEditable(false);
		textFieldNumTrans.setHorizontalAlignment(SwingConstants.CENTER);

		lblTransaccion = new JLabel("Transaccion");
		lblTransaccion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTransaccion.setBounds(30, 78, 102, 15);
		add(lblTransaccion);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(41, 569, 117, 25);
		add(btnFinalizar);

		btnAnadir = new JButton("Seleccionar\r\n");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnadir.setBounds(336, 299, 117, 25);
		add(btnAnadir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 244, 296, 153);
		add(scrollPane);

		listaAnnadidos = new JList(listaPAnnadidos);
		listaAnnadidos.setBackground(Color.WHITE);
		scrollPane.setViewportView(listaAnnadidos);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 237, 150, 160);
		add(scrollPane_1);

		listaProductos = new JList(controladorPanelTickets.cogerListaProductos());
		scrollPane_1.setViewportView(listaProductos);
		listaProductos.setBackground(Color.WHITE);

		lblCantidad = new JLabel("Cantidad");
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

		TextFieldCantidad = new JFormattedTextField(formatter);
		TextFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		TextFieldCantidad.setBounds(411, 265, 40, 27);
		add(TextFieldCantidad);
		TextFieldCantidad.setText("1");

		JLabel lblProdDisp = new JLabel("Productos");
		lblProdDisp.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProdDisp.setBounds(576, 209, 92, 22);
		add(lblProdDisp);

		JLabel lblProductosSeleccionados = new JLabel("Productos Seleccionados");
		lblProductosSeleccionados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductosSeleccionados.setBounds(71, 209, 244, 22);
		add(lblProductosSeleccionados);

		lblError = new JLabel("");
		lblError.setBounds(30, 166, 332, 31);
		add(lblError);

		textLocal = new JTextField();
		textLocal.setBounds(120, 146, 114, 19);
		add(textLocal);
		textLocal.setColumns(10);
		textLocal.setText(controladorPanelTickets.conseguirLocal());
		textLocal.setEditable(false);
		textLocal.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(120, 105, 106, 30);
		add(textFieldFecha);
		textFieldFecha.setText(this.controladorPanelTickets.devolverFechaHora());
		textFieldFecha.setEditable(false);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(30, 148, 70, 15);
		lblLocal.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblLocal);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(30, 112, 70, 15);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		add(lblFecha);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(336, 335, 117, 25);
		add(btnEliminar);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(52, 464, 70, 15);
		add(lblTotal);

		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(92, 461, 114, 19);
		add(textTotal);
		textTotal.setColumns(10);
		textTotal.setText("0");

		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setBounds(300, 79, 46, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(300, 113, 46, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(300, 148, 46, 17);
		add(lblNewLabel_2);
		*/

	}
}
