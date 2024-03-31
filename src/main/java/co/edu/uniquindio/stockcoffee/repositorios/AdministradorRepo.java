package co.edu.uniquindio.stockcoffee.repositorios;

import co.edu.uniquindio.stockcoffee.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {
    Administrador findByEmail(String email);
    @Query("SELECT u FROM Administrador u WHERE u.correo = :identificacion")
    Administrador obtenerUsuarioCorreoNombreUsuario(String identificacion);
}
