package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;



import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.uqvirtual.proyectofinal.application.App;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Factura;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.TipoVehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CajaViewController {
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	ObservableList<Vehiculo> listadoVehiculos = FXCollections.observableArrayList();
	ObservableList<Factura> listadoFactura = FXCollections.observableArrayList();


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtCamiones;

	@FXML
	private TableColumn<Vehiculo,TipoVehiculo> colm_tipoVehiculo_tblTapVehiculos_Disponibles;

	@FXML
	private TextField txtAutos;

	@FXML
	private TableColumn<Factura, String> colCod;

	@FXML
	private TableColumn<Factura, Double> colPrec;

	@FXML
	private TableColumn<Vehiculo,Integer> colm_numRuedas_tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo,String> colm_referencia_tblTapVehiculos_Disponibles;

	@FXML
	private TextField txtTotal;

	@FXML
	private TableView<Vehiculo> tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo,Integer> colm_modelo_tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo, Double> colm_precio_tblTapVehiculos_Disponibles;

	@FXML
	private TableColumn<Vehiculo,Integer> colm_Cantidad_tblTapVehiculos1;

	@FXML
	private TableColumn<Vehiculo,String> colm_marca_tblTapVehiculos_Disponibles;

	@FXML
	private TextField txtMotos;

	@FXML
	private TableView<Factura> tblFactu;

	@FXML
	private TableColumn<Vehiculo, String> colm_placa_tblTapVehiculos_Disponibles;
	private Factura facturaSeleccionada;

	@FXML
	void initialize() {
		
		double precioTotal=0;
		double precioAutos=0;
		double precioMotos=0;
		double precioCamiones=0;
		
		
		for (Factura factura : modelFactoryController.storify.getListaVentas()) {
			if (factura!=null) {
				precioTotal=precioTotal+factura.getPrecioTotal();
			}
		}
	
		for (Factura factura : modelFactoryController.storify.getListaVentas()) {
			if (factura!=null) {
				
				for (Vehiculo vehiculo : factura.getListaVehiculos()) {
					if (vehiculo.getTipoVehiculo()==TipoVehiculo.AUTO) {
						precioAutos=precioAutos+vehiculo.getPrecio();
					}
					if (vehiculo.getTipoVehiculo()==TipoVehiculo.MOTO) {
						precioMotos=precioMotos+vehiculo.getPrecio();
					}
					if (vehiculo.getTipoVehiculo()==TipoVehiculo.CAMION) {
						precioCamiones=precioCamiones+vehiculo.getPrecio();
					}
				}
				precioTotal=precioTotal+factura.getPrecioTotal();
			}
		}
		
		txtTotal.setText(""+precioTotal);
		txtMotos.setText(""+precioMotos);
		txtAutos.setText(""+precioAutos);
		txtCamiones.setText(""+precioCamiones);
		
		this.colCod.setCellValueFactory(new PropertyValueFactory<>("code"));
		this.colPrec.setCellValueFactory(new PropertyValueFactory<>("precioTotal"));
		tblFactu.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			facturaSeleccionada = newSelection;
			mostrarVehiculos();
		});
		
		cargarListadoFacturas();
	}

	private void cargarListadoFacturas() {
		// TODO Auto-generated method stub
		tblFactu.getItems().clear();
		tblFactu.setItems(obtenerFacturas());
	}
	private ObservableList<Factura> obtenerFacturas() {
		// TODO Auto-generated method stub	
		listadoFactura.addAll(modelFactoryController.storify.getListaVentas());
		return listadoFactura;
	}
	private void mostrarVehiculos() {
		// TODO Auto-generated method stub
		if (facturaSeleccionada!=null) {
			this.colm_placa_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("placa"));
			this.colm_marca_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("marca"));
			this.colm_referencia_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("referencia"));
			this.colm_modelo_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("modelo"));
			this.colm_precio_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("precio"));
			this.colm_numRuedas_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("numRuedas"));
			this.colm_tipoVehiculo_tblTapVehiculos_Disponibles.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
			this.colm_Cantidad_tblTapVehiculos1.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

			
			cargarListadoVehiculos();
		}
	}
	private void cargarListadoVehiculos() {
		// TODO Auto-generated method stub
		tblTapVehiculos_Disponibles.getItems().clear();
		tblTapVehiculos_Disponibles.setItems(obtenerVehiculos());
	}

	private ObservableList<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub	
		listadoVehiculos.addAll(facturaSeleccionada.getListaVehiculos());
		return listadoVehiculos;
	}
	public void setAplication(App app) {
		// TODO Auto-generated method stub

	}
}

