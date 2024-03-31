package co.edu.uniquindio.stockcoffee.servicios.implementacion;

import co.edu.uniquindio.stockcoffee.dto.AdministradorDTO;
import co.edu.uniquindio.stockcoffee.repositorios.AdministradorRepo;
import co.edu.uniquindio.stockcoffee.servicios.interfaces.AdministradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {
    private final AdministradorRepo administradorRepo;

    @Override
    public String registrarUsuario(AdministradorDTO administradorDTO) throws Exception {
        return null;
    }

    @Override
    public String actualizarUsuario(String cedula, AdministradorDTO usuarioDTO) throws Exception {
        return null;
    }

    @Override
    public boolean cambiarContrasena(String identificacion, String nuevaContrasena) throws Exception {
        return false;
    }

    @Override
    public String reestablecerContrasena(String email) throws Exception {
        return null;
    }
}
