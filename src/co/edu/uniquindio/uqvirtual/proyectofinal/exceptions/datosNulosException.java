package co.edu.uniquindio.uqvirtual.proyectofinal.exceptions;


import javax.swing.JOptionPane;


public class datosNulosException extends Exception{

	private static final long serialVersionUID = 1L;
	public datosNulosException(String mensaje){
		super(mensaje);
		JOptionPane.showMessageDialog(null, mensaje,
			      "Error!", JOptionPane.ERROR_MESSAGE);
	}

}
