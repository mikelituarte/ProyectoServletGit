package servicios.usuario;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hibernateAll.empleadoHibernateDAO.UsuarioHibernateDAO;
import tablas_Clases.Usuario;

public class UsuarioServices  {

	private final Logger log = LogManager.getRootLogger();
	
	public Usuario leerUsuario(String nombre, String pass) throws ClassNotFoundException, SQLException{
		boolean res = false;
		Usuario usuarioDevuelto = null;
		UsuarioHibernateDAO uhDao = new UsuarioHibernateDAO();
		Usuario usuario = (Usuario) uhDao.leerUsuario(nombre);
		if(usuario != null){
			if(usuario.getClave().equals(pass)){
				res = true;
				usuarioDevuelto = usuario;
			}
		}
		return usuarioDevuelto;
	}
}
