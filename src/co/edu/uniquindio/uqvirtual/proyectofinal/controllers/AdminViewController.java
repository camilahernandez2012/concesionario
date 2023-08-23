package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import co.edu.uniquindio.uqvirtual.proyectofinal.application.App;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Auto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Camion;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Moto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.RolUsuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.TipoVehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Usuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Vehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.services.lTiendaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminViewController {

	private App aplication;




	public App getAplication() {
		return aplication;
	}

	public void setAplication(App aplication) {
		this.aplication = aplication;
	}


	//SE LLAMA LA INSTANCIA DEL MODEL FACTORY CONTROLLER
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}
	ObservableList<Usuario> listadoUsuarios = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listadoVehiculos = FXCollections.observableArrayList();
	ObservableList<Usuario> listadoUsuariosConsultados = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listadoVehiculosConsultados = FXCollections.observableArrayList();


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button bttNuevoUser;

	@FXML
	private ToggleGroup estadoAdminGroupRad;

	@FXML
	private Tab tap_General;

	@FXML
	private TableColumn<Usuario, String> colEmailUser;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_Cantidad_tblTapVehiculos;


	@FXML
	private TextField txtSerch_CodUser;

	@FXML
	private TextField txtUserUser;

	@FXML
	private Label txtUsuario_Tab_Gen;

	@FXML
	private TextField txtSerch_NameUser;

	@FXML
	private Button bttActualizarUser;

	@FXML
	private Button bttLimpiarConsultaUsuario;
	@FXML
	private Button bttConsultaUsuario;

	@FXML
	private Label txtIdentificacion_Tab_Gen;

	@FXML
	private Tab tab_UsuariosCrud;

	@FXML
	private RadioButton radioEstadoInactiveUser;

	@FXML
	private TableColumn<Usuario, RolUsuario> colTipoUser;

	@FXML
	private Button bttGuardarUser;

	@FXML
	private TableColumn<Usuario, String> colCodUser;

	@FXML
	private ComboBox<RolUsuario> cBoxSerch_TipoUser;

	@FXML
	private Label txtCorreo_Tab_Gen;

	@FXML
	private TextField txtNameUser;

	@FXML
	private RadioButton radioEstadoActiveUser;

	@FXML
	private PasswordField txtPassUser;

	@FXML
	private TextField txtCodUser;


	@FXML
	private CheckBox checkBoxMostrarOcultarPasswordAdmin;

	@FXML
	private ComboBox<RolUsuario> cBoxTipoUser;

	@FXML
	private TableColumn<Usuario, String> colNameUser;

	@FXML
	private Label showPassAdmin;

	@FXML
	private TableColumn<Usuario, String> colUserUser;

	@FXML
	private TextField txtEmailUser;

	@FXML
	private Label lblNombreEmpresa_TapGen;

	@FXML
	private TableView<Usuario> tlbUsers;

	@FXML
	private Button bttEliminarAdmin_Tab_Admin;

	@FXML
	private TextField txtPregUser;

	@FXML
	private Label txtNombre_Tab_Gen;

	@FXML
	private TextField txtAnswerUser;

	@FXML
	private CheckBox chkBoxEsAgrupacion;


	//----------------------------TAP VEHICULO

	@FXML
	private TextField txtPlaca;
	@FXML
	private TextField txtMarca;
	@FXML
	private TextField txtReferencia;
	@FXML
	private TextField txtModelo;
	@FXML
	private TextField txtPrecio;
	@FXML
	private TextField txtCantLlantas;
	@FXML
	private TextField txtCant;

	@FXML
	private ComboBox<TipoVehiculo> cmbTipoVehiculo;

	@FXML
	private Label lblMoto;
	@FXML
	private TextField txtCilindraje;
	@FXML
	private Label lblCilindraje;
	@FXML
	private TextField tctCapacidadTanq;
	@FXML
	private Label lblCapacidadTanq;

	@FXML
	private Label lblAuto;
	@FXML
	private Label lblNumPuertas;
	@FXML
	private TextField txtNumPuertas;
	@FXML
	private Label lblIsGasolina;
	@FXML
	private CheckBox chbxIsGasolina;

	@FXML
	private Label lblCamion;
	@FXML
	private Label lblCapCarga;
	@FXML
	private TextField txtCapCarga;


	@FXML
	private TextField txt_Placa_Buaqueda;
	@FXML
	private TextField txt_Marca_Buaqueda;
	@FXML
	private TextField txt_Referencia_Buaqueda;
	@FXML
	private TextField txt_Modelo_Buaqueda;
	@FXML
	private TextField txt_Precio_Buaqueda;

	@FXML
	private Button bttNuevoVehiculo;
	@FXML
	private Button bttGuardarVehiculo;
	@FXML
	private Button bttActua;
	@FXML
	private Button bttConsultarVehiculo;
	@FXML
	private Button btt_LimpiarConsultarVehiculo;
	@FXML
	private Button bttEliminarVehiculo;


	@FXML
	private TableView<Vehiculo> tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, String> colm_placa_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, String> colm_marca_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, String> colm_referencia_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, Integer> colm_modelo_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, Double> colm_precio_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, Integer> colm_numRuedas_tblTapVehiculos;
	@FXML
	private TableColumn<Vehiculo, TipoVehiculo> colm_tipoVehiculo_tblTapVehiculos;




	@FXML
	void bttActionNuevoVehiculo(ActionEvent event) {
		vaciarCamposVehiculo();
		cargarListadoVehiculos();

	}
	private void vaciarCamposVehiculo() {
		// TODO Auto-generated method stub
		txtPlaca.setDisable(false);
		txtCant.setDisable(false);
		txtCant.setText("");
		txtPlaca.setText("");
		txtMarca.setText("");
		txtReferencia.setText("");
		txtModelo.setText("");
		txtPrecio.setText("");
		txtCantLlantas.setText("");
		cmbTipoVehiculo.setValue(null);
		cmbTipoVehiculo.setDisable(false);


		txtCilindraje.setText("");
		tctCapacidadTanq.setText("");
		txtNumPuertas.setText("");
		chbxIsGasolina.setSelected(true);
		txtCapCarga.setText("");


		habilitarDehabilitarCamposMoto(true);
		habilitarDehabilitarCamposAuto(true);
		habilitarDehabilitarCamposCamion(true);

	}

	@FXML
	void bttActionGuardarVehiculo(ActionEvent event) {
		guardarVehiculo();
	}
	private void guardarVehiculo() {
		// TODO Auto-generated method stub
		int numPuertas=-1;
		boolean isGasolina=false;
		int cilindraje=-1;
		double tamTanque=-1;
		double capCarga=-1;


		String placa=txtPlaca.getText();
		String marca=txtMarca.getText();
		String referencia=txtReferencia.getText();
		int modelo=Integer.parseInt(txtModelo.getText());

		double precio=Double.parseDouble(txtPrecio.getText());
		int cantLantas=Integer.parseInt(txtCantLlantas.getText());
		int cantidad=Integer.parseInt(txtCant.getText());

		TipoVehiculo tipoSeleccionado=cmbTipoVehiculo.getValue();


		switch (tipoSeleccionado) {
		case MOTO:
			cilindraje=Integer.parseInt(txtCilindraje.getText());
			tamTanque=Double.parseDouble(tctCapacidadTanq.getText());
			break;
		case AUTO:
			numPuertas=Integer.parseInt(txtNumPuertas.getText());
			isGasolina=obtenerEstadoCheckGasolin();
			break;
		case CAMION:
			capCarga=Double.parseDouble(txtCapCarga.getText());
			break;

		default:
			break;
		}

		if(lTiendaService.validarDatosVehiculo( placa,  marca, tipoSeleccionado,  referencia,  modelo,  precio,  cantLantas,
				cilindraje, tamTanque,
				numPuertas, isGasolina,
				capCarga )){
			Vehiculo nuevo = modelFactoryController.guardarVehiculo(  placa,  marca, tipoSeleccionado,  referencia,  modelo,  precio,  cantLantas,cantidad,
					cilindraje, tamTanque,
					numPuertas, isGasolina,
					capCarga);
			if(nuevo!=null){//SI ES DIFERENTE A NULL ES POR QUE SE CREï¿½ EL AREA
				//SE MUESTRA MENSAJE DE CONFIRMACION
				lTiendaService.mostrarMensaje("Exito", "Creaciï¿½n realizada", "Se ha creado correctamente ", AlertType.INFORMATION);			
				vaciarCamposUsuario();

			}else {//SI RETORNA NULL ES POR QUE OCURRIï¿½ ALGO Y NO SE CREï¿½ EL AREA
				lTiendaService.mostrarMensaje("Cuidado", "Ha ocurrido algo", "No se realizado la creaciï¿½n ha creado ", AlertType.ERROR);
			}
		}
	
		cargarListadoVehiculos();
	}

	private boolean obtenerEstadoCheckGasolin() {
		// TODO Auto-generated method stub
		if (chbxIsGasolina.isSelected()) {
			return true;
		}
		return false;
	}

	@FXML
	void bttActionActualizarVehiculo(ActionEvent event) {
		actualizarVehiculo();
	}
	private void actualizarVehiculo() {
		// TODO Auto-generated method stub
		int numPuertas=-1;
		boolean isGasolina=false;
		int cilindraje=-1;
		double tamTanque=-1;
		double capCarga=-1;


		String placa=txtPlaca.getText();
		String marca=txtMarca.getText();
		String referencia=txtReferencia.getText();
		int modelo=Integer.parseInt(txtModelo.getText());

		double precio=Double.parseDouble(txtPrecio.getText());
		int cantLantas=Integer.parseInt(txtCantLlantas.getText());
		TipoVehiculo tipoSeleccionado=cmbTipoVehiculo.getValue();

		switch (tipoSeleccionado) {
		case MOTO:
			cilindraje=Integer.parseInt(txtCilindraje.getText());
			tamTanque=Double.parseDouble(tctCapacidadTanq.getText());
			break;
		case AUTO:
			numPuertas=Integer.parseInt(txtNumPuertas.getText());
			isGasolina=obtenerEstadoCheckGasolin();
			break;
		case CAMION:
			capCarga=Double.parseDouble(txtCapCarga.getText());
			break;

		default:
			break;
		}

		if(lTiendaService.validarDatosVehiculo( placa,  marca, tipoSeleccionado,  referencia,  modelo,  precio,  cantLantas,
				cilindraje, tamTanque,
				numPuertas, isGasolina,
				capCarga )){
			Vehiculo nuevo = modelFactoryController.actualizarVehiculo(  placa,  marca, tipoSeleccionado,  referencia,  modelo,  precio,  cantLantas,
					cilindraje, tamTanque,
					numPuertas, isGasolina,
					capCarga);
			if(nuevo!=null){//SI ES DIFERENTE A NULL ES POR QUE SE CREï¿½ EL AREA
				//SE MUESTRA MENSAJE DE CONFIRMACION
				lTiendaService.mostrarMensaje("Exito", "Actualización realizada", "Se ha creado correctamente ", AlertType.INFORMATION);			
				vaciarCamposUsuario();

			}else {//SI RETORNA NULL ES POR QUE OCURRIï¿½ ALGO Y NO SE CREï¿½ EL AREA
				lTiendaService.mostrarMensaje("Cuidado", "Ha ocurrido algo", "No se realizado la Actualización ha creado ", AlertType.ERROR);
			}
		}
	
		cargarListadoVehiculos();
	}

	@FXML
	void btt_action_ConsultarVehiculo(ActionEvent event) {
		consultarVehiculos();
	}
	private void consultarVehiculos() {
		// TODO Auto-generated method stub

		//boolean [] campos=new boolean [5];
		String placaBusq=txt_Placa_Buaqueda.getText();
		String marcaBusq=txt_Marca_Buaqueda.getText();
		String referenciaBusq=txt_Referencia_Buaqueda.getText();
		String model=txt_Modelo_Buaqueda.getText();
		String precio=txt_Precio_Buaqueda.getText();
		if (model.equalsIgnoreCase("")) {
			model="0";
		}
		if (precio.equalsIgnoreCase("")) {
			precio="0.0";
		}




		try {
			int modeloBusq=Integer.parseInt(model);
			double precioBusq=Double.parseDouble(precio);

			cargarListadoVehiculosConsultados(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq);
		} catch (NumberFormatException e) {

		}


	}

	//	private boolean[] validarCamposConsultaVehiculo(String placaBusq, String marcaBusq, String referenciaBusq,
	//			int modeloBusq, double precioBusq) {
	//		// TODO Auto-generated method stub
	//		String modelo=""+modeloBusq;
	//		String precio=""+precioBusq;
	//		
	//		
	//		
	//		boolean [] campos=new boolean [5];
	//		campos[0]=false;
	//		campos[1]=false;
	//		campos[2]=false;
	//		campos[3]=false;
	//		campos[4]=false;
	//		
	//		if (placaBusq!=null && !placaBusq.equalsIgnoreCase("")) {
	//			campos[0]=true;
	//		}
	//		if (marcaBusq!=null && !marcaBusq.equalsIgnoreCase("")) {
	//			campos[1]=true;
	//		}
	//		if (referenciaBusq!=null && !referenciaBusq.equalsIgnoreCase("")) {
	//			campos[2]=true;
	//		}
	//		if (modelo!=null && !modelo.equalsIgnoreCase("")) {
	//			campos[3]=true;
	//		}
	//		if (precio!=null && !precio.equalsIgnoreCase("")) {
	//			campos[4]=true;
	//		}
	//		
	//		return campos;
	//		
	//	}

	private void cargarListadoVehiculosConsultados( String placaBusq, String marcaBusq, String referenciaBusq,
			int modeloBusq, double precioBusq) {
		// TODO Auto-generated method stub
		tblTapVehiculos.getItems().clear();
		tblTapVehiculos.setItems(obtenerConsultaVehiculos(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq));
	}

	private ObservableList<Vehiculo> obtenerConsultaVehiculos(String placaBusq, String marcaBusq,
			String referenciaBusq, int modeloBusq, double precioBusq) {
		// TODO Auto-generated method stub
		listadoVehiculosConsultados.addAll(modelFactoryController.obtenerConsultaVehiculos(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq));
		return listadoVehiculosConsultados;
	}

	@FXML
	void btt_action_LimpiarConsultarVehiculo(ActionEvent event) {
		limpiarCamposConsulta();
	}
	private void limpiarCamposConsulta() {
		// TODO Auto-generated method stub

		txt_Placa_Buaqueda.setText("");
		txt_Marca_Buaqueda.setText("");
		txt_Referencia_Buaqueda.setText("");
		txt_Modelo_Buaqueda.setText("");
		txt_Precio_Buaqueda.setText("");

		cargarListadoVehiculos();
	}
	@FXML
	void bttActionEliminarVehiculo(ActionEvent event) {
		eliminarVehiculo();
	}
	private void eliminarVehiculo() {
		// TODO Auto-generated method stub
		String placa = txtPlaca.getText();
		TipoVehiculo tipoVehiculo=cmbTipoVehiculo.getValue();
		boolean estadoElimanacion=false;
		if (lTiendaService.validarCadena(placa)) {
			if (lTiendaService.mostrarVentanaConfirmacion("¿Estas seguro de eliminar este usuarios?")) {
				estadoElimanacion = modelFactoryController.eliminarVehiculo(placa,tipoVehiculo);
				if (estadoElimanacion) {
					lTiendaService.mostrarMensaje("Información", "Operación Realizada", "Eliminación realizada", AlertType.INFORMATION);
				}else {
					lTiendaService.mostrarMensaje("Información", "Operación interrumpida", "Eliminación cancelada", AlertType.WARNING);
				}
			}else{
				lTiendaService.mostrarMensaje("Información", "Operación interrumpida", "Eliminación cancelada", AlertType.INFORMATION);
			}

		}
		
		vaciarCamposUsuario();
		cargarListadoVehiculos();
	}

	@FXML
	void mostrarOcultarPasswordAdmin(ActionEvent event) {
		passwordAdmin();
	}

	@FXML
	void bttActionNuevoUser(ActionEvent event) {
		vaciarCamposUsuario();
	}

	@FXML
	void bttActionGuardarUser(ActionEvent event) {
		guardarUsuario();
	}

	private void guardarUsuario() {
		// TODO Auto-generated method stub
		String codUser = txtCodUser.getText();
		RolUsuario tipoUser = cBoxTipoUser.getValue();
		String userName=txtUserUser.getText();
		String name= txtNameUser.getText();


		String passUser = txtPassUser.getText();
		String emailUser = txtEmailUser.getText();
		String pregUser = txtPregUser.getText();
		String answerUser = txtAnswerUser.getText();
		boolean esAgrupacion=chkBoxEsAgrupacion.isSelected();
		boolean estadoUsuario = obtenerEstadoUsuario();

		if(lTiendaService.validarDatosUsuario(codUser,name,tipoUser,userName,passUser,emailUser,pregUser,answerUser)){
			Usuario nuevo=modelFactoryController.crearUsuario(codUser,name,tipoUser,userName
					,passUser,emailUser,pregUser,answerUser,estadoUsuario,esAgrupacion);

			if(nuevo!=null){//SI ES DIFERENTE A NULL ES POR QUE SE CREï¿½ EL AREA
				//SE MUESTRA MENSAJE DE CONFIRMACION
				lTiendaService.mostrarMensaje("Exito", "Creaciï¿½n realizada", "Se ha creado correctamente ", AlertType.INFORMATION);			
				vaciarCamposUsuario();

			}else {//SI RETORNA NULL ES POR QUE OCURRIï¿½ ALGO Y NO SE CREï¿½ EL AREA
				lTiendaService.mostrarMensaje("Cuidado", "Ha ocurrido algo", "No se realizado la creaciï¿½n ha creado ", AlertType.ERROR);
			}
		}
		
		cargarListadoUsuarios();
	}

	@FXML
	void bttActionActualizarUser(ActionEvent event) {
		actualizarUsuario();
	}

	private void actualizarUsuario() {
		// TODO Auto-generated method stub
		String codUser = txtCodUser.getText();
		RolUsuario tipoUser = cBoxTipoUser.getValue();
		String nameUser=txtUserUser.getText();
		String name= txtNameUser.getText();
		String userUser = txtUserUser.getText();
		String passUser = txtPassUser.getText();
		String emailUser = txtEmailUser.getText();
		String pregUser = txtPregUser.getText();
		String answerUser = txtAnswerUser.getText();
		boolean esAgrupacion=chkBoxEsAgrupacion.isSelected();
		boolean estadoUsuario = obtenerEstadoUsuario();

		if(lTiendaService.validarDatosUsuario(codUser,name,tipoUser,nameUser,passUser,emailUser,pregUser,answerUser)){
			Usuario actualizado=modelFactoryController.actualizarUsuario(codUser,name,tipoUser,nameUser
					,userUser,passUser,emailUser,pregUser,answerUser,estadoUsuario,esAgrupacion);

			if(actualizado!=null){//SI ES DIFERENTE A NULL ES POR QUE SE CREï¿½ EL AREA
				//SE MUESTRA MENSAJE DE CONFIRMACION
				lTiendaService.mostrarMensaje("Exito", "ActualizaciÃ³n realizada", "Se ha creado correctamente ", AlertType.INFORMATION);			
				vaciarCamposUsuario();

			}else {//SI RETORNA NULL ES POR QUE OCURRIï¿½ ALGO Y NO SE CREï¿½ EL AREA
				lTiendaService.mostrarMensaje("Cuidado", "Ha ocurrido algo", "No se realizado la actualizaciÃ³n ha creado ", AlertType.ERROR);
			}
		}
		
		cargarListadoUsuarios();
	}

	@FXML
	void bttActionEliminarAdmin(ActionEvent event) {
		eliminarUsuario();

	}



	private void eliminarUsuario() {
		// TODO Auto-generated method stub
		String codUser = txtCodUser.getText();
		boolean estadoElimanacion=false;
		if (lTiendaService.validarCadena(codUser)) {
			if (lTiendaService.mostrarVentanaConfirmacion("¿Estas seguro de eliminar este usuarios?")) {
				estadoElimanacion = modelFactoryController.eliminarUsuario(codUser);
				if (estadoElimanacion) {
					lTiendaService.mostrarMensaje("Información", "Operación Realizada", "Eliminación realizada", AlertType.INFORMATION);
				}else {
					lTiendaService.mostrarMensaje("Información", "Operación interrumpida", "Eliminación cancelada", AlertType.WARNING);
				}
			}else{
				lTiendaService.mostrarMensaje("Información", "Operación interrumpida", "Eliminación cancelada", AlertType.INFORMATION);
			}

		}
	
		vaciarCamposUsuario();
		cargarListadoUsuarios();
	}

	@FXML
	void bttActionLimpiarConsultaUsuario(ActionEvent event) {
		vaciarCamposConsultaUsuario();
		cargarListadoUsuarios();
	}
	@FXML
	void bttActionConsultaUsuario(ActionEvent event) {
		consultarUsuarios();
	}

	private void consultarUsuarios() {
		// TODO Auto-generated method stub
		boolean [] campos=new boolean [3];
		String codSearch=txtSerch_CodUser.getText();
		String nameSearch=txtSerch_NameUser.getText();
		RolUsuario rolSearch=cBoxSerch_TipoUser.getValue();
		campos=validarCamposConsulta(codSearch,nameSearch,rolSearch);
		cargarListadoUsuariosConsultados(campos,codSearch,nameSearch,rolSearch);


	}
	private void cargarListadoUsuariosConsultados(boolean[] campos, String codSearch, String nameSearch, RolUsuario rolSearch) {
		// TODO Auto-generated method stub
		tlbUsers.getItems().clear();
		tlbUsers.setItems(obtenerConsultaUsuarios(campos,codSearch,nameSearch,rolSearch));
	}
	private ObservableList<Usuario> obtenerConsultaUsuarios(boolean[] campos, String codSearch, String nameSearch, RolUsuario rolSearch) {
		// TODO Auto-generated method stub
		listadoUsuarios.addAll(modelFactoryController.obtenerConsultaUsuarios(campos,codSearch,nameSearch,rolSearch));
		return listadoUsuarios;
	}
	/**
	 * validarCamposConsulta
	 * @param codSearch
	 * @param nameSearch
	 * @param rolSearch
	 * @return
	 */
	private boolean[] validarCamposConsulta(String codSearch, String nameSearch, RolUsuario rolSearch) {
		// TODO Auto-generated method stub
		boolean [] campos=new boolean [3];
		campos[0]=false;campos[1]=false;campos[2]=false;
		if (codSearch!=null && !codSearch.equalsIgnoreCase("")) {
			campos[0]=true;
		}
		if (nameSearch!=null && !nameSearch.equalsIgnoreCase("")) {
			campos[1]=true;
		}
		if (rolSearch!=null) {
			campos[2]=true;
		}
		return campos;
	}
	@FXML
	void initializeTapVehiculo() {
		this.colm_placa_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.colm_marca_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colm_referencia_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("referencia"));
		this.colm_modelo_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		this.colm_precio_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.colm_numRuedas_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("numRuedas"));
		this.colm_tipoVehiculo_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
		this.colm_Cantidad_tblTapVehiculos.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

		tblTapVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			Vehiculo	vehiculoSeleccionado = newSelection;

			mostraInformacionVehiculo(vehiculoSeleccionado);

		});
		cargarListadoVehiculos();

	}


	private void mostraInformacionVehiculo(Vehiculo vehiculoSeleccionado) {
		// TODO Auto-generated method stub
		if (vehiculoSeleccionado!=null) {
			txtPlaca.setText(""+vehiculoSeleccionado.getPlaca());
			txtMarca.setText(""+vehiculoSeleccionado.getMarca());
			txtReferencia.setText(""+vehiculoSeleccionado.getReferencia());
			txtModelo.setText(""+vehiculoSeleccionado.getModelo());
			txtPrecio.setText(""+vehiculoSeleccionado.getPrecio());
			txtCantLlantas.setText(""+vehiculoSeleccionado.getNumRuedas());
			cmbTipoVehiculo.setValue(vehiculoSeleccionado.getTipoVehiculo());
			txtCant.setText(""+vehiculoSeleccionado.getCantidad());
			
			txtPlaca.setDisable(true);
			txtCant.setDisable(true);
			cmbTipoVehiculo.setDisable(true);


			switch (vehiculoSeleccionado.getTipoVehiculo()) {
			case MOTO:

				if (vehiculoSeleccionado instanceof Moto) {
					txtCilindraje.setText(""+((Moto) vehiculoSeleccionado).getCilindraje());
					tctCapacidadTanq.setText(""+((Moto) vehiculoSeleccionado).getTamTanque());
				}

				break;
			case AUTO:
				if (vehiculoSeleccionado instanceof Auto) {
					txtNumPuertas.setText(""+((Auto) vehiculoSeleccionado).getNumPuertas());
					if (((Auto) vehiculoSeleccionado).isGasolina()) {
						chbxIsGasolina.setSelected(true);
					}else {
						chbxIsGasolina.setSelected(false);
					}
				}
				break;
			case CAMION:
				if (vehiculoSeleccionado instanceof Camion) {
					txtCapCarga.setText(""+((Camion) vehiculoSeleccionado).getCapCarga());

				}
				break;

			default:

				break;
			}


		}
	}

	@FXML
	void initialize() {
		comboBox();
		initializeTapVehiculo();
		iniciarDatosUserLog();
		iniciarTapUsuarios();

		this.colCodUser.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.colNameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
		this.colTipoUser.setCellValueFactory(new PropertyValueFactory<>("rol"));
		this.colEmailUser.setCellValueFactory(new PropertyValueFactory<>("email"));
		this.colUserUser.setCellValueFactory(new PropertyValueFactory<>("username"));

		tlbUsers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			Usuario	usuarioSeleccionado = newSelection;

			mostraInformacionUsuario(usuarioSeleccionado);

		});
		cargarListadoUsuarios();
		/*	tlbUsers.setOnMouseClicked(event -> {
		if (event.getClickCount() == 2) {
			// Paso 2: Obtener el elemento seleccionado de la tabla
			Usuario usuarioSeleccionado = tlbUsers.getSelectionModel().getSelectedItem();

			if (usuarioSeleccionado != null) {
				// Paso 3: Crear y configurar la nueva ventana


				lTiendaService.mostrarMensaje("Usuario", "Datos", " Nombre:    "+usuarioSeleccionado.getName()+" \n "
						+ "Usuario:      "+usuarioSeleccionado.getUsername()
					 +" \n Codigo:       "+usuarioSeleccionado.getCodigo()
					 +" \n Email:        "+usuarioSeleccionado.getEmail()
					 +" \n Tipo usuario: "+usuarioSeleccionado.getRol(), AlertType.CONFIRMATION);

			}
		}
	});*/
	}


	private void iniciarDatosUserLog() {
		// TODO Auto-generated method stub
		txtNombre_Tab_Gen.setText("Nombre:   "+modelFactoryController.userLogueado.getName());
		txtUsuario_Tab_Gen.setText("Usuario:  "+modelFactoryController.userLogueado.getUsername());
		txtCorreo_Tab_Gen.setText("Email:    "+modelFactoryController.userLogueado.getEmail());
		txtIdentificacion_Tab_Gen.setText("Código:   "+modelFactoryController.userLogueado.getCodigo());
	}

	/**
	 * comboBox
	 */
	public void comboBox() {
		// TODO Auto-generated method stub
		cmbTipoVehiculo.setOnAction(event -> {
			// Obtener la opción seleccionada del ComboBox
			TipoVehiculo opcionSeleccionada = cmbTipoVehiculo.getValue();

			switch (opcionSeleccionada) {
			case MOTO:
				habilitarDehabilitarCamposMoto(false);
				habilitarDehabilitarCamposAuto(true);
				habilitarDehabilitarCamposCamion(true);
				break;
			case AUTO:
				habilitarDehabilitarCamposMoto(true);
				habilitarDehabilitarCamposAuto(false);
				habilitarDehabilitarCamposCamion(true);
				break;
			case CAMION:
				habilitarDehabilitarCamposMoto(true);
				habilitarDehabilitarCamposAuto(true);
				habilitarDehabilitarCamposCamion(false);
				break;

			default:

				break;
			}
		});
	}

	private void habilitarDehabilitarCamposMoto(boolean estado) {
		// TODO Auto-generated method stub
		lblMoto.setDisable(estado);
		lblCilindraje.setDisable(estado);
		lblCapacidadTanq.setDisable(estado);
		txtCilindraje.setDisable(estado);
		tctCapacidadTanq.setDisable(estado);
	}
	private void habilitarDehabilitarCamposAuto(boolean estado) {
		// TODO Auto-generated method stub
		lblAuto.setDisable(estado);
		lblNumPuertas.setDisable(estado);
		lblIsGasolina.setDisable(estado);
		txtNumPuertas.setDisable(estado);
		chbxIsGasolina.setDisable(estado);
	}
	private void habilitarDehabilitarCamposCamion(boolean estado) {
		// TODO Auto-generated method stub
		lblCamion.setDisable(estado);
		lblCapCarga.setDisable(estado);
		txtCapCarga.setDisable(estado);
	}

	private void mostraInformacionUsuario(Usuario usuarioSeleccionado) {
		// TODO Auto-generated method stub
		if (usuarioSeleccionado!=null) {

			txtCodUser.setDisable(true);
			txtCodUser.setText(usuarioSeleccionado.getCodigo());
			cBoxTipoUser.setValue(usuarioSeleccionado.getRol());
			txtUserUser.setText(usuarioSeleccionado.getUsername());
			txtNameUser.setText(usuarioSeleccionado.getName());
			txtPassUser.setText(usuarioSeleccionado.getContrasena());
			txtEmailUser.setText(usuarioSeleccionado.getEmail());
			txtPregUser.setText(usuarioSeleccionado.getPreguntaSeguridad());
			txtAnswerUser.setText(usuarioSeleccionado.getRespuesta());
			if(usuarioSeleccionado.isEstado()){
				radioEstadoActiveUser.setSelected(true);
			}else {
				radioEstadoInactiveUser.setSelected(true);
			}


		}
	}



	private void cargarListadoUsuarios() {
		// TODO Auto-generated method stub
		tlbUsers.getItems().clear();
		tlbUsers.setItems(obtenerUsuarios());
	}
	private void cargarListadoVehiculos() {
		// TODO Auto-generated method stub
		tblTapVehiculos.getItems().clear();
		tblTapVehiculos.setItems(obtenerVehiculos());
	}

	private ObservableList<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub	
		listadoVehiculos.addAll(modelFactoryController.obtenerVehiculos());
		return listadoVehiculos;
	}

	private ObservableList<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		listadoUsuarios.addAll(modelFactoryController.obtenerUsuarios());
		return listadoUsuarios;
	}

	private void iniciarTapUsuarios() {
		// TODO Auto-generated method stub
		vaciarCamposUsuario();
		vaciarCamposConsultaUsuario();
		iniciarComboBox();
	}

	private void iniciarComboBox() {
		// TODO Auto-generated method stub
		cBoxSerch_TipoUser.getItems().addAll(RolUsuario.values());
		cBoxTipoUser.getItems().addAll(RolUsuario.values());
		cmbTipoVehiculo.getItems().addAll(TipoVehiculo.values());

	}


	public void vaciarCamposUsuario(){
		txtCodUser.setDisable(false);
		txtCodUser.setText("");	
		cBoxTipoUser.setValue(RolUsuario.VENDEDOR);	
		txtNameUser.setText("");

		txtUserUser.setText("");
		txtPassUser.setText("");
		checkBoxMostrarOcultarPasswordAdmin.setSelected(false);
		showPassAdmin.setText("");
		txtEmailUser.setText("");
		txtPregUser.setText("");
		txtAnswerUser.setText("");
		txtCodUser.setText("");
		radioEstadoActiveUser.setSelected(true);
		radioEstadoInactiveUser.setSelected(false);



		chkBoxEsAgrupacion.setDisable(false);

		cargarListadoUsuarios();
	}
	public void vaciarCamposConsultaUsuario(){
		txtSerch_CodUser.setText("");
		txtSerch_NameUser.setText("");
		cBoxSerch_TipoUser.setValue(null);

	}
	public boolean obtenerEstadoUsuario(){
		//SI EL RADIOBUTTON radio_Select_RolAdministrador ESTA SELECCIONADO
		if(radioEstadoActiveUser.isSelected()){
			return true;
		}	
		return false;
	}
	private void passwordAdmin() {
		// TODO Auto-generated method stub
		showPassAdmin.setVisible(false);
		showPassAdmin.setText("");
		if(!txtPassUser.getText().equalsIgnoreCase("")){
			if(checkBoxMostrarOcultarPasswordAdmin.isSelected()){
				showPassAdmin.setVisible(true);
				showPassAdmin.setText(""+txtPassUser.getText());
			}else{
				showPassAdmin.setVisible(false);
				showPassAdmin.setText(""+txtPassUser.getText());
			}	
		}
	}




}
