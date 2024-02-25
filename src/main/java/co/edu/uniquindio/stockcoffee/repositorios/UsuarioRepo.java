package co.edu.uniquindio.stockcoffee.repositorios;

import co.edu.uniquindio.stockcoffee.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.email = :identificacion")
    Usuario obtenerUsuarioCorreoNombreUsuario(String identificacion);
}
