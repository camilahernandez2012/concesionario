package co.edu.uniquindio.uqvirtual.proyectofinal.application;

import java.io.IOException;

import co.edu.uniquindio.uqvirtual.proyectofinal.controllers.AdminViewController;
import co.edu.uniquindio.uqvirtual.proyectofinal.controllers.CajaViewController;
import co.edu.uniquindio.uqvirtual.proyectofinal.controllers.LoginController;
import co.edu.uniquindio.uqvirtual.proyectofinal.controllers.RecuperarPass_Controller_View;
import co.edu.uniquindio.uqvirtual.proyectofinal.controllers.VendedorViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class App extends Application {

	private Stage primaryStage;
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Storify-Login");	
		//	this.primaryStage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		mostrarventanaPrincipal();
	}


	/**
	 * mostrarVentanaPrincipal
	 * ESTA FUNCION LLAMA LA VENTANA PRINCIPAL
	 */
	private void mostrarventanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(App.class.getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/login.fxml"));

			AnchorPane rootLayout = loader.load();

			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);



			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * MAIN
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * ABRIR VENTANA PRINCIPAL ADMINISTRADOR
	 * @throws IOException
	 */
	public void abrirVentanaPrincipalAdmin() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/vistaPrincipalAdministrador.fxml"));
		Parent root2 = (Parent) fxmlLouder.load();
		AdminViewController vcc = (AdminViewController) fxmlLouder.getController();
		vcc.setAplication(this);
		Stage stage = new Stage();
		stage.setTitle("Storify-BIENVENIDO ADMINISTRADOR");
		stage.setScene(new Scene(root2));
		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		//stage.setResizable(false);
		stage.show();
	}

	/**
	 * 
	 * @throws IOException
	 */
//	public void abrirVentanaPrincipalUsuario() throws IOException{
//		// TODO Auto-generated method stub
//		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/VentanaPrincipalUsuario.fxml"));
//		Parent root2 = (Parent) fxmlLouder.load();
//		UserViewController vcc = (UserViewController) fxmlLouder.getController();
//		vcc.setAplication(this);
//		Stage stage = new Stage();
//		stage.setTitle("Storify-BIENVENIDO");
//		stage.setScene(new Scene(root2));
//		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
//		//stage.setResizable(false);
//		stage.show();
//		
//	}


	


	public void recuperarContrasena() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/RecuperacionContrasena_View.fxml"));
		Parent root2 = (Parent) fxmlLouder.load();
		RecuperarPass_Controller_View vcc = (RecuperarPass_Controller_View) fxmlLouder.getController();
		vcc.setAplicacion(this);
		Stage stage = new Stage();
		stage.setTitle("Storify");
		stage.setScene(new Scene(root2));
		stage.initModality(Modality.APPLICATION_MODAL);//esta linea hace que no retorne a la otra vista hasta que cierres esta
		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		stage.setResizable(false);
		stage.show();
	}



//	public void verCancion() throws IOException {
//		// TODO Auto-generated method stub
//		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/VerCancion.fxml"));
//		Parent root2 = (Parent) fxmlLouder.load();
//		ReproductorViewController vcc = (ReproductorViewController) fxmlLouder.getController();
//		vcc.setAplication(this);
//		Stage stage = new Stage();
//		stage.setTitle("Storify");
//		stage.setScene(new Scene(root2));
//		//	stage.initModality(Modality.APPLICATION_MODAL);//esta linea hace que no retorne a la otra vista hasta que cierres esta
//		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
//		stage.setResizable(true);
//		stage.show();
//
//		stage.setOnCloseRequest(event -> {
//			event.consume(); // Evitar que se cierre automáticamente
//
//			// Mostrar un mensaje de confirmación
//			Alert alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("Cerrar ventana");
//			alert.setHeaderText("¿Está seguro que desea cerrar la ventana?");
//			alert.setContentText("");
//
//			if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
//				// Acciones a realizar al cerrar la ventana
//				//ventanaCerrada=true;
//				vcc.pauseVideo();
//				stage.close();
//				
//			}
//		});
//	}


	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void abrirVentanaVendedor() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/VistaVendedor.fxml"));
		Parent root2 = (Parent) fxmlLouder.load();
		VendedorViewController vcc = (VendedorViewController) fxmlLouder.getController();
		vcc.setAplication(this);
		Stage stage = new Stage();
		stage.setTitle("Storify-BIENVENIDO ADMINISTRADOR");
		stage.setScene(new Scene(root2));
		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		//stage.setResizable(false);
		stage.show();
	}


	public void abrirVentanaCaja() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/uqvirtual/proyectofinal/view/GestionCaja.fxml"));
		Parent root2 = (Parent) fxmlLouder.load();
		CajaViewController vcc = (CajaViewController) fxmlLouder.getController();
		vcc.setAplication(this);
		Stage stage = new Stage();
		stage.setTitle("Storify-BIENVENIDO ADMINISTRADOR");
		stage.setScene(new Scene(root2));
		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		//stage.setResizable(false);
		stage.show();
	}


	

}
