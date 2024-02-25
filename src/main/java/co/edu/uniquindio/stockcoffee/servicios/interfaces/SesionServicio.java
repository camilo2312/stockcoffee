package co.edu.uniquindio.stockcoffee.servicios.interfaces;

import co.edu.uniquindio.stockcoffee.dto.SesionDTO;
import co.edu.uniquindio.stockcoffee.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO session);

    void logout(int codigoUsuario);

    TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception;
}
