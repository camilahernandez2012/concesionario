package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
    private String placa;
    private String marca;
    private String referencia;
    private TipoVehiculo tipoVehiculo;
    private int modelo;
    private double precio;
    private int numRuedas;
    private int cantidad;
    
    
    

    public Vehiculo() {
		super();
	}

	public Vehiculo(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad) {
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.tipoVehiculo=tipoVehiculo;
        this.modelo = modelo;
        this.precio = precio;
        this.numRuedas = numRuedas;
        this.cantidad= cantidad;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public int getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    // Setters
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
    

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean compararPlacaYTipoVehiculo(String placaVehiculo, TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		if(this.getPlaca().equalsIgnoreCase(placaVehiculo)&&this.tipoVehiculo==tipoVehiculo){
			return true;
		}
		return false;
	}

    
}