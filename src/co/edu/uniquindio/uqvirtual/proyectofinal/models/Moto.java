package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cilindraje;
    private double tamTanque;

    


	
	public Moto() {
		super();
	}
	public Moto(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad,
                int cilindraje, double tamTanque) {
        super(placa, marca, tipoVehiculo, referencia, modelo, precio, numRuedas, cantidad);
        this.cilindraje = cilindraje;
        this.tamTanque = tamTanque;
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

	// Getters específicos de Moto
    public int getCilindraje() {
        return cilindraje;
    }

    public double getTamTanque() {
        return tamTanque;
    }

    // Setters específicos de Moto
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setTamTanque(double tamTanque) {
        this.tamTanque = tamTanque;
    }

}
