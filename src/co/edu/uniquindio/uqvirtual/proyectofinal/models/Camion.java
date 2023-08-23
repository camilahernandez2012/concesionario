package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.io.Serializable;

public class Camion extends Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
    private double capCarga;

    
    
    public Camion() {
		super();
	}

	public Camion(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad,
                  double capCarga) {
        super(placa, marca, tipoVehiculo ,referencia, modelo, precio, numRuedas, cantidad);
        this.capCarga = capCarga;
    }

    // Getter específico de Camion
    public double getCapCarga() {
        return capCarga;
    }

    // Setter específico de Camion
    public void setCapCarga(double capCarga) {
        this.capCarga = capCarga;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    // Ejemplo de uso
//    public static void main(String[] args) {
//        Camion camion = new Camion("PQR123", "Volvo", "VNL", 2023, 80000, 6, 20000.0);
//        System.out.println(camion.getMarca());  // Imprimirá "Volvo"
//        camion.setPrecio(85000);
//        System.out.println(camion.getPrecio());  // Imprimirá 85000.0
//    }
}
