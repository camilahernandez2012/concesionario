package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.uqvirtual.proyectofinal.application.App;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Auto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Camion;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Factura;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Moto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.TipoVehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendedorViewController {

	//SE LLAMA LA INSTANCIA DEL MODEL FACTORY CONTROLLER
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	ObservableList<Vehiculo> listadoVehiculos = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listadoVehiculosCarrito = FXCollections.observableArrayList();
	Vehiculo vehiculoSeleccionado;
	Vehiculo vehiculoSeleccionadoCarrito;
	int cantidad=0;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Vehiculo, TipoVehiculo> colm_tipoVehiculo_tblTapVehiculos_Disponibles;

	@FXML
	private Button bttLimpiarCarrito;

	@FXML
	private Button bttAgregar;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_Cantidad_tblTapVehiculos_Carrito;

	@FXML
	private TableColumn<Vehiculo,String> colm_placa_tblTapVehiculos_Carrito;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_modelo_tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo,String> colm_placa_tblTapVehiculos_Disponibles;

	@FXML
	private Button btt_LimpiarConsultarVehiculo;

	@FXML
	private TableColumn<Vehiculo,Double> colm_precio_tblTapVehiculos_Carrito;

	@FXML
	private Button bttGenerarVenta;

	@FXML
	private TableColumn<Vehiculo, TipoVehiculo> colm_tipoVehiculo_tblTapVehiculos_Carrito;

	@FXML
	private TextField txt_Modelo_Buaqueda;

	@FXML
	private TextField txt_Precio_Buaqueda;

	@FXML
	private Button bttQuitar;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_numRuedas_tblTapVehiculos_Disponibles;

	@FXML
	private Button bttConsultarVehiculo;

	@FXML
	private TableColumn<Vehiculo, String> colm_referencia_tblTapVehiculos_Disponibles;

	@FXML
	private TableView<Vehiculo> tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo, Double> colm_precio_tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_Cantidad_tblTapVehiculos1;

	@FXML
	private TableColumn<Vehiculo, String> colm_marca_tblTapVehiculos_Disponibles;

	@FXML
	private TextField txt_Placa_Buaqueda;

	@FXML
	private TextField txt_Referencia_Buaqueda;

	@FXML
	private TableView<Vehiculo> tblTapVehiculos_Carrito;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_numRuedas_tblTapVehiculos_Carrito;

	@FXML
	private TableColumn<Vehiculo, Integer> colm_modelo_tblTapVehiculos_Carrito;

	@FXML
	private TableColumn<Vehiculo, String> colm_referencia_tblTapVehiculos_Carrito;

	@FXML
	private TextField txt_Marca_Buaqueda;

	@FXML
	private TableColumn<Vehiculo, String> colm_marca_tblTapVehiculos_Carrito;






	@FXML
	void btt_action_LimpiarConsultarVehiculo(ActionEvent event) {
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

	private void cargarListadoVehiculosConsultados( String placaBusq, String marcaBusq, String referenciaBusq,
			int modeloBusq, double precioBusq) {
		// TODO Auto-generated method stub
		tblTapVehiculos_Disponibles.getItems().clear();
		tblTapVehiculos_Disponibles.setItems(obtenerConsultaVehiculos(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq));
	}
	private ObservableList<Vehiculo> obtenerConsultaVehiculos(String placaBusq, String marcaBusq,
			String referenciaBusq, int modeloBusq, double precioBusq) {
		// TODO Auto-generated method stub
		listadoVehiculos.addAll(modelFactoryController.obtenerConsultaVehiculos(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq));
		return listadoVehiculos;
	}

	@FXML
	void bttAgregar_Action(ActionEvent event) {
		agregarACarrito();
	}

	private void agregarACarrito() {
		// TODO Auto-generated method stub
		Vehiculo agregado=new Vehiculo();
		int cantActual=0;
		if (vehiculoSeleccionado!=null) {
			if (validarCantidad()) {



				if (vehiculoSeleccionado instanceof Moto) {
					agregado=new Moto(vehiculoSeleccionado.getPlaca(), vehiculoSeleccionado.getMarca(), vehiculoSeleccionado.getTipoVehiculo(),
							vehiculoSeleccionado.getReferencia(), vehiculoSeleccionado.getModelo(), vehiculoSeleccionado.getPrecio(),
							vehiculoSeleccionado.getNumRuedas(), cantidad, ((Moto) vehiculoSeleccionado).getCilindraje(), ((Moto) vehiculoSeleccionado).getTamTanque());



				}
				if (vehiculoSeleccionado instanceof Auto) {

					agregado=new Auto(vehiculoSeleccionado.getPlaca(), vehiculoSeleccionado.getMarca(), vehiculoSeleccionado.getTipoVehiculo(),
							vehiculoSeleccionado.getReferencia(), vehiculoSeleccionado.getModelo(), vehiculoSeleccionado.getPrecio(),
							vehiculoSeleccionado.getNumRuedas(), cantidad, ((Auto) vehiculoSeleccionado).getNumPuertas(), ((Auto) vehiculoSeleccionado).isGasolina());
				}
				if (vehiculoSeleccionado instanceof Camion) {
					agregado=new Camion(vehiculoSeleccionado.getPlaca(), vehiculoSeleccionado.getMarca(), vehiculoSeleccionado.getTipoVehiculo(),
							vehiculoSeleccionado.getReferencia(), vehiculoSeleccionado.getModelo(), vehiculoSeleccionado.getPrecio(),
							vehiculoSeleccionado.getNumRuedas(), cantidad, ((Camion) vehiculoSeleccionado).getCapCarga());

				}


				modelFactoryController.listadoVehiculosCarrito.add(agregado);

				//vehiculoSeleccionado.setCantidad(cantActual-cantidad);
				cargarListadoVehiculos();
				cargarListadoVehiculosCarrito();
				cantidad=0;

			}
		}
	}

	private boolean validarCantidad() {
		// TODO Auto-generated method stub
		String entrada = JOptionPane.showInputDialog("Digita la cantidad:");
		cantidad= Integer.parseInt(entrada);

		if (cantidad<=vehiculoSeleccionado.getCantidad()) {
			return true;
		}
		return false;
	}

	@FXML
	void bttQuitar_Action(ActionEvent event) {
		quitarDeCarrito();
	}

	private void quitarDeCarrito() {
		// TODO Auto-generated method stub
		if (vehiculoSeleccionadoCarrito!=null) {

			if (modelFactoryController.quitarVehiculoCarrito(vehiculoSeleccionadoCarrito)) {
				modelFactoryController.listadoVehiculosCarrito.remove(vehiculoSeleccionadoCarrito); 
			}


			cargarListadoVehiculos();
			cargarListadoVehiculosCarrito();
			cantidad=0;


		}
	}


	@FXML
	void bttGenerarVenta_Action(ActionEvent event) {
		genrarFactura();
	}

	

	@FXML
	void bttGLimpiarCarrito_Action(ActionEvent event) {
		initialize();
	}

	@FXML
	void initialize() {
		initializeTblCarrito();
		initializeTblDisponibles();
	}
	@FXML
	void initializeTblDisponibles() {
		this.colm_placa_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.colm_marca_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colm_referencia_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("referencia"));
		this.colm_modelo_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		this.colm_precio_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.colm_numRuedas_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("numRuedas"));
		this.colm_tipoVehiculo_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
		this.colm_Cantidad_tblTapVehiculos1.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

		tblTapVehiculos_Disponibles.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			vehiculoSeleccionado = newSelection;

		});
		cargarListadoVehiculos();
	}
	private void cargarListadoVehiculos() {
		// TODO Auto-generated method stub
		tblTapVehiculos_Disponibles.getItems().clear();
		tblTapVehiculos_Disponibles.setItems(obtenerVehiculos());
	}

	private ObservableList<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub	
		listadoVehiculos.addAll(modelFactoryController.obtenerVehiculos());
		return listadoVehiculos;
	}
	@FXML
	void initializeTblCarrito() {
		this.colm_placa_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.colm_marca_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colm_referencia_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("referencia"));
		this.colm_modelo_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		this.colm_precio_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.colm_numRuedas_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("numRuedas"));
		this.colm_tipoVehiculo_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
		this.colm_Cantidad_tblTapVehiculos_Carrito.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

		tblTapVehiculos_Carrito.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			vehiculoSeleccionadoCarrito = newSelection;

		});
		cargarListadoVehiculosCarrito();
	}
	private void cargarListadoVehiculosCarrito() {
		// TODO Auto-generated method stub
		if (modelFactoryController.listadoVehiculosCarrito!=null) {
			tblTapVehiculos_Carrito.getItems().clear();
			tblTapVehiculos_Carrito.setItems(obtenerVehiculosCarrito());
		}else {
			tblTapVehiculos_Carrito.getItems().clear();
		}

	}

	private ObservableList<Vehiculo> obtenerVehiculosCarrito() {
		// TODO Auto-generated method stub	
		listadoVehiculosCarrito.addAll(modelFactoryController.listadoVehiculosCarrito);
		return listadoVehiculosCarrito;
	}
	public void setAplication(App app) {
		// TODO Auto-generated method stub

	}
	
	private void genrarFactura() {
		// TODO Auto-generated method stub
		modelFactoryController.generarFactura();
		
		modelFactoryController.listadoVehiculosCarrito.clear();
		cargarListadoVehiculos();
		cargarListadoVehiculosCarrito();
		cantidad=0;
		
	}
}
