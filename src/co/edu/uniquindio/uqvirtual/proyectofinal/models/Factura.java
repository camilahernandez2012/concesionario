package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.util.ArrayList;

public class Factura {

	private String code;
	private ArrayList<Vehiculo>listaVehiculos;
	private double precioTotal;
	
	
	
	
	
	
	
	
	
	public Factura(String code, ArrayList<Vehiculo> listaVehiculos, double precioTotal) {
		super();
		this.code = code;
		this.listaVehiculos = listaVehiculos;
		this.precioTotal = precioTotal;
	}



	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}



	@Override
	public String toString() {
		return "Factura [code=" + code + ", listaVehiculos=" + listaVehiculos + ", precioTotal=" + precioTotal + "]";
	}
	
	
	
	
}
