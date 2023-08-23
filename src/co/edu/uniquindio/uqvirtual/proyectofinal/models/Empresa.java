package co.edu.uniquindio.uqvirtual.proyectofinal.models;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.uniquindio.uqvirtual.proyectofinal.exceptions.datosNulosException;

public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Vehiculo>listaVehiculos;
	private  ArrayList<Usuario>listaUsuarios;
	private  ArrayList<Factura>listaVentas;



	public Empresa() {
		super();
		this.listaVehiculos = new ArrayList<Vehiculo>();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaVentas = new ArrayList<Factura>();
	}



	public ArrayList<Factura> getListaVentas() {
		return listaVentas;
	}



	public void setListaVentas(ArrayList<Factura> listaVentas) {
		this.listaVentas = listaVentas;
	}



	public Empresa(ArrayList<Vehiculo> listaVehiculos, ArrayList<Usuario> listaUsuarios) {
		super();
		this.listaVehiculos = listaVehiculos;
		this.listaUsuarios = listaUsuarios;
	}



	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}



	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}



	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}



	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}



	/*
	 * validacion para el login
	 */
	public Usuario validarIngreso(String usuario, String password, RolUsuario rol) {
		// TODO Auto-generated method stub
		for (Usuario encontrado : this.listaUsuarios) {		
			if (encontrado!=null) {
				if (encontrado.validarExistencia(usuario,password,rol)) {
					return encontrado;	
				}
			}	
		}
		return null;
	}



	public Usuario crearUsuario(String codUser, String name, RolUsuario tipoUser, String nameUser,
			String passUser, String emailUser, String pregUser, String answerUser, boolean estadoUsuario, boolean esAgrupacion) {

		Usuario nuevoUsuario = new Usuario();

		if (buscarUsuarioCodigoBoolean(codUser)==false) {
			if (buscarUsuarioBoolean(nameUser)==false) {

				nuevoUsuario.setCodigo(codUser);
				nuevoUsuario.setName(name);
				nuevoUsuario.setUsername(nameUser);
				nuevoUsuario.setContrasena(passUser);
				nuevoUsuario.setRol(tipoUser);
				nuevoUsuario.setEmail(emailUser);
				nuevoUsuario.setEstado(estadoUsuario);
				nuevoUsuario.setPreguntaSeguridad(pregUser);
				nuevoUsuario.setRespuesta(answerUser);



				this.listaUsuarios.add(nuevoUsuario);
				return nuevoUsuario;
			}
		}
		return null; 
	}



	public Usuario actualizarUsuario(String codUser, String name, RolUsuario tipoUser, String nameUser ,
			String userUser, String passUser, String emailUser, String pregUser, String answerUser, boolean estadoUsuario, boolean esAgrupacion) {
		// Buscar el usuario por su c�digo

		for (Usuario usuario : this.listaUsuarios) {
			if (usuario.getCodigo().equalsIgnoreCase(codUser)) {
				usuario.setName(name);
				//usuario.setUsername(userUser);
				usuario.setContrasena(passUser);
				//usuario.setRol(tipoUser);
				usuario.setEmail(emailUser);
				usuario.setEstado(estadoUsuario);
				usuario.setPreguntaSeguridad(pregUser);
				usuario.setRespuesta(answerUser);

				return usuario;
			}
		}
		return null; // Usuario no encontrado

	}


	private boolean buscarUsuarioBoolean(String nameUser) {
		// TODO Auto-generated method stub
		for (Usuario encontrado : this.listaUsuarios) {
			if (encontrado.validarUserName(nameUser)) {
				return true;
			}
		}
		return false;
	}

	private boolean buscarUsuarioCodigoBoolean(String codUser) {
		// TODO Auto-generated method stub
		for (Usuario encontrado : this.listaUsuarios) {
			if (encontrado.validarCodigo(codUser)) {
				return true;
			}
		}
		return false;
	}

	// READ: Obtener un usuario por su username
	public Usuario obtenerUsuario(String username) {
		for (Usuario encontrado : this.listaUsuarios) {
			if (encontrado.getUsername().equals(username)) {
				return encontrado;
			}
		}
		return null; // Usuario no encontrado
	}





	// DELETE: Eliminar un usuario
	public boolean eliminarUsuario(String codUser) {
		// Buscar el usuario por su c�digo
		boolean estadoArtista=false;
		for (Usuario usuario : this.listaUsuarios) {	
			if (usuario.getCodigo().equalsIgnoreCase(codUser)) {	
				// Eliminar el artista asociado al usuario si es un artista
				this.getListaUsuarios().remove(usuario); // Eliminar el usuario de la lista
				return true; // Usuario eliminado exitosamente
			}
		}
		return false; // Usuario no encontrado
	}

	public ArrayList<Usuario> obtenerConsultaUsuarios(boolean[] campos, String codSearch, String nameSearch,
			RolUsuario rolSearch) {
		// TODO Auto-generated method stub
		ArrayList<Usuario>consulta=new ArrayList<Usuario>();
		for (Usuario usuario : this.listaUsuarios) {
			if (usuario.getName().equalsIgnoreCase(nameSearch) || usuario.getCodigo().equalsIgnoreCase(codSearch)||usuario.getRol()==rolSearch) {
				consulta.add(usuario);
			}
		}
		return consulta;
	}


	public Usuario cambiarPassword(String identificacion,String password) throws datosNulosException {
		// TODO Auto-generated method stub
		Usuario encontrada=obtenerUsuarioCodigo(identificacion);//SE LLAMA LA PERSONA SEGUN LA IDENTIFICACION

		if(identificacion==null){
			throw new datosNulosException("Datos nulos en funcion crearEmpleado");
		}
		if(encontrada !=null){
			encontrada.setContrasena(password);
			return encontrada;
		}
		return null;
	}

	private Usuario obtenerUsuarioCodigo(String identificacion) {
		// TODO Auto-generated method stub
		for ( Usuario user : this.listaUsuarios) {
			if (user.getCodigo().equalsIgnoreCase(identificacion)) {
				return user;
			}
		}
		return null; // Si no se encuentra el artista, se retorna null
	}

	/**
	 * validarCorreo
	 * @param correo
	 * @return
	 */
	public Usuario validarCorreo(String correo) {
		// TODO Auto-generated method stub
		Usuario encontrado=null;
		boolean validarCorreoUsuario=false;
		Usuario persona = new Usuario();
		for (Usuario encontradoActual : this.listaUsuarios) {
			persona=encontradoActual;
			if(persona !=null){
				encontrado=persona;
				validarCorreoUsuario=encontrado.validarCorreoUsuario(correo);
				if(validarCorreoUsuario){
					return encontrado;
				}
			}
		}
		return null;
	}



	public ArrayList<Usuario> getUsuariosTablas() {
		ArrayList<Usuario> usuariosEncontrados=new ArrayList<Usuario>();
		for (Usuario encontrado : this.listaUsuarios) {		
			if (encontrado!=null) {
				usuariosEncontrados.add(encontrado);
			}	
		}	
		return usuariosEncontrados;
	}


	public Vehiculo crearVehiculo(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,int cantidad,
			int cilindraje,double tamTanque,
			int numPuertas,boolean isGasolina,
			double capCarga) {
		Vehiculo nuevo=null;
		if (tipoVehiculo!=null) {
			if(!validarVehiculoExiste(placa,tipoVehiculo)){
				nuevo=new Vehiculo(placa, marca, tipoVehiculo, referencia, modelo, precio, numRuedas,cantidad);
				switch (tipoVehiculo) {
				case MOTO:
					Moto nuevaMoto= new Moto(placa, marca,tipoVehiculo, referencia, modelo, precio, numRuedas,cantidad, cilindraje, tamTanque);
					this.listaVehiculos.add(nuevaMoto);

					break;
				case AUTO:
					Auto nuevoAuto=new Auto(placa, marca, tipoVehiculo, referencia, modelo, precio, numRuedas,cantidad, numPuertas, isGasolina);
					this.listaVehiculos.add(nuevoAuto);
					break;
				case CAMION:
					Camion nuevoCamion =new Camion(placa, marca, tipoVehiculo, referencia, modelo, precio, numRuedas,cantidad, capCarga);
					this.listaVehiculos.add(nuevoCamion);
					break;

				default:
					break;
				}
			}
		}

		return nuevo; 
	}



	private boolean validarVehiculoExiste(String placa, TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.compararPlacaYTipoVehiculo(placa,tipoVehiculo)){
				return true;
			}
		}
		return false;
	}

	public Vehiculo actualizarVehiculo(String placa, String marca,TipoVehiculo tipoVehiculo, String referencia, int modelo, double precio, int numRuedas,
			int cilindraje,double tamTanque,
			int numPuertas,boolean isGasolina,
			double capCarga) {
		// Buscar el usuario por su c�digo

		for (Vehiculo vehiculo : this.listaVehiculos) {
			if (vehiculo.compararPlacaYTipoVehiculo(placa, tipoVehiculo)) {


				//String placa
				vehiculo.setMarca(marca);
				//TipoVehiculo tipoVehiculo
				vehiculo.setReferencia(referencia);
				vehiculo.setModelo(modelo);
				vehiculo.setPrecio(precio);
				vehiculo.setNumRuedas(numRuedas);

				switch (tipoVehiculo) {
				case MOTO:
					if (vehiculo instanceof Moto) {
						((Moto) vehiculo).setCilindraje(cilindraje);
						((Moto) vehiculo).setTamTanque(tamTanque);
					}
					break;
				case AUTO:
					if (vehiculo instanceof Auto) {
						((Auto) vehiculo).setNumPuertas(numPuertas);
						((Auto) vehiculo).setGasolina(isGasolina);
					}
					break;
				case CAMION:
					if (vehiculo instanceof Camion) {
						((Camion) vehiculo).setCapCarga(capCarga);
						
					}
					break;

				default:
					break;
				}

				return vehiculo;
			}
		}
		return null; // Usuario no encontrado

	}
	
	// DELETE: Eliminar un usuario
		public boolean eliminarVehiculo(String placaVehiculo,TipoVehiculo tipoVehiculo) {
			// Buscar el usuario por su c�digo
			boolean estadoArtista=false;
			for (Vehiculo vehiculo : this.listaVehiculos) {	
				if (vehiculo.compararPlacaYTipoVehiculo(placaVehiculo, tipoVehiculo)) {
					//Agregar validacion para no eliminar si se ha facturado 
					
					// Eliminar el artista asociado al usuario si es un artista
					this.getListaVehiculos().remove(vehiculo); // Eliminar el usuario de la lista
					return true; // Usuario eliminado exitosamente
				}
			}
			return false; // Usuario no encontrado
		}


	
		public ArrayList<Vehiculo> obtenerConsultaVehiculos( String placaBusq, String marcaBusq,
				String referenciaBusq, int modeloBusq, double precioBusq) {
			// TODO Auto-generated method stub
				
			ArrayList<Vehiculo>consulta=new ArrayList<Vehiculo>();
			for (Vehiculo vehiculo : this.listaVehiculos) {
				if (vehiculo.getPlaca().equalsIgnoreCase(placaBusq) 
						|| vehiculo.getMarca().equalsIgnoreCase(marcaBusq)
						||vehiculo.getReferencia().equalsIgnoreCase(referenciaBusq)
						|| vehiculo.getModelo()==modeloBusq
						|| vehiculo.getPrecio() == precioBusq) {
					consulta.add(vehiculo);
				}
			}
			return consulta;
		}



		public boolean quitarVehiculoCarrito(Vehiculo vehiculoSeleccionadoCarrito) {
			// TODO Auto-generated method stub
			
			for (Vehiculo vehiculo : this.listaVehiculos) {
				if (vehiculo.compararPlacaYTipoVehiculo(vehiculoSeleccionadoCarrito.getPlaca(),vehiculoSeleccionadoCarrito.getTipoVehiculo())) {
					int cantidad = vehiculo.getCantidad();
				//	vehiculo.setCantidad(cantidad+vehiculoSeleccionadoCarrito.getCantidad());
					return true;
				}
			}
			return false;
		}



		public boolean quitarCantidad(int cantidad, Vehiculo vehiculoSeleccionado) {
			// TODO Auto-generated method stub
			Vehiculo nuevo=new Vehiculo();
			nuevo=vehiculoSeleccionado;
			for (Vehiculo vehiculo : this.listaVehiculos) {
				if (vehiculo.compararPlacaYTipoVehiculo(nuevo.getPlaca(),nuevo.getTipoVehiculo())) {
					int cantidadActual = nuevo.getCantidad()-cantidad;
					vehiculo.setCantidad(cantidadActual);
					return true;
				}
			}
			return false;
		}



		public Factura crearFactura(ArrayList<Vehiculo> listadoVehiculosCarrito) {
			// TODO Auto-generated method stub
			String code=""+1;
			double precio =0.0;
			
			for (Vehiculo vehiculo : listadoVehiculosCarrito) {
				
				precio=precio+(vehiculo.getPrecio()*vehiculo.getCantidad());
				
			}
			Factura nueva= new Factura(code, listadoVehiculosCarrito, precio);
			if (nueva!=null) {
				this.listaVentas.add(nueva);
				
				for (Vehiculo vehiculo : listadoVehiculosCarrito) {
					
					quitarCantidad(vehiculo.getCantidad(),vehiculo);
					
				}
				return nueva;
			}
			
			return null;
		}



}
