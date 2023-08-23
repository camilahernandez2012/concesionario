package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import java.util.ArrayList;

import co.edu.uniquindio.uqvirtual.proyectofinal.exceptions.datosNulosException;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Auto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Camion;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Empresa;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Factura;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Moto;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.RolUsuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.TipoVehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Usuario;
import co.edu.uniquindio.uqvirtual.proyectofinal.models.Vehiculo;
import co.edu.uniquindio.uqvirtual.proyectofinal.services.lTiendaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;



public class ModelFactoryController {
	public Empresa storify;
	public Usuario adminsActual;
	public Usuario userLogueado;

	Thread guardarXML;
	Thread cargarXML;

	public boolean actualizar=false;
	public ArrayList<Vehiculo> listadoVehiculosCarrito = new ArrayList<Vehiculo>();

	

	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}
	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		inicializarDatos();
	}
	private void inicializarDatos() {
		//	 TODO Auto-generated method stub
		storify=new Empresa();


		ArrayList<Usuario> listUsuarios=new ArrayList<Usuario>();

		Usuario nuevo=new Usuario("1104544039","camila","admin", "admin", "camila@gmail.com", RolUsuario.ADMIN, true, "que", "so");
		Usuario nuevo2=new Usuario("1234","seb","seba", "seba", "seba@gmail.com", RolUsuario.VENDEDOR, true, "que", "so");
		Usuario nuevo3=new Usuario("4321","san","san", "san", "san@gmail.com", RolUsuario.GESTION_DE_CAJA, true, "que", "so");
		listUsuarios.add(nuevo);
		listUsuarios.add(nuevo2);
		listUsuarios.add(nuevo3);

		storify.setListaUsuarios(listUsuarios);

		ArrayList<Vehiculo> listaVehiculos=new ArrayList<Vehiculo>();
		Moto nueva= new Moto("msl-123", "Yamaha", TipoVehiculo.MOTO, "asdad", 2001, 16321, 2,1000, 150, 400);
		Auto carro=new Auto("QHF-355", "Renault", TipoVehiculo.AUTO, "Twingo", 2006, 900000, 4,1000, 3, true);
		Camion camion= new Camion("DAS-4321", "SHACMAN", TipoVehiculo.CAMION, "camion", 2019, 1000000, 6,10000, 5000);
		listaVehiculos.add(nueva);
		listaVehiculos.add(carro);
		listaVehiculos.add(camion);
		storify.setListaVehiculos(listaVehiculos);
		
		ArrayList<Factura>listaFac=new ArrayList<Factura>();
		
		Factura nuevasF1= new Factura("1", listaVehiculos, 400000.0);
		
		listaFac.add(nuevasF1);
		storify.setListaVentas(listaFac);

	
	}



	/**
	 * crearUsuario
	 * @param codUser
	 * @param name
	 * @param tipoUser
	 * @param nameUser
	 * @param nacionalUser
	 * @param userUser
	 * @param passUser
	 * @param emailUser
	 * @param pregUser
	 * @param answerUser
	 * @param estadoUsuario
	 * @param esAgrupacion
	 * @return
	 */
	public Usuario crearUsuario(String codUser, String name, RolUsuario tipoUser, String nameUser,
			String passUser, String emailUser, String pregUser, String answerUser, boolean estadoUsuario, boolean esAgrupacion) {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario=storify.crearUsuario( codUser,name,  tipoUser,  nameUser,
				passUser,  emailUser,  pregUser,  answerUser,  estadoUsuario,  esAgrupacion);



		return nuevoUsuario;
	}




	/**
	 * actualizarUsuario
	 * @param codUser
	 * @param name
	 * @param tipoUser
	 * @param nameUser
	 * @param nacionalUser
	 * @param userUser
	 * @param passUser
	 * @param emailUser
	 * @param pregUser
	 * @param answerUser
	 * @param estadoUsuario
	 * @param esAgrupacion
	 * @return
	 */
	public Usuario actualizarUsuario(String codUser, String name, RolUsuario tipoUser, String nameUser
			, String userUser, String passUser, String emailUser, String pregUser,
			String answerUser, boolean estadoUsuario, boolean esAgrupacion) {
		// TODO Auto-generated method stub
		Usuario actualizado=null;	
		actualizado=storify.actualizarUsuario( codUser,  name,  tipoUser,  nameUser  ,
				userUser,  passUser,  emailUser,  pregUser,  answerUser,  estadoUsuario,  esAgrupacion);	
		return actualizado;
	}

	public boolean eliminarUsuario(String codUser) {
		// TODO Auto-generated method stub
		boolean eliminado=false;	
		if (codUser.equalsIgnoreCase(adminsActual.getCodigo())) {
			lTiendaService.mostrarMensaje("Error", "Operación interrumoida", "No puedes eliminar el usuario desde el que estas logueado", AlertType.ERROR);
		}else {
			eliminado=storify.eliminarUsuario(codUser);	
		}

		return eliminado;
	}

	public ArrayList<Usuario> obtenerConsultaUsuarios(boolean[] campos, String codSearch, String nameSearch, RolUsuario rolSearch) {
		// TODO Auto-generated method stub

		return storify.obtenerConsultaUsuarios(campos,codSearch,nameSearch,rolSearch);
	}

	public Usuario cambiarPasword(String identificacion,String password) throws datosNulosException {
		// TODO Auto-generated method stub
		Usuario encontrado=null;
		encontrado=storify.cambiarPassword(identificacion,password);
		if(encontrado!=null){
			return encontrado;
		}
		return null;
	}

	/**
	 * validarCorreoRecuperacion
	 * 
	 * @param correo
	 * @return
	 */
	public Usuario validarCorreoRecuperacion(String correo) {
		// TODO Auto-generated method stub
		Usuario encontrado=null;

		encontrado=storify.validarCorreo(correo);
		if(encontrado!=null){
			return encontrado;
		}

		return null;
	}

	public ArrayList<Usuario>  obtenerUsuarios() {
		// TODO Auto-generated method stub
		return storify.getUsuariosTablas();
	}

	public ArrayList<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub
		return storify.getListaVehiculos();
	}

	public Vehiculo guardarVehiculo(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad,
			int cilindraje,double tamTanque,
			int numPuertas,boolean isGasolina,
			double capCarga) {
		// TODO Auto-generated method stub

		Vehiculo nuevo=storify.crearVehiculo(placa, marca, tipoVehiculo, referencia, modelo, precio, numRuedas,cantidad, cilindraje, tamTanque, numPuertas, isGasolina, capCarga);

		return nuevo;
	}

	public Vehiculo actualizarVehiculo(String placa, String marca, TipoVehiculo tipoSeleccionado, String referencia,
			int modelo, double precio, int cantLantas, int cilindraje, double tamTanque, int numPuertas,
			boolean isGasolina, double capCarga) {
		// TODO Auto-generated method stub
		Vehiculo nuevo=storify.actualizarVehiculo(placa, marca, tipoSeleccionado, referencia, modelo, precio, cantLantas, cilindraje, tamTanque, numPuertas, isGasolina, capCarga);
		return nuevo;
	}

	public boolean eliminarVehiculo(String placa, TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
				boolean eliminado=false;	
				
					eliminado=storify.eliminarVehiculo(placa, tipoVehiculo);
				

				return eliminado;
	}

	public ArrayList<Vehiculo> obtenerConsultaVehiculos( String placaBusq, String marcaBusq,
			String referenciaBusq, int modeloBusq, double precioBusq) {
		// TODO Auto-generated method stub
		return storify.obtenerConsultaVehiculos(placaBusq,marcaBusq,referenciaBusq,modeloBusq,precioBusq);
	}

	public boolean quitarVehiculoCarrito(Vehiculo vehiculoSeleccionadoCarrito) {
		// TODO Auto-generated method stub
		if (storify.quitarVehiculoCarrito(vehiculoSeleccionadoCarrito)) {
			return true;
		}
		return false;
	}

	public boolean agregarVehiculoCarrito(int cantidad, Vehiculo vehiculoSeleccionado) {
		// TODO Auto-generated method stub
	
		Vehiculo vehiculoAgregar=vehiculoSeleccionado;
		if (storify.quitarCantidad(cantidad, vehiculoSeleccionado)) {
			vehiculoAgregar.setCantidad(cantidad);
			listadoVehiculosCarrito.add(vehiculoAgregar);
			return true;
		}
		

		return false;
	}

	public void generarFactura() {
		// TODO Auto-generated method stub
		
		Factura nueva=storify.crearFactura(listadoVehiculosCarrito);
		if (nueva!=null) {
			lTiendaService.mostrarMensaje("realizado", "realizado", "Factura realizada: "+nueva.toString(), AlertType.INFORMATION);
			
		}
		
	}

	
}
