package co.edu.uniquindio.stockcoffee.seguridad.servicios;

import co.edu.uniquindio.stockcoffee.entidades.Usuario;
import co.edu.uniquindio.stockcoffee.repositorios.UsuarioRepo;
import co.edu.uniquindio.stockcoffee.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo clienteRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario cliente = clienteRepo.findByEmail(email);
        if(cliente == null){

        }else{
            return UserDetailsImpl.build(cliente);
        }

        return null;
    }
}
