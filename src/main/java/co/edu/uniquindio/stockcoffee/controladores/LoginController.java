package co.edu.uniquindio.stockcoffee.controladores;

import co.edu.uniquindio.stockcoffee.dto.AdministradorDTO;
import co.edu.uniquindio.stockcoffee.dto.MensajeDTO;
import co.edu.uniquindio.stockcoffee.dto.SesionDTO;
import co.edu.uniquindio.stockcoffee.dto.TokenDTO;
import co.edu.uniquindio.stockcoffee.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.stockcoffee.servicios.interfaces.SesionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class LoginController {
    private final AdministradorServicio administradorServicio;
    private final SesionServicio sesionServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody AdministradorDTO
                                                               admin) throws Exception {
        administradorServicio.registrarUsuario(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Administrador creado correctamente"));
    }

    @GetMapping("/reestablecerContrasena/{email}")
    public ResponseEntity<MensajeDTO> reestablecerContrasena(@PathVariable String email) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                administradorServicio.reestablecerContrasena(email)));
    }

    @PostMapping("/refresh")
    public ResponseEntity<MensajeDTO> refreshToken(@Valid @RequestBody TokenDTO tokenDTO) throws  Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.refreshToken(tokenDTO))) ;
    }
}
