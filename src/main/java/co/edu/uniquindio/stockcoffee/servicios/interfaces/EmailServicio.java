package co.edu.uniquindio.stockcoffee.servicios.interfaces;

import co.edu.uniquindio.stockcoffee.dto.EmailDTO;

public interface EmailServicio {
    void enviarEmail(EmailDTO emailDTO) throws Exception;
}
