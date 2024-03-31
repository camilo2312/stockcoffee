package co.edu.uniquindio.stockcoffee.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Proveedor implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String NIT;
    @Column(length = 100, nullable = false)
    private String razonSocial;
    private String direccion;
    @Column(length = 20, nullable = false)
    private String numeroTelefono;
    @Column(length = 200, nullable = false)
    private String correo;
    @OneToMany(mappedBy = "proveedor")
    private List<Bolsa> lstBolsas;
    @ManyToMany(mappedBy = "lstProveedor")
    private List<CafeVerde> lstCafeVerdeProveedor;
}
