package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.uqvirtual.proyectofinal.application.App;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.RolUsuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Usuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.services.lTiendaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {


private App aplication;
	
	
	

	public App getAplication() {
	return aplication;
}

public void setAplication(App aplication) {
	this.aplication = aplication;
}

	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	private App aplicacion;

	public App getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(App aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<RolUsuario> cmbBoxRol;

	@FXML
	private Button bttSalir;

	@FXML
	private Button bttIngresar;

	@FXML
	private TextField txtUsuario;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Hyperlink lbltxtRecuoerarPass;

	@FXML
	void btt_Ingresar_Action_Login(ActionEvent event) throws IOException {
		validarIngreso();
	}

	@FXML
	void btt_Salir_Action_Login(ActionEvent event) {
		cerrarVentana();
	}

	@FXML
	void hyper_RemenberPass_Action_Login(ActionEvent event) throws IOException {
		aplicacion.recuperarContrasena();
	}

	@FXML
	void initialize() {
		cmbBoxRol.getItems().addAll(RolUsuario.values());
		txtUsuario.setText("seba");//SE CAPTURAN LOS DATOS DEL TEXT FIELD Y SE ASIGNA A UN STRING
		txtPassword.setText("seba");//SE CAPTURAN LOS DATOS DEL TEXT FIELD Y SE ASIGNA A UN STRING
		cmbBoxRol.setValue(RolUsuario.VENDEDOR);
	}

	private void validarIngreso() throws IOException {
		// TODO Auto-generated method stub
		String usuario=txtUsuario.getText();//SE CAPTURAN LOS DATOS DEL TEXT FIELD Y SE ASIGNA A UN STRING
		String password=txtPassword.getText();//SE CAPTURAN LOS DATOS DEL TEXT FIELD Y SE ASIGNA A UN STRING
		RolUsuario rol=cmbBoxRol.getValue();//SE CAPTURAN LOS DATOS DEL COMBOBOX Y SE ASIGNA A UN STRING
		Usuario user=null;
		boolean estadoExistencia=false;

		if(lTiendaService.validarCadena(usuario)&& lTiendaService.validarCadena(password)&& rol!=null){//SE VALIDA QUE LA CADENA NO EST� NULA NI VACIA

			user=modelFactoryController.storify.validarIngreso(usuario, password,rol);
			if(user!=null){//SE VALIDA QUE EL ADMINISTRADOR RETORNADO NO SEA NULO
				switch (rol) {
				case ADMIN:
					estadoExistencia=true;
					modelFactoryController.userLogueado=user;
					modelFactoryController.adminsActual=user;
					aplicacion.abrirVentanaPrincipalAdmin();

					break;
				case VENDEDOR:
					//se retorna un empleado si los datos enviados son encontrados
					estadoExistencia=true;
					modelFactoryController.userLogueado=user;
					aplicacion.abrirVentanaVendedor();

					break;
				case GESTION_DE_CAJA:
					estadoExistencia=true;
					modelFactoryController.userLogueado=user;
					aplicacion.abrirVentanaCaja();

					break;
				default:
					lTiendaService.mostrarMensaje("Cuidado", "Campo vacio", "No has seleccionado un rol", AlertType.WARNING);
					break;
				}
			}else{//SI ES NULO MUESTRA ESTE MENSAJE
				estadoExistencia=false;	
			}

		}
		if (estadoExistencia) {
			//SE CIERRA LA VENTANA ACTUAL(LOGIN)
			cerrarVentana();

			lTiendaService.mostrarMensaje("Bienvenido", "Has ingresado", "Has ingresado como "+rol, AlertType.INFORMATION);

		}else{
			lTiendaService.mostrarMensaje("ha ocurrido algo", "Datos incorrectos o vacios", "Usuario o contrase�a ", AlertType.WARNING);
		}
	}



	private void cerrarVentana() {
		// TODO Auto-generated method stub
		Stage stage =  (Stage) this.bttSalir.getScene().getWindow();
		stage.close();
	}
}
