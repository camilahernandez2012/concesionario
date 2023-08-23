package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.io.Serializable;

public class Auto extends Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
    private int numPuertas;
    private boolean isGasolina;

    
    
    public Auto() {
		super();
	}

	public Auto(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad,
                int numPuertas, boolean isGasolina) {
        super(placa, marca,  tipoVehiculo,referencia, modelo, precio, numRuedas, cantidad);
        this.numPuertas = numPuertas;
        this.isGasolina = isGasolina;
    }

    // Getters específicos de Auto
    public int getNumPuertas() {
        return numPuertas;
    }

    public boolean isGasolina() {
        return isGasolina;
    }

    // Setters específicos de Auto
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public void setGasolina(boolean gasolina) {
        isGasolina = gasolina;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    // Ejemplo de uso
//    public static void main(String[] args) {
//        Auto auto = new Auto("LMN789", "Ford", "Focus", 2023, 18000, 4, 4, true);
//        System.out.println(auto.getReferencia());  // Imprimirá "Focus"
//        auto.setPrecio(19000);
//        System.out.println(auto.getPrecio());  // Imprimirá 19000.0
//    }
}
