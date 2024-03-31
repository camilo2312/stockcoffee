package co.edu.uniquindio.stockcoffee.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre1;
    @Column(length = 100, nullable = false)
    private String nombre2;
    @Column(length = 100, nullable = false)
    private String apellido1;
    @Column(length = 100, nullable = false)
    private String apellido2;
    @Column(length = 100)
    private String cuidad;
    @Column(length = 300)
    private String direccion;
    @Column(length = 20, nullable = false)
    private String numeroTelefono;
    @Column(length = 200, nullable = false)
    private String correo;
    @Column(length = 10, nullable = false)
    private String contrasena;
    private String tipo_contribuyente;
    private String tipo_relacion;
    @ManyToMany(mappedBy = "lstAdministrador")
    private List<CafeVerde> lstCafeVerdeAdministrador;
    @OneToMany(mappedBy = "administrador")
    private List<PedidoCafe> lstPedidoCafe;

}
