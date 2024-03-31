package co.edu.uniquindio.stockcoffee.servicios.interfaces;

import co.edu.uniquindio.stockcoffee.dto.AdministradorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AdministradorServicio{
    // Método que permite registrar un administrador en la base de datos
    String registrarUsuario(AdministradorDTO administradorDTO) throws  Exception;
    // Método que permite actualizar el registro de un administrador
    String actualizarUsuario(String cedula, AdministradorDTO usuarioDTO) throws Exception;
    // Método que permite cambiar la contraseña de acceso del administrador
    boolean cambiarContrasena(String identificacion, String nuevaContrasena) throws Exception;
    // Método que permite envíar un correo con la url para realizar el cambió de contraseña
    String reestablecerContrasena(String email) throws Exception;
}
