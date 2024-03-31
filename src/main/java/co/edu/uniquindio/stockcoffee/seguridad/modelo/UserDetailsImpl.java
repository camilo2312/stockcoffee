package co.edu.uniquindio.stockcoffee.seguridad.modelo;

import co.edu.uniquindio.stockcoffee.entidades.Administrador;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String username, password, codigo;
    private Collection<? extends GrantedAuthority> authorities;
    public static UserDetailsImpl build(Administrador user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user instanceof Administrador){
            authorities.add( new SimpleGrantedAuthority("ADMINISTRADOR") );
        }
        return new UserDetailsImpl(user.getCorreo(), user.getContrasena(), user.getId() + "", authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public String getCodigo() { return codigo; }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
