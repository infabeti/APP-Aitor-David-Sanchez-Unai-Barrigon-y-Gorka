package Modelo;


import java.sql.Date;
import java.util.ArrayList;

public class TransformadorDatos {

	public ListaProductos cambiarFormatoListaProductos(ArrayList<String[]> arrayBbdd) {
		ListaProductos lp = new ListaProductos();
		for (int i = 0; i < arrayBbdd.size(); i++) {
			// Conseguir el string del arraylist
			String[] arrString = arrayBbdd.get(i);
			// crear Objeto de tipo producto
			String nombre = arrString[0];
			double precioCompra = Double.parseDouble(arrString[3]);
			double precioVenta = Double.parseDouble(arrString[4]);
			String tipo = arrString[2];

			// Pasar de string a tipo date
			System.out.println(arrString[1]);
			java.sql.Date fechaCaducidad;
			if(arrString[1].equalsIgnoreCase(null))
			{
				fechaCaducidad = Date.valueOf(arrString[1]);

			}
			else
			{
				//Productos no perecederos
				fechaCaducidad = new Date(0);
			}
			
			//añadir producto a lp
			lp.addProducto(new Producto(nombre, fechaCaducidad, tipo, precioCompra, precioVenta));

		}

		return lp;

	}
	
	public ListaPlatos cambiarFormatoListaPlatos(ArrayList<String[]> arrayBbdd) {
		ListaPlatos lp = new ListaPlatos();
		
		for (int i = 0; i < arrayBbdd.size(); i++) {
			// Conseguir el string del arraylist
			String[] arrString = arrayBbdd.get(i);
			// crear Objeto de tipo Plato
			String nombre = arrString[0];
			System.out.println(nombre + " *     ****" + arrString[1]);
			double pvp = Double.parseDouble(arrString[1]);

			
			//añadir plato a lp
			lp.addPlato(new Plato(nombre, pvp));

		}
		
		return lp;
		
	}
}
