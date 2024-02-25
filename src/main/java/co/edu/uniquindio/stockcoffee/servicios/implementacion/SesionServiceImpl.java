package co.edu.uniquindio.stockcoffee.servicios.implementacion;

import co.edu.uniquindio.stockcoffee.dto.SesionDTO;
import co.edu.uniquindio.stockcoffee.dto.TokenDTO;
import co.edu.uniquindio.stockcoffee.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.stockcoffee.seguridad.servicios.JwtService;
import co.edu.uniquindio.stockcoffee.servicios.interfaces.SesionServicio;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SesionServiceImpl implements SesionServicio {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public SesionServiceImpl(JwtService jwtService, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getPassword())
        );
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return new TokenDTO(jwtToken, refreshToken);
    }

    @Override
    public void logout(int codigoUsuario) {

    }

    @Override
    public TokenDTO refreshToken(@NotNull TokenDTO tokenDTO) throws Exception {
        String email = jwtService.extractUsername(tokenDTO.getRefreshToken());
        UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);
        if (jwtService.isTokenValid(tokenDTO.getRefreshToken(), user)) {
            String token = jwtService.generateToken(user);
            return new TokenDTO(token, tokenDTO.getRefreshToken());
        }
        throw new Exception("Error construyendo el token");
    }
}
