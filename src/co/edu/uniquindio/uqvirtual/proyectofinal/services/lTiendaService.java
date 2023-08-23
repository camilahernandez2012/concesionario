package co.edu.uniquindio.uqvirtual.proyectofinal.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import co.edu.uniquindio.uqvirtual.proyectofinal.models.RolUsuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.TipoVehiculo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class lTiendaService {

	public lTiendaService() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * validarCadena
	 * esta funcion valida si una caena no tiene caracteres especiales
	 * en especial:  "" '' '"/
	 */
	public static boolean validarCadena(String cadena) {
		// TODO Auto-generated method stub
		if(cadena!=null){
			if(!cadena.equalsIgnoreCase("")){
				return true;//retorna verdadero si no es nula ni vacia
			}else {
				mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada estï¿½ vacia", AlertType.ERROR);
			}
		}else {
			mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada es nula", AlertType.ERROR);
		}

		return false;
	}

	public static boolean validarCadenaBoolean(String cadena) {
		// TODO Auto-generated method stub
		if(cadena!=null){
			if(!cadena.equalsIgnoreCase("")){
				return true;//retorna verdadero si no es nula ni vacia
			}else {
				//	mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada estï¿½ vacia", AlertType.ERROR);
			}
		}else {
			//mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada es nula", AlertType.ERROR);
		}

		return false;
	}

	public static boolean mostrarVentanaConfirmacion(String mensaje) {
		// Crear una ventana de confirmaciÃ³n personalizada
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("ConfirmaciÃ³n");
		alert.setHeaderText(mensaje);
		alert.setContentText("Al continuar, se realizarÃ¡n cambios.");

		// Agregar botones personalizados (Confirmar y Cancelar)
		ButtonType confirmButton = new ButtonType("Confirmar", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(confirmButton, cancelButton);

		// Obtener el resultado del diÃ¡logo
		ButtonType result = alert.showAndWait().orElse(cancelButton);

		// Verificar el resultado y devolver un booleano
		return result == confirmButton;
	}
	public static void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alerta = new Alert(alertType);

		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();

	}
	public static boolean validarDatosUsuario(String codUser, String name, RolUsuario tipoUser, String nameUser,
			String passUser, String emailUser, String pregUser, String answerUser) {
		// TODO Auto-generated method stub
		String mensajeError="Hay valores nulos o vacios en los siguientes campos: \n";
		String mensaje="Hay valores nulos o vacios en los siguientes campos: \n";
		if(!validarCadenaBoolean(codUser)){
			mensajeError+= "-Identificaciï¿½n \n ";
		}
		if(tipoUser==null){
			mensajeError+= "-Rol \n ";
		}
		if(!validarCadenaBoolean(name)){
			mensajeError+= "-Nombre \n ";
		}

		if(!validarCadenaBoolean(nameUser)){
			mensajeError+= "-Usuario \n ";
		}
		if(!validarCadenaBoolean(passUser)){
			mensajeError+= "-Contraseï¿½a \n ";
		}
		if(!validarCadenaBoolean(emailUser)){
			mensajeError+= "-Email \n ";
		}
		if(!validarCadenaBoolean(pregUser)){
			mensajeError+= "-Pregunta de seguridad \n ";
		}
		if(!validarCadenaBoolean(answerUser)){
			mensajeError+= "-Respuesta a pregunta de seguridad \n ";
		}

		if(!mensajeError.equalsIgnoreCase(mensaje)){
			mostrarMensaje("Cuidado", "Error en datos digitados", mensajeError, AlertType.ERROR);
			return false;
		}else{
			return true;
		}
	}
	public static String PassCheck (String password) {

		String resultado = password;        // Resultado de password valido
		int length = 0;                     // Almacenamos numero de caracteres en el pass
		int numCount = 0;                   // Variable usada para almacenar numeros en el password
		int capCount = 0;                   // Variable usada para almacenar mayusculas en el password

		for (int x =0; x < password.length(); x++) {
			if ((password.charAt(x) >= 47 && password.charAt(x) <= 58) || (password.charAt(x) >= 64 && password.charAt(x) <= 91) ||
					(password.charAt(x) >= 97 && password.charAt(x) <= 122)) {

			} 

			if ((password.charAt(x) > 47 && password.charAt(x) < 58)) { // Cuenta la cantidad de numero
				numCount ++;
			}

			if ((password.charAt(x) > 64 && password.charAt(x) < 91)) { // Cuenta la cantidad de mayuscula
				capCount ++;
			}

			length = (x + 1); // Cuenta la longitud del password

		} // Final del bucle

		if (numCount < 1){              // Revisa que el password contenga minimo 1 numero

			if(resultado.equalsIgnoreCase(password)){
				resultado="";
			}
			resultado += "No tiene suficientes nï¿½meros el Password!";
		}

		if (capCount < 1) {
			if(resultado.equalsIgnoreCase(password)){
				resultado="";
			}// Revisa que el password contenga minimo 1 mayuscula
			resultado += "No tiene suficientes mayusculas el Password!";
		}

		if (length < 8){  
			if(resultado.equalsIgnoreCase(password)){
				resultado="";
			}// Revisa la longitud minima de 8 caracteres del password
			resultado += "Inutilizable: no cumple con el mï¿½nimo de caracteres!";
		}
		if(!resultado.equalsIgnoreCase(password)){
			mostrarMensaje("Datos incorrectos", "Contrasena Invalida", "La contraseï¿½a no se pudo crear por: \n "+resultado, AlertType.WARNING);
		}
		return (resultado); 
	}
	public static boolean validarDatosCancion( String name, String album, String ano, String duracion
			, String url) {
		// TODO Auto-generated method stub
		String mensajeError="Hay valores nulos o vacios en los siguientes campos: \n";
		String mensaje="Hay valores nulos o vacios en los siguientes campos: \n";
		//		if(!validarCadenaBoolean(codigo)){
		//			mensajeError+= "-Identificaciï¿½n \n ";
		//		}
		if(!validarCadenaBoolean(name)){
			mensajeError+= "-nombre \n ";
		}
		if(!validarCadenaBoolean(album)){
			mensajeError+= "-album \n ";
		}
		if(!validarCadenaBoolean(ano)){
			mensajeError+= "-año \n ";
		}
		if(!validarCadenaBoolean(duracion)){
			mensajeError+= "-Duracion \n ";
		}

		if(!validarCadenaBoolean(url)){
			mensajeError+= "-url \n ";
		}
		if(!mensajeError.equalsIgnoreCase(mensaje)){
			mostrarMensaje("Cuidado", "Error en datos digitados", mensajeError, AlertType.ERROR);
			return false;
		}else{
			return true;
		}


	}
	public static String generarCodigoAleatorio(int digitos) {
		Random random = new Random();
		StringBuilder codigo = new StringBuilder();

		for (int i = 0; i < digitos; i++) {
			int cifra = random.nextInt(10);
			codigo.append(cifra);
		}

		return codigo.toString();
	}

	public static BufferedImage leerImagen(String ruta) {
		try {
			return ImageIO.read(new File(ruta));
		} catch (IOException e) {
			System.out.println("Error al leer la imagen: " + e.getMessage());
			return null;
		}
	}

	public static void guardarImagen(BufferedImage imagen, String ruta) {
		try {
			File archivoSalida = new File(ruta);
			ImageIO.write(imagen, "jpg", archivoSalida);
		} catch (IOException e) {
			System.out.println("Error al guardar la imagen: " + e.getMessage());
		}
	}

	public static BufferedImage actualizarImagen(BufferedImage imagen) {
		// Aquí puedes realizar las modificaciones deseadas en la imagen
		// por ejemplo, cambiar los píxeles, aplicar filtros, etc.
		// Devuelve la imagen actualizada o null en caso de error.

		// Ejemplo: Girar la imagen 90 grados en sentido horario
		int ancho = imagen.getWidth();
		int alto = imagen.getHeight();
		BufferedImage imagenActualizada = new BufferedImage(alto, ancho, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				imagenActualizada.setRGB(y, ancho - x - 1, imagen.getRGB(x, y));
			}
		}
		return imagenActualizada;
	}

	public static void eliminarImagen(String ruta) {
		File archivo = new File(ruta);
		if (archivo.delete()) {
			System.out.println("Imagen eliminada: " + ruta);
		} else {
			System.out.println("No se pudo eliminar la imagen: " + ruta);
		}
	}

	/**
	 * El método distanciaEdicion() implementa el algoritmo de distancia de
	 *  edición utilizando la programación dinámica. Calcula la distancia de edición 
	 *  entre dos cadenas s1 y s2 y devuelve el resultado.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int distanciaEdicion(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
				}
			}
		}

		return dp[m][n];
	}
	public static boolean validarDatosVehiculo(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,
			int cilindraje,double tamTanque,
			int numPuertas,boolean isGasolina,
			double capCarga ) {
		// TODO Auto-generated method stub
		String mensajeError="Hay valores nulos o vacios en los siguientes campos: \n";
		String mensaje="Hay valores nulos o vacios en los siguientes campos: \n";
		//		if(!validarCadenaBoolean(codigo)){
		//			mensajeError+= "-Identificaciï¿½n \n ";
		//		}
		if(!validarCadenaBoolean(placa)){
			mensajeError+= "-Placa \n ";
		}
		if(!validarCadenaBoolean(marca)){
			mensajeError+= "-Marca \n ";
		}
		if(!validarCadenaBoolean(referencia)){
			mensajeError+= "-Referencia \n ";
		}
//		if(!validarCadenaBoolean(modelo)){
//			mensajeError+= "-Modelo \n ";
//		}

		if(tipoVehiculo==null){
			mensajeError+= "-Tipo vehiculo \n ";
		}else {
			switch (tipoVehiculo) {
			case MOTO:
				if(cilindraje==-1){
					mensajeError+= "-Cilindraje \n ";
				}
				if(tamTanque<=-1){
					mensajeError+= "-Capacidad tanque \n ";
				}
				break;
			case AUTO:
				if(numPuertas<=-1){
					mensajeError+= "-Numero de puertas \n ";
				}
				
				break;
			case CAMION:
				if(capCarga<=-1){
					mensajeError+= "-Capacidad de carga \n ";
				}
				
				break;

			default:
				break;
			}
		}
		if(!mensajeError.equalsIgnoreCase(mensaje)){
			mostrarMensaje("Cuidado", "Error en datos digitados", mensajeError, AlertType.ERROR);
			return false;
		}else{
			return true;
		}
	}

}
