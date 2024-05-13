package ProveedoresyPiezas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Utilidades {
	

	public ArrayList<Pieza> cargarPiezas(String filename) {
		ArrayList<Pieza>piezas = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero);

			// En caso de que queramos saltar la primera linea
			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");

				piezas.add(new Pieza(Integer.parseInt(linea[0]), linea[1],
						Integer.parseInt(linea[2]), Double.parseDouble(linea[3])));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return piezas;

	}
	
	public ArrayList<Proveedor> cargarProveedores(String filename) {
		ArrayList<Proveedor>proveedor = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			// En caso de que queramos saltar la primera linea
			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");

				proveedor.add(new Proveedor(Integer.parseInt(linea[0]), linea[1],
						linea[2]));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return proveedor;
	}
	
	
}
