package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.uqvirtual.proyectofinal.application.App;
import co.edu.uniquindio.uqvirtual.proyectofinal.exceptions.datosNulosException;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Usuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.services.lTiendaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RecuperarPass_Controller_View {
	private App aplicacion;
	private Usuario encontrado;

	//SE LLAMA LA INSTANCIA DEL MODEL FACTORY CONTROLLER
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();


	/**
	 * GETTERS AND SETTERS
	 */

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}
	public App getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(App app) {
		// TODO Auto-generated method stub

	}
	public Usuario getEncontrado() {
		return encontrado;
	}
	public void setEncontrado(Usuario encontrado) {
		this.encontrado = encontrado;
	}
	@FXML
	private TabPane tapPane_RecuperarPassword;

	@FXML
	private Tab tabCambiar_Pass;

	@FXML
	private Tab tabRecup_Correo;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtCorreoRecuperacion;

	@FXML
	private Button bttResponderPregunta;

	@FXML
	private Button bttEnviarCorreo;

	@FXML
	private Button bttCambiarPassword;

	@FXML
	private TextField txtRespuesta;

	@FXML
	private PasswordField txtContrasenaNueva;

	@FXML
	private PasswordField txtContrasenaNuevaRepetida;

	@FXML
	private ImageView idImgCarga;
	
	/**
	 * bttCambiarPassword_Action
	 * @param event
	 * @throws datosNulosException
	 * @throws IOException
	 */
	@FXML
	void bttCambiarPassword_Action(ActionEvent event) throws datosNulosException, IOException {
		cambiarPassword();
	}
	/**
	 * bttEnviarCorreo_Action
	 * @param event
	 */
	@FXML
	void bttEnviarCorreo_Action(ActionEvent event) {	
		validarCorreo();	
	}
	/**
	 * bttResponderPregunta_Action
	 * @param event
	 */
	@FXML
	void bttResponderPregunta_Action(ActionEvent event) {
		validarRespuesta();
	}
	/**
	 * validarCorreo
	 * Este metodo recibe un string el cual ser� el correo
	 */
	private void validarCorreo() {
		// TODO Auto-generated method stub
		vistaInicial();
		String correo=txtCorreoRecuperacion.getText();
		Usuario usuario=modelFactoryController.validarCorreoRecuperacion(correo);
		if (usuario!=null) {
			EnvioCorreos correoRecuperacion=new EnvioCorreos();
			correoRecuperacion.createEmail(correo, "Correo de recuperación", "Para recuperar tu contraseña debes responder la siguiente pregunta: \n "+usuario.getPreguntaSeguridad());
			correoRecuperacion.sendEmail();		
			lTiendaService.mostrarMensaje("Exito", "Correo enviado", "Se ha enviado exitosamente el correo de recuperacion a "+correo, AlertType.INFORMATION);
			vistaCorreoEnviado();
			encontrado=usuario;
		}else{
			lTiendaService.mostrarMensaje("No encontrado", "Correo no enviado", "No se ha encontrado correo de recuperacion : "+correo, AlertType.WARNING);
			vistaInicial();
		}
	}
	/**
	 * cambiarPassword
	 * funcion que ontiene datos nuevos para cambiar contrase�a del usuario encontrado
	 * @throws datosNulosException
	 * @throws IOException
	 */
	private void cambiarPassword() throws datosNulosException, IOException {
		// TODO Auto-generated method stub
		Usuario persona=null;
		String password=txtContrasenaNueva.getText();
		String passwordConfirma=txtContrasenaNuevaRepetida.getText();
		if(lTiendaService.validarCadena(password)&&lTiendaService.validarCadena(passwordConfirma)){
			if(lTiendaService.PassCheck(password).equalsIgnoreCase(password)){
				if(password.equalsIgnoreCase(passwordConfirma)){
					persona=modelFactoryController.cambiarPasword(encontrado.getCodigo(),password);
					if(persona!=null){
						lTiendaService.mostrarMensaje("Se ha cambiado la contrase�a con �xito", "Se cambi� la contrase�a", "Se ha cambiado la contrase�a con exito", AlertType.INFORMATION);
						
						cerrarVentana();
					}else{
						lTiendaService.mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a", "Se ha cambiado la contrase�a con exito", AlertType.INFORMATION);

					}
				}else{
					lTiendaService.mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a", "Las contrase�as deben ser iguales en los dos campos", AlertType.INFORMATION);
				}
			}


		}else{
			lTiendaService.mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a", "Hay algun campo vacio o nulo", AlertType.INFORMATION);
		}


	}
	/**
	 * vistaCorreoEnviado
	 * ESTE METODO HABILITA CIERTOS ELEMENTOS DE LA VISTA SOLO Y SOLO SI EL CORREO SE ENVIA
	 */
	private void vistaCorreoEnviado() {
		// TODO Auto-generated method stub
		txtRespuesta.setDisable(false);
		bttResponderPregunta.setDisable(false);
	}
	/**
	 * vistaCorreoEnviado
	 * ESTE METODO HABILITA CIERTOS ELEMENTOS DE LA VISTA SOLO Y SOLO SI EL CORREO SE ENVIA
	 */
	public void vistaRespuetaCorrecta() {
		// TODO Auto-generated method stub
		tabRecup_Correo.setDisable(true);
		tabCambiar_Pass.setDisable(false);
		tapPane_RecuperarPassword.getSelectionModel().select(tabCambiar_Pass);
	}
	/**
	 * vistaInicial
	 * DESABILITA CIERTOS ELEMENTOS PARA LA VISTA INICIAL
	 */
	private void vistaInicial() {
		// TODO Auto-generated method stub
		tapPane_RecuperarPassword.getSelectionModel().select(tabRecup_Correo);
		tabCambiar_Pass.setDisable(true);
		txtRespuesta.setDisable(true);
		bttResponderPregunta.setDisable(true);
	}
	/**
	 * validarRespuesta
	 */
	private void validarRespuesta() {
		int contador=0;
		do {//SOLO SE PUEDE ENVIAR LA RESPUESTA 3 VECES
			String respuesta=txtRespuesta.getText();
			// TODO Auto-generated method stub
			if(respuesta==null||respuesta.equalsIgnoreCase("")){//SE VALIDA QUE NO SEA NULA NI VACIA LA CADENA
				JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
			}else{
				if (encontrado.getRespuesta().equalsIgnoreCase(respuesta)) {
					JOptionPane.showMessageDialog(null, "Respuesta Correcta");
					vistaRespuetaCorrecta();
					break;
				}
			}
		} while (contador<=3);


	}
	/**
	 * cerrarVentana
	 * METODO CIERRA LA VENTANA CON EL BOTON SALIR
	 */
	private void cerrarVentana() {
		// TODO Auto-generated method stub
		Stage stage =  (Stage) this.bttCambiarPassword.getScene().getWindow();
		stage.close();
	}

}

