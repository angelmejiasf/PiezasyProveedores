package ProveedoresyPiezas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Programa {
	public static ArrayList<Pieza> piezas = new ArrayList();
	public static ArrayList<Proveedor> proveedor = new ArrayList();

	public Programa(ArrayList<Pieza> piezas, ArrayList<Proveedor> proveedor) {
		super();
		this.piezas = piezas;
		this.proveedor = proveedor;
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}

	public ArrayList<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(ArrayList<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Programa [piezas=" + piezas + ", proveedor=" + proveedor + "]";
	}

	public void generarFichero(String filename) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (Proveedor proveedor : proveedor) {
				writer.write("Proveedor: " + proveedor.nombreProveedor + "\n");
				for (Pieza pieza : piezas) {
					if (pieza.getProveedor() == proveedor.codProveedor) {
						String linea = "◉" +pieza.nombrePieza + "\n";
						writer.write(linea);
					}
				}
			}
			System.out.println("Se ha generado el archivo: " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leerPiezas() {
		System.out.println(piezas);
	}
	public static void main(String[] args) {

		Utilidades utilidades = new Utilidades();
		ArrayList<Pieza> piezas = utilidades.cargarPiezas("piezas.csv");
		ArrayList<Proveedor> proveedor = utilidades.cargarProveedores("proveedor.csv");
		

		Programa app = new Programa(piezas, proveedor);
		//app.leerPiezas();
		app.generarFichero("proveedorPieza.txt");
	}
}
