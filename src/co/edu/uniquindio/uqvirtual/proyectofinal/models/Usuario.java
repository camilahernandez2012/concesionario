package co.edu.uniquindio.uqvirtual.proyectofinal.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String name;
	private String username;
	private String contrasena;
	private String email;
	private RolUsuario rol;
	private boolean estado;
	private String preguntaSeguridad;
	private String respuesta;
	


	public Usuario(String codigo,String name,String username, String contrasena, String email, RolUsuario rol, boolean estado,
			String preguntaSeguridad,String respuesta) {
		super();
		this.name = name;
		this.codigo = codigo;
		this.username = username;
		this.contrasena = contrasena;
		this.email = email;
		this.rol = rol;
		this.estado = estado;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuesta = respuesta;
		
	}

	public Usuario() {
		super();
	}

	/*
	 * Getters and setters
	 */

	
	
	
//	public boolean agregarCancionUsuario(Cancion cancion) {
//		
//		if (validarCancionExiste(cancion.getCodigo())) {
//			return false;
//		}else {
//			this.agregarCancion(cancion);
//			return true;
//		}	
//		
//	}

//	private boolean validarCancionExiste(String codigo2) {
//		// TODO Auto-generated method stub
//		for (Cancion cancion : this.getListaCanciones()) {
//			if (cancion!=null) {
//				if (cancion.getCodigo().equalsIgnoreCase(codigo2)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RolUsuario getRol() {
		return rol;
	}

	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}







	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean validarExistencia(String usuario, String password, RolUsuario rolRecibido) {
		// TODO Auto-generated method stub
		if (this.username.equalsIgnoreCase(usuario)&&this.contrasena.equals(password)&&rol==rolRecibido) {
			return true;
		}
		return false;
	}
	/**
	 * validarCodigo
	 * @param codUser
	 * @return
	 */
	public boolean validarCodigo(String codUser) {
		// TODO Auto-generated method stub
		if (this.getCodigo().equalsIgnoreCase(codUser)) {
			return true;
		}
		return false;
	}
	/**
	 * validarUserName
	 * @param nameUser
	 * @return
	 */
	public boolean validarUserName(String nameUser) {
		// TODO Auto-generated method stub
		if (this.getUsername().equalsIgnoreCase(nameUser)) {
			return true;
		}
		return false;
	}

	/**
	 * validarCorreoUsuario
	 * ESTA FUNCION RETORNA VERDADERO SI LOS DOS CORREOS COMPARADOS 
	 * SON IGUALES
	 * @param correo
	 * @return
	 */
	public boolean validarCorreoUsuario(String correo) {
		// TODO Auto-generated method stub
		if (this.getEmail().equalsIgnoreCase(correo)) {
			return true;
		}
		return false;
	}


}
